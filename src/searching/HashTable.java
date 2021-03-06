package searching;

/**
 * Hash Table is a data structure which store data in associative manner. In
 * hash table, data is stored in array format where each data values has its own
 * unique index value. Access of data becomes very fast if we know the index of
 * desired data.<br>
 * <br>
 * Thus, it becomes a data structure in which insertion and search operations
 * are very fast irrespective of size of data. Hash Table uses array as a
 * storage medium and uses hash technique to generate index where an element is
 * to be inserted or to be located from. <br>
 * <br>
 * Hashing is a technique to convert a range of key values into a range of
 * indexes of an array.<br>
 * <br>
 * Time Complexity : <br>
 * Search O(1)<br>
 * Insert O(1)<br>
 * Delete O(1)<br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class HashTable {

	private static final int SIZE = 20;
	private int count = 0;
	private Data[] table = new Data[SIZE];

	/**
	 * It may happen that the hashing technique used create already used index
	 * of the array. In such case, we can search the next empty location in the
	 * array by looking into the next cell until we found an empty cell. This
	 * technique is called linear probing.<br>
	 * <br>
	 * Time Complexity :<br>
	 * Worst Case O(n)<br>
	 * Best Case O(1)<br>
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) throws Exception {
		if (this.count >= SIZE) throw new Exception("HashTable full");
		Data data = new Data(key, value);
		// get the hash
		int hashIndex = hashCode(data.getKey());
		// move in array until an empty or deleted cell
		while (table[hashIndex] != null && table[hashIndex].getKey() != -1) {
			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
		}
		table[hashIndex] = data;
		count++;
	}

	/**
	 * It may happen that the hashing technique used create already used index
	 * of the array. In such case, we can search the next empty location in the
	 * array by looking into the next cell until we found an empty cell. This
	 * technique is called linear probing.<br>
	 * <br>
	 * Time Complexity :<br>
	 * Worst Case O(n)<br>
	 * Best Case O(1)<br>
	 * 
	 * @param key
	 * @return
	 */
	public Data get(int key) {
		// get the hash
		int hashIndex = hashCode(key);
		int iterations = 0;
		// move in array until an empty
		while (table[hashIndex] != null && iterations <= SIZE) {
			if (table[hashIndex].getKey() == key) return table[hashIndex];
			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
			iterations++;
		}
		return null;
	}

	/**
	 * It may happen that the hashing technique used create already used index
	 * of the array. In such case, we can search the next empty location in the
	 * array by looking into the next cell until we found an empty cell. This
	 * technique is called linear probing.<br>
	 * <br>
	 * Time Complexity :<br>
	 * Worst Case O(n)<br>
	 * Best Case O(1)<br>
	 * 
	 * @param data
	 * @return
	 */
	public Data remove(Data data) {
		// get the hash
		int hashIndex = hashCode(data.getKey());
		int iterations = 0;
		// move in array until an empty
		while (table[hashIndex] != null && iterations <= SIZE) {
			if (table[hashIndex].getKey() == data.getKey()) {
				Data temp = table[hashIndex];
				// assign a dummy item at deleted position
				table[hashIndex] = new Data(-1, -1);
				count--;
				return temp;
			}
			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
			iterations++;
		}
		return null;
	}

	public void display() {
		for (int index = 0; index < table.length; index++) {
			System.out.println("Location(" + index + "):" + table[index]);
		}
		System.out.println();
	}

	private int hashCode(int key) { return key % SIZE; }

	public static void main(String[] args) throws Exception {
		HashTable hashTable = new HashTable();
		hashTable.put(1, 20);  hashTable.put(2, 70);  hashTable.put(42, 80); hashTable.put(4, 25);
		hashTable.put(12, 44); hashTable.put(14, 32); hashTable.put(17, 11); hashTable.put(13, 78);
		hashTable.put(37, 97); hashTable.put(57, 97);
		// Checkout the wrapping to start of array
		hashTable.put(77, 97);
		hashTable.display();
		Data item = hashTable.get(37);
		System.out.println((item != null) ? ("Element found: " + item) : ("Element 37 not found"));
		hashTable.remove(item);
		item = hashTable.get(37);
		System.out.println((item != null) ? ("Element found: " + item) : ("Element 37 not found"));
	}

	public static class Data {
		int key;
		int value;
		public Data(int key, int value) { this.key = key; this.value = value; }
		public int getKey() { return key; }
		public int getValue() { return value; }
		@Override
		public String toString() { return "Data[key=" + key + ";value=" + value + "]"; }
	}
}
