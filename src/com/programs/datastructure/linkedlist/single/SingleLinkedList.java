package com.programs.datastructure.linkedlist.single;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SingleLinkedList {

	/**
	 *
	 */
	Node start;

	/**
	 *
	 */
	public SingleLinkedList() {
		start = null;
	}

	/**
	 * Add Node to the front of Linked List
	 *
	 * @param data
	 */
	public void addFront(final Object data) {
		// store a reference to the current start node
		Node current = start;

		// assign our start to a new node
		// that has data and points
		// to our old start
		start = new Node(data, current);
	}

	/**
	 * Add Node to the rear of Linked List
	 *
	 * @param data
	 */
	public void addRear(final Object data) {
		Node pointer = start;
		Node current = null;

		if (pointer == null) {
			addFront(data);
			return;
		}

		// find the last Node
		while (pointer != null) {
			current = pointer;
			pointer = pointer.next;
		}

		// create a new node that has
		// data and points to null
		current.next = new Node(data, null);
	}

	/**
	 * Delete node that matches data
	 *
	 * @param data
	 */
	public void deleteNode(final Object data) {
		Node pointer = start;

		if (pointer == null) {
			return;
		}

		Node current = pointer.next;

		if (pointer != null && pointer.data.equals(data)) {
			start = pointer.next;
			pointer = current;
			current = pointer.next;
		}

		while (current != null) {
			if (current.data.equals(data)) {
				pointer.next = current.next;
				current = pointer.next;
			} else {
				pointer = pointer.next;
				current = pointer.next;
			}
		}
	}

	/**
	 * Return the front object's data
	 *
	 * @return
	 */
	public Object getFront() {
		if (start != null) {
			return start.data;
		} else {
			return null;
		}
	}

	/**
	 * Print the singleLinkedList
	 */
	public void print() {
		Node pointer = start;

		if (pointer == null) {
			System.out.println("SingleLinkedList is Empty");
		}

		while (pointer != null) {
			System.out.println("Node : " + pointer.data);
			pointer = pointer.next;
		}
	}

	/**
	 * Returns size of single linked list
	 *
	 * @return
	 */
	public int size() {
		int size = 0;

		Node pointer = start;

		while (pointer != null) {
			pointer = pointer.next;
			size++;
		}
		return size;
	}
}