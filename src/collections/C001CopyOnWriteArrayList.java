package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A thread-safe variant of ArrayList in which all mutative operations (add,
 * set, and so on) are implemented by making a fresh copy of the underlying
 * array. <br> 
 * <br>
 * This is ordinarily too costly, but may be more efficient than
 * alternatives when traversal operations vastly out number mutations, and is
 * useful when you cannot or don't want to synchronize traversals, yet need to
 * preclude interference among concurrent threads. The "snapshot" style iterator
 * method uses a reference to the state of the array at the point that the
 * iterator was created. This array never changes during the lifetime of the
 * iterator, so interference is impossible and the iterator is guaranteed not to
 * throw ConcurrentModificationException. The iterator will not reflect
 * additions, removals, or changes to the list since the iterator was created.
 * Element-changing operations on iterators themselves (remove, set, and add)
 * are not supported. These methods throw UnsupportedOperationException.<br>
 * <br>
 * Source :
 * https://examples.javacodegeeks.com/core-java/util/concurrent/copyonwritearraylist/java-util-concurrent-copyonwritearraylist-example/
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C001CopyOnWriteArrayList {

	private static final Integer NUM_OF_THREADS = 3;

	public static void main(String[] args) {
		// Create ExecutorService using the newFixedThreadPool() method
		// of the Executors class.
		ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);

		// Create an array to store Task objects.
		Task[] tasks = new Task[NUM_OF_THREADS+1];
		for (int i = 1; i <= NUM_OF_THREADS; i++)
			tasks[i] = new Task("Thread-" + i);

		// Print original context "for" internally uses an iterator
		Task.getData().forEach(x -> System.out.printf("%s ", x));
		System.out.println(); System.out.println();

		// Execute Thread
		service.submit(tasks[1]);

		// Costly operation - A new copy of the collection is created
		Task.getData().addIfAbsent("Oliver");

		// Execute Thread
		service.submit(tasks[2]);

		// Costly operation - A new copy of the collection is created
		Task.getData().remove("Lex");

		// Execute Thread
		service.submit(tasks[3]);

		// Try to remove an element using Iterator methods
		Iterator<String> it = Task.getData().iterator();
		Task.getData().remove(1);
		while (it.hasNext()) {
			try {
				// This is NOT supported by CopyOnWriteArrayList's Iterator
				it.remove();
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
				break;
			}
		}
		// Shutdown ExecutionService
		service.shutdown();
	}
}

class Task implements Runnable {
	private static final CopyOnWriteArrayList<String> data = new CopyOnWriteArrayList<String>(
			new String[] { "Peter", "Bruce", "Clark", "Barry", "Lex" });
	private String name;

	public Task(String name) { this.name = name; }

	public static CopyOnWriteArrayList<String> getData() { return data; }

	@Override
	public void run() {
		Iterator<String> it = data.iterator();
		try {
			System.out.println(this.name + " sleeping...");
			TimeUnit.SECONDS.sleep(3);
			// will never see NEW elements in console as 
			// they are added after iterator has copy of list
			data.add("NEW" + this.name.charAt(this.name.length()-1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " executing...");
		while (it.hasNext()) System.out.printf("\t" + this.name + "-" + it.next() + "\n");
		System.out.println("\n");
	}
}