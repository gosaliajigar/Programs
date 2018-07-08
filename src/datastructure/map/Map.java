package datastructure.map;

import java.util.Set;

/**
 * Map Interface
 * 
 * @author "Jigar Gosalia"
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {
	public static class Entry<K, V> {
		public K key;
		public V value;
		public Entry<K, V> next;
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	void put(K key, V value);
	V get(K key);
	boolean remove(K key);
	boolean containsKey(K key);
	boolean containsValue(V value);
	Set<Entry<K, V>> entrySet();
	Set<K> keySet();
	boolean isEmpty();
	int size();
}