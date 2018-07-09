package pojos;

/**
 * @author Jigar Gosalia
 *
 */
public class BinaryNode {
	public int data;
	public BinaryNode left;
	public BinaryNode right;
	public int depth;

	public BinaryNode(int data, BinaryNode left, BinaryNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(int data) { this(data, null, null); }

	public int getData() { return data; }

	public void setData(int data) { this.data = data; }

	public BinaryNode getLeft() { return left; }

	public void setLeft(BinaryNode left) { this.left = left; }

	public BinaryNode getRight() { return right; }

	public void setRight(BinaryNode right) { this.right = right; }

	@Override
	public String toString() { return "Node [data=" + data + ", left=" + left + ", right=" + right + "]"; }
}
