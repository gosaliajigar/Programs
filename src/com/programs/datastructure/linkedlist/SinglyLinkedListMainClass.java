package com.programs.datastructure.linkedlist;

/**
 * Operations on SinglyLinkedList and their Time Complexity
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SinglyLinkedListMainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();

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
		System.out.println("Deleting node with data : 3");
		singleLinkedList.deleteNode("3");
		System.out.println();

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();
		System.out.println();

		System.out.println("Printing First Element in Single Linked List ... ");
		System.out.println(singleLinkedList.getFront());
	}
}
