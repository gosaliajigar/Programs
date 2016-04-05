package com.programs.datastructure.table;

/**
 * HashEntry for HashTable.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class HashEntry<K, V> {

	private K key;

	private V value;

	public HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}