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
public class AnagramDiff {

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
		for (int index = 0; index < Math.max(one.length(),  two.length()); index++) {
			if (index < one.length()) {
				char c = one.charAt(index);
				oneMap.put(c, oneMap.getOrDefault(c, 0) + 1);				
				finalMap.put(c, 0);
			}
			if (index < two.length()) {
				char c = two.charAt(index);
				twoMap.put(c, twoMap.getOrDefault(c, 0) + 1);				
				finalMap.put(c, 0);
			}
		}
		System.out.println("Character Count : " + oneMap);
		System.out.println("Character Count : " + twoMap);
		System.out.println("All characters  : " + finalMap);
		for (Character character : finalMap.keySet()) {
			int oneCount = oneMap.getOrDefault(character, 0); 
			int twoCount = twoMap.getOrDefault(character, 0); 
			finalMap.put(character, Math.abs(oneCount - twoCount));
		}
		return finalMap;
	}

	/**
	 * Add delta of two strings to find no of characters that need to be deleted
	 * to find anagram
	 * 
	 * @param map
	 * @return
	 */
	public static int count(Map<Character, Integer> map) {
		return map.values().stream().mapToInt(u -> u).sum();
	}
}