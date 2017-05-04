package datastructure.linkedlist;

/**
 * @author "Jigar Gosalia"
 *
 */
public class DoublyLinkedList {

	/**
	 * 
	 */
	int count;

	/**
	 * 
	 */
	DoubleNode front;

	/**
	 * 
	 */
	DoubleNode rear;

	/**
	 * 
	 */
	public DoublyLinkedList() {
		super();
		this.count = 0;
		this.front = null;
		this.rear = null;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public Object getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		return front.getData();
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @return
	 */
	public Object getRear() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Doubly Linked List!");
		}
		return rear.getData();
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(Object data) {
		return (find(data) != null) ? true : false;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @param data
	 */
	public void addFront(Object data) {
		DoubleNode node = new DoubleNode(data);
		if (isEmpty()) {
			rear = node;
		} else {
			front.setPrevious(node);
		}
		node.setNext(front);
		front = node;
		count++;
	}

	/**
	 * Time Complexity : O(1)<br><br>
	 * 
	 * @param data
	 */
	public void addRear(Object data) {
		DoubleNode node = new DoubleNode(data);
		if (isEmpty()) {
			front = node;
		} else {
			rear.setNext(node);
		}
		node.setPrevious(rear);
		rear = node;
		count++;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 */
	public void add(Object newData, Object findData) throws Exception {
		DoubleNode node = new DoubleNode(newData);
		DoubleNode current = find(findData);
		if (findData != null) {
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
			front = rear = null;
		} else {
			front = front.getNext();
			front.setPrevious(null);
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
			front = rear = null;
		} else {
			rear = rear.getPrevious();
			rear.setNext(null);
		}
		count--;
	}

	/**
	 * Time Complexity : O(n)<br><br>
	 * 
	 * @param data
	 */
	public void delete(Object data) {
		DoubleNode current = find(data);
		if (current != null) {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
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
		return (count == 0) ? true : false;
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
		DoubleNode current = rear;
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
		DoubleNode current = front;
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
	private DoubleNode find(Object data) {
		DoubleNode current = front;
		while (current != null) {
			if (current.getData().equals(data)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
}
