/**
 * 
 */
package com.programs.tree.traversal;

/**
 * Node for Tree Traversal
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Node {

	int data;

	Node left;

	Node right;

	/**
	 * @param data
	 */
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * @param data
	 * @param left
	 * @param right
	 */
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}
