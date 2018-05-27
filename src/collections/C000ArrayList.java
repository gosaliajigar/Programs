package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList(), ArrayList(collection), ArrayList(capacity)<br>
 * <br>
 * add(e), add(i, e), addAll(collection), addAll(i, collection) <br>
 * clear(), clone()<br> 
 * contains(o), containsAll(collection)<br>
 * forEach(Consumer)<br>
 * get(i)<br>
 * indexOf(o)<br>
 * isEmpty(), size()<br>
 * iterator() <br>
 * lastIndexOf(o)<br>
 * listIterator(), listIterator(i)<br>
 * remove(i), remove(o), removeAll(collection), removeIf(Predicate) <br>
 * replaceAll(UnaryOperator) <br>
 * retainAll(collection)<br>
 * set(i, e) <br>
 * sort(comparator) <br>
 * subList(start, end) <br>
 * toArray() toArray(T[]) <br>
 * <br>
 * Implementation : http://www.codenuclear.com/how-arraylist-works-internally-java/ <br>
 * https://netjs.blogspot.com/2015/08/how-arraylist-works-internally-in-java.html
 * <br><br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C000ArrayList {

	public static void main(String[] args) {
		// constructors
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(9, 8, 3, 2, 6));
		List<Integer> b = new ArrayList<Integer>(a);

		// clone - shallow copy only and elements are not copied
		List<Integer> c = (List<Integer>) ((ArrayList<Integer>)b).clone();
		
		// add, addAll
		a.add(0, 0);
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

		// get
		System.out.println(a.get(0));
		System.out.println();

		// indexOf, lastIndexOf
		System.out.println(a.indexOf(2) + " - " + a.lastIndexOf(2));
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
		a.removeIf(x -> x>=100);
		System.out.println(a);
		System.out.println();
		
		// replaceAll
		System.out.println(a);
		a.replaceAll(x -> x+x+x+x+x);
		System.out.println(a);
		System.out.println();
		
		// retainAll
		a.addAll(b); a.retainAll(b);
		System.out.println(a);
		System.out.println();

		// set
		a.set(0, 100);

		// subList
		System.out.println(a.subList(2, 4));
		System.out.println();

		// toArray
		Object[] obja = a.toArray();
		System.out.println(Arrays.toString(obja));
		System.out.println();

		// toArray(T[])
		System.out.println(a.size() + " - " + a);
		Integer[] inta = a.toArray(new Integer[] {});
		System.out.println(inta.length + " - " + Arrays.toString(inta));

		inta = a.toArray(new Integer[] {11, 22, 33, 44, 55});
		System.out.println(inta.length + " - " + Arrays.toString(inta));

		inta = a.toArray(new Integer[] {11, 22, 33, 44, 55, 66, 77, 88});
		System.out.println(inta.length + " - " + Arrays.toString(inta));
		System.out.println();

		// iterator()
		// removing thru iterator wouldn't throw ConcurrentModificationException
		Iterator<Integer> itr = a.iterator();
		while (itr.hasNext()) { int value = itr.next(); System.out.print(value + " "); if (value%2 != 0) itr.remove(); }
		System.out.println();

		// listIterator(), listIterator(i)
		ListIterator<Integer> litr = a.listIterator();
		while (litr.hasNext()) { System.out.print(litr.next() + " "); }
		System.out.println();
		litr = a.listIterator(a.size());
		while (litr.hasPrevious()) { System.out.print(litr.previous() + " "); }
		System.out.println(); System.out.println();

		// sort
		a.sort(Collections.reverseOrder());
		System.out.println(a);
		System.out.println();
		
		// ConcurrentModificationException when removing element
		// for (Integer x : a) {
		//	a.remove(x);
		// }
	}
}
