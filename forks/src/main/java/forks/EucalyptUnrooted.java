package forks;

import java.io.IOException;

import eucalypt.EucalyptService;
import input.InputInterface;
import input.SimpleInput;
import output.OutputInterface;
import output.SimpleOutput;
import structures.Node;
import structures.RootedTree;
import structures.UnRootedTree;

public class EucalyptUnrooted {

	static InputInterface input= new SimpleInput();
	static OutputInterface output= new SimpleOutput();

	static UnRootedTree G;

	static RootedTree S;

	public static void main(String[] args) throws IOException {


		G= new UnRootedTree(input.getUnrootedG(),input.getMapping());

		S= new RootedTree(input.getS(),input.getMapping());

		labelEdges(G.getFirstG().getRoot().getLeft());

		output.printUnrooted(G);




	}


	private static void labelEdges(Node g) throws IOException {



		g.setEdgeFatherWeight(EucalyptService.getOptimumReconciliationWeight(S,G.getFirstG()));

		if (!g.isLeaf()) {

			updateGLeft(g);

			labelEdges(G.getFirstG().getRoot().getLeft());

			restoreGFromLeft(g);
			
			updateGRight(g);

			labelEdges(G.getFirstG().getRoot().getRight());
			
			restoreGFromRight(g);

		}

	}

	//sposto la radice all'arco sinistro
	private static void updateGLeft(Node g) {


		Node old_g_sibling= g.getSibling();

		g.getLeft().setParent(G.getFirstG().getRoot());

		G.getFirstG().getRoot().setLeft(g.getLeft());

		G.getFirstG().getRoot().setRight(g);

		g.setLeft(old_g_sibling);

		old_g_sibling.setParent(g);

	}

	//Riporto la radice sopra dall'arco sinistro
	private static void restoreGFromLeft(Node g) {

		Node old_g_left = g.getLeft();

		G.getFirstG().getRoot().getLeft().setParent(g);
		
		g.setLeft(G.getFirstG().getRoot().getLeft());
		
		old_g_left.setParent(G.getFirstG().getRoot());
		
		G.getFirstG().getRoot().setLeft(g);
		
		G.getFirstG().getRoot().setRight(old_g_left);

	}



	private static void updateGRight(Node g) {
		
		Node old_g_sibling= g.getSibling();

		g.getRight().setParent(G.getFirstG().getRoot());

		G.getFirstG().getRoot().setRight(g.getRight());

		G.getFirstG().getRoot().setLeft(g);

		g.setRight(old_g_sibling);

		old_g_sibling.setParent(g);
		
	}


	private static void restoreGFromRight(Node g) {
		
		Node old_g_right = g.getRight();

		G.getFirstG().getRoot().getRight().setParent(g);
		
		g.setRight(G.getFirstG().getRoot().getRight());
		
		old_g_right.setParent(G.getFirstG().getRoot());
		
		G.getFirstG().getRoot().setLeft(g);
		
		G.getFirstG().getRoot().setRight(old_g_right);
		
	}







}
