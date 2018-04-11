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

	public static class Node {

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

}
