package com.programs.datastructure.linkedlist.single;

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
	public Object data;

	/**
	 * Store a reference to the next node in this
	 */
	public Node next;

	/**
	 * @param data
	 * @param next
	 */
	public Node(final Object data, final Node next) {
		this.data = data;
		this.next = next;
	}
}