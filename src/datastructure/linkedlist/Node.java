package datastructure.linkedlist;

/**
 * Node PoJo
 *
 * @author "Jigar Gosalia"
 *
 */
public class Node<T> {

	/**
	 * Data stored in this node
	 */
	private T data;

	/**
	 * Store a reference to the next node in this
	 */
	private Node<T> next;

	/**
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @param data
	 * @param next
	 */
	public Node(final T data, final Node<T> next) {
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