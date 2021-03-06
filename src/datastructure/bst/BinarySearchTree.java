package datastructure.bst;

import pojos.BinaryNode;

/**
 * Binary Search Tree BST and its operations.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTree {
	private BinaryNode root;
	public BinarySearchTree () {}
	public BinaryNode getRoot() { return root; }
	public void setRoot(BinaryNode node) { this.root = node; }

	public void create(int array[]) {
		for (int index = 0; index < array.length; index++) {
			insert(array[index]);
		}
	}

	public void createBST(int[] array) {
		root = createBinarySearchTree(array, 0, array.length-1);
	}

	private BinaryNode createBinarySearchTree(int array[], int low, int high) {
		if (low <= high) {
			int mid = low + ((high-low) / 2);
			BinaryNode node = new BinaryNode(array[mid]);
			node.setLeft(createBinarySearchTree(array, low, mid-1));
			node.setRight(createBinarySearchTree(array, mid+1, high));
			return node;
		}
		return null;
	}

	public void insert(int data) {
		BinaryNode node = new BinaryNode(data);
		BinaryNode current = root;
		if (root == null) {	root = node;
		} else {
			while(true) {
				// > scenario
				if (data > current.getData()) {
					if (current.getRight() == null) {
						current.setRight(node);
						break;
					}
					current = current.getRight();
					// <= scenario
				} else {
					if (current.getLeft() == null) {
						current.setLeft(node);;
						break;
					}
					current = current.getLeft();
				}
			}
		}
	}

	public BinaryNode search(int data) {
		BinaryNode current = root;
		while(current != null) {
			if (data > current.getData()) {
				current = current.getRight();
			} else if (data < current.getData()) {
				current = current.getLeft();
			} else {
				return current;
			}
		}
		return null;
	}

	public static BinaryNode treeMinimum(BinaryNode node) {
		return (node != null && node.getLeft() != null) ? treeMinimum(node.getLeft()) : node;
	}

	public static BinaryNode treeMaximum(BinaryNode node) {
		return (node != null && node.getRight() != null) ? treeMaximum(node.getRight()) : node;
	}

	public static void delete(BinaryNode node) {
		// pseudo code as this requires each node 
		// to store reference to its parent
		
		// 4 cases
			// 1. no children
			// 2. has just left child
			// 3. has just right child
			// 4. has both children
		
		// 1. no child
		// just delete the node
		
		// 2. has just left child
		// return transparent(root, node, node.left);
		
		// 3. has just right child
		// return transparent(root, node, node.right);
		
		// 4. has both children (get successor)
		// Node y = treeMinimum(node.getRight());
		// if (y.p != node) {
		// 		transparent(root, y, y.getRight());
		//		y.right = node.right;
		//		y.right.p = y;
		// }
		// transparent(root, node, y);
		// y.left = node.left
		// y.left.p = y; 
	}

	@SuppressWarnings("unused")
	private static void transparent(BinaryNode root, BinaryNode u, BinaryNode v) {
		// replace u by v on u's parent node
		//	if (u.p == null) {
		//		root = v;
		//	} else if (u.p.left == u) {
		//		u.p.left = v;
		//	} else {
		//		u.p.right = v;
		//	}
		// make v's parent as u's parent
		//	if (v != null) {
		//		v.p = u.p; u.p = null;
		//	}
	}

	// If the right subtree of node x is nonempty, then the successor of x is
	// just the leftmost node in x�s right subtree
	//
	// If the right subtree of node x is empty and x has a successor y, then y 
	// is the lowest ancestor of x whose left child is also an ancestor of x.
	public static BinaryNode successor(BinaryNode node) {
		if (node != null) {
			if (node.getRight() != null) {
				return treeMinimum(node.getRight());
			} else {
				// Node y = node.p;
				// while(y != null && y.right == node) {
				//		node = y;
				//		y = y.p;
				// }
				// return y;
			}
		}
		return null;
	}

	public static BinaryNode predecessor(BinaryNode node) {
		if (node != null) {
			if (node.getLeft() != null) {
				return treeMaximum(node.getLeft());
			} else {
				// Node y = node.p;
				// while(y != null && y.left == node) {
				// 		node = y;
				//		y = y.p;
				// }
				// return y;
			}
		}
		return null;
	}
}
