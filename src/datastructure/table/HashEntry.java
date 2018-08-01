package datastructure.table;

/**
 * @author Jigar Gosalia
 *
 * @param <K>
 * @param <V>
 */
public class HashEntry<K, V> {
	private K key;
	private V value;
	public HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() { return key; }
	public V getValue() { return value; }
}
