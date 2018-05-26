package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * LinkedList(), LinkedList(collection)<br>
 * <br>
 * add(e), add(i, e), addFirst(e), addLast(e), addAll(collection), addAll(i,
 * collection) <br>
 * clear(), clone()<br>
 * contains(o), containsAll(collection)<br>
 * descendingIterator()<br>
 * element()<br>
 * forEach(Consumer)<br>
 * get(i) getFirst() getLast()<br>
 * indexOf(o)<br>
 * isEmpty(), size()<br>
 * iterator() <br>
 * lastIndexOf(o)<br>
 * listIterator(), listIterator(i)<br>
 * offer(e) offerFirst(e) offerLast(e)<br>
 * peek() peekFirst() peekLast()<br>
 * poll() pollFirst() pollLast() <br>
 * pop() <br>
 * push(e) <br>
 * remove() remove(i), remove(o), removeFirst() removeFirstOccurrence(o)
 * removeLast() removeLastOccurrence() removeAll(collection),
 * removeIf(Predicate) <br>
 * replaceAll(UnaryOperator) <br>
 * retainAll(collection)<br>
 * set(i, e) <br>
 * sort(comparator) <br>
 * subList(start, end) <br>
 * toArray() toArray(T[]) <br>
 * <br>
 * LinkedList class in Java implements List and Deque interfaces and LinkedList
 * implements it using doubly linkedlist.<br>
 * <br>
 * In the implementation of the LinkedList class in Java there is a private
 * class Node which provides the structure for a node in a doubly linked list.
 * It has item variable for holding the value and two reference to Node class
 * itself for connecting to next and previous nodes.<br>
 * <br>
 * Source :
 * https://netjs.blogspot.com/2015/08/how-linked-list-class-works-internally-java.html
 * <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class Try001LinkedList {

	public static void main(String[] args) {
		// constructors
		List<Integer> a = new LinkedList<Integer>(Arrays.asList(9, 8, 3, 2, 6));
		List<Integer> b = new LinkedList<Integer>(a);

		// clone - shallow copy only and elements are not copied
		List<Integer> c = (List<Integer>) ((LinkedList<Integer>) b).clone();

		// add, addFirst, addLast, addAll
		a.add(0, 0);
		System.out.println(a.add(10) + " - " + a.addAll(b) + " - " + a.addAll(Arrays.asList(0, 1, 2, 2)));
		((Deque<Integer>) a).addFirst(0);
		((Deque<Integer>) a).addLast(0);
		((Deque<Integer>) a).removeFirst();
		((Deque<Integer>) a).removeLast();
		System.out.println();

		// contains, containsAll
		System.out.println(a.contains(2) + " - " + a.containsAll(b) + " - " + a.containsAll(Arrays.asList(0, 1)));
		System.out.println();

		// descendingIterator()
		// removing thru iterator wouldn't throw ConcurrentModificationException
		System.out.println(a);
		Iterator<Integer> ditr = ((Deque<Integer>) a).descendingIterator();
		while (ditr.hasNext()) {
			int value = ditr.next();
			System.out.print(value + " ");
			if (value % 2 != 0)
				ditr.remove();
		}
		System.out.println();

		// element
		System.out.println();
		System.out.println(((Queue) a).element());
		System.out.println();

		// forEach
		a.forEach(System.out::print);
		System.out.println();
		a.forEach(x -> System.out.printf("%s - ", x));
		System.out.println();

		// get, getFirst, getLast
		System.out.println(a.get(0) + " - " + ((Deque) a).getFirst() + " - " + ((Deque) a).getLast());
		System.out.println();

		// indexOf, lastIndexOf
		System.out.println(a.indexOf(2) + " - " + a.lastIndexOf(2));
		System.out.println();

		// isEmpty, size
		System.out.println(a.isEmpty() + " - " + a.size());
		System.out.println();

		// push pop peekFirst peekLast
		System.out.println(a);
		((Deque) a).push(333);
		System.out.println(((Deque<Integer>) a).peek() + " - " + ((Deque<Integer>) a).pop());
		System.out.println(a);
		System.out.println();

		// offer offerFirst offerLast poll pollFirst pollLast
		System.out.println(a);
		((Deque) a).offer(333);
		System.out.println(((Deque<Integer>) a).peek() + " - " + ((Deque<Integer>) a).poll());
		System.out.println(a);
		System.out.println();

		// remove, removeFirst, removeLast, removeFirstOccurrence, removeLastOccurrence,
		// removeAll
		a.addAll(Arrays.asList(-200, -100, -100, 100, 200, 300, 400, 100, -100, -100));
		System.out.println(((Deque<Integer>) a).remove() + "" + ((Deque<Integer>) a).removeFirst() + ""
				+ ((Deque<Integer>) a).removeLast() + "" + ((Deque<Integer>) a).removeFirstOccurrence(-100) + ""
				+ ((Deque<Integer>) a).removeLast() + "" + ((Deque<Integer>) a).removeLastOccurrence(-100));
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

		// replaceAll
		System.out.println(a);
		a.replaceAll(x -> x + x + x + x + x);
		System.out.println(a);
		System.out.println();

		// retainAll (only keep common elements)
		a.addAll(b);
		a.retainAll(b);
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

		// listIterator(), listIterator(i)
		ListIterator<Integer> litr = a.listIterator();
		while (litr.hasNext()) {
			System.out.print(litr.next() + " ");
		}
		System.out.println();
		litr = a.listIterator(a.size());
		while (litr.hasPrevious()) {
			System.out.print(litr.previous() + " ");
		}
		System.out.println();
		System.out.println();

		// sort
		a.sort(Collections.reverseOrder());
		System.out.println(a);
		System.out.println();

		// ConcurrentModificationException when removing element
		// for (Integer x : a) {
		// a.remove(x);
		// }
	}
}
