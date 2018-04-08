package datastructure.bst;

/**
 * Binary Search Tree BST and its operations.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTree {

	private BinaryNode root;

	public BinarySearchTree () {
		super();
		this.root = null;
	}

	/**
	 * @return
	 */
	public BinaryNode getRoot() {
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
		BinaryNode node = new BinaryNode(data, null, null);
		BinaryNode parent;
		if (root == null) {
			root = node;
		} else {
			BinaryNode current = root;
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
	public BinaryNode search(int data) {
		BinaryNode node = null;
		BinaryNode current = root;
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
