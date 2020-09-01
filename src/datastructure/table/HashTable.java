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
	private int count = 0;
	private HashEntry<K, V>[] table;
	public HashTable() { table = new HashEntry[TABLE_SIZE]; }

	public V get(K key) {
		int search = 0;
		int hash = hashCode(key);
		while (table[hash] != null && search <= TABLE_SIZE) {
			if (table[hash].getKey().equals(key)) return table[hash].getValue();
			hash = (hash + 1) % TABLE_SIZE;
			search++;
		}
		return null;
	}

	public void put(K key, V value) throws Exception {
		if (count < TABLE_SIZE) {
			int hash = hashCode(key);
			while (table[hash] != null) {
				if (table[hash].getKey().equals(key)) break;
				hash = (hash + 1) % TABLE_SIZE;
			}
			if (table[hash] == null) count++;
			table[hash] = new HashEntry(key, value);
		} else {
			throw new Exception("Table Full!");
		}
	}

	private int hashCode(K key) { return (key.hashCode() % TABLE_SIZE); }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		data.append("{");
		for (HashEntry<K, V> entry : table) {
			if (entry != null) {
				data.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
			}
		}
		if (data.toString().endsWith(", ")) {
			data.delete(data.length() - 2, data.length());
		}
		data.append("}");
		return data.toString();
	}

	public static void main(String[] args) throws Exception {
		HashTable<String, String> hashTable = new HashTable<String, String>();
		hashTable.put("1", "11"); hashTable.put("2", "22");
		System.out.println(hashTable);
		System.out.println(hashTable.get("1"));
		hashTable.put("1", "12");
		System.out.println(hashTable.get("1"));
		System.out.println(hashTable);
		System.out.println(hashTable.get("3"));
	}
}