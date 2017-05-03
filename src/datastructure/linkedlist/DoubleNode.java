package com.programs.datastructure.linkedlist;

/**
 * Node PoJo
 *
 * @author "Jigar Gosalia"
 *
 */
public class DoubleNode {

	/**
	 * Data stored in this node
	 */
	private Object data;

	/**
	 * Store a reference to the next node in this
	 */
	private DoubleNode next;

	/**
	 * Store a reference to the previous node in this
	 */
	private DoubleNode previous;

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
	public DoubleNode getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(DoubleNode next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public DoubleNode getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 */
	public void setPrevious(DoubleNode previous) {
		this.previous = previous;
	}

	/**
	 * @param data
	 * @param next
	 */
	public DoubleNode(final Object data, final DoubleNode next, final DoubleNode previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	/**
	 * @param data
	 */
	public DoubleNode(final Object data) {
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