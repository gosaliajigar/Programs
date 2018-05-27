package collections;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * A scalable concurrent NavigableSet implementation based on a
 * ConcurrentSkipListMap. The elements of the set are kept sorted according to
 * their natural ordering, or by a Comparator provided at set creation time,
 * depending on which constructor is used.<br>
 * 
 * <br>
 * ConcurrentSkipListSet is used in concurrent threading environment.
 * ConcurrentSkipListSet maintains the behavior same as TreeSet. The elements in
 * ConcurrentSkipListSet can be accessed simultaneously and element's integrity
 * will be maintained. ConcurrentSkipListSet does not affect the performance.
 * All access is lock free. And we do not need to worry for synchronization.<br>
 * <br>
 * 
 * Source: https://www.concretepage.com/java/concurrentskiplistset_java <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C014ConcurrentSkipListSet {

	public static final ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<String>();

	public static void main(String[] args) {
		new Thread(new AddThread()).start();
		new Thread(new RemoveThread()).start();
	}
}

class AddThread implements Runnable {
	@Override
	public void run() {
		// adds specified element in the set
		C014ConcurrentSkipListSet.set.add("A");
		C014ConcurrentSkipListSet.set.add("B");

		// returns the first element
		String s1 = C014ConcurrentSkipListSet.set.first();
		System.out.println(s1);

		// returns the last element.
		String s2 = C014ConcurrentSkipListSet.set.last();
		System.out.println(s2);
	}
}

class RemoveThread implements Runnable {
	@Override
	public void run() {
		// removes the specified element from the set.
		C014ConcurrentSkipListSet.set.remove("A");
	}
}
