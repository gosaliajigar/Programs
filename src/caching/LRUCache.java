package caching;

import java.util.HashMap;
import java.util.Map;

/**
 * Using Generics, implementing Least Recently Used Cache with ... <br>
 * - doubly linked list for O(1) addition/deletion<br>
 * - map for O(1) retrieval<br>
 * 
 * @param <K>
 * @param <V>
 */
public final class LRUCache<K, V> {

	private int capacity;

	private Map<K, Node<K, V>> map = new HashMap<K, Node<K, V>>();

	private Node<K, V> head;

	private Node<K, V> tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public V get(K key) {
		if (map.containsKey(key)) {
			Node<K, V> node = map.get(key);
			remove(node);
			setHead(node);
			return node.getValue();
		}
		return null;
	}

	public void put(K key, V value) {
		if (map.containsKey(key)) {
			Node<K, V> old = map.get(key);
			old.setValue(value);
			remove(old);
			setHead(old);
		} else {
			Node<K, V> newNode = new Node<K, V>(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.getKey());
				remove(tail);
			}
			setHead(newNode);
			map.put(key, newNode);
		}
	}

	private void remove(Node<K, V> node) {
		// node can be head
		if (node.getPrevious() != null) {
			node.getPrevious().setNext(node.getNext());
		} else {
			head = node.getNext();
		}

		// node can be tail
		if (node.getNext() != null) {
			node.getNext().setPrevious(node.getPrevious());
		} else {
			tail = node.getPrevious();
		}
		node.setNext(null);
		node.setPrevious(null);
	}

	private void setHead(Node<K, V> node) {
		node.setNext(head);
		node.setPrevious(null);

		if (head != null)
			head.setPrevious(node);

		head = node;

		if (tail == null)
			tail = head;
	}
}

/*
 * Internal node class
 * 
 * @param <K>
 * 
 * @param <V>
 */
class Node<K, V> {
	private K key;
	private V value;
	private Node<K, V> previous;
	private Node<K, V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<K, V> previous) {
		this.previous = previous;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<String, Integer>(5);
		cache.put("1", 1);
		cache.put("2", 2);
		cache.put("3", 3);
		cache.put("4", 4);
		System.out.println(cache);
		cache.put("5", 5);
		System.out.println(cache);
		cache.put("2", 6);
		System.out.println(cache);
		cache.put("6", 6);
		System.out.println(cache);
	}
}

