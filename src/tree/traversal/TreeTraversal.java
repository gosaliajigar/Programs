package com.programs.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

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
		BinaryNode node = bstTree.search(31);
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
	public static void preOrderTraversal(BinaryNode node) {
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
	public static void inOrderTraversal(BinaryNode node) {
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
	public static void postOrderTraversal(BinaryNode node) {
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
	public static void levelOrderTraversal(BinaryNode root) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryNode node = queue.remove();
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
