package datastructure.linkedlist;

import datastructure.linkedlist.SinglyLinkedList.Node;

/**
 * Merge two sorted list using a temporary sentinel node at start.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MergeSortedList {

	private static SinglyLinkedList<Integer> even = new SinglyLinkedList<Integer>();
	private static SinglyLinkedList<Integer> odd = new SinglyLinkedList<Integer>();

	public static void main(String[] args) {
		populateEven(even);
		populateOdd(odd);
		Node<Integer> list = merge(odd.getRoot(), even.getRoot());
		print(list);
	}

	private static void populateOdd(SinglyLinkedList<Integer> odd) {
		for (int index = 0; index < 20; index++) {
			if (index % 2 != 0) {
				odd.addRear(index);
			}
		}
		odd.print();
		System.out.println();
	}

	private static void populateEven(SinglyLinkedList<Integer> even) {
		for (int index = 1; index < 10; index++) {
			if (index % 2 == 0) {
				even.addRear(index);
			}
		}
		even.print();
		System.out.println();
	}

	private static void print(Node<Integer> list) {
		System.out.println();
		Node<Integer> current = list;
		while (current != null) {
			System.out.print(current.getData());
			current = current.getNext();
			if (current != null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	private static Node<Integer> merge(Node<Integer> one, Node<Integer> two) {
		// Sentinel Node
		Node<Integer> head = new Node<Integer>(0, null);
		Node<Integer> current = head;
		while (one != null || two != null) {
			if (one != null && two != null) {
				if (one.getData() < two.getData()) {
					current.setNext(one);
					one = one.getNext();
					current = current.getNext();
				} else if (one.getData() > two.getData()) {
					current.setNext(two);
					two = two.getNext();
					current = current.getNext();
				} else {
					current.setNext(one);
					one = one.getNext();
					current = current.getNext();
					current.setNext(two);
					two = two.getNext();
					current = current.getNext();
				}
			} else if (one != null) {
				current.setNext(one);
				one = one.getNext();
				current = current.getNext();
			} else if (two != null) {
				current.setNext(two);
				two = two.getNext();
				current = current.getNext();
			}
		}
		return head.getNext();
	}
}
