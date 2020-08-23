package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * How to sort an array in Java
 * 
 * If Object then either it should implement Comparable or pass a Comparator.
 *
 *
 * @author "Jigar Gosalia"
 *
 */
public class ArraySort {

	// class not implementing Comparable<T>
	static class Person {
		private String fName;
		private String lName;
		public Person(String fName, String lName) { this.fName = fName; this.lName = lName; }
		@Override
		public String toString() { return "Person:fName=" + this.fName + ";lName=" + this.lName; }
	}

	// class implementing Comparable<T>
	static class Point implements Comparable<Point> {
		private int x;
		private int y;
		public Point(int x, int y) { this.x = x; this.y = y; }
		@Override
		public String toString() { return this.x + "-" + this.y; }
		@Override
		public int compareTo(Point o) { return (((Integer)this.x).compareTo(o.x)); }
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		int[] intArr = { 1, 4, 2, 6, 3 };

		String[] strArr = { "E", "A", "U", "O", "I" };

		Person[] personArr = {new Person("A", "A"), new Person("Z", "Z"), new Person("C", "C"), new Person("", ""), new Person("O", "O")};

		Point[] pointArr = { new Point(0,0), new Point(30,30), new Point(20,20), new Point(10,10)};

		// Arrays.sort(T[] t) uses Dual-Pivot Quick sort algorithm with
		// performance of O(n log(n)).
		// The sorting is done in natural ascending order.
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		// String class implements Comparable<T>
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		// reverse the order by using collections helper methods
		Arrays.sort(strArr, Collections.reverseOrder());
		System.out.println(Arrays.toString(strArr));
		// if class doesn't implement Comparable then use explicit Comparator
		// else ClassCastException
		// Arrays.sort(personArr);
		Arrays.sort(personArr, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.fName.compareTo(o2.fName);
			}
		});
		// Java-8 functional way
		// Arrays.sort(personArr, (o1, o2) -> o1.fName.compareTo(o2.fName));
		System.out.println(Arrays.toString(personArr));

		Arrays.sort(pointArr);
		System.out.println(Arrays.toString(pointArr));
	}
}
