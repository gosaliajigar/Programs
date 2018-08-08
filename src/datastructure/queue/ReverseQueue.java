package datastructure.queue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Reverse Queue using Recursion
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1); queue.add(2); queue.add(3); queue.add(4);
		queue.add(5); queue.add(6); queue.add(7); queue.add(8);
		queue.add(9);
		System.out.println(queue);
		reverseQueue(queue);
		System.out.println(queue);
	}

	public static void reverseQueue(Queue<Integer> queue) {
		if (queue == null ||  queue.isEmpty()) return;
		// data stays in stack so keep calling queue with next element
		int top = queue.remove();
		reverseQueue(queue);
		// now unwind stack and add elements which were in stack
		queue.add(top);
	}
}
