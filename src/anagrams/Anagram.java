package anagrams;

import java.util.HashMap;
import java.util.Map;

/**
 * "hello" & "billion" will be anagrams when {h, e, b, i, i, n} are deleted and
 * only left characters are {l, l, o}<br>
 * <br>
 *  1. count character and their occurrences of both the strings<br>
 *  2. collect all characters in final map<br>
 *  3. iterate over final map and get the delta of counts from both maps<br>
 *  4. sum all the counts of all characters in final map to get no. of 
 *     characters that need to be deleted for anagrams.<br>
 *      
 * @author "Jigar Gosalia"
 * 
 */
public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String one = "hello";
		String two = "billion";
		Map<Character, Integer> map = anagram(one, two);
		System.out.println();
		System.out.println("Characters to be deleted          : " + map);
		System.out.println("Count of characters to be deleted : " + count(map));
	}

	/**
	 * find anagram map which has details on which characters need to deleted to
	 * create anagrams
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static Map<Character, Integer> anagram(String one, String two) {
		Map<Character, Integer> oneMap = new HashMap<Character, Integer>();
		Map<Character, Integer> twoMap = new HashMap<Character, Integer>();
		Map<Character, Integer> finalMap = new HashMap<Character, Integer>();

		// get max size of both the strings and populate 3 maps
		int max = ((one.length() >= two.length()) ? one.length() : two.length());
		for (int index = 0; index < max; index++) {
			if (index < one.length()) {
				insert(oneMap, one.charAt(index));
				finalMap.put(one.charAt(index), 0);
			}
			if (index < two.length()) {
				insert(twoMap, two.charAt(index));
				finalMap.put(two.charAt(index), 0);
			}
		}

		System.out.println("Character Count : " + oneMap);
		System.out.println("Character Count : " + twoMap);
		System.out.println("All characters  : " + finalMap);
		for (Character character : finalMap.keySet()) {
			int delta = 0;
			int oneCount = ((oneMap.get(character) != null) ? oneMap
					.get(character) : 0); 
			int twoCount = ((twoMap.get(character) != null) ? twoMap.get(character)
					: 0); 
			delta = oneCount - twoCount;
			finalMap.put(character, Math.abs(delta));
		}
		return finalMap;
	}

	/**
	 * Prepare map with no of counts for each character in string
	 * 
	 * @param map
	 * @param character
	 */
	public static void insert(Map<Character, Integer> map, Character character) {
		if (!map.containsKey(character)) { map.put(character, 1);
		} else { map.put(character, map.get(character) + 1);
		}
	}

	/**
	 * Add delta of two strings to find no of characters that need to be deleted
	 * to find anagram
	 * 
	 * @param map
	 * @return
	 */
	public static int count(Map<Character, Integer> map) {
		int sum = 0;
		for (Character character : map.keySet()) sum += map.get(character);
		return sum;
	}
}