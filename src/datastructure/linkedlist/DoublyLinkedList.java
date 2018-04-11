package datastructure.linkedlist;

/**
 * @author "Jigar Gosalia"
 *
 */
public class DoublyLinkedList<T> {

	int count;

	DoubleNode<T> head;

	DoubleNode<T> tail;

	public DoublyLinkedList() {
		super();
		this.count = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public T getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		return head.getData();
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public T getRear() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		return tail.getData();
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(T data) {
		return (find(data) != null) ? true : false;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @param data
	 */
	public void addFront(T data) {
		DoubleNode<T> node = new DoubleNode<T>(data);
		if (isEmpty()) {
			tail = node;
		} else {
			head.setPrevious(node);
		}
		node.setNext(head);
		head = node;
		count++;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @param data
	 */
	public void addRear(T data) {
		DoubleNode<T> node = new DoubleNode<T>(data);
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
		}
		node.setPrevious(tail);
		tail = node;
		count++;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 */
	public void add(T newData, T findData) throws Exception {
		DoubleNode<T> node = new DoubleNode<T>(newData);
		DoubleNode<T> current = find(findData);
		if (current != null) {
			node.setNext(current.getNext());
			node.setPrevious(current);
			current.setNext(node);
			node.getNext().setPrevious(node);
			count++;
		} else {
			throw new Exception(findData + " not present in doubly linked list!");
		}
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @throws Exception
	 */
	public void deleteFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		if (count == 1) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		count--;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @throws Exception
	 */
	public void deleteRear()  throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		if (count == 1) {
			head = tail = null;
		} else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		count--;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 */
	public void delete(T data) {
		DoubleNode<T> current = find(data);
		if (current != null) {
			// current is head
			if (current.getPrevious() != null) {
				current.getPrevious().setNext(current.getNext());
			} else {
				head = current.getNext();
			}
			// current is tail
			if (current.getNext() != null) {
				current.getNext().setPrevious(current.getPrevious());
			} else {
				tail = current.getPrevious();
			}
			current.setNext(null);
			current.setPrevious(null);
			count--;
		}
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (count == 0);
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @return
	 */
	public String printForward() {
		return this.toString();
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @return
	 */
	public String printBackward() {
		StringBuilder data = new StringBuilder();
		DoubleNode<T> current = tail;
		data.append("DoublyLinkedList(B:" + size() + "):[");
		while (current != null) {
			data.append(current.getData());
			current = current.getPrevious();
			if (current != null) {
				data.append(", ");
			}
		}
		data.append("]");
		return data.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder data = new StringBuilder();
		DoubleNode<T> current = head;
		data.append("DoublyLinkedList(F:" + size() + "):[");
		while (current != null) {
			data.append(current.getData());
			current = current.getNext();
			if (current != null) {
				data.append(", ");
			}
		}
		data.append("]");
		return data.toString();
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 * @return
	 */
	private DoubleNode<T> find(T data) {
		DoubleNode<T> current = head;
		while (current != null) {
			if (current.getData().equals(data)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
}
