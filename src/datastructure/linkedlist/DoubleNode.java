package datastructure.linkedlist;

/**
 * Node PoJo
 *
 * @author "Jigar Gosalia"
 *
 */
public class DoubleNode<T> {

	/**
	 * Data stored in this node
	 */
	private T data;

	/**
	 * Store a reference to the next node in this
	 */
	private DoubleNode<T> next;

	/**
	 * Store a reference to the previous node in this
	 */
	private DoubleNode<T> previous;

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
	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public DoubleNode<T> getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 */
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}

	/**
	 * @param data
	 * @param next
	 */
	public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	/**
	 * @param data
	 */
	public DoubleNode(final T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DoubleNode:[Data=" + data + "]";
	}
}