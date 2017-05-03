package com.programs.add.numbers;

import com.programs.datastructure.linkedlist.Node;
import com.programs.datastructure.linkedlist.SinglyLinkedList;

/**
 * Add numbers in singly linked list
 * 
 * @author "Jigar Gosalia"
 *
 */
public class AddNumbersInSinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SinglyLinkedList listOne = new SinglyLinkedList();
		SinglyLinkedList listTwo = new SinglyLinkedList();
		listOne.addFront(1);
		listOne.addFront(9);
		listOne.addFront(9);
		listOne.print();
		System.out.println();
		listTwo.addFront(1);
		listTwo.addFront(1);
		listTwo.print();
		SinglyLinkedList listThree = add(listOne, listTwo);
		System.out.println();
		listThree.print();
	}

	/**
	 * @param listOne
	 * @param listTwo
	 * @return
	 */
	private static SinglyLinkedList add(SinglyLinkedList listOne, SinglyLinkedList listTwo) {
		SinglyLinkedList result = new SinglyLinkedList();
		Node startOne = listOne.getStart();
		Node startTwo = listTwo.getStart();
		int carry = 0;
		while (startOne != null || startTwo != null) {
			int one = 0;
			int two = 0;
			if (startOne != null) {
				one = (int) startOne.getData();
				startOne = startOne.getNext();
			}
			if (startTwo != null) {
				two = (int) startTwo.getData();
				startTwo = startTwo.getNext();
			}
			int sum = carry + one + two;
			carry = 0;
			if (sum > 9) {
				carry = sum / 10;
				result.addRear(sum % 10);
			} else {
				result.addRear(sum);
			}
		}
		return result;
	}
}
