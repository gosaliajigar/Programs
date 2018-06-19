package collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TreeSet is like HashSet which contains the unique elements only but in a
 * sorted manner. The major difference is that TreeSet provides a total ordering
 * of the elements. The elements are ordered using their natural ordering, or by
 * a Comparator typically provided at sorted set creation time. The set's
 * iterator will traverse the set in ascending element order. <br>
 * <br>
 * 
 * whenever you are adding element to the TreeSet object , it works just like
 * HashSet , The only difference is that instead of HashMap here we have TreeMap
 * object in the constructor. <br>
 * <br>
 * 
 * add(Element E) adds element E as a key in the TreeSet with value as constant
 * Object() PRESENT. <br>
 * <br>
 * 
 * There are many ways to find out the index of element in the TreeSet. one
 * liner : set.headSet(element).size() <br>
 * <br>
 * 
 * TreeSet(), TreeSet(collection), TreeSet(comparator), TreeSet(SortedSet)<br>
 * <br>
 * add(e), addAll(collection) <br>
 * clear(), clone()<br>
 * contains(o), containsAll(collection)<br>
 * ceiling floor lower higher <br>
 * comparator <br>
 * descendingIterator<br>
 * descendingSet<br>
 * first last<br>
 * forEach(Consumer)<br>
 * isEmpty(), size()<br>
 * iterator() <br>
 * pollFirst pollLast<br>
 * remove(o), removeAll(collection), removeIf(Predicate) <br>
 * retainAll(collection)<br>
 * subSet tailSet headSet <br>
 * toArray() toArray(T[]) <br>
 * <br>
 * <br>
 * Source :
 * http://javahungry.blogspot.com/2015/10/how-treeset-works-internally-in-java-interview-questions.html
 * <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C013TreeSet {

	public static void main(String[] args) {
		Set<Integer> t = new TreeSet<Integer>(IntStream.rangeClosed(1, 49).boxed().collect(Collectors.toSet()));
		t.removeIf(x -> x % 2 == 0);

		// floor ceiling lower higher
		System.out.println(((TreeSet<Integer>) t).floor(41) + " - " + ((TreeSet<Integer>) t).ceiling(41));
		System.out.println(((TreeSet<Integer>) t).floor(40) + " - " + ((TreeSet<Integer>) t).ceiling(42));
		System.out.println(((TreeSet<Integer>) t).lower(41) + " - " + ((TreeSet<Integer>) t).higher(41));
		System.out.println();

		// first last
		System.out.println(((TreeSet<Integer>) t).first() + " - " + ((TreeSet<Integer>) t).last());
		System.out.println(t);
		System.out.println();

		// pollFirst pollLast
		System.out.println(((TreeSet<Integer>) t).pollFirst() + " - " + ((TreeSet<Integer>) t).pollLast());
		System.out.println(t);
		System.out.println();

		/// subSet
		System.out.println(((TreeSet<Integer>) t).subSet(9, 31));
		System.out.println(((TreeSet<Integer>) t).subSet(9, false, 31, true));
		System.out.println();

		// headSet
		System.out.println(((TreeSet<Integer>) t).headSet(11));
		System.out.println(((TreeSet<Integer>) t).headSet(11, true));
		System.out.println();

		// tailSet
		System.out.println(((TreeSet<Integer>) t).tailSet(41));
		System.out.println(((TreeSet<Integer>) t).tailSet(41, false));
		System.out.println();
	}
}
