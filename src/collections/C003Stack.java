package collections;

import java.util.Stack;

/**
 * 
 * Java Stack is LIFO object. It extends Vector class, but supports only five
 * operations. Java Stack class has only one constructor which is empty or
 * default constructor. So, when we create a Stack, initially it contains no
 * items that means Stack is empty.
 * 
 * Stack internally has a pointer: TOP, which refers to the top of the Stack
 * element. If Stack is empty, TOP refers to the before first element location.
 * If Stack is not empty, TOP refers to the top element.
 * 
 * push(i)<br>
 * pop()<br>
 * peek()<br>
 * search(i)<br>
 * empty()<br>
 * size()<br>
 * 
 * Source : https://www.journaldev.com/13401/java-stack
 * 
 * @author Jigar Gosalia
 *
 */
public class C003Stack {

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
