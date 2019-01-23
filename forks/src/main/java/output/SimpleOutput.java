package output;

import structures.Node;
import structures.UnRootedTree;

public class SimpleOutput implements OutputInterface{


	@Override
	public void printUnrooted(UnRootedTree G) {
		
		printWeight(G.getFirstG().getRoot().getLeft());
		
	}

	private void printWeight(Node node) {
		
		System.out.println(node.getLabel()+" - "+node.getParent().getLabel()+" score: "+node.getEdgeFatherWeight());
		
		if (!node.isLeaf()) {
			printWeight(node.getLeft());
			printWeight(node.getRight());
		}
		
	};
	
}
