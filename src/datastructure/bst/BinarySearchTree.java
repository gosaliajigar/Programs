package datastructure.bst;

/**
 * Binary Search Tree BST and its operations.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTree {

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

	public void createBST(int[] array) {
		root = createBinarySearchTree(array, 0, array.length);
	}

	private Node createBinarySearchTree(int array[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			Node node = new Node(array[mid]);
			node.setLeft(createBinarySearchTree(array, low, mid));
			node.setRight(createBinarySearchTree(array, mid+1, high));
			return node;
		}
		return null;
	}
	
	/**
	 * @param data
	 */
	public void insert(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
		} else {
			Node current = root;
			Node parent = null;
			while(true) {
				// > scenario
				if (data > current.getData()) {
					parent = current;
					current = current.getRight();
					if (current == null) {
						parent.setRight(node);
						break;
					}
					// <= scenario
				} else {
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

	public static Node treeMinimum(Node node) {
		return (node != null && node.getLeft() != null) ? treeMinimum(node.getLeft()) : node;
	}

	public static Node treeMaximum(Node node) {
		return (node != null && node.getRight() != null) ? treeMaximum(node.getRight()) : node;
	}

	public static void delete(Node node) {
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
		
		// 4. has both children
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

	private static void transparent(Node root, Node u, Node v) {
		// replace u by v on its parent node
		//	if (u.p == null) {
		//		root = v;
		//	} else if (u.p.left == u) {
		//		u.p.left = v;
		//	} else {
		//		u.p.right = v;
		//	}
		//	if (v != null) {
		//		v.p = u.p;
		//	}
	}
	
	public static Node successor(Node node) {
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

	public static Node predecessor(Node node) {
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
	
	
	public static class Node {
		int data;
		Node left;
		Node right;
		public int depth;

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

}
