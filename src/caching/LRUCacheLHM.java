package caching;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * LRUCache using existing collection framework class LinkedHashMap
 * 
 * @author "Jigar Gosalia"
 *
 */
public class LRUCacheLHM<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;

	private int cacheSize;
	
	/**
	 * true = access order
	 * false = insertion order
	 * 
	 * @param cacheSize
	 */
	public LRUCacheLHM(int cacheSize) {
		super(cacheSize, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() >= cacheSize;
	}

	public static void main(String[] args) {
		LRUCacheLHM<String, Integer> cacheLHM = new LRUCacheLHM<String, Integer>(5);
		cacheLHM.put("1", 1);
		cacheLHM.put("2", 2);
		cacheLHM.put("3", 3);
		cacheLHM.put("4", 4);
		System.out.println(cacheLHM);
		cacheLHM.put("5", 5);
		System.out.println(cacheLHM);
		cacheLHM.put("2", 6);
		System.out.println(cacheLHM);
		cacheLHM.put("6", 6);
		System.out.println(cacheLHM);
	}
}
