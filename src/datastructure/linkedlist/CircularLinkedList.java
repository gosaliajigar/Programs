package datastructure.linkedlist;

/**
 * Check if a given list is circular using two pointers.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CircularLinkedList {

	/**
	 * 
	 */
	private static SinglyLinkedList start = new SinglyLinkedList();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		create(start);
		System.out.println("is Cyclic: " + hasCycle(start.getStart()));

		// Attach rear to start
		start.getRear().setNext(start.getStart());
		System.out.println("is Cyclic: " + hasCycle(start.getStart()));
	}

	/**
	 * @param start
	 */
	private static void create(SinglyLinkedList start) {
		for (int index = 0; index < 10; index++) {
			start.addFront(index);
		}
	}

	/**
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(Node head) {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow == fast)
				return true;
		}
		return false;
	}
}
