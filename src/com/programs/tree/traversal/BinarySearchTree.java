package com.programs.tree.traversal;

/**
 * Binary Search Tree BST and its operations.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTree {

	/**
	 * 
	 */
	private Node root;

	public BinarySearchTree () {
		super();
		this.root = null;
	}

	/**
	 * @return
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param array
	 */
	public void create(int array[]) {
		for (int index = 0; index < array.length; index++) {
			insert(array[index]);
		}
	}

	/**
	 * @param data
	 */
	public void insert(int data) {
		Node node = new Node(data, null, null);
		Node parent;
		if (root == null) {
			root = node;
		} else {
			Node current = root;
			parent = null;
			while(true) {
				if (data > current.getData()) {
					parent = current;
					current = current.getRight();
					if (current == null) {
						parent.setRight(node);
						break;
					}
				} else if (data <= current.getData()) {
					parent = current;
					current = current.getLeft();
					if (current == null) {
						parent.setLeft(node);;
						break;
					}
				}
			}
		}
	}

	/**
	 * @param data
	 * @return
	 */
	public Node search(int data) {
		Node node = null;
		Node current = root;
		while(current != null) {
			if (data > current.getData()) {
				current = current.getRight();
			} else if (data < current.getData()) {
				current = current.getLeft();
			} else {
				node = current;
				break;
			}
		}
		return node;
	}
}
