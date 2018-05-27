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

	private static final Integer NUM_OF_THREADS = 5;

	public static void main(String[] args) {

		// Create ExecutorService using the newFixedThreadPool() method
		// of the Executors class.
		ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);

		// Create an array to store IterateMe objects.
		Task[] tasks = new Task[NUM_OF_THREADS];
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			tasks[i] = new Task("Thread-" + i, false);
		}

		// Print original context "for" internally uses an iterator
		Task.getNames().forEach(x -> System.out.printf("%s ", x));
		System.out.println();

		// Execute Thread
		service.submit(tasks[0]);

		// Costly operation - A new copy of the collection is created
		Task.getNames().addIfAbsent("Oliver");

		// Execute Thread
		tasks[1].setGoToSleep(true);
		service.submit(tasks[1]);

		// Costly operation - A new copy of the collection is created
		Task.getNames().remove("Lex");

		// Execute Thread
		service.submit(tasks[2]);

		// Try to remove an element using Iterator methods
		Iterator<String> it = Task.getNames().iterator();
		Task.getNames().remove(1);
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
	private static final CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>(
			new String[] { "Peter", "Bruce", "Clark", "Barry", "Lex" });
	private String tName;
	private boolean goToSleep;

	public Task(String name, boolean goToSleep) {
		this.tName = name;
		this.goToSleep = goToSleep;
	}

	public static CopyOnWriteArrayList<String> getNames() {
		return names;
	}

	public void setGoToSleep(boolean goToSleep) {
		this.goToSleep = goToSleep;
	}

	@Override
	public void run() {
		if (this.goToSleep) {
			try {
				System.out.println(this.tName + " sleeping...");
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Iterator<String> it = names.iterator();

		while (it.hasNext()) {
			System.out.printf(it.next() + " ");
		}
		System.out.println();
	}
}