package utility;

import java.util.concurrent.atomic.AtomicInteger;

import constants.Errors;
import constants.ForksConstant;
import input.ParameterInterface;
import structures.Node;
import structures.RootedTree;
import structures.UnRootedTree;

public class Methods {

	private static  ParameterInterface parameters;

	public static int findMiddleIndex(String unrootedG) {

		String minusOutsideBracket=unrootedG.substring(unrootedG.indexOf("(")+1, unrootedG.lastIndexOf(")"));

		int i=0;
		int sum=0;
		boolean end=false;

		//se il sinistro √® una foglia la met√† sar√† la prima virgola
		if (minusOutsideBracket.charAt(0)!='(') {
			try {
				return unrootedG.indexOf(",");
			} catch (IndexOutOfBoundsException e) {
				throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_NOT_COMMA_FOUND+": "+unrootedG);
			}
		}

		while (!end) {
			if (minusOutsideBracket.charAt(i)=='(') {
				sum++;
			}
			if (minusOutsideBracket.charAt(i)==')') {
				sum--;
				if (sum==0) {
					end=true;
				} else if (sum<0) {
					throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_BRACKETS+": "+unrootedG);
				}
			}
			i++;
			if (i>=minusOutsideBracket.length()) {
				throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_BRACKETS+": "+unrootedG);
			}
		}
		return i+1; //il pi√π 1 √® per il fatto che ho rimosso le parentesi esterne all'inizio
	}

	public static int findMiddleIndexComma(String unrootedG) {

		String minusOutsideBracket=unrootedG.substring(unrootedG.indexOf("(")+1, unrootedG.lastIndexOf(")"));

		int i=0;
		int sum=0;
		boolean end=false;

		//se il sinistro √® una foglia la met√† sar√† la prima virgola
		if (minusOutsideBracket.charAt(0)!='(') {
			try {
				return unrootedG.indexOf(",");
			} catch (IndexOutOfBoundsException e) {
				throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_NOT_COMMA_FOUND+": "+unrootedG);
			}
		}

		while (!end) {
			if (minusOutsideBracket.charAt(i)=='(') {
				sum++;
			}
			if (minusOutsideBracket.charAt(i)==')') {
				sum--;
				if (sum==0) {
					end=true;
				} else if (sum<0) {
					throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_BRACKETS+": "+unrootedG);
				}
			}
			i++;
			if (i>=minusOutsideBracket.length()) {
				throw new RuntimeException(Errors.UNROOTED_TREE_GENERATOR_ERROR_WRONG_FORMAT_BRACKETS+": "+unrootedG);
			}
		}

		return i+unrootedG.substring(i).indexOf(","); 
	}


	public static void  setForks(RootedTree G, RootedTree S) {
		setForks(G.getRoot(),S);
	}

	public static Node setForks(Node node, RootedTree S) {

		if (node.isLeaf()) {
			Node Sleaf= S.getNodeByLabel(node.getLabel());
			node.getFork().setCenter(Sleaf);
			node.getFork().setRight(Sleaf);
			node.getFork().setLeft(Sleaf);
			return node;
		}

		//il centro Ë il lca dei centri dei figli
		Node lca=((setForks(node.getRight(),S)).getFork().getCenter()).lca((setForks(node.getLeft(),S)).getFork().getCenter());

		node.getFork().setCenter(lca);

		if (lca.isLeaf()) { // se lca Ë una foglia allora left e right li metto uguali
			node.getFork().setLeft(lca);
			node.getFork().setRight(lca);
		} else { //altrimenti i figli
			node.getFork().setLeft(node.getFork().getCenter().getLeft());
			node.getFork().setRight(node.getFork().getCenter().getRight());
		}

		return node;

	}

	public static void  setTops(RootedTree G) {
		setTops(G.getRoot(),G.getRoot().getFork().getCenter());
	}

	public static void setTops(Node node, Node top) {

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




	public static void generateMapping(RootedTree G, ParameterInterface inputParameters) {

		parameters=inputParameters;
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
		generateDynamicMapping(G.getRoot(),G);

	}



	private static void generateDynamicMapping(Node node,RootedTree G) {

		//se sono una foglia non devo fare nnt
		if (node.isLeaf()) {
			return;
		}

		//postorder per assicurarmi di aver calcolato prima i costi ottimali dei figli
		generateDynamicMapping(node.getLeft(),G);
		generateDynamicMapping(node.getRight(),G);

		//se sono un nodo interno calcolo il punteggio migliore di mandare il node nei 4 punti della forketta

		//left
		setLeftCost(node,G);

		//right
		setRightCost(node,G);

		//center
		setCenterCost(node,G);

		//top
		setTopCost(node,G);

		//!!! l'ordine center -> top conta!!!//
		/*int a=0;
	a++;*/

	}


	private static void setTopCost(Node node,RootedTree G) {

		// se il centro ed il top sono uguali allora il top si deve comportare come il centro
		if (node.getFork().getTop()==node.getFork().getCenter()) {
			node.getMapping().getTop_fork_map().setNodo(node.getFork().getTop());
			node.getMapping().getTop_fork_map().setCosto(node.getMapping().getCenter_fork_map().getCosto());
			node.getMapping().getTop_fork_map().setMapLeft(node.getMapping().getCenter_fork_map().getMapLeft());
			node.getMapping().getTop_fork_map().setMapRight(node.getMapping().getCenter_fork_map().getMapRight());
			return;
		} 

		//costo transfer
		//Ë massimo perchË non puÚ avvenire quando il nodo Ë al top
		float costoTransfer= Integer.MAX_VALUE;

		//costo speciazione
		//Ë massimo perchË non puÚ avvenire quando il nodo Ë al top
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


	private static void setCenterCost(Node node,RootedTree G) {

		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli Ë esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//decido se la duplicazione avviene a destra o a sinistra
			//sinistra
			float costoDuplicazioneSinistra=0;
			AtomicInteger forkPointLeftDuplicazioneSinistra= new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa
			AtomicInteger forkPointRightDuplicazioneSinistra=new AtomicInteger(0);//dove viene mappato il figlio, utile per ricostruire la mappa

			//se un figlio ha la stessa forchetta allora lui Ë costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getLeft().getFork())) {
				float costoDuplicazioneSinistraCentro=node.getLeft().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneSinistraSinistra=node.getLeft().getMapping().getLeft_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneSinistra=costoDuplicazioneSinistra+Math.min(costoDuplicazioneSinistraCentro,costoDuplicazioneSinistraSinistra);
				if (costoDuplicazioneSinistraCentro<=costoDuplicazioneSinistraCentro) {//setto per ricostruire la mappa
					forkPointLeftDuplicazioneSinistra.set(ForksConstant.CENTER);
				} else {
					forkPointLeftDuplicazioneSinistra.set(ForksConstant.LEFT);
				}
			} else {// altrimenti se la forchetta Ë effettivamente a sinistra lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
				if (node.getLeft().getFork().getTop().equals(node.getFork().getLeft())) {
					costoDuplicazioneSinistra=costoDuplicazioneSinistra+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointLeftDuplicazioneSinistra);
				} else {
					costoDuplicazioneSinistra=Integer.MAX_VALUE;
				}
			}

			//se un figlio ha la stessa forchetta allora  lui Ë costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				float costoDuplicazioneSinistraCentro=node.getRight().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneSinistraSinistra=node.getRight().getMapping().getLeft_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneSinistra=costoDuplicazioneSinistra+Math.min(costoDuplicazioneSinistraCentro,costoDuplicazioneSinistraSinistra);
				if (costoDuplicazioneSinistraCentro<=costoDuplicazioneSinistraSinistra) {//setto per ricostruire la mappa
					forkPointRightDuplicazioneSinistra.set(ForksConstant.CENTER);
				} else {
					forkPointRightDuplicazioneSinistra.set(ForksConstant.LEFT);
				}
			} else {// altrimenti se la forchetta Ë effettivamente a sinistra lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
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
			//se un figlio ha la stessa forchetta allora lui Ë costretto ad andare al centro o a destra
			if (node.getFork().equals(node.getLeft().getFork())) {
				float costoDuplicazioneDestraCentro=node.getLeft().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneDestraDestra=node.getLeft().getMapping().getRight_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneDestra=costoDuplicazioneDestra+Math.min(costoDuplicazioneDestraCentro,costoDuplicazioneDestraDestra);
				if (costoDuplicazioneDestraCentro<=costoDuplicazioneDestraDestra) {//setto per ricostruire la mappa
					forkPointLeftDuplicazioneDestra.set(ForksConstant.CENTER);
				} else {
					forkPointLeftDuplicazioneDestra.set(ForksConstant.RIGHT);
				}
			} else {// altrimenti se la forchetta Ë effettivamente a sinistra lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
				if (node.getLeft().getFork().getTop().equals(node.getFork().getRight())) {
					costoDuplicazioneDestra=costoDuplicazioneDestra+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getCenter(),parameters.getCl(),forkPointLeftDuplicazioneDestra);
				} else {
					costoDuplicazioneDestra=Integer.MAX_VALUE;
				}
			}

			//se un figlio ha la stessa forchetta allora  lui Ë costretto ad andare al centro o a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				float costoDuplicazioneDestraCentro=node.getRight().getMapping().getCenter_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				float costoDuplicazioneDestraDestra=node.getRight().getMapping().getRight_fork_map().getCosto()+parameters.getCl(); //aggiungo il costo senza mettendoci una loss (va nel figlio sinistro)
				costoDuplicazioneDestra=costoDuplicazioneDestra+Math.min(costoDuplicazioneDestraCentro,costoDuplicazioneDestraDestra);
				if (costoDuplicazioneDestraCentro<=costoDuplicazioneDestraDestra) {//setto per ricostruire la mappa
					forkPointRightDuplicazioneDestra.set(ForksConstant.CENTER);
				} else {
					forkPointRightDuplicazioneDestra.set(ForksConstant.RIGHT);
				}
			} else {// altrimenti se la forchetta Ë effettivamente a sinistra lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
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
		//Ë massimo perchË non puÚ avvenire quando il nodo Ë al centro
		float costoTransfer=Integer.MAX_VALUE;


		//costo speciazione
		float costoSpeciazione= 0;


		//il costo della speciazione Ë quando il figlio sinistro va a left fork e il destro a right fork oppure
		float costoSpeciazioneLeftLeftRightRight=0;
		AtomicInteger forkPointLeftLeftRightRightLEFT= new AtomicInteger(0);//per ricostruire la mappa finale
		AtomicInteger forkPointLeftLeftRightRightRIGHT= new AtomicInteger(0);


		//il costo della speciazione Ë quando il figlio sinistro va a right fork e il destro a left fork
		float costoSpeciazioneLeftRightRightLeft=0;
		AtomicInteger forkPointLeftRightRightLeftLEFT= new AtomicInteger(0);//per ricostruire la mappa finale
		AtomicInteger forkPointLeftRightRightLeftRIGHT= new AtomicInteger(0);


		//quindi leftleftrightright
		if (node.getLeft().getFork().equals(node.getFork())) { //se la fork di left Ë la stessa, allora left deve andare a sinistra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getLeft().getMapping().getLeft_fork_map().getCosto();//prendo il costo di mandare left a sinistra senza aggiungere loss chiaramente
			forkPointLeftLeftRightRightLEFT.set(ForksConstant.LEFT);
		} else if(node.getLeft().getFork().contains(node.getFork().getLeft()) ) { //altrimenti se le forchette sono diverse e sinistra comunque puÚ stare sulla sinistra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getLeft().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftLeftRightRightLEFT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non puÚ essere leftleftrightright
			costoSpeciazioneLeftLeftRightRight=Integer.MAX_VALUE;
		}

		if (node.getRight().getFork().equals(node.getFork())) { //se la fork di right Ë la stessa, allora right deve andare a right
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getRight().getMapping().getRight_fork_map().getCosto();//prendo il costo di mandare right a destra senza aggiungere loss chiaramente
			forkPointLeftLeftRightRightRIGHT.set(ForksConstant.RIGHT);
		} else if(node.getRight().getFork().contains(node.getFork().getRight()) ) { //altrimenti se le forchette sono diverse e destra comunque puÚ stare sulla destra
			costoSpeciazioneLeftLeftRightRight=costoSpeciazioneLeftLeftRightRight+node.getRight().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftLeftRightRightRIGHT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non puÚ essere leftleftrightright
			costoSpeciazioneLeftLeftRightRight=Integer.MAX_VALUE;
		}


		//quindi leftrightrightleft
		if (node.getLeft().getFork().equals(node.getFork())) { //se la fork di left Ë la stessa, allora left deve andare a destra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getLeft().getMapping().getRight_fork_map().getCosto();//prendo il costo di mandare left a sinistra senza aggiungere loss chiaramente
			forkPointLeftRightRightLeftLEFT.set(ForksConstant.RIGHT);
		} else if(node.getLeft().getFork().contains(node.getFork().getRight()) ) { //altrimenti se le forchette sono diverse e sinistra comunque puÚ stare sulla destra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getLeft().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftRightRightLeftLEFT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non puÚ essere leftrightrightleft
			costoSpeciazioneLeftRightRightLeft=Integer.MAX_VALUE;
		}

		if (node.getRight().getFork().equals(node.getFork())) { //se la fork di right Ë la stessa, allora right deve andare a sinistra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getRight().getMapping().getLeft_fork_map().getCosto();//prendo il costo di mandare right a destra senza aggiungere loss chiaramente
			forkPointLeftRightRightLeftRIGHT.set(ForksConstant.LEFT);
		} else if(node.getRight().getFork().contains(node.getFork().getLeft()) ) { //altrimenti se le forchette sono diverse e destra comunque puÚ stare sulla sinistra
			costoSpeciazioneLeftRightRightLeft=costoSpeciazioneLeftRightRightLeft+node.getRight().getMapping().getMinimumPlusDistanceSpeciazione(node.getFork().getCenter(),parameters.getCl(),forkPointLeftRightRightLeftRIGHT);//conto una qualsiasi posizione con le loss
		} else {//altrimenti non puÚ essere leftrightrightleft
			costoSpeciazioneLeftRightRightLeft=Integer.MAX_VALUE;
		}

		//il costo della speciazione quindi Ë il minimo tra i due
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


	private static void setLeftCost(Node node,RootedTree G) {
		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli Ë esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//se un figlio ha la stessa forchetta allora anche lui Ë costretto ad andare a sinistra
			if (node.getFork().equals(node.getLeft().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneSinistra.set(ForksConstant.LEFT);
			} else {// altrimenti lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointDuplicazioneSinistra);
			}

			//se un figlio ha la stessa forchetta allora anche lui Ë costretto ad andare a sinistra
			if (node.getFork().equals(node.getRight().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneDestra.set(ForksConstant.LEFT);
			} else {// altrimenti lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointDuplicazioneDestra);
			}

			//sommo il costo della duplicazione
			costoDuplicazione=costoDuplicazione+parameters.getCd();

		} else {
			costoDuplicazione=Integer.MAX_VALUE;
		}

		//costo speciazione
		//Ë massimo perchË non puÚ avvenire quando il nodo Ë sulla sinistra
		float costoSpeciazione= Integer.MAX_VALUE;

		//costo transfer
		float costoTransfer=0;



		AtomicInteger forkPointTransferSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestra= new AtomicInteger(0);

		//possibile quando leftleftrightright
		float costoTransferLeftLeftRightRight=0;
		AtomicInteger forkPointTransferSinistraLeftLeftRightRight = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftLeftRightRight= new AtomicInteger(0);

		//se il figlio sinistro contiene il left, allora ci puÚ andare 
		if (node.getLeft().getFork().contains(node.getFork().getLeft())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftLeftRightRight.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse vedo dove puÚ andare tra tutti i suoi punti
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointTransferSinistraLeftLeftRightRight);
			}
		} else {// altrimenti il sinistro non puÚ andare in left quindi non puÚ essere leftleftrightright
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
		} else {// altrimenti il destro non puÚ andare in right quindi non puÚ essere leftleftrightright
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
		} else {// altrimenti il sinistro non puÚ andare in right quindi non puÚ essere leftleftrightright
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il left, allora puÚ andarci 
		if (node.getRight().getFork().contains(node.getFork().getLeft())) {
			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in left
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getLeft_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftRightRightLeft.set(ForksConstant.LEFT);
			} else { //altrimenti se sono forchette diverse vedo dove puÚ andare tra tutti i suoi punti
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getLeft(),parameters.getCl(),forkPointTransferDestraLeftRightRightLeft);

			}
		} else {// altrimenti il destro non puÚ andare in left quindi non puÚ essere leftrightrightleft
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}


		//il costo del transfer Ë il minimo tra i due
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


	private static void setRightCost(Node node,RootedTree G) {
		//costo duplicazione
		float costoDuplicazione=0;
		AtomicInteger forkPointDuplicazioneSinistra = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointDuplicazioneDestra= new AtomicInteger(0);
		//possibile solo se almeno una delle forchette dei figli Ë esattamente la forchetta del nodo
		if (node.getFork().equals(node.getLeft().getFork()) || node.getFork().equals(node.getRight().getFork())) {

			//se un figlio ha la stessa forchetta allora anche lui Ë costretto ad andare a destra
			if (node.getFork().equals(node.getLeft().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneSinistra.set(ForksConstant.RIGHT);

			} else {// altrimenti lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss

				costoDuplicazione=costoDuplicazione+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointDuplicazioneSinistra);
			}

			//se un figlio ha la stessa forchetta allora anche lui Ë costretto ad andare a destra
			if (node.getFork().equals(node.getRight().getFork())) {
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (vanno nello stesso valore)
				forkPointDuplicazioneDestra.set(ForksConstant.RIGHT);

			} else {// altrimenti lo metto nel minimo di dove puÚ andare il figlio sommandoci le loss
				costoDuplicazione=costoDuplicazione+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointDuplicazioneDestra);
			}

			//sommo il costo della duplicazione
			costoDuplicazione=costoDuplicazione+parameters.getCd();

		} else {
			costoDuplicazione=Integer.MAX_VALUE;
		}

		//costo speciazione
		//Ë massimo perchË non puÚ avvenire quando il nodo Ë sulla sinistra
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
		} else {// altrimenti il sinistro non puÚ andare in left quindi non puÚ essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//se il figlio destro contiene il right, allora ci puÚ andare 
		if (node.getRight().getFork().contains(node.getFork().getRight())) {

			if (node.getRight().getFork().equals(node.getFork())) { // se il figlio destro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferDestraLeftLeftRightRight.set(ForksConstant.RIGHT);
			} else { //altrimenti se sono forchette diverse vedo dove puÚ andare tra tutti i suoi punti
				costoTransferLeftLeftRightRight=costoTransferLeftLeftRightRight+node.getRight().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointTransferDestraLeftLeftRightRight);
			}
		} else {// altrimenti il destro non puÚ andare in right quindi non puÚ essere leftleftrightright
			costoTransferLeftLeftRightRight=Integer.MAX_VALUE;
		}

		//possibile quando leftrightrightleft
		float costoTransferLeftRightRightLeft=0;
		AtomicInteger forkPointTransferSinistraLeftRightRightLeft = new AtomicInteger(0); //setto anche per il mapping
		AtomicInteger forkPointTransferDestraLeftRightRightLeft= new AtomicInteger(0);

		//se il figlio sinistro contiene il right, allora ci puÚ andare 
		if (node.getLeft().getFork().contains(node.getFork().getRight())) {

			if (node.getLeft().getFork().equals(node.getFork())) { // se il figlio sinistro ha la stessa forchetta allora deve andare per forza in right
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getRight_fork_map().getCosto(); //aggiungo il costo senza metterci loss (va nel transfer diretto)
				forkPointTransferSinistraLeftRightRightLeft.set(ForksConstant.RIGHT);
			} else {//altrimenti se sono forchette diverse vedo dove puÚ andare tra tutti i suoi punti
				costoTransferLeftRightRightLeft=costoTransferLeftRightRightLeft+node.getLeft().getMapping().getMinimumPlusDistance(node.getFork().getRight(),parameters.getCl(),forkPointTransferSinistraLeftRightRightLeft);
			}
		} else {// altrimenti il sinistro non puÚ andare in right quindi non puÚ essere leftleftrightright
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
		} else {// altrimenti il destro non puÚ andare in left quindi non puÚ essere leftrightrightleft
			costoTransferLeftRightRightLeft=Integer.MAX_VALUE;
		}


		//il costo del transfer Ë il minimo tra i due
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

	//setta i costi a tutti gli archi
	public static void walk(UnRootedTree g,RootedTree S) {

		//assegnamo il peso al primo arco, ovvero secondo il format input, l'arco tra il left della radice
		//del GFirst e il destro della radice del GFirst
		g.getFirstG().getRoot().getLeft().setEdgeFatherWeight(g.getFirstG().getRoot().getMapping().getBetter());

		//facciamo partire in post order su GFirst la procedura ricorsiva che assegna i pesi agli archi
		assignWeights(g.getFirstG(),g.getFirstG().getRoot().getLeft(),S);


	}

	//prendo in input l'albero rootato gi‡ con tutte l informazioni ed il nodo il cui arco 
	//adiacente con il padre Ë stato pesato
	private static void assignWeights(RootedTree g, Node v, RootedTree S) {

		//se v Ë una foglia non devo fare nulla
		if (v.isLeaf()) {
			return;
		}

		//mi salvo i valori che potrebbero cambiare,
		//mi salvo il figlio di root che non Ë v
		//e mi salvo se v Ë figlio sinistro o destro di root
		boolean vIsLeftChildOfOldRoot=v.isLeftChild();
		Node oldRootSonNotV=v.getSibling();

		Node oldVLeft= v.getLeft();
		Node oldVRight= v.getRight();

		//faccio finta di radicare in v_1 - left

		//aggiorno la nuova radice, qui Ë arbitrario l'ordine
		g.getRoot().setLeft(v.getLeft());
		g.getRoot().setRight(v);

		//aggiorno v
		v.setLeft(oldRootSonNotV);
		
		//aggiorno il padre di left.v
		oldVLeft.setParent(g.getRoot());

		//aggiorno le forchette di v e poi r
		//updateSingleFork(v);
		//updateSingleFork(g.getRoot());
		setForks(g, S);
		
		//aggiorno i tops di v ed r (ATTENZIONE NON LINEARE!!!!!!!!!!!!) 
		setTops(g);

		//ora che ho aggiornato sia root che v, devo ricalcolare il costo
		generateMapping(g, parameters);


		//ora che ho ricalcolato il costo assegno il peso all'arco (v,v.left) 
		oldVLeft.setEdgeFatherWeight(g.getRoot().getMapping().getBetter());

		//adesso faccio ricorsione sui figli di v.left (old)  
		//e ipotizzo che alla fine della ricorsione il grafo g Ë come lo ho lasciato
		assignWeights(g,oldVLeft,S);

		//ora devo radicare in v.right, ma per farlo ritorno alla configurazione originaria
		//reset r
		if (vIsLeftChildOfOldRoot) {
			g.getRoot().setLeft(v);
			g.getRoot().setRight(oldRootSonNotV);
		} else {
			g.getRoot().setLeft(oldRootSonNotV);
			g.getRoot().setRight(v);
		}


		//reset v
		v.setLeft(oldVLeft);
		
		//reset left.v
		oldVLeft.setParent(v);

		//radico ora in v.right, quindi aggiorno la radice
		g.getRoot().setLeft(v);
		g.getRoot().setRight(v.getRight());

		//aggiorno v
		v.setRight(oldRootSonNotV);

		//aggiorno il padre di right.v
		oldVRight.setParent(g.getRoot());
		
		//aggiorno le forchette di v e poi r
		//updateSingleFork(v);
		//updateSingleFork(g.getRoot());
		setForks(g, S);
		
		//aggiorno i tops di v ed r (ATTENZIONE NON LINEARE!!!!!!!!!!!!) 
		setTops(g);

		//ora che ho aggiornato sia root che v, devo ricalcolare il costo
		//di v ed R
		generateMapping(g, parameters);

		//ora che ho ricalcolato il costo assegno il peso all'arco (v,v.right) 
		oldVRight.setEdgeFatherWeight(g.getRoot().getMapping().getBetter());

		//adesso faccio ricorsione sui figli di v.right (old) 
		//e ipotizzo che che alla fine della ricorsione il grafo g Ë come lo ho lasciato
		assignWeights(g,oldVRight,S);

		//avrei finito, ma per poter usufruire dell'ipotesi che g Ë sempre come lo ho lasciato, 
		//lo riporto allo stato originale
		//reset root
		if (vIsLeftChildOfOldRoot) {
			g.getRoot().setLeft(v);
			g.getRoot().setRight(oldRootSonNotV);
		} else {
			g.getRoot().setLeft(oldRootSonNotV);
			g.getRoot().setRight(v);
		}
		//reset v
		v.setRight(oldVRight);
		
		//reset left.v
		oldVRight.setParent(v);

	}


	private static void updateSingleFork(Node node) {
		if (node.isLeaf()) {
			return;
		}

		//il centro Ë il lca dei centri dei figli
		Node lca=(node.getLeft().getFork().getCenter()).lca(node.getRight().getFork().getCenter());

		node.getFork().setCenter(lca);

		if (lca.isLeaf()) { // se lca Ë una foglia allora left e right li metto uguali
			node.getFork().setLeft(lca);
			node.getFork().setRight(lca);
		} else { //altrimenti i figli
			node.getFork().setLeft(node.getFork().getCenter().getLeft());
			node.getFork().setRight(node.getFork().getCenter().getRight());
		}

		return ;

	}

	private static void generateDynamicMappingNonRecursive(Node node,RootedTree G) {

		//se sono una foglia non devo fare nnt
		if (node.isLeaf()) {
			return;
		}

		//se sono un nodo interno calcolo il punteggio migliore di mandare il node nei 4 punti della forketta

		//left
		setLeftCost(node,G);

		//right
		setRightCost(node,G);

		//center
		setCenterCost(node,G);

		//top
		setTopCost(node,G);

	}


}
