package forks;

import java.util.concurrent.atomic.AtomicInteger;

import constants.ForksConstant;
import input.InputInterface;
import input.ParameterInterface;
import input.SimpleInput;
import input.SimpleParameter;
import structures.Node;
import structures.RootedTree;

public class MainRooted {

	static RootedTree G;
	static RootedTree S;
	static InputInterface input= new SimpleInput();
	static ParameterInterface parameters= new SimpleParameter();

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		G= new RootedTree(input.getG(),input.getMapping());

		S= new RootedTree(input.getS(),input.getMapping());

		setForks(G.getRoot());

		setTops(G.getRoot(),G.getRoot().getFork().getCenter());

		/*for (Node node: G.getNodes()) {
			System.out.println("nodo:  "+node.getLabel());
			System.out.println("centro:  "+node.getFork().getCenter().getLabel());
			System.out.println("top:  "+node.getFork().getTop().getLabel());
			System.out.println("left:  "+node.getFork().getRight().getLabel());
			System.out.println("right:  "+node.getFork().getLeft().getLabel());

		}*/

		generateMapping();

		for (Node node: G.getNodes()) {
			System.out.println("-----");
			System.out.println("nodo: "+node.getLabel()+" - punteggio: "+node.getMapping().getBetter());
			System.out.println("top: "+node.getMapping().getTop_fork_map().getNodo().getLabel()+" - punteggio: "+node.getMapping().getTop_fork_map().getCosto());
			System.out.println("center: "+node.getMapping().getCenter_fork_map().getNodo().getLabel()+" - punteggio: "+node.getMapping().getCenter_fork_map().getCosto());
			System.out.println("left: "+node.getMapping().getLeft_fork_map().getNodo().getLabel()+" - punteggio: "+node.getMapping().getLeft_fork_map().getCosto());
			System.out.println("right: "+node.getMapping().getRight_fork_map().getNodo().getLabel()+" - punteggio: "+node.getMapping().getRight_fork_map().getCosto());
		}

		System.out.println("OPTIMUM COST: "+G.getRoot().getMapping().getBetter());
		System.out.println("MAPPING:");
		printOptimumMap(G.getRoot(),G.getRoot().getMapping().getBestNode());
		
		printTreeIsSeparate();

	}


	private static void printTreeIsSeparate() {

		for (Node node : G.getNodes()) {
			if ((!node.isLeaf()) && (node.getFork().getCenter()==node.getLeft().getFork().getCenter() || node.getFork().getCenter()==node.getRight().getFork().getCenter())) {
				System.out.println("Non è saparato");
				return;
			}
		}
		System.out.println("è saparato");
	}


	private static void printOptimumMap(Node node, int code) {

		if (!node.isLeaf()) {
			printOptimumMap(node.getLeft(), node.getMapping().getCodeLeftChildByCode(code)) ;
			printOptimumMap(node.getRight(), node.getMapping().getCodeRightChildByCode(code)) ;
			System.out.println(node.getLabel()+" -> "+node.getMapping().getNodeByCode(code).getLabel()+"     dyn$ "+node.getMapping().getCostByCode(code)+"    sing$ "+(node.getMapping().getCostByCode(code)-node.getRight().getMapping().getCostByCode(node.getMapping().getCodeRightChildByCode(code))-node.getLeft().getMapping().getCostByCode(node.getMapping().getCodeLeftChildByCode(code))));
		} else {
			System.out.println(node.getLabel()+" -> "+node.getLabel());
		}





	}


	private static void generateMapping() {

		//inizializzo la matrice dei costi
		for (Node node: G.getNodes()) {

			if (node.isLeaf()) {
				node.getMapping().getCenter_fork_map().setCosto(0);
				node.getMapping().getCenter_fork_map().setNodo(node.getFork().getCenter());
				if (node.getFork().getTop()!=node.getFork().getCenter()) {
					node.getMapping().getTop_fork_map().setCosto(Integer.MAX_VALUE);
				} else {
					node.getMapping().getTop_fork_map().setCosto(0);
				}
				node.getMapping().getTop_fork_map().setNodo(node.getFork().getTop());
				node.getMapping().getLeft_fork_map().setCosto(0);
				node.getMapping().getLeft_fork_map().setNodo(node.getFork().getLeft());
				node.getMapping().getRight_fork_map().setCosto(0);
				node.getMapping().getRight_fork_map().setNodo(node.getFork().getRight());
			} else {
				node.getMapping().getCenter_fork_map().setCosto(Integer.MAX_VALUE);
				node.getMapping().getTop_fork_map().setCosto(Integer.MAX_VALUE);
				node.getMapping().getLeft_fork_map().setCosto(Integer.MAX_VALUE);
				node.getMapping().getRight_fork_map().setCosto(Integer.MAX_VALUE);
			}


		}

		//inizio la programmazione dinamica
		generateDynamicMapping(G.getRoot());

	}



	private static void generateDynamicMapping(Node node) {

		//se sono una foglia non devo fare nnt
		if (node.isLeaf()) {
			return;
		}

		//postorder per assicurarmi di aver calcolato prima i costi ottimali dei figli
		generateDynamicMapping(node.getLeft());
		generateDynamicMapping(node.getRight());

		//se sono un nodo interno calcolo il punteggio migliore di mandare il node nei 4 punti della forketta

		//left
		setLeftCost(node);

		//right
		setRightCost(node);

		//center
		setCenterCost(node);

		//top
		setTopCost(node);

		//!!! l'ordine center -> top conta!!!//
		/*int a=0;
		a++;*/

	}


	private static void setTopCost(Node node) {

		// se il centro ed il top sono uguali allora il top si deve comportare come il centro
		if (node.getFork().getTop()==node.getFork().getCenter()) {
			node.getMapping().getTop_fork_map().setNodo(node.getFork().getTop());
			node.getMapping().getTop_fork_map().setCosto(node.getMapping().getCenter_fork_map().getCosto());
			node.getMapping().getTop_fork_map().setMapLeft(node.getMapping().getCenter_fork_map().getMapLeft());
			node.getMapping().getTop_fork_map().setMapRight(node.getMapping().getCenter_fork_map().getMapRight());
			return;
		} 

		//costo transfer
		//è massimo perchè non può avvenire quando il nodo è al top
		float costoTransfer= Integer.MAX_VALUE;

		//costo speciazione
		//è massimo perchè non può avvenire quando il nodo è al top
		float costoSpeciazione= Integer.MAX_VALUE;

		//costo duplicazione
		float costoDuplicazione=0;

		AtomicInteger forkPointLeftDuplicazione= new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
		costoDuplicazione = costoDuplicazione + node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getTop(),parameters.getCl(),forkPointLeftDuplicazione); //ci metto quello a sinistra con le loss

		AtomicInteger forkPointRightDuplicazione=new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
		costoDuplicazione = costoDuplicazione + node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getTop(),parameters.getCl(),forkPointRightDuplicazione); //ci metto quello a destra con le loss

		//metto il costo della duplicazione
		costoDuplicazione=costoDuplicazione+parameters.getCd();

		//setto infine il costo per andare nel centro della fork come il minimo tra i tre eventi possibili
		node.getMapping().getTop_fork_map().setNodo(node.getFork().getTop());
		if (costoDuplicazione<=costoTransfer && costoDuplicazione<=costoSpeciazione) {
			node.getMapping().getTop_fork_map().setCosto(costoDuplicazione);
			node.getMapping().getTop_fork_map().setMapLeft(forkPointLeftDuplicazione.get());
			node.getMapping().getTop_fork_map().setMapRight(forkPointRightDuplicazione.get());
		} else if (costoTransfer<=costoDuplicazione && costoTransfer<=costoSpeciazione){
			node.getMapping().getTop_fork_map().setCosto(costoTransfer);
		} else {
			node.getMapping().getTop_fork_map().setCosto(costoSpeciazione);
		}
	}


	private static void setCenterCost(Node node) {

		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli è esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//decido se la duplicazione avviene a destra o a sinistra
			//sinistra
			float costoDuplicazioneSinistra=0;
			AtomicInteger forkPointLeftDuplicazioneSinistra= new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
			AtomicInteger forkPointRightDuplicazioneSinistra=new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa

			//se un figlio ha la stessa forchetta allora lui è costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getLeft().getFork())) {
				float costoDuplicazioneSinistraCentro=node.getLeft().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneSinistraSinistra=node.getLeft().getMapping().getLeft_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneSinistra=costoDuplicazioneSinistra+Math.min(costoDuplicazioneSinistraCentro,costoDuplicazioneSinistraSinistra);
				if (costoDuplicazioneSinistraCentro<=costoDuplicazioneSinistraCentro) {//setto per ricostruire la mappa
					forkPointLeftDuplicazioneSinistra.set(ForksConstant.CENTER);
				} else {
					forkPointLeftDuplicazioneSinistra.set(ForksConstant.LEFT);
				}
			} else {// altrimenti se la forchetta è effettivamente a sinistra lo metto nel minimo di dove può andare il figlio sommandoci le loss
				if (node.getLeft().getFork().getTop().equals(node.getFork().getLeft())) {
					costoDuplicazioneSinistra=costoDuplicazioneSinistra+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointLeftDuplicazioneSinistra);
				} else {
					costoDuplicazioneSinistra=Integer.MAX_VALUE;
				}
			}

			//se un figlio ha la stessa forchetta allora  lui è costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				float costoDuplicazioneSinistraCentro=node.getRight().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneSinistraSinistra=node.getRight().getMapping().getLeft_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneSinistra=costoDuplicazioneSinistra+Math.min(costoDuplicazioneSinistraCentro,costoDuplicazioneSinistraSinistra);
				if (costoDuplicazioneSinistraCentro<=costoDuplicazioneSinistraSinistra) {//setto per ricostruire la mappa
					forkPointRightDuplicazioneSinistra.set(ForksConstant.CENTER);
				} else {
					forkPointRightDuplicazioneSinistra.set(ForksConstant.LEFT);
				}
			} else {// altrimenti se la forchetta è effettivamente a sinistra lo metto nel minimo di dove può andare il figlio sommandoci le loss
				if (node.getRight().getFork().getTop().equals(node.getFork().getLeft())) {
					costoDuplicazioneSinistra=costoDuplicazioneSinistra+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointRightDuplicazioneSinistra);
				} else {
					costoDuplicazioneSinistra=Integer.MAX_VALUE;
				}
			}


			//destra
			float costoDuplicazioneDestra=0;
			AtomicInteger forkPointLeftDuplicazioneDestra= new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
			AtomicInteger forkPointRightDuplicazioneDestra=new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
			//se un figlio ha la stessa forchetta allora lui è costretto ad andare al centro o a destra
			if (node.getFork().equals(node.getLeft().getFork())) {
				float costoDuplicazioneDestraCentro=node.getLeft().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneDestraDestra=node.getLeft().getMapping().getRight_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneDestra=costoDuplicazioneDestra+Math.min(costoDuplicazioneDestraCentro,costoDuplicazioneDestraDestra);
				if (costoDuplicazioneDestraCentro<=costoDuplicazioneDestraDestra) {//setto per ricostruire la mappa
					forkPointLeftDuplicazioneDestra.set(ForksConstant.CENTER);
				} else {
					forkPointLeftDuplicazioneDestra.set(ForksConstant.RIGHT);
				}
			} else {// altrimenti se la forchetta è effettivamente a sinistra lo metto nel minimo di dove può andare il figlio sommandoci le loss
				if (node.getLeft().getFork().getTop().equals(node.getFork().getRight())) {
					costoDuplicazioneDestra=costoDuplicazioneDestra+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointLeftDuplicazioneDestra);
				} else {
					costoDuplicazioneDestra=Integer.MAX_VALUE;
				}
			}

			//se un figlio ha la stessa forchetta allora  lui è costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				float costoDuplicazioneDestraCentro=node.getRight().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneDestraDestra=node.getRight().getMapping().getRight_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneDestra=costoDuplicazioneDestra+Math.min(costoDuplicazioneDestraCentro,costoDuplicazioneDestraDestra);
				if (costoDuplicazioneDestraCentro<=costoDuplicazioneDestraDestra) {//setto per ricostruire la mappa
					forkPointRightDuplicazioneDestra.set(ForksConstant.CENTER);
				} else {
					forkPointRightDuplicazioneDestra.set(ForksConstant.RIGHT);
				}
			} else {// altrimenti se la forchetta è effettivamente a sinistra lo metto nel minimo di dove può andare il figlio sommandoci le loss
				if (node.getRight().getFork().getTop().equals(node.getFork().getRight())) {
					costoDuplicazioneDestra=costoDuplicazioneDestra+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointRightDuplicazioneDestra);
				} else {
					costoDuplicazioneDestra=Integer.MAX_VALUE;
				}
			}


			//uso il minimo tra destra o sinistra
			costoDuplicazione=Math.min(costoDuplicazioneSinistra,costoDuplicazioneDestra);

			if (costoDuplicazioneSinistra<=costoDuplicazioneDestra) {
				forkPointDuplicazioneSinistra=forkPointLeftDuplicazioneSinistra;
				forkPointDuplicazioneDestra=forkPointRightDuplicazioneSinistra;
			} else {
				forkPointDuplicazioneSinistra=forkPointLeftDuplicazioneDestra;
				forkPointDuplicazioneDestra=forkPointRightDuplicazioneDestra;
			}
			//sommo il costo della duplicazione
			costoDuplicazione=costoDuplicazione+parameters.getCd();




		} else {
			costoDuplicazione=Integer.MAX_VALUE;
		}


		//costo transfer
		//è massimo perchè non può avvenire quando il nodo è al centro
		float costoTransfer=Integer.MAX_VALUE;


		//costo speciazione
		float costoSpeciazione= 0;


		//il costo della speciazione è quando il figlio sinistro va a left fork e il destro a right fork oppure
		float costoSpeciazioneLeftLeftRightRight=0;
		AtomicInteger forkPointLeftLeftRightRightLEFT= new AtomicInteger(0);//per ricostruire la mappa finale
		AtomicInteger forkPointLeftLeftRightRightRIGHT= new AtomicInteger(0);


		//il costo della speciazione è quando il figlio sinistro va a right fork e il destro a left fork
		float costoSpeciazioneLeftRightRightLeft=0;
		AtomicInteger forkPointLeftRightRightLeftLEFT= new AtomicInteger(0);//per ricostruire la mappa finale
		AtomicInteger forkPointLeftRightRightLeftRIGHT= new AtomicInteger(0);


		//quindi leftleftrightright
		if (node.getLeft().getFork().equals(node.getFork())) { //se la fork di left è la stessa, allora left deve andare a sinistra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getLeft().getMapping().getLeft_fork_map().getCosto();//prendo il costo di mandare left a sinistra senza aggiungere loss chiaramente
			forkPointLeftLeftRightRightLEFT.set(ForksConstant.LEFT);
		} else if(node.getLeft().getFork().contains(node.getFork().getLeft()) ) { //altrimenti se le forchette sono diverse e sinistra comunque può stare sulla sinistra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getLeft().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftLeftRightRightLEFT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non può essere leftleftrightright
			costoSpeciazioneLeftLeftRightRight=Integer.MAX_VALUE;
		}

		if (node.getRight().getFork().equals(node.getFork())) { //se la fork di right è la stessa, allora right deve andare a right
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getRight().getMapping().getRight_fork_map().getCosto();//prendo il costo di mandare right a destra senza aggiungere loss chiaramente
			forkPointLeftLeftRightRightRIGHT.set(ForksConstant.RIGHT);
		} else if(node.getRight().getFork().contains(node.getFork().getRight()) ) { //altrimenti se le forchette sono diverse e destra comunque può stare sulla destra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getRight().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftLeftRightRightRIGHT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non può essere leftleftrightright
			costoSpeciazioneLeftLeftRightRight=Integer.MAX_VALUE;
		}


		//quindi leftrightrightleft
		if (node.getLeft().getFork().equals(node.getFork())) { //se la fork di left è la stessa, allora left deve andare a destra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getLeft().getMapping().getRight_fork_map().getCosto();//prendo il costo di mandare left a sinistra senza aggiungere loss chiaramente
			forkPointLeftRightRightLeftLEFT.set(ForksConstant.RIGHT);
		} else if(node.getLeft().getFork().contains(node.getFork().getRight()) ) { //altrimenti se le forchette sono diverse e sinistra comunque può stare sulla destra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getLeft().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftRightRightLeftLEFT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non può essere leftrightrightleft
			costoSpeciazioneLeftRightRightLeft=Integer.MAX_VALUE;
		}

		if (node.getRight().getFork().equals(node.getFork())) { //se la fork di right è la stessa, allora right deve andare a sinistra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getRight().getMapping().getLeft_fork_map().getCosto();//prendo il costo di mandare right a destra senza aggiungere loss chiaramente
			forkPointLeftRightRightLeftRIGHT.set(ForksConstant.LEFT);
		} else if(node.getRight().getFork().contains(node.getFork().getLeft()) ) { //altrimenti se le forchette sono diverse e destra comunque può stare sulla sinistra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getRight().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftRightRightLeftRIGHT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non può essere leftrightrightleft
			costoSpeciazioneLeftRightRightLeft=Integer.MAX_VALUE;
		}

		//il costo della speciazione quindi è il minimo tra i due
		costoSpeciazione=Math.min(costoSpeciazioneLeftLeftRightRight, costoSpeciazioneLeftRightRightLeft);
		AtomicInteger forkPointSpeciazioneLeft;
		AtomicInteger forkPointSpeciazioneRight;
		if (costoSpeciazioneLeftLeftRightRight<=costoSpeciazioneLeftRightRightLeft) {
			forkPointSpeciazioneLeft=forkPointLeftLeftRightRightLEFT;
			forkPointSpeciazioneRight=forkPointLeftLeftRightRightRIGHT;
		} else {
			forkPointSpeciazioneLeft=forkPointLeftRightRightLeftLEFT;
			forkPointSpeciazioneRight=forkPointLeftRightRightLeftRIGHT;
		}

		//aggiungo il costo della speciazione
		costoSpeciazione=costoSpeciazione+parameters.getCs();

		//se sono nel caso particolare del padre che ha entrambi i figli nello stesso nodo e questi non sono stelle ma proprio nodi (entrambe le fogli vanno nella stessa etichetta) allora la speciazione non si verifica mai
		if (node.getFork().isSingleNode()) {
			costoSpeciazione=Integer.MAX_VALUE;
		}

		//setto infine il costo per andare nel centro della fork come il minimo tra i tre eventi possibili
		node.getMapping().getCenter_fork_map().setNodo(node.getFork().getCenter());
		if (costoDuplicazione<=costoTransfer && costoDuplicazione<=costoSpeciazione) {
			node.getMapping().getCenter_fork_map().setCosto(costoDuplicazione);
			node.getMapping().getCenter_fork_map().setMapLeft(forkPointDuplicazioneSinistra.get());
			node.getMapping().getCenter_fork_map().setMapRight(forkPointDuplicazioneDestra.get());
		} else if (costoTransfer<=costoDuplicazione && costoTransfer<=costoSpeciazione){
			node.getMapping().getCenter_fork_map().setCosto(costoTransfer);
		} else {
			node.getMapping().getCenter_fork_map().setCosto(costoSpeciazione);
			node.getMapping().getCenter_fork_map().setMapLeft(forkPointSpeciazioneLeft.get());
			node.getMapping().getCenter_fork_map().setMapRight(forkPointSpeciazioneRight.get());
		}

	}


	private static void setLeftCost(Node node) {
		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli è esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//se un figlio ha la stessa forchetta allora anche lui è costretto ad andare a sinistra
			if (node.getFork().equals(node.getLeft().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneSinistra.set(ForksConstant.LEFT);
			} else {// altrimenti lo metto nel minimo di dove può andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointDuplicazioneSinistra);
			}

			//se un figlio ha la stessa forchetta allora anche lui è costretto ad andare a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneDestra.set(ForksConstant.LEFT);
			} else {// altrimenti lo metto nel minimo di dove può andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointDuplicazioneDestra);
			}

			//sommo il costo della duplicazione
			costoDuplicazione=costoDuplicazione+parameters.getCd();

		} else {
			costoDuplicazione=Integer.MAX_VALUE;
		}

		//costo speciazione
		//è massimo perchè non può avvenire quando il nodo è sulla sinistra
		float costoSpeciazione= Integer.MAX_VALUE;

		//costo transfer
		float costoTransfer=0;



		AtomicInteger forkPointTransferSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestra= new AtomicInteger(0);

		//possibile quando leftleftrightright
		float costoTransferLeftLeftRightRight=0;
		AtomicInteger forkPointTransferSinistraLeftLeftRightRight = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftLeftRightRight= new AtomicInteger(0);

		//se il figlio sinistro contiene il left, allora ci può andare 
		if (node.getLeft().getFork().contains(node.getFork().getLeft())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftLeftRightRight.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse vedo dove può andare tra tutti i suoi punti
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointTransferSinistraLeftLeftRightRight);
			}
		} else {// altrimenti il sinistro non può andare in left quindi non può essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il right, allora ci deve andare 
		if (node.getRight().getFork().contains(node.getFork().getRight())) {

			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftLeftRightRight.set(ForksConstant.RIGHT);
			} else { //altrimenti se sono forchette diverse deve andare in top
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getTop_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftLeftRightRight.set(ForksConstant.TOP);
			}
		} else {// altrimenti il destro non può andare in right quindi non può essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//possibile quando leftrightrightleft
		float costoTransferLeftRightRightLeft=0;
		AtomicInteger forkPointTransferSinistraLeftRightRightLeft = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftRightRightLeft= new AtomicInteger(0);

		//se il figlio sinistro contiene il right, allora ci deve andare 
		if (node.getLeft().getFork().contains(node.getFork().getRight())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftRightRightLeft.set(ForksConstant.RIGHT);
			} else { //altrimenti se sono forchette diverse deve andare in top
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getTop_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftRightRightLeft.set(ForksConstant.TOP);			}
		} else {// altrimenti il sinistro non può andare in right quindi non può essere leftleftrightright
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il left, allora può andarci 
		if (node.getRight().getFork().contains(node.getFork().getLeft())) {
			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftRightRightLeft.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse vedo dove può andare tra tutti i suoi punti
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointTransferDestraLeftRightRightLeft);

			}
		} else {// altrimenti il destro non può andare in left quindi non può essere leftrightrightleft
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}


		//il costo del transfer è il minimo tra i due
		costoTransfer=Math.min(costoTransferLeftLeftRightRight, costoTransferLeftRightRightLeft);
		if (costoTransferLeftLeftRightRight<=costoTransferLeftRightRightLeft) {//penso al mapping
			forkPointTransferSinistra=forkPointTransferSinistraLeftLeftRightRight;
			forkPointTransferDestra=forkPointTransferDestraLeftLeftRightRight;
		} else {
			forkPointTransferSinistra=forkPointTransferSinistraLeftRightRightLeft;
			forkPointTransferDestra=forkPointTransferDestraLeftRightRightLeft;
		}

		//sommo il costo del transfer
		costoTransfer=costoTransfer+parameters.getCt();

		//se sono nel caso particolare del padre che ha entrambi i figli nello stesso nodo e questi non sono stelle ma proprio nodi (entrambe le fogli vanno nella stessa etichetta) allora il transfer non si verifica mai
		if (node.getFork().isSingleNode()) {
			costoTransfer=Integer.MAX_VALUE;
		}


		//setto infine il costo per andare nel sinistro della fork come il minimo tra i tre eventi possibili
		node.getMapping().getLeft_fork_map().setNodo(node.getFork().getLeft());
		if (costoDuplicazione<=costoTransfer && costoDuplicazione<=costoSpeciazione) {
			node.getMapping().getLeft_fork_map().setCosto(costoDuplicazione);
			node.getMapping().getLeft_fork_map().setMapLeft(forkPointDuplicazioneSinistra.get());
			node.getMapping().getLeft_fork_map().setMapRight(forkPointDuplicazioneDestra.get());
		} else if (costoTransfer<=costoDuplicazione && costoTransfer<=costoSpeciazione){
			node.getMapping().getLeft_fork_map().setCosto(costoTransfer);
			node.getMapping().getLeft_fork_map().setMapLeft(forkPointTransferSinistra.get());
			node.getMapping().getLeft_fork_map().setMapRight(forkPointTransferDestra.get());
		} else {
			node.getMapping().getLeft_fork_map().setCosto(costoSpeciazione);
		}
	}


	private static void setRightCost(Node node) {
		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli è esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//se un figlio ha la stessa forchetta allora anche lui è costretto ad andare a destra
			if (node.getFork().equals(node.getLeft().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneSinistra.set(ForksConstant.RIGHT);

			} else {// altrimenti lo metto nel minimo di dove può andare il figlio sommandoci le loss

				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointDuplicazioneSinistra);
			}

			//se un figlio ha la stessa forchetta allora anche lui è costretto ad andare a destra
			if (node.getFork().equals(node.getRight().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneDestra.set(ForksConstant.RIGHT);

			} else {// altrimenti lo metto nel minimo di dove può andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointDuplicazioneDestra);
			}

			//sommo il costo della duplicazione
			costoDuplicazione=costoDuplicazione+parameters.getCd();

		} else {
			costoDuplicazione=Integer.MAX_VALUE;
		}

		//costo speciazione
		//è massimo perchè non può avvenire quando il nodo è sulla sinistra
		float costoSpeciazione= Integer.MAX_VALUE;

		//costo transfer
		float costoTransfer=0;



		AtomicInteger forkPointTransferSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestra= new AtomicInteger(0);

		//possibile quando leftleftrightright
		float costoTransferLeftLeftRightRight=0;
		AtomicInteger forkPointTransferSinistraLeftLeftRightRight = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftLeftRightRight= new AtomicInteger(0);

		//se il figlio sinistro contiene il left, allora ci deve andare 
		if (node.getLeft().getFork().contains(node.getFork().getLeft())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftLeftRightRight.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse deve andare in top
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getTop_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftLeftRightRight.set(ForksConstant.TOP);			}
		} else {// altrimenti il sinistro non può andare in left quindi non può essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il right, allora ci può andare 
		if (node.getRight().getFork().contains(node.getFork().getRight())) {

			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftLeftRightRight.set(ForksConstant.RIGHT);
			} else { //altrimenti se sono forchette diverse vedo dove può andare tra tutti i suoi punti
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointTransferDestraLeftLeftRightRight);
			}
		} else {// altrimenti il destro non può andare in right quindi non può essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//possibile quando leftrightrightleft
		float costoTransferLeftRightRightLeft=0;
		AtomicInteger forkPointTransferSinistraLeftRightRightLeft = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftRightRightLeft= new AtomicInteger(0);

		//se il figlio sinistro contiene il right, allora ci può andare 
		if (node.getLeft().getFork().contains(node.getFork().getRight())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftRightRightLeft.set(ForksConstant.RIGHT);
			} else {//altrimenti se sono forchette diverse vedo dove può andare tra tutti i suoi punti
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointTransferSinistraLeftRightRightLeft);
			}
		} else {// altrimenti il sinistro non può andare in right quindi non può essere leftleftrightright
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il left, allora ci deve 
		if (node.getRight().getFork().contains(node.getFork().getLeft())) {
			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftRightRightLeft.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse deve andare in top
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getTop_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftRightRightLeft.set(ForksConstant.TOP);
			}
		} else {// altrimenti il destro non può andare in left quindi non può essere leftrightrightleft
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}


		//il costo del transfer è il minimo tra i due
		costoTransfer=Math.min(costoTransferLeftLeftRightRight, costoTransferLeftRightRightLeft);
		if (costoTransferLeftLeftRightRight<=costoTransferLeftRightRightLeft) {//penso al mapping
			forkPointTransferSinistra=forkPointTransferSinistraLeftLeftRightRight;
			forkPointTransferDestra=forkPointTransferDestraLeftLeftRightRight;
		} else {
			forkPointTransferSinistra=forkPointTransferSinistraLeftRightRightLeft;
			forkPointTransferDestra=forkPointTransferDestraLeftRightRightLeft;
		}

		//sommo il costo del transfer
		costoTransfer=costoTransfer+parameters.getCt();

		//se sono nel caso particolare del padre che ha entrambi i figli nello stesso nodo e questi non sono stelle ma proprio nodi (entrambe le fogli vanno nella stessa etichetta) allora il transfer non si verifica mai
		if (node.getFork().isSingleNode()) {
			costoTransfer=Integer.MAX_VALUE;
		}

		//setto infine il costo per andare nel destro della fork come il minimo tra i tre eventi possibili
		node.getMapping().getRight_fork_map().setNodo(node.getFork().getRight());
		if (costoDuplicazione<=costoTransfer && costoDuplicazione<=costoSpeciazione) {
			node.getMapping().getRight_fork_map().setCosto(costoDuplicazione);
			node.getMapping().getRight_fork_map().setMapLeft(forkPointDuplicazioneSinistra.get());
			node.getMapping().getRight_fork_map().setMapRight(forkPointDuplicazioneDestra.get());
		} else if (costoTransfer<=costoDuplicazione && costoTransfer<=costoSpeciazione){
			node.getMapping().getRight_fork_map().setCosto(costoTransfer);
			node.getMapping().getRight_fork_map().setMapLeft(forkPointTransferSinistra.get());
			node.getMapping().getRight_fork_map().setMapRight(forkPointTransferDestra.get());
		} else {
			node.getMapping().getRight_fork_map().setCosto(costoSpeciazione);
		}
	}


	private static void setTops(Node node, Node top) {

		node.getFork().setTop(top);

		if (node.isLeaf()) {
			return;
		}

		if (node.getFork().getCenter()==node.getLeft().getFork().getCenter()) {
			setTops(node.getLeft(), top);
		} else {
			if (node.getLeft().getFork().getCenter().isDescendant(node.getFork().getLeft())) {
				setTops(node.getLeft(), node.getFork().getLeft());
			} else {
				setTops(node.getLeft(), node.getFork().getRight());
			}

		}


		if (node.getFork().getCenter()==node.getRight().getFork().getCenter()) {
			setTops(node.getRight(), top);
		} else {
			if (node.getRight().getFork().getCenter().isDescendant(node.getFork().getLeft())) {
				setTops(node.getRight(), node.getFork().getLeft());
			} else {
				setTops(node.getRight(), node.getFork().getRight());
			}
		}


	}

	private static Node setForks(Node node) {



		if (node.isLeaf()) {
			Node Sleaf= S.getNodeByLabel(node.getLabel());
			node.getFork().setCenter(Sleaf);
			node.getFork().setRight(Sleaf);
			node.getFork().setLeft(Sleaf);
			return node;
		}

		//il centro è il lca dei centri dei figli
		Node lca=((setForks(node.getRight())).getFork().getCenter()).lca((setForks(node.getLeft())).getFork().getCenter());

		node.getFork().setCenter(lca);

		if (lca.isLeaf()) { // se lca è una foglia allora left e right li metto uguali
			node.getFork().setLeft(lca);
			node.getFork().setRight(lca);
		} else { //altrimenti i figli
			node.getFork().setLeft(node.getFork().getCenter().getLeft());
			node.getFork().setRight(node.getFork().getCenter().getRight());
		}

		return node;

	}

}



