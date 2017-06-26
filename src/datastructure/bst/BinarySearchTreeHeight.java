package datastructure.bst;

/**
 * Find height of Binary Search Tree.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTreeHeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.create(new int[] { 27, 14, 35, 10, 19, 31, 42 });
		TreeTraversal.inOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println("Height of binary tree: " + findHeight(tree.getRoot()));
	}

	/**
	 * @param node
	 * @return
	 */
	public static int findHeight(BinaryNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}
}
