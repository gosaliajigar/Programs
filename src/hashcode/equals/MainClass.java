package hashcode.equals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Understanding importance of hashcode and equals method.<br>
 * <br>
 * <b>Override only hashCode</b><br>
 * <br>
 * Imagine you have this<br>
 * 
 * Dog first = new Dog("white", 1);<br>
 * Dog second = new Dog("white", 1);<br>
 * <br>
 * If you only override hashCode then when you call map.put(first,someValue) it
 * takes first, calculates its hashCode and stores it in a given bucket. Then
 * when you call map.put(second,someOtherValue) it should replace first with
 * second as per the Map Documentation because they are equal (according to our
 * definition).<br>
 * <br>
 * But the problem is that equals was not redefined, so when the map hashes
 * second and iterates through the bucket looking if there is an object k such
 * that second.equals(k) is true it won't find any as second.equals(first) will
 * be false. Hence it will insert both first and second dogs in map in SAME
 * bucket instead of overriding first by second.<br>
 * <br>
 * <br>
 * <b>Override only equals</b><br>
 * <br>
 * If only equals is overridden, then when you call map.put(first,someValue)
 * first will hash to some bucket and when you call
 * map.put(second,someOtherValue) it will hash to some other bucket (as they
 * have a different hashCode). So, although they are equal, as they don't hash
 * to the same bucket, the map can't realize it and both of them stay in the
 * map. Hence it will insert both first and second dogs in map in DIFFERENT
 * bucket instead of overriding first by second.<br>
 * <br>
 * <b>Override neither hashCode nor equals</b><br>
 * <br>
 * map.put(first,someValue) and map.put(second,someOtherValue) both will be
 * inserted into map in absence of hashcode and equals method. Also when you do
 * map.get(new Dog("white")), it wouldn't return any value back as it wouldn't
 * be able to find that object in absence of equals method.<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param arg
	 */
	public static void main(final String[] arg) {

		Dog d1 = new Dog("red", 1);
		Dog d2 = new Dog("white", 1);
		Dog d3 = new Dog("black", 1);
		Dog d4 = new Dog("red", 1);

		Map<Dog, Integer> map = new HashMap<Dog, Integer>();
		System.out.println(MainClass.printMapUsingIterator(map));
		map.put(d1, 1);
		map.put(d2, 2);
		map.put(d3, 3);
		// d4 won't be inserted in Map as key Dog has equals and hashCode
		// implementation which will identify that d4(red) is same as d1(red),
		// hence it would override d1 by updating the key=4.
		// In absence of equals and hashCode implementation, d4(red) is inserted
		// into map.
		map.put(d4, 4);
		System.out.println(MainClass.printMapUsingIterator(map));
		System.out.println("Size of Map     : " + map.size());
		// In absence of equals and hashCode implementation, it wouldn't find
		// dog with red color.
		System.out.println("Red is at       : " + map.get(new Dog("red", 1)));
		// In absence of equals and hashCode implementation, it wouldn't find
		// dog with red color.
		System.out.println("Deleting key at : " + map.get(new Dog("red", 1)));
		// In absence of equals and hashCode implementation, it wouldn't delete
		// dog with red color.
		map.remove(new Dog("red", 1));
		System.out.println(MainClass.printMapUsingEntrySet(map));
		System.out.println("Size of Map     : " + map.size());
	}

	/**
	 * @param map
	 * @return
	 */
	public static String printMapUsingIterator(final Map<Dog, Integer> map) {
		Iterator<Entry<Dog, Integer>> iterator = map.entrySet().iterator();

		StringBuilder prettyMapFormat = new StringBuilder();
		prettyMapFormat.append("Printing Map    : ");
		prettyMapFormat.append("{");

		while (iterator.hasNext()) {
			Entry<Dog, Integer> entry = iterator.next();
			prettyMapFormat.append(entry.getKey().getColor()).append("=").append(entry.getValue());
			if (iterator.hasNext()) {
				prettyMapFormat.append(", ");
			}
		}
		prettyMapFormat.append("}");
		return prettyMapFormat.toString();
	}

	/**
	 * @param map
	 * @return
	 */
	public static String printMapUsingEntrySet(final Map<Dog, Integer> map) {
		StringBuilder prettyMapFormat = new StringBuilder();
		prettyMapFormat.append("Printing Map    : ");
		prettyMapFormat.append("{");
		for (Entry<Dog, Integer> entry : map.entrySet()) {
			prettyMapFormat.append(entry.getKey().getColor()).append("=").append(entry.getValue()).append(", ");
		}
		prettyMapFormat.delete(prettyMapFormat.length() - 2, prettyMapFormat.length());
		prettyMapFormat.append("}");
		return prettyMapFormat.toString();
	}
}
