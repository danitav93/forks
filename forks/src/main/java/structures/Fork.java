package structures;

public class Fork {

	private Node center;
	private Node top;
	private Node left;
	private Node right;
	
	
	
	public Node getCenter() {
		return center;
	}
	public void setCenter(Node center) {
		this.center = center;
	}
	public Node getTop() {
		return top;
	}
	public void setTop(Node top) {
		this.top = top;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public boolean equals(Fork fork) {
		if (fork==null) {
			return false;
		}
		
		return fork.getCenter()==getCenter();
	}
	public boolean contains(Node node) {
		if (node==center || node==top || node== left || node==right) {
			return true;
		}
		return false;
	}
	public boolean isSingleNode() {
		return center==left && center==right;
	}
	
}
