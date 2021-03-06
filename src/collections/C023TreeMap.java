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
 * ceilingEntry(k) ceilingKey(k) floorEntry(k) floorKey(k) lowerEntry(k) lowerKey(k) higherEntry(k) higherKey(k) <br>
 * comparator <br>
 * descendingKeySet<br>
 * descendingMap<br>
 * keySet() entrySet() values() <br>
 * firstEntry firstKey lastEntry lastKey<br>
 * forEach(BiConsumer)<br>
 * get(k)<br>
 * isEmpty(), size()<br>
 * put(k,v) putAll(map)<br>
 * pollFirstEntry pollLastEntry<br>
 * remove(k), remove(k, v) <br>
 * replace(k,nv) replace(k,ov,nv) <br>
 * subMap tailMap headMap <br>
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
		// {3=300, 5=500, 7=700, 9=900}
		System.out.println(map);
		System.out.println();

		// descendingKeySet [9, 7, 5, 3]
		System.out.println(map.descendingKeySet());
		System.out.println();

		// descendingMap {9=900, 7=700, 5=500, 3=300}
		System.out.println(map.descendingMap());
		System.out.println();

		// ceilingEntry ceilingKey 5=500 : 5
		System.out.println(map + " : " + map.ceilingEntry(5) + " : " + map.ceilingKey(5));
		System.out.println();
		
		// floorEntry floorKey 5=500 : 5
		System.out.println(map + " : " + map.floorEntry(5) + " : " + map.floorKey(5));
		System.out.println();
		
		// lowerEntry lowerKey 3=300 : 3
		System.out.println(map + " : " + map.lowerEntry(5) + " : " + map.lowerKey(5));
		System.out.println();

		// higherEntry higherKey 7=700 : 7
		System.out.println(map + " : " + map.higherEntry(5) + " : " + map.higherKey(5));
		System.out.println();

		// firstEntry firstKey 3=300 : 3
		System.out.println(map + " : " + map.firstEntry() + " : " + map.firstKey());
		System.out.println();

		// lastEntry lastKey 9=900 : 9
		System.out.println(map + " : " + map.lastEntry() + " : " + map.lastKey());
		System.out.println();
		
		// subMap {3=300, 5=500} - {5=500, 7=700}
		System.out.println(map + " - " + map.subMap(3, 6) + " - " + map.subMap(3, false, 9, false));
		System.out.println();

		// headMap {3=300, 5=500} - {3=300, 5=500, 7=700}
		System.out.println(map + " - " + map.headMap(7) + " - " + map.headMap(7, true));
		System.out.println();
		
		// tailMap {7=700, 9=900} - {9=900}
		System.out.println(map + " - " + map.tailMap(7) + " - " + map.tailMap(7, false));
		System.out.println();

		// pollFirstEntry pollLastEntry 3=300 : 9=900
		System.out.println(map + " : " + map.pollFirstEntry() + " : " + map.pollLastEntry());
		System.out.println();
		
		// {5=500, 7=700}
		System.out.println(map);
		System.out.println();
	}
}
