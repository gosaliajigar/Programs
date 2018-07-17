package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet is an extended version of HashSet. HashSet doesn't follow any
 * order where as LinkedHashSet maintains insertion order.<br> 
 * <br>
 * HashSet uses HashMap object internally to store its elements where as LinkedHashSet uses
 * LinkedHashMap object internally to store and process its elements. <br>
 * <br>
 * LinkedHashSet uses LinkedHashMap object to store its elements. The elements
 * you insert in the LinkedHashSet are stored as keys of this LinkedHashMap
 * object. Each key, value pair in the LinkedHashMap are instances of its
 * static inner class called Entry<K, V>. This Entry<K, V> class extends
 * HashMap.Entry class. The insertion order of elements into LinkedHashMap are
 * maintained by adding two new fields to this class. They are before and after.
 * These two fields hold the references to previous and next elements. These two
 * fields make LinkedHashMap to function as a doubly linked list. <br>
 * <br>
 * The first two fields of above inner class of LinkedHashMap (before and after)
 * are responsible for maintaining the insertion order of the LinkedHashSet.<br>
 * <br>
 * In LinkedHashMap, the same set of Entry objects (rather references to Entry
 * objects) are arranged in two different manner. One is the HashMap and another
 * one is Doubly linked list. Entry objects just sit on heap memory, unaware
 * of that they are part of two different data structures. <br>
 * <br>
 * 
 * LinkedHashSet(), LinkedHashSet(collection), LinkedHashSet(capacity)<br>
 * <br>
 * add(e), addAll(collection) <br>
 * clear(), clone()<br>
 * contains(o), containsAll(collection)<br>
 * forEach(Consumer)<br>
 * isEmpty(), size()<br>
 * iterator() <br>
 * remove(o), removeAll(collection), removeIf(Predicate) <br>
 * retainAll(collection)<br>
 * toArray() toArray(T[]) <br>
 * <br>
 * <br>
 * 
 * Source : http://javaconceptoftheday.com/how-linkedhashset-works-internally-in-java/
 * <br><br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C012LinkedHashSet {

	public static void main(String[] args) {
		// constructors
		Set<Integer> a = new LinkedHashSet<Integer>(Arrays.asList(9, 8, 3, 2, 6));
		Set<Integer> b = new LinkedHashSet<Integer>(a);

		@SuppressWarnings({"unused", "unchecked"})
		// clone - shallow copy only and elements are not copied
		Set<Integer> c = (Set<Integer>) ((HashSet<Integer>) b).clone();

		// add, addAll
		System.out.println(a.add(10) + " - " + a.addAll(b) + " - " + a.addAll(Arrays.asList(0, 1, 2, 2)));
		System.out.println();

		// contains, containsAll
		System.out.println(a.contains(2) + " - " + a.containsAll(b) + " - " + a.containsAll(Arrays.asList(0, 1)));
		System.out.println();

		// forEach
		a.forEach(System.out::print);
		System.out.println();
		a.forEach(x -> System.out.printf("%s - ", x));
		System.out.println();

		// isEmpty, size
		System.out.println(a.isEmpty() + " - " + a.size());
		System.out.println();

		// remove, removeAll
		a.remove(5); // object and not index
		System.out.println(a + " - " + b);
		a.removeAll(b); // remove all elements that match with b
		System.out.println(a);
		a.remove(new Integer(9)); // object with value 9
		System.out.println();

		// removeIf
		a.addAll(Arrays.asList(100, 200, 300, 400));
		System.out.println(a);
		a.removeIf(x -> x >= 100);
		System.out.println(a);
		System.out.println();

		// retainAll
		a.addAll(b);
		a.retainAll(b);
		System.out.println(a);
		System.out.println();

		// toArray
		Object[] obja = a.toArray();
		System.out.println(Arrays.toString(obja));
		System.out.println();

		// toArray(T[])
		System.out.println(a.size() + " - " + a);
		Integer[] inta = a.toArray(new Integer[] {});
		System.out.println(inta.length + " - " + Arrays.toString(inta));

		inta = a.toArray(new Integer[] { 11, 22, 33, 44, 55 });
		System.out.println(inta.length + " - " + Arrays.toString(inta));

		inta = a.toArray(new Integer[] { 11, 22, 33, 44, 55, 66, 77, 88 });
		System.out.println(inta.length + " - " + Arrays.toString(inta));
		System.out.println();

		// iterator()
		// removing thru iterator wouldn't throw ConcurrentModificationException
		Iterator<Integer> itr = a.iterator();
		while (itr.hasNext()) {
			int value = itr.next();
			System.out.print(value + " ");
			if (value % 2 != 0)
				itr.remove();
		}
		System.out.println();

		// ConcurrentModificationException when removing element
		// for (Integer x : a) {
		// a.remove(x);
		// }
	}
}
