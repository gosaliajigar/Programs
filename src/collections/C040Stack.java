package collections;

import java.util.Stack;

/**
 * push(i)<br>
 * pop()<br>
 * peek()<br>
 * search(i)<br>
 * empty()<br>
 * size()<br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C040Stack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		System.out.println(s.empty());
		System.out.println();

		// peek throw EmptyStackException
		// System.out.println(s.peek());
		System.out.println(s);
		System.out.println();

		System.out.print(s.push(10) + " - " + s.push(9));
		System.out.println();
		System.out.println(s);
		System.out.println();

		System.out.println(s.size());
		System.out.println();

		// 1-based distance/position from top
		// top = 1 (distance)
		System.out.println(s.search(10) + " - " + s.search(3));
		System.out.println();

		System.out.println(s.pop() + " - " + s.pop());
		// throws EmptyStackException when empty
		// System.out.println(s.pop());
		System.out.println();
	}
}
