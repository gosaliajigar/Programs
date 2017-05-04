package tree.traversal;

/**
 * Node for Tree Traversal
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinaryNode {

	int data;

	BinaryNode left;

	BinaryNode right;

	/**
	 * @param data
	 */
	public BinaryNode(int data) {
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
	public BinaryNode(int data, BinaryNode left, BinaryNode right) {
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
	public BinaryNode getLeft() {
		return left;
	}

	/**
	 * @param left
	 */
	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	/**
	 * @return
	 */
	public BinaryNode getRight() {
		return right;
	}

	/**
	 * @param right
	 */
	public void setRight(BinaryNode right) {
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
