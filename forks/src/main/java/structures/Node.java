package structures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import constants.Errors;



public class Node {

    private Node parent;
	
	private Node left;
	
	private Node right;
	
	private String label;
	
	private Fork fork;
	
	private Mapping mapping;
	
	private float edgeFatherWeight;//per il grafo indiretto
	
	public Node getParent() {
		return parent;
	}

	public Node getLeft() {
		return left;
	}


	public Node getRight() {
		return right;
	}

	public Node getSibling() {
		
		if (isLeftChild()) {
			return parent.getRight();
		}
		return parent.getLeft();
	}

	public Set<Node> getCluster() {
		
		if (this instanceof Node ) {
			return new HashSet<>(Arrays.asList(this));
		}
		
		if (left==null || right==null) {
			throw new RuntimeException(Errors.TREE_NODE_ERROR_CHILDREN);
		}
		
		Set<Node> cluster= left.getCluster();
		cluster.addAll(right.getCluster());
		
		return cluster;
		
	}

	public boolean isLeaf() {
		
		return left==null && right==null;
		
	}

	public boolean isRoot() {
		return parent==null;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public boolean isLeftChild() {
		if (parent==null) {
			throw new RuntimeException(Errors.TREE_NODE_ERROR_IS_LEFT_OR_RIGHT);

		}
		return parent.getLeft()==this;
	}

	public boolean isRightChild() {
		if (parent==null) {
			throw new RuntimeException(Errors.TREE_NODE_ERROR_IS_LEFT_OR_RIGHT);

		}
		return parent.getRight()==this;
	}

	

	
	public boolean comparable(Node node) {
		if (node==null) {
			return false;
		}
		return  isAscendant(node) || isDescendant(node);
	}

	public boolean isAscendant(Node node) {
		
		if (this==node) {
			return true;
		}
		if (node.getParent()==null) {
			return false;
		}
		if (this==node.getParent()) {
			return true;
		}
		
		return isAscendant(node.getParent());
	}

	public boolean isDescendant(Node node) {
		if (node==this ) {
			return true;
		}

		if (getParent()==null) {
			return false;
		}
		if ( node==getParent()) {
			return true;
		}
		return getParent().isDescendant(node);
	}

	//non efficient
	public int getComparableDistance(Node node) {
	
		
		if (!node.comparable(this)) {
			return Integer.MAX_VALUE;
		}
		
		if (node==this) {
			return 0;
		}
		
		if (node.isAscendant(this)) {
			return getParent().getComparableDistance(node)+1;
		} else {
			return getComparableDistance(node.getParent())+1;
		}
		
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label=label;
	}

	public Node lca(Node node) {
		if (isAscendant(node)) {
			return (Node)this;
		}
		if (isDescendant(node)) {
			return node;
		}
		return getParent().lca(node.getParent());
	}

	public Fork getFork() {
		if (fork==null) {
			fork= new Fork();
		}
		return fork;
	}

	public void setFork(Fork fork) {
		this.fork = fork;
	}

	public Mapping getMapping() {
		if (mapping==null) {
			mapping= new Mapping();
		}
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public float getEdgeFatherWeight() {
		return edgeFatherWeight;
	}

	public void setEdgeFatherWeight(float edgeFatherWeight) {
		this.edgeFatherWeight = edgeFatherWeight;
	}

	

	
	
}
