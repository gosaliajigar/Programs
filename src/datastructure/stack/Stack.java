package datastructure.stack;

/**
 * @author "Jigar Gosalia"
 *
 */
public class Stack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	@SuppressWarnings("unused")
	public Stack(final int capacity) {
		maxSize = capacity;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(final int element) {
		if (isFull()) throw new RuntimeException("Stack is Full");
		stackArray[++top] = element;
	}

	public int pop() {
		if (isEmpty()) throw new RuntimeException("Stack is Empty");
		return stackArray[top--];
	}

	public int peek() {
		if (isEmpty()) throw new RuntimeException("Stack is Empty");
		return stackArray[top];
	}

	public boolean isEmpty() { return (top == -1); }

	public boolean isFull() { return (top == maxSize - 1); }

	public int getCapacity() { return maxSize; }

	public int getSize() { return top + 1; }

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
