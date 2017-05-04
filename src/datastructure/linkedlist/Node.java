package datastructure.linkedlist;

/**
 * Node PoJo
 *
 * @author "Jigar Gosalia"
 *
 */
public class Node {

	/**
	 * Data stored in this node
	 */
	private Object data;

	/**
	 * Store a reference to the next node in this
	 */
	private Node next;

	/**
	 * @return
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @param data
	 * @param next
	 */
	public Node(final Object data, final Node next) {
		this.data = data;
		this.next = next;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node:[Data=" + data + "]";
	}
}