package datastructure.linkedlist;

import datastructure.linkedlist.SinglyLinkedList.Node;

/**
 * Check if a given list is circular using two pointers.<br>
 * <br>
 * Floyd's tortoise and the hare algorithm<br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class CircularLinkedList {

	private static SinglyLinkedList<Integer> head = new SinglyLinkedList<Integer>();

	public static void main(String[] args) {
		create(head);
		System.out.println("is Cyclic: " + hasCycle(head.getRoot()));

		// Attach rear to start
		head.getRear().setNext(head.getStart());
		System.out.println("is Cyclic: " + hasCycle(head.getRoot()));
	}

	private static void create(SinglyLinkedList<Integer> start) {
		for (int index = 0; index < 10; index++) {
			start.addFront(index);
		}
	}

	public static boolean hasCycle(Node<Integer> head) {
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) return true;
		}
		return false;
	}
}
