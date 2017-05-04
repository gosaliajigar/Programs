package datastructure.table;

/**
 * HashTable Implementation with Linear Probing.<br>
 * <br>
 * When there is no more place in the table, the loop, searching for empty slot,
 * will run infinitely. It won't happen in real hash table based on open
 * addressing, because it is most likely dynamic-sized. <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class HashTable<K, V> {

	private final static int TABLE_SIZE = 128;

	private HashEntry<K, V>[] table;

	public HashTable() {
		table = new HashEntry[TABLE_SIZE];
	}

	/**
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int hash = hashCode(key);
		while (table[hash] != null && !table[hash].getKey().equals(key)) {
			hash = (hash + 1) % TABLE_SIZE;
		}
		if (table[hash] != null)
			return table[hash].getValue();
		return null;
	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		int hash = hashCode(key);
		while (table[hash] != null && table[hash].getKey().equals(key)) {
			hash = (hash + 1) % TABLE_SIZE;
		}
		table[hash] = new HashEntry(key, value);
	}

	/**
	 * @param key
	 * @return
	 */
	private int hashCode(K key) {
		return (key.hashCode() % TABLE_SIZE);
	}
}