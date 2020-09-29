package datastructure.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import pojos.BinaryNode;

/**
 * Tree Traversal<br>
 * 1. Pre Order Tree Traversal   (P-L-R)<br>
 * 2. In Order Tree Traversal    (L-P-R)<br>
 * 3. Post Order Tree Traversal  (L-R-P)<br>
 * 4. Level Order Tree Traversal (Level)<br>
 * <br>
 * 
 * 					27
 * 			14				35
 * 		10		19		31		42
 * 									57
 * 
 * @author "Jigar Gosalia"
 *
 */
public class TreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = { 27, 14, 35, 10, 19, 31, 42, 57 };
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
		System.out.println();
		System.out.printf("Vertical Level Order Traversal : ");
		System.out.println(verticalOrderTraversal(bstTree.getRoot()));
		System.out.println();
		int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchTree minBST = new BinarySearchTree();
		minBST.createBST(a);
		inOrderTraversal(minBST.getRoot());
		System.out.println();
		System.out.println();
		System.out.println(BinarySearchTree.treeMinimum(minBST.getRoot()));
		System.out.println();
		System.out.println();
		System.out.println(BinarySearchTree.treeMaximum(minBST.getRoot()));

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
				if (node.getLeft() != null) queue.add(node.getLeft());
				if (node.getRight() != null) queue.add(node.getRight());
			}
		}
	}

	/**
	 * Vertical Level Order Tree Traversal (Print by Vertical Level)
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> verticalOrderTraversal(BinaryNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		helper(root, map);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.addAll(map.values());
		return result;
	}

	private static void helper(BinaryNode root, Map<Integer, List<Integer>> map) {
		if (root != null) {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			Queue<Integer> orders = new LinkedList<Integer>();
			queue.offer(root);
			orders.offer(0);
			while (!queue.isEmpty()) {
				BinaryNode node = queue.poll();
				int order = orders.poll();
				map.computeIfAbsent(order, key -> new ArrayList<Integer>()).add(node.data);
				if (node.left != null) {
					queue.offer(node.left);
					orders.offer(order - 1);
				}
				if (node.right != null) {
					queue.offer(node.right);
					orders.offer(order + 1);
				}
			}
		}
	}
}
