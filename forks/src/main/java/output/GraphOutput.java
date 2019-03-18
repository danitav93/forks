package output;

import java.awt.Color;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import structures.Node;
import structures.UnRootedTree;

public class GraphOutput implements OutputInterface {

	private UnRootedTree G;
	
	private Graph graph;
	
	private float optimum;
	
	@Override
	public void printUnrooted(UnRootedTree G) {
		
		this.G=G;
		
		optimum=SimpleOutput.findMinimumCost(G.getFirstG().getRoot().getLeft());
		
		//System.out.println(G.getFirstG().getDescription(G.getFirstG().getRoot()));
		
		graph = new SingleGraph("Undirected Labeled Graph");
		
		graph.addNode(G.getFirstG().getRoot().getRight().getLabel());
		
		recursion(G.getFirstG().getRoot().getLeft());
		
		graph.display();
		
	}

	private void recursion(Node node) {
		
		//System.out.println(node.getLabel());
		
		graph.addNode(node.getLabel());
		
		boolean isOptimum= node.getEdgeFatherWeight()==optimum;
		
		if (node==G.getFirstG().getRoot().getLeft()) {
			graph.addEdge(node.getSibling().getLabel()+"-"+node.getLabel(), node.getSibling().getLabel(), node.getLabel());
			graph.getEdge(node.getSibling().getLabel()+"-"+node.getLabel()).addAttribute("ui.label", node.getEdgeFatherWeight());
			if (isOptimum) {
				graph.getEdge(node.getSibling().getLabel()+"-"+node.getLabel()).addAttribute("ui.style", "size: 5px; fill-color: red;");
			}
		} else {
			graph.addEdge(node.getParent().getLabel()+"-"+node.getLabel(), node.getParent().getLabel(), node.getLabel());
			graph.getEdge(node.getParent().getLabel()+"-"+node.getLabel()).addAttribute("ui.label", node.getEdgeFatherWeight());
			if (isOptimum) {
				graph.getEdge(node.getParent().getLabel()+"-"+node.getLabel()).addAttribute("ui.style", "size: 5px; fill-color: red;");
			}
		}
		
		

		if (!node.isLeaf()) {
			recursion(node.getLeft());
			recursion(node.getRight());
		}
		
	}

}
