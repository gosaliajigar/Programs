package datastructure.linkedlist;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SinglyLinkedList<T> {

	private Node<T> root;

	public SinglyLinkedList() {
		root = null;
	}

	public Node<T> getRoot() {
		return this.root;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * Add Node to the front of Linked List
	 *
	 * @param data
	 */
	public void addFront(final T data) {
		// create a reference to the start node with new data
		Node<T> node = new Node<T>(data, root);

		// assign our start to a new node
		root = node;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * Add Node to the rear of Linked List
	 *
	 * @param data
	 */
	public void addRear(final T data) {
		Node<T> node = new Node<T>(data, null);
		Node<T> current = root;

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
	public void deleteNode(final T data) {
		if (root != null) {
			Node<T> previous = root;

			if (previous != null && previous.getData().equals(data)) {
				root = previous.getNext();
				previous.setNext(null);
				return;
			}

			Node<T> current = previous.getNext();

			while (current != null) {
				if (current.getData().equals(data)) {
					previous.setNext(current.getNext());
					current.setNext(null);
					return;
				} else {
					previous = current;
					current = current.getNext();
				}
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
	public T getFront() {
		if (root != null) {
			return root.getData();
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
		Node<T> current = root;

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

		Node<T> current = root;

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
	public Node<T> getStart() {
		return this.root;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @return
	 */
	public Node<T> getRear() {
		Node<T> current = root;
		if (current != null) {
			while(current.getNext() != null) {
				current = current.getNext();
			}
		}
		return current;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * recursively print singly linked list
	 * 
	 * @param node
	 */
	public void recursivePrint(Node<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			recursivePrint(node.getNext());
		}
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * recursively print singly linked list in reverse
	 * 
	 * @param node
	 */
	public void recursiveReversePrint(Node<T> node) {
		if (node != null) {
			recursiveReversePrint(node.getNext());
			System.out.print(node.getData() + " ");
		}
	}
}