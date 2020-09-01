package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a list of strings of all the same length, group together equivalent
 * strings (Group Shifted Strings or Ceaser Encryption).
 * 
 * input: ['abc', 'bcd', 'acd', 'bde', 'def' ,'abc']
 * output: [['abc', 'bcd', 'def'], ['acd', 'bde']]
 * 
 * @author "Jigar Gosalia"
 *
 */
public class GroupShiftedStrings {

	public static void main(String[] args) {
		System.out.println(GroupShiftedStrings
				.group(Arrays.asList("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "acd", "bde", "zab")));
	}

	public static List<Set<String>> group(List<String> words) {
		Map<String, Set<String>> map = new HashMap<>();
		for (String word : words) {
			String normalizedDistance = normalizeDistance(word);
			map.computeIfAbsent(normalizedDistance, key -> new HashSet<String>()).add(word);
		}
		System.out.println(map);
		return new ArrayList<Set<String>>(map.values());
	}

	public static String normalizeDistance(String word) {
		StringBuilder normalizedDistance = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			normalizedDistance.append((word.charAt(i) - word.charAt(0) + 26) % 26);
			if (i < word.length()-1) normalizedDistance.append('.');
		}
		return normalizedDistance.toString();
	}

}
