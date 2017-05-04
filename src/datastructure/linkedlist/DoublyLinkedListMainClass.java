package datastructure.linkedlist;

/**
 * Operations on DoublyLinkedList and their Time Complexity
 * 
 * @author "Jigar Gosalia"
 *
 */
public class DoublyLinkedListMainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		try {
			DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

			System.out.println("Printing size of Doubly Linked List : " + doublyLinkedList.size());
			System.out.println("Printing Doubly Linked List ... ");
			doublyLinkedList.printForward();
			doublyLinkedList.printBackward();
			doublyLinkedList.addRear("1");
			doublyLinkedList.addFront("0");
			doublyLinkedList.addRear("2");
			doublyLinkedList.addRear("3");
			doublyLinkedList.addRear("4");
			doublyLinkedList.addFront("-1");
			System.out.println();

			System.out.println("Printing size of Doubly Linked List : " + doublyLinkedList.size());
			System.out.println("Printing Doubly Linked List ... ");
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

			System.out.println("Deleting node with data : 3");
			doublyLinkedList.delete("3");
			System.out.println();

			System.out.println("Printing size of Doubly Linked List : " + doublyLinkedList.size());
			System.out.println("Printing Doubly Linked List ... ");
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

			System.out.println("Printing First Element in Doubly Linked List ... ");
			doublyLinkedList.deleteFront();
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();
			
			System.out.println("Printing First Element in Doubly Linked List ... ");
			doublyLinkedList.deleteFront();
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

			System.out.println("Printing First Element in Doubly Linked List ... ");
			doublyLinkedList.deleteFront();
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

			System.out.println("Printing First Element in Doubly Linked List ... ");
			doublyLinkedList.deleteFront();
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

			System.out.println("Printing First Element in Doubly Linked List ... ");
			doublyLinkedList.deleteFront();
			System.out.println(doublyLinkedList.printForward());
			System.out.println(doublyLinkedList.printBackward());
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
