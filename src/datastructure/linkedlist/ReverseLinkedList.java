package datastructure.linkedlist;

import datastructure.linkedlist.SinglyLinkedList.Node;

public class ReverseLinkedList {

	public static <T> Node<T> reverseIterative(Node<T> head) {
		if (head == null || head.getNext() == null) return head;
		Node<T> prev = head, curr = head.getNext();
		while (curr != null) {
			Node<T> next = curr.getNext();
			curr.setNext(prev);
			curr = next;
			prev = curr;
		}
		head.setNext(null);
		return prev;
	}

	public static <T> Node<T> reverseRecursive(Node<T> head) {
		if (head == null || head.getNext() == null) return head;
		Node<T> next = head.getNext();
		head.setNext(null);
		Node<T> rest = reverseRecursive(next);
		next.setNext(head);
		return rest;
	}
}
