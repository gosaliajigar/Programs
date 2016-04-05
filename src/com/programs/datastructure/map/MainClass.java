package com.programs.datastructure.map;

import java.util.Set;

import com.programs.datastructure.map.Map.Entry;

/**
 * Demonstrate Custom HashMap implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(21, 12);
		map.put(25, 121);
		System.out.println("HashMap(" + map.size() + ")");
		map.put(29, 100);
		map.put(30, 151);
		map.put(33, 15);
		map.put(35, 89);
		map.put(28, 28);
		System.out.println("HashMap(" + map.size() + ")");
		System.out.println();
		map.display();
		System.out.println();

		displayEntrySet(map.entrySet());
		System.out.println();
		displaySet(map.keySet());
		System.out.println();

		System.out.println("Key(21)=" + map.get(21));
		System.out.println("Key(51)=" + map.get(51));
		System.out.println();

		System.out.println("Add Key(33) again with value 66");
		map.put(33, 66);
		map.display();
		System.out.println();

		System.out.println("Remove Key(21): " + map.remove(21));
		System.out.println("Remove Key(51): " + map.remove(51));
		map.display();
		System.out.println();

		System.out.println("Remove Key(21): " + map.remove(21));
		System.out.println("Remove Key(51): " + map.remove(51));
		map.display();
		System.out.println();

		System.out.println("Remove Key(29): " + map.remove(29));
		map.display();
		System.out.println("HashMap(" + map.size() + ")");		
	}

	/**
	 * @param keySet
	 */
	private static <K> void displaySet(Set<K> keySet) {
		for (K key: keySet) {
			System.out.print("{" + key + "}");
		}
		System.out.println();
	}

	/**
	 * @param entrySet
	 */
	private static <K, V> void displayEntrySet(Set<Entry<K, V>> entrySet) {
		for (Entry<K, V> entry: entrySet) {
			System.out.print("{key=" + entry.key + ";value=" + entry.value + "}");
		}
		System.out.println();
	}
}