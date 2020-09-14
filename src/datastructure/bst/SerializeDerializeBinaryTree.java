package datastructure.bst;

import pojos.BinaryNode;

/**
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SerializeDerializeBinaryTree {

	private static int[] array = new int[] { 27, 14, 35, 10, 19, 31, 42, 57 };

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.create(array);
		StringBuilder sb = new StringBuilder();
		serialize(tree.getRoot(), sb);
		TreeTraversal.preOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println(sb);

		System.out.println();

		BinaryNode newRoot = deserialize(sb.toString().split(","), new int[] { 0 });
		BinarySearchTree deserializeTree = new BinarySearchTree();
		deserializeTree.setRoot(newRoot);
		TreeTraversal.preOrderTraversal(deserializeTree.getRoot());
		System.out.println();
	}

	/**
	 * Serialize in Pre-Order Traversal
	 * 
	 * @param node
	 * @param sb
	 */
	public static void serialize(BinaryNode node, StringBuilder sb) {
		if (node == null)
			return;
		sb.append(node.data + ",");
		serialize(node.left, sb);
		serialize(node.right, sb);
		sb.append("#,");
	}

	public static BinaryNode deserialize(String[] data, int[] t) {
		if (t[0] >= data.length || data[t[0]].equals("#"))
			return null;
		BinaryNode node = new BinaryNode(Integer.parseInt(data[t[0]]));
		t[0] = t[0] + 1;
		node.left = deserialize(data, t);
		t[0] = t[0] + 1;
		node.right = deserialize(data, t);
		return node;
	}
}
