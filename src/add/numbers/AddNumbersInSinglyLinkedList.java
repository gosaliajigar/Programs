package add.numbers;

import datastructure.linkedlist.SinglyLinkedList;
import datastructure.linkedlist.SinglyLinkedList.Node;

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
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<Integer>();
		listOne.addFront(9);
		listOne.addFront(9);
		listOne.addFront(9);
		listOne.print();
		System.out.println();
		listTwo.addFront(1);
		listTwo.addFront(1);
		listTwo.print();
		SinglyLinkedList<Integer> listThree = add(listOne, listTwo);
		System.out.println();
		listThree.print();
	}

	/**
	 * @param listOne
	 * @param listTwo
	 * @return
	 */
	private static SinglyLinkedList<Integer> add(SinglyLinkedList<Integer> listOne, SinglyLinkedList<Integer> listTwo) {
		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
		Node<Integer> startOne = listOne.getStart();
		Node<Integer> startTwo = listTwo.getStart();
		int carry = 0;
		while (startOne != null || startTwo != null) {
			int one = 0;
			int two = 0;
			if (startOne != null) {
				one = (Integer) startOne.getData();
				startOne = startOne.getNext();
			}
			if (startTwo != null) {
				two = (Integer) startTwo.getData();
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
		// if carry is greater than 0 then add another node
		// with it's value
		if (carry != 0) {
			result.addRear(carry);
		}

		return result;
	}
}
