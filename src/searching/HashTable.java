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

	/**
	 * 
	 */
	private static final int SIZE = 20;

	/**
	 * 
	 */
	private static Data[] hashArray = new Data[SIZE];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insert(1, 20);
		insert(2, 70);
		insert(42, 80);
		insert(4, 25);
		insert(12, 44);
		insert(14, 32);
		insert(17, 11);
		insert(13, 78);
		insert(37, 97);
		insert(57, 97);
		// Checkout the wrapping to start of array
		insert(77, 97);

		display();

		Data item = search(37);

		if (item != null) {
			System.out.println("Element found: " + item);
		} else {
			System.out.println("Element not found");
		}

		delete(item);

		item = search(37);

		if (item != null) {
			System.out.println("Element found: " + item);
		} else {
			System.out.println("Element not found");
		}
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
	 * @param value
	 */
	private static void insert(int key, int value) {

		Data data = new Data(key, value);

		// get the hash
		int hashIndex = hashCode(data.getKey());

		// move in array until an empty or deleted cell
		while (hashArray[hashIndex] != null && hashArray[hashIndex].getKey() != -1) {
			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
		}
		hashArray[hashIndex] = data;
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
	private static Data search(int key) {

		// get the hash
		int hashIndex = hashCode(key);

		// move in array until an empty
		while (hashArray[hashIndex] != null) {

			if (hashArray[hashIndex].getKey() == key)
				return hashArray[hashIndex];

			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
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
	private static Data delete(Data data) {
		// get the hash
		int hashIndex = hashCode(data.getKey());

		// move in array until an empty
		while (hashArray[hashIndex] != null) {

			if (hashArray[hashIndex].getKey() == data.getKey()) {
				Data temp = hashArray[hashIndex];

				// assign a dummy item at deleted position
				hashArray[hashIndex] = new Data(-1, -1);
				return temp;
			}

			// go to next cell and wrap around the table
			hashIndex = (hashIndex + 1) % SIZE;
		}
		return null;
	}

	/**
	 * 
	 */
	private static void display() {
		for (int index = 0; index < hashArray.length; index++) {
			System.out.println("Location(" + index + "):" + hashArray[index]);
		}
		System.out.println();
	}

	/**
	 * @param key
	 * @return
	 */
	private static int hashCode(int key) {
		return key % SIZE;
	}
}
