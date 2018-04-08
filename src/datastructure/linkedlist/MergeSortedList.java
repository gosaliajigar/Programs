package datastructure.linkedlist;

/**
 * Merge two sorted list using a temporary sentinel node at start.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MergeSortedList {

	/**
	 * 
	 */
	private static SinglyLinkedList even = new SinglyLinkedList();

	/**
	 * 
	 */
	private static SinglyLinkedList odd = new SinglyLinkedList();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		populateOne(even);

		populateTwo(odd);

		Node list = merge(odd.getStart(), even.getStart());

		print(list);
	}

	/**
	 * @param odd
	 */
	private static void populateTwo(SinglyLinkedList odd) {
		for (int index = 0; index < 20; index++) {
			if (index % 2 != 0) {
				odd.addRear(index);
			}
		}
		odd.print();
		System.out.println();
	}

	/**
	 * @param even
	 */
	private static void populateOne(SinglyLinkedList even) {
		for (int index = 1; index < 10; index++) {
			if (index % 2 == 0) {
				even.addRear(index);
			}
		}
		even.print();
		System.out.println();
	}

	/**
	 * @param list
	 */
	private static void print(Node list) {
		System.out.println();
		Node current = list;
		while (current != null) {
			System.out.print(current.getData());
			current = current.getNext();
			if (current != null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	/**
	 * @param odd
	 * @param even
	 * @return
	 */
	private static Node merge(Node odd, Node even) {
		// Sentinel Node
		Node list = new Node(0, null);
		Node start = list;
		while (odd != null || even != null) {
			if (odd != null && even != null) {
				if ((Integer)odd.getData() < (Integer)even.getData()) {
					list.setNext(odd);
					odd = odd.getNext();
					list = list.getNext();
				} else if ((Integer)odd.getData() > (Integer)even.getData()) {
					list.setNext(even);
					even = even.getNext();
					list = list.getNext();
				} else {
					list.setNext(odd);
					odd = odd.getNext();
					list = list.getNext();
					list.setNext(even);
					even = even.getNext();
					list = list.getNext();
				}
			} else if (odd != null) {
				list.setNext(odd);
				odd = odd.getNext();
				list = list.getNext();
			} else if (even != null) {
				list.setNext(even);
				even = even.getNext();
				list = list.getNext();
			}
		}
		return start;
	}
}
