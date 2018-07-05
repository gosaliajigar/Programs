package datastructure.stack;

import java.util.Stack;

/**
 * @author Jigar Gosalia
 *
 */
public class ReverseStack {

	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		stack.push(1); stack.push(2); stack.push(3); stack.push(4);
		System.out.println(stack);
		reverse();
		System.out.println(stack.peek());
	}

	public static void reverse() {
		if (!stack.isEmpty()) {
			Integer element = stack.pop();
			reverse();
		}
	}
}
