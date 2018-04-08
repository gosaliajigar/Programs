package datastructure.linkedlist;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SinglyLinkedList {

	Node start;

	public SinglyLinkedList() {
		start = null;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
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
	 * Time Complexity : O(n)<br><br>
	 * 
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
	 * Time Complexity : O(n)<br><br>
	 * 
	 * Delete node that matches data
	 *
	 * @param data
	 */
	public void deleteNode(final Object data) {
		if (start == null) {
			return;
		}

		Node previous = start;

		if (previous != null && previous.getData().equals(data)) {
			start = previous.getNext();
			return;
		}

		Node current = previous.getNext();

		while (current != null) {
			if (current.getData().equals(data)) {
				previous.setNext(current.getNext());
				return;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
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
	 * Time Complexity : O(n)<br><br>
	 * 
	 * Print the singleLinkedList
	 */
	public void print() {
		Node current = start;

		if (current == null) {
			System.out.println("SingleLinkedList is Empty");
		}

		while (current != null) {
			System.out.print(current);
			current = current.getNext();
			if (current != null) {
				System.out.print(", ");
			}
		}
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
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

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public Node getStart() {
		return this.start;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @return
	 */
	public Node getRear() {
		Node current = start;
		Node previous = current;
		while (current != null) {
			previous = current;
			current = current.getNext();
		}
		return previous;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * recursively print singly linked list
	 * 
	 * @param start
	 */
	public void recursivePrint(Node start) {
		if (start == null) {
			return;
		}
		System.out.print(start.getData() + " ");
		recursivePrint(start.getNext());
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * recursively print singly linked list in reverse
	 * 
	 * @param start
	 */
	public void recursiveReversePrint(Node start) {
		if (start == null) {
			return;
		}
		recursiveReversePrint(start.getNext());
		System.out.print(start.getData() + " ");
	}
}