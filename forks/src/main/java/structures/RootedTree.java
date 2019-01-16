package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import constants.Errors;
import methods.Methods;


public class RootedTree {

	private List<Node> nodes= new ArrayList<>();
	private Node root;
	private HashMap<String,String> labelMapping;

	
	public RootedTree(String inputFormat, HashMap<String,String> labelMapping) {
		this.labelMapping=labelMapping;
		initializeNodes(inputFormat,null);
	}
	
   private Node initializeNodes(String rooted, Node parent) {
		
		if (!rooted.contains(",")) {
				Node leaf= new Node();
				nodes.add(leaf);
				leaf.setParent(parent);
				leaf.setLabel(rooted);
				return leaf;
		}
		
		String label= rooted.substring(rooted.lastIndexOf("!"));
		
		String withoutExternalBrackets= rooted.substring(1,rooted.lastIndexOf(")"));
		
		Node node= new Node();
		
		if (parent==null) {
			root=node;
		}
		
		nodes.add(node);
		
		node.setLabel(label);
		
		node.setParent(parent);
		
		node.setLeft(initializeNodes(rooted.substring(1,Methods.findMiddleIndexComma(rooted)),node));
		
		node.setRight(initializeNodes(withoutExternalBrackets.substring(Methods.findMiddleIndexComma(rooted)),node));
				
		return node;
		
	}
	
	public Node getNodeByLabel(String label) {
		
		
		
		for (Node node:nodes) {
			if (node.getLabel().equals(label)) {
				return node;
			}
		}
		
		if (labelMapping.containsKey(label)) {
			return getNodeByLabel(labelMapping.get(label));
		}
		
		throw new RuntimeException(Errors.TREE_NODE_NOT_FOUND_ERROR+": "+label);
		
	}


	public List<Node> getNodes() {
		return nodes;
	}


	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}


	public Node getRoot() {
		return root;
	}


	public void setRoot(Node root) {
		this.root = root;
	}
	
	
	
	
	
}
