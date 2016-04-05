package com.programs.datastructure.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Custom HashMap Implementation with Chaining.
 * 
 * @author "Jigar Gosalia"
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> implements Map<K, V> {

	private int count;

	private Entry<K, V>[] table;

	private final double loadFactor = 0.75;

	private static final int TABLE_SIZE = 4;

	/**
	 * 
	 */
	public HashMap() {
		table = new Entry[TABLE_SIZE];
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void put(K key, V value) {
		if (key != null) {
			if (count >= (table.length * loadFactor)) {
				resize();
			}

			int hash = hashcode(key);

			Entry<K, V> entry = new Entry<K, V>(key, value, null);

			if (table[hash] == null) {
				count++;
				table[hash] = entry;
			} else {
				Entry<K, V> previous = null;
				Entry<K, V> current = table[hash];
				// we have reached last entry of bucket.
				while (current != null) {
					if (current.key.equals(key)) {
						// node has to be insert on first of
						// bucket.
						if (previous == null) {
							entry.next = current.next;
							table[hash] = entry;
						} else {
							entry.next = current.next;
							previous.next = entry;
						}
						count++;
						return;
					}
					previous = current;
					current = current.next;
				}
				previous.next = entry;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {
		int hash = hashcode(key);
		if (table[hash] != null) {
			Entry<K, V> entry = table[hash];
			while (entry != null) {
				if (entry.key.equals(key)) {
					// return value corresponding to key.
					return entry.value;
				}
				entry = entry.next;
			}
		}
		// returns null if key is not found.
		return null;
	}

	/**
	 * @param key
	 * @return
	 */
	@Override
	public boolean remove(K key) {
		int hash = hashcode(key);
		if (table[hash] != null) {
			Entry<K, V> previous = null; 
			Entry<K, V> current = table[hash];
			while (current != null) {
				if (current.key.equals(key)) {
					if (previous == null) {
						table[hash] = table[hash].next;
					} else {
						previous.next = current.next;
					}
					count--;
					return true;
				}
				previous = current;
				current = current.next;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#entrySet()
	 */
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet =  new HashSet<Entry<K, V>>();
		for (int index = 0; index < table.length; index++) {
			Entry<K, V> entry = table[index];
			while (entry != null) {
				entrySet.add(entry);
				entry = entry.next;
			}
		}
		return entrySet;
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		int hash = hashcode(key);
		if (table[hash] != null) {
			Entry<K, V> entry = table[hash];
			while (entry != null) {
				if (entry.key.equals(key)) {
					return true;
				}
				entry = entry.next;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(V value) {
		for (int index = 0; index < table.length; index++) {
			Entry<K, V> entry = table[index];
			while (entry != null) {
				if (value.equals(entry.value)) {
					return true;
				}
				entry = entry.next;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#keySet()
	 */
	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for (int index = 0; index < table.length; index++) {
			Entry<K, V> entry = table[index];
			while (entry != null) {
				keySet.add(entry.key);
				entry = entry.next;
			}
		}
		return keySet;
	}

	/* (non-Javadoc)
	 * @see com.programs.datastructure.map.Map#size()
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * 
	 */
	public void display() {
		for (int index = 0; index < table.length; index++) {
			Entry<K, V> entry = table[index];
			while (entry != null) {
				System.out.print("{key=" + entry.key + ";value=" + entry.value + "}");
				entry = entry.next;
			}
			System.out.println();
		}
	}

	/**
	 * 
	 */
	private void resize() {
		int size = (int) (table.length * 1.5);
		Entry<K, V>[] newTable = new Entry[size];
		for (int index = 0; index < table.length; index++) {
			newTable[index] = table[index];
		}
		table = newTable;
	}

	/**
	 * @param key
	 * @return
	 */
	private int hashcode(K key) {
		return (Math.abs(key.hashCode()) % TABLE_SIZE);
	}
}
