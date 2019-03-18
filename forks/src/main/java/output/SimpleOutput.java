package output;

import structures.Node;
import structures.RootedTree;
import structures.UnRootedTree;

public class SimpleOutput implements OutputInterface{


	@Override
	public void printUnrooted(UnRootedTree G) {
		
		float minimum= findMinimumCost(G.getFirstG().getRoot().getLeft());
		
		System.out.println("Costo ottimo: "+minimum);
		
		System.out.println("Numero di plateau: "+getNumberOfPlateaus(G.getFirstG().getRoot().getLeft(),minimum));
		
		//printWeight(G.getFirstG().getRoot().getLeft(),G.getFirstG());
		
	}

	private int getNumberOfPlateaus(Node g, float minimum) {
		
		if (g.isLeaf()) {
			if (g.getEdgeFatherWeight()==minimum && g.getEdgeFatherWeight()!=g.getParent().getEdgeFatherWeight()) {
				if (g.isRightChild()) {
					return 1;
				} 
				if (g.getSibling().getEdgeFatherWeight()==minimum) {
					return 0;
				}
				return 1;
				
			}
			return 0;
		}
		
		int fromBottom= getNumberOfPlateaus(g.getLeft(),minimum)+getNumberOfPlateaus(g.getRight(),minimum);
		int currentContribute=0;
		if (g.getEdgeFatherWeight()==minimum && g.getEdgeFatherWeight()!=g.getParent().getEdgeFatherWeight()) {
			if (g.isRightChild()) {
				currentContribute=1;
			} else if (g.getSibling().getEdgeFatherWeight()!=minimum) {
				currentContribute=1;
			}
		}
			
		return fromBottom+currentContribute;
	}

	public static float findMinimumCost(Node v) {
		if (v.isLeaf()) {
			return v.getEdgeFatherWeight();
		}
		return Math.min(Math.min(findMinimumCost(v.getLeft()),findMinimumCost(v.getRight())),v.getEdgeFatherWeight());
	}

	private void printWeight(Node node,RootedTree g) {
		
		
		if (node!=g.getRoot().getLeft()) {
			System.out.println(node.getLabel()+" - "+node.getParent().getLabel()+" score: "+node.getEdgeFatherWeight());
		}else {
			System.out.println(node.getLabel()+" - "+node.getParent().getRight().getLabel()+" score: "+node.getEdgeFatherWeight());
		}
		if (!node.isLeaf()) {
			printWeight(node.getLeft(),g);
			printWeight(node.getRight(),g);
		}
		
	};
	
}
