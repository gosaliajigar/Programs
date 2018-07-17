package collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque is the abbreviation of “Double Ended Queue”. 
 * A Collection that allows us to add (or) remove elements at both ends.
 * 
 * This class is likely to be faster than Stack when used as a stack, and faster
 * than LinkedList when used as a queue.
 * 
 * Resizable-array implementation of the Deque interface. Array deques have no
 * capacity restrictions; they grow as necessary to support usage. They are not
 * thread-safe; in the absence of external synchronization, they do not support
 * concurrent access by multiple threads. Null elements are prohibited. This
 * class is likely to be faster than Stack when used as a stack, and faster than
 * LinkedList when used as a queue. Most ArrayDeque operations run in amortized
 * constant time. Exceptions include remove, removeFirstOccurrence,
 * removeLastOccurrence, contains, iterator.remove(), and the bulk operations,
 * all of which run in linear time.
 * 
 * The iterators returned by this class's iterator method are fail-fast: If the
 * deque is modified at any time after the iterator is created, in any way
 * except through the iterator's own remove method, the iterator will generally
 * throw a ConcurrentModificationException. Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 * 
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * ConcurrentModificationException on a best-effort basis. Therefore, it would
 * be wrong to write a program that depended on this exception for its
 * correctness: the fail-fast behavior of iterators should be used only to
 * detect bugs.
 * 
 * We can see that the ArrayDeque is more than twice as fast as LinkedList
 * implementation. The benefit is coming from two places as far as I understand.
 * 
 * 1. ArrayDeque is backed by Array and Array is more cache-locality friendly
 * than LinkedList (since it has to go through another indirection in order to
 * get where next node is).
 * 
 * 2. ArrayDeque is memory efficient than LinkedList since it does not have to
 * keep an additional reference to the next node.
 * 
 * So using ArrayDeque instead of LinkedList when using it in a queue like
 * fashion.
 * 
 * So why is the ArrayDeque much faster? First of all, it removes the need for
 * extra memory used to create a ‘link’ that points to other objects. An
 * ArrayDeque is backed by a circular array (hopefully that was obvious by the
 * name), so all objects are ordered next to each other in the array. The
 * objects sitting contiguously in memory also helps out in cache hits as well.
 *
 * The twelve methods described above are summarized in the following table:
 * 
 * 								First Element (Head) 				Last Element (Tail)
 * 					Throws exception 		Special value	Throws exception 		Special value 
 * Insert 				addFirst(e) 		offerFirst(e) 		addLast(e)			offerLast(e)
 * Remove 				removeFirst() 		pollFirst() 		removeLast() 		pollLast()
 * Examine				getFirst() 			peekFirst() 		getLast() 			peekLast() 
 * 
 * 
 * This interface extends the Queue interface. When a deque is used as a queue, FIFO (First-In-First-Out)
 * behavior results. Elements are added at the end of the deque and removed from the beginning. 
 * 
 * The methods inherited from the Queue interface are precisely equivalent to Deque methods as indicated in 
 * the following table:
 * 
 * Queue Method 				Equivalent Deque Method
 * 	add(e) 							addLast(e) 
 * 	offer(e) 						offerLast(e)
 * 	remove() 						removeFirst()
 *  poll() 							pollFirst() 
 *  element() 						getFirst() 
 *  peek()							peekFirst() 
 *  
 *  
 * Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference 
 * to the legacy Stack class. When a deque is used as a stack, elements are pushed and popped from the beginning
 * of the deque. Stack methods are precisely equivalent to Deque methods as indicated in the table below:
 * 
 * Stack Method 				Equivalent Deque Method
 *  push(e) 						addFirst(e)
 *  pop() 							removeFirst()
 * 	peek() 							peekFirst() 
 * 
 * Note that the peek method works equally well when a deque is used as a queue or a stack; in either case, 
 * elements are drawn from the beginning of the deque.
 * 
 * 
 * Source: http://javaqueue2010.blogspot.com/
 * http://brianandstuff.com/2016/12/12/java-arraydeque-vs-linkedlist/
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 * https://www.javatpoint.com/java-deque-arraydeque
 * 
 * @author Jigar Gosalia
 *
 */
public class C032ArrayDeque {

	public static void main(String[] args) {
		// Creating Deque and adding elements
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Ravi"); deque.add("Vijay"); deque.add("Ajay");
		// Traversing elements
		for (String str : deque) { System.out.println(str); }

		deque.clear();

		System.out.println();
		deque.offer("arvind"); deque.offer("vimal"); deque.add("mukul"); deque.offerFirst("jai");
		System.out.println("After offerFirst Traversal...");
		for (String s : deque) { System.out.println(s); }
		// deque.poll();
		// deque.pollFirst();//it is same as poll()
		deque.pollLast(); System.out.println();
		System.out.println("After pollLast() Traversal...");
		for (String s : deque) { System.out.println(s); }
		System.out.println();

		Deque<Book> queue = new ArrayDeque<Book>();
		// Creating and Adding Books to Deque
		queue.add(new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8));
		queue.add(new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4));
		queue.add(new Book(103, "Operating System", "Galvin", "Wiley", 6));
		// Traversing ArrayDeque
		for (Book b : queue) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}
	}
}

class Book {
	int id;
	String name, author, publisher;
	int quantity;
	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
}