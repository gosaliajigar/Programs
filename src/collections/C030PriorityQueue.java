package collections;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PriorityQueue is an unbounded Queue implementation in Java, which is based on
 * priority heap. PriorityQueue allows you to keep elements in a particular
 * order, according to there natural order or custom order defined by Comparator
 * interface in Java.<br>
 * <br>
 * 
 * Iterator returned by PriorityQueue doesn't offer any ordering traversal guarantee.<br>
 * <br>
 * <br>
 * 
 * 		Summary of Queue methods <br>
 * 			Throws exception 		Returns special value<br> 
 * Insert	 	add(e)					offer(e)<br> 
 * Remove 		remove() 				poll() <br>
 * Examine 		element() 				peek() <br>
 * <br>
 * 
 * throws NoSuchElementException on remove() and element() if queue is empty.
 * 
 * Source:
 * https://javarevisited.blogspot.com/2013/10/what-is-priorityqueue-data-structure-java-example-tutorial.html <br>
 * https://www.sanfoundry.com/java-program-priority-queue/ <br>
 * <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C030PriorityQueue {
	public static void main(String args[]) {
		// [0-9] [A-Z] [a-z]
		PriorityQueue<Item> items = new PriorityQueue<Item>();
		items.addAll(Arrays.asList( new Item("iPhone", 900), 
									new Item("iPad", 300), 
									new Item("Xbox", 300),
									new Item("iWatch", 300)));
		System.out.println(items);
		System.out.println();

		System.out.println(items.peek() + " : " + items);
		System.out.println();

		System.out.println(items.poll() + " : " + items);
		System.out.println();

		// null elements not allowed in PriorityQueue - NullPointerException
		// items.add(null);

		items.offer(new Item("Pixel", 300));

		while (!items.isEmpty()) {
			System.out.println(items.poll() + " : " + items);
			System.out.println();
		}

		PriorityQueue<Person> persons = new PriorityQueue<Person>();
		persons.add(new Person("John"));
		// throws collections.Person cannot be cast to java.lang.Comparable
		// as it would compare its elements and they are not comparable.
		// persons.add(new Person("Johnny"));
	}
}

class Item implements Comparable<Item> {
	private String name;
	private int price;
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Item other = (Item) obj;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) return false;
		if (this.price != other.price) return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 97;
		int hash = 5;
		hash = prime * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = prime * hash + this.price;
		return hash;
	}

	@Override
	public int compareTo(Item i) {
		if (this.name.equals(i.name)) return this.price - i.price;
		return this.name.compareTo(i.name);
	}

	@Override
	public String toString() {
		return String.format("%s: $%d", name, price);
	}
}

class Person {
	private String name;
	public Person(String name) { this.name = name; }
	@Override
	public String toString() { return name; }
}