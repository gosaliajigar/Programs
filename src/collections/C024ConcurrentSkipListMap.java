package collections;

/**
 * A scalable concurrent ConcurrentNavigableMap implementation. The map is
 * sorted according to the natural ordering of its keys, or by a Comparator
 * provided at map creation time, depending on which constructor is used.<br>
 * <br>
 * This class implements a concurrent variant of SkipLists providing expected
 * average log(n) time cost for the containsKey, get, put and remove operations
 * and their variants. Insertion, removal, update, and access operations safely
 * execute concurrently by multiple threads.<br>
 * <br>
 * 
 * clear(), clone()<br>
 * containsKey(k), containsValue(v)<br>
 * ceilingEntry ceilingKey floorEntry floorKey lowerEntry lowerKey higherEntry
 * higherKey <br>
 * comparator <br>
 * descendingKeySet<br>
 * descendingMap<br>
 * entrySet()<br>
 * firstEntry firstKey lastEntry lasyKey<br>
 * forEach(BiConsumer)<br>
 * get(k)<br>
 * isEmpty(), size()<br>
 * keySet()<br>
 * put(k,v) putAll(map)<br>
 * pollFirstEntry pollLastEntry<br>
 * remove(k), remove(k, v) <br>
 * replace(k,nv) replace(k,ov,nv) <br>
 * subMap tailMap headMap <br>
 * values() <br>
 * <br>
 *  
 * Source :https://www.concretepage.com/java/example_concurrentskiplistmap_java
 * <br>
 * <br>
 * https://javapapers.com/java/java-concurrentskiplistmap/ <br>
 * https://examples.javacodegeeks.com/core-java/util/concurrent/concurrentskiplistmap/java-util-concurrent-concurrentskiplistmap-example/<br>
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C024ConcurrentSkipListMap {

	public static void main(String[] args) {
	}
}
