package datastructure.linkedlist;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SinglyLinkedList<T> {
	private Node<T> root;
	public SinglyLinkedList() {}
	public Node<T> getRoot() { return this.root; }

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
		return ((root != null) ? root.getData() : null);
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * Print the singleLinkedList
	 */
	public void print() {
		Node<T> current = root;
		if (current == null) System.out.println("SingleLinkedList is Empty");
		while (current != null) {
			System.out.print(current);
			current = current.getNext();
			if (current != null) System.out.print(", ");
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
	public Node<T> getStart() { return this.root; }

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

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SinglyLinkedList<String> singleLinkedList = new SinglyLinkedList<String>();

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());
		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();
		singleLinkedList.addRear("1");
		singleLinkedList.addFront("0");
		singleLinkedList.addRear("2");
		singleLinkedList.addRear("3");
		singleLinkedList.addRear("4");
		singleLinkedList.addFront("-1");

		System.out.println();
		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());
		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();

		System.out.println();
		System.out.print("Priting Single Linked List (recursively)         : ");
		Node<String> current = singleLinkedList.getRoot();
		singleLinkedList.recursivePrint(current);

		System.out.println();
		System.out.print("Priting Single Linked List (reverse recursively) : ");
		current = singleLinkedList.getRoot();
		singleLinkedList.recursiveReversePrint(current);
		System.out.println();

		System.out.println();
		System.out.println("Deleting node with data : 3");
		singleLinkedList.deleteNode("3");
		System.out.println();

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();
		System.out.println();

		System.out.print("Printing First Element in Single Linked List : ");
		System.out.println(singleLinkedList.getFront());
	}

	public static class Node<T> {
		private T data;
		private Node<T> next;
		public T getData() { return data; }
		public void setData(T data) { this.data = data; }
		public Node<T> getNext() { return next; }
		public void setNext(Node<T> next) { this.next = next; }
		public Node(final T data, final Node<T> next) {
			this.data = data;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node:[Data=" + data + "]";
		}
	}
}