package forks;

import java.io.IOException;
import java.util.Scanner;

import eucalypt.EucalyptService;
import input.InputInterface;
import input.nPlateausInput;
import output.GraphOutput;
import output.OutputInterface;
import output.SimpleOutput;
import structures.Node;
import structures.RootedTree;
import structures.UnRootedTree;

public class EucalyptUnrooted {
	

	//static InputInterface input= new SimpleInput();
	static InputInterface input;

	//static OutputInterface output= new SimpleOutput();
	static OutputInterface output= new GraphOutput();

	static UnRootedTree G;

	static RootedTree S;

	public static void main(String[] args) throws IOException {

		System.out.println("Numero di plateaus: ");

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.close();
		
		long startTime = System.currentTimeMillis();

		input = new nPlateausInput(n);


		G= new UnRootedTree(input.getUnrootedG(),input.getMapping());

		S= new RootedTree(input.getS(),input.getMapping());

		labelEdges(G.getFirstG().getRoot().getLeft());

		output.printUnrooted(G);

		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("tempo di esecuzione: "+elapsedTime/1000+"s");


	}


	private static void labelEdges(Node g) throws IOException {

		//System.out.println("Starting new tree:  "+g.getLabel());

		g.setEdgeFatherWeight(EucalyptService.getOptimumReconciliationWeight(S,G.getFirstG()));

		//System.out.println(g.getEdgeFatherWeight());

		if (!g.isLeaf()) {

			boolean wasRight=g.isRightChild();

			updateGLeft(g);

			labelEdges(G.getFirstG().getRoot().getLeft());

			restoreGFromLeft(g,wasRight);

			updateGRight(g);

			labelEdges(G.getFirstG().getRoot().getRight());

			restoreGFromRight(g,wasRight);

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
	private static void restoreGFromLeft(Node g, boolean wasRight) {

		Node old_g_left = g.getLeft();

		G.getFirstG().getRoot().getLeft().setParent(g);

		g.setLeft(G.getFirstG().getRoot().getLeft());

		old_g_left.setParent(G.getFirstG().getRoot());

		if (wasRight) {

			G.getFirstG().getRoot().setLeft(old_g_left);

			G.getFirstG().getRoot().setRight(g);

		} else {

			G.getFirstG().getRoot().setLeft(g);

			G.getFirstG().getRoot().setRight(old_g_left);

		}

	}



	private static void updateGRight(Node g) {

		Node old_g_sibling= g.getSibling();

		g.getRight().setParent(G.getFirstG().getRoot());

		G.getFirstG().getRoot().setRight(g.getRight());

		G.getFirstG().getRoot().setLeft(g);

		g.setRight(old_g_sibling);

		old_g_sibling.setParent(g);

	}


	private static void restoreGFromRight(Node g, boolean wasRight) {

		Node old_g_right = g.getRight();

		G.getFirstG().getRoot().getRight().setParent(g);

		g.setRight(G.getFirstG().getRoot().getRight());

		old_g_right.setParent(G.getFirstG().getRoot());

		if (wasRight) {

			G.getFirstG().getRoot().setLeft(old_g_right);

			G.getFirstG().getRoot().setRight(g);

		} else {

			G.getFirstG().getRoot().setLeft(g);

			G.getFirstG().getRoot().setRight(old_g_right);

		}


	}







}
