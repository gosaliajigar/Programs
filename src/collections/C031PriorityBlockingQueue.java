package collections;

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Internal data structure: this implementation uses an array representation 
 * of a binary heap which is a complete binary tree. This data structure allows 
 * the queue efficiently orders its elements based on their values. It also uses
 * ReentrantLock to protect public operations in multi-threaded context.<br>
 * <br>
 * 
 * An unbounded blocking queue that uses the same ordering rules as class 
 * PriorityQueue and supplies blocking retrieval operations. While this queue 
 * is logically unbounded, attempted additions may fail due to resource 
 * exhaustion (causing OutOfMemoryError). This class does not permit null elements.
 * A priority queue relying on natural ordering also does not permit insertion of 
 * non-comparable objects (doing so results in ClassCastException) <br>
 * <br>
 * 
 * A Queue that additionally supports operations that wait for the queue to
 * become non-empty when retrieving an element, and wait for space to become
 * available in the queue when storing an element. BlockingQueue methods come in
 * four forms, with different ways of handling operations that cannot be
 * satisfied immediately, but may be satisfied at some point in the future: one
 * throws an exception, the second returns a special value (either null or
 * false, depending on the operation), the third blocks the current thread
 * indefinitely until the operation can succeed, and the fourth blocks for only
 * a given maximum time limit before giving up. These methods are summarized in
 * the following table: <br>
 * 
 * Summary of BlockingQueue methods<br>
 * 			Throws exception 	Special value 		Blocks 			Times out<br>
 * Insert 		add(e) 				offer(e) 		put(e) 		offer(e, time, unit)<br>
 * Remove 		remove() 			poll() 			take() 		poll(time, unit) <br>
 * Examine 		element() 			peek() 			N/A 			N/A<br>
 * <br>
 * <br>
 * 
 * Sources: http://www.codejava.net/java-core/concurrency/java-priorityblockingqueue-examples <br>
 * http://www.baeldung.com/java-priority-blocking-queue
 * 
 * 
 * @author Jigar Gosalia
 *
 */
public class C031PriorityBlockingQueue {

	// Check @link{BQMainClass.class}
	// put and take
	public static void main(String[] args) throws Exception {
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
		// anonymous Runnable class
		new Thread(() -> {
		    System.out.println("Polling...");
		    while (true) {
		        try {
		        	// blocking call
		        	Integer poll = queue.take();
		        	// Integer poll = queue.poll(1, TimeUnit.SECONDS);
		        	// above will poll only for 1 seconds and move to continue with loop
		            System.out.println("Polled: " + poll);
		            TimeUnit.SECONDS.sleep(1);
		            
		        } 
		        catch (InterruptedException e) { 
		            e.printStackTrace();
		        }
		    }
		}).start();
		System.out.println("Sleeping for 5 seconds ... ");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Adding to queue ... ");
		queue.addAll(Arrays.asList(1, 5, 6, 1, 2, 6, 7));
		System.out.println("Queue size ... " + queue.size() + " and sleep for 20 seconds");
		TimeUnit.SECONDS.sleep(20);
		System.out.println("Processed!!");
		queue.addAll(Arrays.asList(1, 5, 6, 1, 2, 6, 7));
		// have to add exit else blocking call take() will
		// wait for ever for data from queue.
		// below statement will make program to exit even before 
		// queue is able to read the whole queue.
		System.exit(1);
	}
}
