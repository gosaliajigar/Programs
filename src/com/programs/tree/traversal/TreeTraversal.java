package com.programs.tree.traversal;

/**
 * Tree Traversal<br>
 * 1. Pre Order Tree Traversal  (P-L-R)<br>
 * 2. In Order Tree Traversal   (L-P-R)<br>
 * 3. Post Order Tree Traversal (L-R-P)<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class TreeTraversal {

	/**
	 * 
	 */
	private static Node root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = { 27, 14, 35, 10, 19, 31, 42 };
		create(array);
		System.out.println("Tree: " + root);
		System.out.println();
		Node node = search(31);
		System.out.println((node != null) ? "Element(31) found: " + node : "Element(31) not found");
		node = search(15);
		System.out.println((node != null) ? "Element(15) found: " + node : "Element(15) not found");
		System.out.println();
		System.out.printf("Pre Order Traversal : ");
		preOrderTraversal(root);
		System.out.println();
		System.out.printf("In Order Traversal  : ");
		inOrderTraversal(root);
		System.out.println();
		System.out.printf("Post Order Traversal: ");
		postOrderTraversal(root);
	}

	/**
	 * @param array
	 */
	public static void create(int array[]) {
		for (int index = 0; index < array.length; index++) {
			insert(array[index]);
		}
	}

	/**
	 * @param data
	 */
	private static void insert(int data) {
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
	private static Node search(int data) {
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

	/**
	 * Pre Order Tree Traversal (P-L-R)
	 * 
	 * @param node
	 */
	private static void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.printf(node.getData() + " ");
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
		return;
	}

	/**
	 * In Order Tree Traversal (L-P-R)
	 * 
	 * @param node
	 */
	private static void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.getLeft());
			System.out.printf(node.getData() + " ");
			inOrderTraversal(node.getRight());
		}
		return;
	}

	/**
	 * Post Order Tree Traversal (L-R-P)
	 * 
	 * @param node
	 */
	private static void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.printf(node.getData() + " ");
		}
		return;
	}
}
