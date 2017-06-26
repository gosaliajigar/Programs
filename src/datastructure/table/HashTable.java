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

	private static int count = 0;

	private HashEntry<K, V>[] table;

	public HashTable() {
		table = new HashEntry[TABLE_SIZE];
	}

	/**
	 * @param key
	 * @return
	 */
	public V get(K key) {
		int search = 0;
		int hash = hashCode(key);
		while (table[hash] != null && !table[hash].getKey().equals(key) && search <= TABLE_SIZE) {
			hash = (hash + 1) % TABLE_SIZE;
			search++;
		}
		if (table[hash] != null && search <= TABLE_SIZE)
			return table[hash].getValue();
		return null;
	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) throws Exception {
		if (count < TABLE_SIZE) {
			int hash = hashCode(key);
			while (table[hash] != null && !table[hash].getKey().equals(key)) {
				hash = (hash + 1) % TABLE_SIZE;
			}
			table[hash] = new HashEntry(key, value);
			count++;
		} else {
			throw new Exception("Table Full!");
		}
	}

	/**
	 * @param key
	 * @return
	 */
	private int hashCode(K key) {
		return (key.hashCode() % TABLE_SIZE);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		for (HashEntry<K, V> entry : table) {
			if (entry != null && entry.getKey() != null) {
				data.append(entry.getKey()).append(" : ").append(entry.getValue()).append(",");
			}
		}
		if (data.length() > 0) {
			data.deleteCharAt(data.length() - 1);
		}
		return data.toString();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		HashTable<String, String> hashTable = new HashTable<String, String>();
		hashTable.put("1", "11");
		hashTable.put("2", "22");
		System.out.println(hashTable);
		System.out.println(hashTable.get("1"));
		hashTable.put("1", "12");
		System.out.println(hashTable.get("1"));
		System.out.println(hashTable);
	}
}