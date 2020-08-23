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
		// 979 + 21
		SinglyLinkedList<Integer> listOne = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> listTwo = new SinglyLinkedList<Integer>();
		// 979
		listOne.addFront(9);
		listOne.addFront(7);
		listOne.addFront(9);
		listOne.print();
		System.out.println();
		// 21
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
			int sum = carry;
			if (rootOne != null) {
				sum += rootOne.getData();
				rootOne = rootOne.getNext();
			}
			if (rootTwo != null) {
				sum += rootTwo.getData();
				rootTwo = rootTwo.getNext();
			}
			result.addRear((sum > 9) ? sum % 10 : sum);
			carry = (sum > 9) ? 1 : 0;
		}
		// if carry is greater than 0 then add another node
		// with it's value
		if (carry != 0) {
			result.addRear(carry);
		}

		return result;
	}
}
