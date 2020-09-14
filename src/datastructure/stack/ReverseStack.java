package datastructure.stack;

import java.util.Stack;

/**
 * @author Jigar Gosalia
 *
 */
public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); stack.push(2); stack.push(3);
		System.out.println(stack.peek() + " : " + stack);
		reverse(stack);
		System.out.println(stack.peek() + " : " + stack);
		while (!stack.isEmpty()) { System.out.print(stack.pop() + " "); }
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) return;
		// top element is in stack
		int top = stack.pop();
		reverse(stack);
		// stack unwinds now so insert top at bottom of stack
		insertAtBottom(stack, top);
	}

	public static void insertAtBottom(Stack<Integer> stack, int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		// top element in stack
		int top = stack.pop();
		insertAtBottom(stack, x);
		// stack unwinds
		stack.push(top);
	}
}
