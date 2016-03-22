package com.programs.datastructure.linkedlist;

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
		// create a reference to the start node with new data
		Node node = new Node(data, start);

		// assign our start to a new node
		start = node;
	}

	/**
	 * Add Node to the rear of Linked List
	 *
	 * @param data
	 */
	public void addRear(final Object data) {
		Node node = new Node(data, null);
		Node current = start;

		if (current != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		} else {
			addFront(data);
		}
	}

	/**
	 * Delete node that matches data
	 *
	 * @param data
	 */
	public void deleteNode(final Object data) {
		Node previous = start;

		if (previous == null) {
			return;
		}

		Node current = previous.getNext();

		if (previous != null && previous.getData().equals(data)) {
			start = previous.getNext();
			previous = current;
			current = previous.getNext();
		}

		while (current != null) {
			if (current.getData().equals(data)) {
				previous.setNext(current.getNext());
				current = previous.getNext();
			} else {
				previous = previous.getNext();
				current = previous.getNext();
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
			return start.getData();
		} else {
			return null;
		}
	}

	/**
	 * Print the singleLinkedList
	 */
	public void print() {
		Node current = start;

		if (current == null) {
			System.out.println("SingleLinkedList is Empty");
		}

		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * Returns size of single linked list
	 *
	 * @return
	 */
	public int size() {
		int size = 0;

		Node current = start;

		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}
}