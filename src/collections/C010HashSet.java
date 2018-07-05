package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet uses HashMap internally to store it’s objects. Whenever you create a
 * HashSet object, one HashMap object associated with it is also created. This
 * HashMap object is used to store the elements you enter in the HashSet. The
 * elements you add into HashSet are stored as keys of this HashMap object. The
 * value associated with those keys will be a constant.
 * <br><br>
 * 
 * Whenever you insert an element into HashSet using add() method, it actually
 * creates an entry in the internally backing HashMap object with element you
 * have specified as it’s key and constant called “PRESENT” as it’s value.
 * <br><br>
 * 
 * You can notice that, add() method of HashSet class internally calls put()
 * method of backing HashMap object by passing the element you have specified as
 * a key and constant “PRESENT” as it’s value.
 * <br><br>
 * 
 * HashSet(), HashSet(collection), HashSet(capacity)<br>
 * <br>
 * add(e), addAll(collection), addAll(i, collection) <br>
 * clear(), clone()<br>
 * contains(o), containsAll(collection)<br>
 * forEach(Consumer)<br>
 * isEmpty(), size()<br>
 * iterator() <br>
 * remove(i), remove(o), removeAll(collection), removeIf(Predicate) <br>
 * retainAll(collection)<br>
 * toArray() toArray(T[]) <br>
 * <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C010HashSet {

	public static void main(String[] args) {
		// constructors
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(9, 8, 3, 2, 6));
		Set<Integer> b = new HashSet<Integer>(a);

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
		a.remove(5); // index 5
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

		// ConcurrentModificationException when removing element with iterator
		// for (Integer x : a) {
		// a.remove(x);
		// }
	}
}
