package collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap(), LinkedHashMap(capacity), LinkedHashMap(capacity,
 * loadFactor), LinkedHashMap(capacity, loadFactor, accessOrder),
 * LinkedHashMap(map)<br>
 * <br>
 * clear(), clone()<br>
 * containsKey(k), containsValue(v)<br>
 * compute(k, BiFunction) computeIfAbsent(k, Function) computeIfPresent(k, BiFunction)<br>
 * entrySet()<br>
 * forEach(BiConsumer)<br>
 * get(k) getOrDefault(k, dv)<br>
 * isEmpty(), size()<br>
 * keySet()<br>
 * put(k,v) putAll(map) putIfAbsent(k,v)<br>
 * remove(k), remove(k, v) <br>
 * replace(k,nv) replace(k,ov,nv) <br>
 * protected boolean removeEldestEntry(Map.Entry<K,V> eldest) <br>
 * values() <br>
 * <br>
 * 
 * LinkedHashMap is the Hashtable (synchronized HashMap) and linkedlist
 * implementation of the Map interface, with predictable iteration order.<br>
 * <br>
 * 
 * 
 * Sources :
 * http://www.devinline.com/2015/03/how-linkedhashmap-works-internally.html
 * http://javahungry.blogspot.com/2015/08/how-linkedhashmap-works-internally-in-java.html
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C022LinkedHashMap {

	public static void main(String[] args) {
		Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
		// same as HashMap
		// accessOrder = false == insertion order (by default)
		// accessOrder = true  == access order (for LRU Cache)
	}
}
