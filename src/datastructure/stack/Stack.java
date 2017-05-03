package com.programs.datastructure.stack;

/**
 * @author "Jigar Gosalia"
 *
 */
public class Stack {

	/**
	 * Size of stack array
	 */
	private int maxSize;

	/**
	 * Stack Array
	 */
	private int[] stackArray;

	/**
	 * Top of Stack
	 */
	private int top;

	/**
	 *
	 */
	@SuppressWarnings("unused")
	private Stack() {
	}

	/**
	 * Constructor
	 *
	 * @param capacity
	 */
	public Stack(final int capacity) {
		// set array size
		maxSize = capacity;
		// create array
		stackArray = new int[maxSize];
		// no items yet
		top = -1;
	}

	/**
	 *
	 */
	public void makeEmpty() {
		top = -1;
	}

	/**
	 * Put item on top of stack
	 *
	 * @param element
	 */
	public void push(final int element) {

		if (!isFull()) {
			// increment top, insert item
			stackArray[++top] = element;
		} else {
			System.out.println("Stack is Full");
		}
	}

	/**
	 * @return
	 */
	public int pop() {
		if (!isEmpty()) {
			// Pop item from top of stack,
			// access item & decrement top
			return stackArray[top--];
		} else {
			// return -1 is stack is empty
			return -1;
		}
	}

	/**
	 * @return
	 */
	public int peek() {
		if (!isEmpty()) {
			// Peek at the top of stack
			return stackArray[top];
		} else {
			// return -1 if stack is empty
			return -1;
		}
	}

	/**
	 *
	 * @return
	 */
	public boolean isEmpty() {
		// True if stack is empty
		return (top == -1);
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		// True if stack is full
		return (top == maxSize - 1);
	}

	/**
	 * @return
	 */
	public int getCapacity() {
		return maxSize;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return top + 1;
	}

	@Override
	public String toString() {
		StringBuilder objectBuilder = new StringBuilder();
		objectBuilder.append("##########################")
				.append(System.getProperty("line.separator"))
				.append("isStackFull  : " + isFull())
				.append(System.getProperty("line.separator"))
				.append("isStackEmpty : " + isEmpty())
				.append(System.getProperty("line.separator"))
				.append("Capacity     : " + getCapacity())
				.append(System.getProperty("line.separator"))
				.append("Size         : " + getSize())
				.append(System.getProperty("line.separator"))
				.append("Peeking      : " + peek())
				.append(System.getProperty("line.separator"))
				.append("##########################");
		return objectBuilder.toString();
	}
}
