package collections;

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
public class Try020HashMap {

}
