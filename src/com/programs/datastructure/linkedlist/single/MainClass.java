package com.programs.datastructure.linkedlist.single;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());
		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();
		singleLinkedList.addFront("one");
		singleLinkedList.addRear("two");
		singleLinkedList.addRear("three");
		singleLinkedList.addRear("four");
		singleLinkedList.addFront("zero");

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());
		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();

		System.out.println();
		System.out.println("Deleting node with data : " + "three");
		singleLinkedList.deleteNode("three");
		System.out.println();

		System.out.println("Printing size of Single Linked List : " + singleLinkedList.size());		System.out.println("Printing Single Linked List ... ");
		singleLinkedList.print();
		System.out.println();

		System.out.println("Printing First Element in Single Linked List ... ");
		System.out.println(singleLinkedList.getFront());
	}
}
