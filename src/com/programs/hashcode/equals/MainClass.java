package com.programs.hashcode.equals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param arg
	 */
	public static void main(final String[] arg) {

		Dog d1 = new Dog("red");
		Dog d2 = new Dog("white");
		Dog d3 = new Dog("black");
		Dog d4 = new Dog("red");

		Map<Dog, Integer> map = new HashMap<Dog, Integer>();
		System.out.println(MainClass.printMapUsingIterator(map));
		map.put(d1, 1);
		map.put(d2, 2);
		map.put(d3, 3);
		// d4 won't be inserted in Map as key Dog has equals and hashCode
		// implementation which will identify that d4(red) is same as d1(red),
		// hence it would override d1 by updating the key=4.
		// In absence of equals and hashCode implementation, d4(red) is inserted
		// into map.
		map.put(d4, 4);
		System.out.println(MainClass.printMapUsingIterator(map));
		System.out.println("Size of Map     : " + map.size());
		// In absence of equals and hashCode implementation, it wouldn't find
		// dog with red color.
		System.out.println("Red is at       : " + map.get(new Dog("red")));
		// In absence of equals and hashCode implementation, it wouldn't find
		// dog with red color.
		System.out.println("Deleting key at : " + map.get(new Dog("red")));
		// In absence of equals and hashCode implementation, it wouldn't delete
		// dog with red color.
		map.remove(new Dog("red"));
		System.out.println(MainClass.printMapUsingEntrySet(map));
		System.out.println("Size of Map     : " + map.size());
	}

	/**
	 * @param map
	 * @return
	 */
	public static String printMapUsingIterator(final Map<Dog, Integer> map) {
		Iterator<Entry<Dog, Integer>> iterator = map.entrySet().iterator();

		StringBuilder prettyMapFormat = new StringBuilder();
		prettyMapFormat.append("Printing Map    : ");
		prettyMapFormat.append("{");

		while (iterator.hasNext()) {
			Entry<Dog, Integer> entry = iterator.next();
			prettyMapFormat.append(entry.getKey().getColor()).append("=")
					.append(entry.getValue());
			if (iterator.hasNext()) {
				prettyMapFormat.append(", ");
			}
		}
		prettyMapFormat.append("}");
		return prettyMapFormat.toString();
	}

	/**
	 * @param map
	 * @return
	 */
	public static String printMapUsingEntrySet(final Map<Dog, Integer> map) {
		StringBuilder prettyMapFormat = new StringBuilder();
		prettyMapFormat.append("Printing Map    : ");
		prettyMapFormat.append("{");
		for (Entry<Dog, Integer> entry : map.entrySet()) {
			prettyMapFormat.append(entry.getKey().getColor()).append("=")
					.append(entry.getValue()).append(", ");
		}
		prettyMapFormat.delete(prettyMapFormat.length()-2, prettyMapFormat.length());
		prettyMapFormat.append("}");
		return prettyMapFormat.toString();
	}
}
