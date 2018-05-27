package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap(), HashMap(capacity), HashMap(capacity, loadFactor), HashMap(map)<br>
 * <br>
 * clear(), clone()<br>
 * containsKey(k), containsValue(v)<br>
 * compute(k, BiFunction) computeIfAbsent(k, Function) computeIfPresent(k,
 * BiFunction)<br>
 * entrySet()<br>
 * forEach(BiConsumer)<br>
 * get(k) getOrDefault(k, dv)<br>
 * isEmpty(), size()<br>
 * keySet()<br>
 * put(k,v) putAll(map) putIfAbsent(k,v)<br>
 * remove(k), remove(k, v) <br>
 * replace(k,nv) replace(k,ov,nv) <br>
 * values() <br>
 * <br>
 * 
 * HashMap stores the data in the form of key-value pairs. Each key-value pair
 * is stored in an object of Entry<K, V> class. Entry<K, V> class is the static
 * inner class of HashMap which is defined like below. <br>
 * 
 * Array of Entry<K,V> to store data.<br>
 * <br>
 * To summarize the whole HashMap structure, each key-value pair is stored in an
 * object of Entry<K, V> class. This class has an attribute called next which
 * holds the pointer to next key-value pair. This makes the key-value pairs
 * stored as a linked list. All these Entry<K, V> objects are stored in an array
 * called table[]<br>
 * <br>
 * 
 * table[0] is always reserved for null key as hash code of null is 0.<br>
 * <br>
 * 
 * Additional hash function ensures that hashCodes that differ only by constant
 * multiples at each bit position have a bounded number of collisions
 * (approximately 8 at default load factor)<br>
 * <br>
 * 
 * Source : http://javaconceptoftheday.com/how-hashmap-works-internally-in-java/
 * <br>
 * http://coding-geek.com/how-does-a-hashmap-work-in-java/ <br>
 * <br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C020HashMap {

	public static void main(String[] args) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(2, 200); m.put(3, 300); m.put(4, 400);
		// put returns old value (null is 1st time)
		System.out.println(m.put(1, 111) + " - " + m.put(1, 100));
		System.out.println(m);
		System.out.println();
		
		// putIfAbsent returns old value or null if absent
		System.out.println(m.putIfAbsent(5, 500) + " : " + m);
		System.out.println(m.putIfAbsent(1, 700) + " : " + m);
		System.out.println();
		
		// containsKey & containsValue
		System.out.println(m.containsKey(1) + " - " + m.containsValue(100));
		System.out.println();
		
		// compute(k, BiFunction)
		System.out.println(m);
		// return new value if BiFunction returns non-null
		System.out.println(m.compute(1, (k,v) -> 2000) + " : " + m);
		// delete entry if BiFunction returns null
		System.out.println(m.compute(5, (k,v) -> null) + " : " + m);
		System.out.println();
		
		// computeIfAbsent(k, Function)
		System.out.println(m);
		// do nothing if Function returns null
		System.out.println(m.computeIfAbsent(5, (v) -> null) + " : " + m);
		// add entry if Function returns non-null and return value
		System.out.println(m.computeIfAbsent(5, (v) -> 500) + " : " + m);
		System.out.println();

		// computeIfPresent(k, BiFunction)
		System.out.println(m);
		// update entry if BiFunction returns non-null
		System.out.println(m.computeIfPresent(5, (k,v) -> v*10000) + " : " + m);
		// delete entry if BiFunction returns null
		System.out.println(m.computeIfPresent(5, (k, v) -> null) + " : " + m);
		System.out.println();

		// entrySet
		System.out.println(m.entrySet());
		System.out.println();
		
		// keySet
		System.out.println(m.keySet());
		System.out.println();
		
		// values
		System.out.println(m.values());
		System.out.println();
		
		// getOrDefault
		System.out.println(m.getOrDefault(9, 11111));
		System.out.println();
		
		// forEach(BiConsumer)
		m.forEach((k,v) -> System.out.printf("%s - %s ", k, v));
		System.out.println(); System.out.println();
		
		// remove(k) remove(k,v)
		System.out.println(m.remove(1, 200) + " : " + m);
		System.out.println(m.remove(1) + " : " + m);
		System.out.println();
	
		// replace(k,nv) replace(k,ov,nv)
		System.out.println(m.replace(2, 200) + " : " + m);
		System.out.println(m.replace(2, 200, -200) + " : " + m);
		System.out.println();
	}
}
