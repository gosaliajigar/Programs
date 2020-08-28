package caching;

public class CacheUsage {

	public static void main(String[] args) {
		LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(5);
		lruCache.put("1", 1); lruCache.put("2", 2); lruCache.put("3", 3); lruCache.put("4", 4);
		System.out.println(lruCache);
		lruCache.put("5", 5);
		System.out.println(lruCache);
		lruCache.put("2", 6);
		System.out.println(lruCache);
		lruCache.put("6", 6);
		System.out.println(lruCache);

		System.out.println();

		LFUCache cache = new LFUCache(5);
		cache.put(1, 1); cache.put(2, 2); cache.put(3, 3); cache.put(4, 4);
		System.out.println(cache);
		cache.put(5, 5);
		System.out.println(cache);
		cache.put(2, 6);
		System.out.println(cache);
		cache.put(6, 6);
		System.out.println(cache);
	}
}
