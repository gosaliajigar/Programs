package datastructure.map;

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

	public HashMap() { table = new Entry[TABLE_SIZE]; }

	/* (non-Javadoc)
	 * @see datastructure.map.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void put(K key, V value) {
		if (key != null) {
			Entry<K, V> entry = find(key);
			if (entry != null) {
				entry.value = value;
				return;
			}
			if (count >= (table.length * loadFactor)) rehash();
			int hash = hashcode(key);
			Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
			if (table[hash] != null) newEntry.next = table[hash];
			count++;
			table[hash] = newEntry;
		}
	}

	/* (non-Javadoc)
	 * @see datastructure.map.Map#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {
		Entry<K, V> entry = find(key);
		return ((entry != null) ? entry.value : null);
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
						current = current.next;
						table[hash] = current;
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
	 * @see datastructure.map.Map#entrySet()
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
	 * @see datastructure.map.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {	return (find(key) != null);	}

	/* (non-Javadoc)
	 * @see datastructure.map.Map#containsValue(java.lang.Object)
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
	 * @see datastructure.map.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() { return (count == 0);	}

	/* (non-Javadoc)
	 * @see datastructure.map.Map#keySet()
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
	 * @see datastructure.map.Map#size()
	 */
	@Override
	public int size() { return count; }

	public void display() {
		entrySet().forEach((e) -> System.out.print("{key=" + e.key + ";value=" + e.value + "}"));
		System.out.println();
	}

	private void rehash() {
		int size = (int) (table.length * 1.5);
		System.out.println(" -- resizing from " + table.length + " to " + size);
		Entry<K, V>[] newTable = new Entry[size];
		int newCount = 0;
		for (Entry<K, V> entry : entrySet()) {
			int hash = (Math.abs(entry.key.hashCode()) % size);
			Entry<K, V> newEntry = new Entry<K, V>(entry.key, entry.value, null);
			if (newTable[hash] != null) {
				newEntry.next = newTable[hash];
			}
			newCount++;
			newTable[hash] = newEntry;
		}
		table = newTable;
		count = newCount;
	}

	/**
	 * @param key
	 * @return
	 */
	private int hashcode(K key) { return (Math.abs(key.hashCode()) % table.length); }

	private Entry<K, V> find(K key) {
		int hash = hashcode(key);
		if (table[hash] != null) {
			Entry<K, V> entry = table[hash];
			while (entry != null) {
				if (entry.key.equals(key)) return entry;
				entry = entry.next;
			}
		}
		return null;
	}
}
