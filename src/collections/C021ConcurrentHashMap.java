package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * underlined data structure for ConcurrentHashMap is Hashtable<br>
 * <br>
 * A hash table supporting full concurrency of retrievals and high expected
 * concurrency for updates. This class obeys the same functional specification
 * as Hashtable, and includes versions of methods corresponding to each method
 * of Hashtable. However, even though all operations are thread-safe, retrieval
 * operations do not entail locking, and there is not any support for locking
 * the entire table in a way that prevents all access. This class is fully
 * interoperable with Hashtable in programs that rely on its thread safety but
 * not on its synchronization details.<br>
 * <br>
 *
 * Source:
 * https://javarevisited.blogspot.com/2013/02/concurrenthashmap-in-java-example-tutorial-working.html <br>
 * https://www.geeksforgeeks.org/difference-hashmap-concurrenthashmap/ <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C021ConcurrentHashMap {

	public static void main(String[] args) throws Exception {
		// itr has no elements when it was initialized
		Iterator<Map.Entry<Integer, String>> itr = HashMapThread.map.entrySet().iterator();

		new Thread(new HashMapThread(100, "A")).start();
		new Thread(new HashMapThread(101, "B")).start();
		new Thread(new HashMapThread(102, "C")).start();
		new Thread(new HashMapThread(103, "D")).start();

		Thread.sleep(1000);
		for (Map.Entry<Integer, String> entry : HashMapThread.map.entrySet()) {
			Thread.sleep(2000);
			System.out.println(entry);
		}

		// false shows that map was empty when itr was initialized
		// hence itr has no next elements even though map has elements.
		System.out.println(itr.hasNext() + " : " + HashMapThread.map.size());
		while (itr.hasNext()) {
			// below is never executed
			Map.Entry<Integer, String> entry = itr.next();
			System.out.println("Removing " + entry.getKey() + "-" + entry.getValue());
			itr.remove();
		}
		System.out.println(HashMapThread.map);
	}
}

class HashMapThread implements Runnable {
	public static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

	int id;
	String label;

	public HashMapThread(int id, String label) {
		this.id = id;
		this.label = label;
	}

	@Override
	public void run() {
		// Child add new element in the object
		System.out.println("Started " + id + " ... ");
		try {
			map.put(id, label);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Child Thread going to add element");
		}
	}
}