package collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * A Red-Black tree based NavigableMap implementation. The map is sorted
 * according to the natural ordering of its keys, or by a Comparator provided at
 * map creation time, depending on which constructor is used.<br>
 * <br>
 * 
 * TreeMap(), TreeMap(comparator), TreeMap(map), TreeMap(sortedmap)<br>
 * <br>
 * clear(), clone()<br>
 * containsKey(k), containsValue(v)<br>
 * ceilingEntry ceilingKey floorEntry floorKey lowerEntry lowerKey higherEntry higherKey <br>
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
 * Source :
 * http://javahungry.blogspot.com/2014/06/how-treemap-works-ten-treemap-java-interview-questions.html
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C023TreeMap {

	public static void main(String[] args) {
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> map = (TreeMap<Integer, Integer>) m;
		map.put(9, 900);
		map.put(7, 700);
		map.put(5, 500);
		map.put(3, 300);
		System.out.println(map);
		System.out.println();

		// descendingKeySet
		System.out.println(map.descendingKeySet());
		System.out.println();

		// descendingMap
		System.out.println(map.descendingMap());
		System.out.println();

		// ceilingEntry ceilingKey
		System.out.println(map + " : " + map.ceilingEntry(5) + " : " + map.ceilingKey(5));
		System.out.println();
		
		// floorEntry floorKey
		System.out.println(map + " : " + map.floorEntry(5) + " : " + map.floorKey(5));
		System.out.println();
		
		// lowerEntry lowerKey
		System.out.println(map + " : " + map.lowerEntry(5) + " : " + map.lowerKey(5));
		System.out.println();

		// higherEntry higherKey
		System.out.println(map + " : " + map.higherEntry(5) + " : " + map.higherKey(5));
		System.out.println();

		// firstEntry firstKey
		System.out.println(map + " : " + map.firstEntry() + " : " + map.firstKey());
		System.out.println();

		// lastEntry lastKey
		System.out.println(map + " : " + map.lastEntry() + " : " + map.lastKey());
		System.out.println();
		
		// subMap
		System.out.println(map + " - " + map.subMap(3, 6) + " - " + map.subMap(3, false, 9, false));
		System.out.println();

		// headMap
		System.out.println(map + " - " + map.headMap(7) + " - " + map.headMap(7, true));
		System.out.println();
		
		// tailMap
		System.out.println(map + " - " + map.tailMap(7) + " - " + map.tailMap(7, false));
		System.out.println();

		// pollFirstEntry pollLastEntry
		System.out.println(map + " : " + map.pollFirstEntry() + " : " + map.pollLastEntry());
		System.out.println(map);
		System.out.println();
	}
}
