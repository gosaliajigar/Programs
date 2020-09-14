package datastructure.stack;

public class SortStack {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(10);
		stack.push(1); stack.push(5); stack.push(2); stack.push(3);
		stack.push(4); stack.push(3); 
		System.out.println(stack.peek() + " : " + stack);
		sort(stack);
		System.out.println(stack.peek() + " : " + stack);
		while (!stack.isEmpty()) { System.out.print(stack.pop() + " "); }
	}

	public static void sort(Stack<Integer> primary) {
		Stack<Integer> secondary = new Stack<Integer>(10);
		while (!primary.isEmpty()) {
			Integer top = primary.pop();
			// find location for the element from primary in secondary stack.
			// biggest element first in secondary stack
			while (!secondary.isEmpty() && secondary.peek() > top) {
				primary.push(secondary.pop());
			}
			// push the primary element in secondary appropriate location.
			secondary.push(top);
		}
		System.out.println(secondary.peek() + " : " + secondary);
		// copy elements back from secondary
		while (!secondary.isEmpty()) { primary.push(secondary.pop()); }
		System.out.println();
	}
}
