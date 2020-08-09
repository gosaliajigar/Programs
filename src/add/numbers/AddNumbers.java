package add.numbers;

import datastructure.linkedlist.SinglyLinkedList;
import datastructure.linkedlist.SinglyLinkedList.Node;

/**
 * Add numbers in singly linked list
 * 
 * @author "Jigar Gosalia"
 *
 */
public class AddNumbers {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<Integer>();
		listOne.addFront(9);
		listOne.addFront(7);
		listOne.addFront(9);
		listOne.print();
		System.out.println();
		listTwo.addFront(2);
		listTwo.addFront(1);
		listTwo.print();
		SinglyLinkedList<Integer> listThree = add(listOne.getRoot(), listTwo.getRoot());
		System.out.println();
		listThree.print();
	}

	/**
	 * @param listOne
	 * @param listTwo
	 * @return
	 */
	private static SinglyLinkedList<Integer> add(Node<Integer> rootOne, Node<Integer> rootTwo) {
		SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
		int carry = 0;
		while (rootOne != null || rootTwo != null) {
			int one = 0;
			int two = 0;
			if (rootOne != null) {
				one = rootOne.getData();
				rootOne = rootOne.getNext();
			}
			if (rootTwo != null) {
				two = rootTwo.getData();
				rootTwo = rootTwo.getNext();
			}
			int sum = carry + one + two;
			carry = 0;
			if (sum > 9) {
				carry = 1;
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
