package com.programs.tree.traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Tree Traversal<br>
 * 1. Pre Order Tree Traversal   (P-L-R)<br>
 * 2. In Order Tree Traversal    (L-P-R)<br>
 * 3. Post Order Tree Traversal  (L-R-P)<br>
 * 4. Level Order Tree Traversal (Level)<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class TreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = { 27, 14, 35, 10, 19, 31, 42 };
		BinarySearchTree bstTree = new BinarySearchTree();
		bstTree.create(array);
		System.out.println("Tree: " + bstTree.getRoot());
		System.out.println();
		Node node = bstTree.search(31);
		System.out.println((node != null) ? "Element(31) found: " + node : "Element(31) not found");
		node = bstTree.search(15);
		System.out.println((node != null) ? "Element(15) found: " + node : "Element(15) not found");
		System.out.println();
		System.out.printf("Pre Order Traversal   : ");
		preOrderTraversal(bstTree.getRoot());
		System.out.println();
		System.out.printf("In Order Traversal    : ");
		inOrderTraversal(bstTree.getRoot());
		System.out.println();
		System.out.printf("Post Order Traversal  : ");
		postOrderTraversal(bstTree.getRoot());
		System.out.println();
		System.out.printf("Level Order Traversal : ");
		levelOrderTraversal(bstTree.getRoot());
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

	/**
	 * Level Order Tree Traversal (Print by Level)
	 * 
	 * @param node
	 */
	private static void levelOrderTraversal(Node root) {
		List<Node> queue = new LinkedList<Node>();
		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				Node node = queue.remove(0);
				System.out.printf(node.getData() + " ");
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
		}
	}
}
