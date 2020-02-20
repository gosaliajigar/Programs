package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * On every 3 occurrences of a char, skip the 1st occurrence and return last 2 occurrences.
 * 
 * Continue doing this for full string.
 * 
 * @author Jigar Gosalia
 *
 */
public class StringTriplets {

	public static void main(String[] args) {
		String[] input = { "aaa", "aaaa", "aaaaa", "aaaaaa", "aaabbb", "aaaabbbb", "abcccaaabbbc" };
		Map<String, String> responses = new LinkedHashMap<String, String>();
		for (String i : input) {
			responses.put(i, skipTriplets(i));
		}
		for (Entry<String, String> entry : responses.entrySet()) {
			System.out.printf("%-20s ==> %-20s\n", entry.getKey(), entry.getValue());

		}
	}

	private static String skipTriplets(String data) {
		if (data == null || data.length() <= 2) {
			return data;
		}
		StringBuilder response = new StringBuilder();
		int i = 0;
		for (; i < data.length() - 2; i++) {
			if (data.charAt(i) == data.charAt(i + 1) && data.charAt(i + 1) == data.charAt(i + 2)) {
				// bingo - found triplet so skip this char
			} else {
				response.append(data.charAt(i));
			}
		}
		// append last 2 chars as by now the last 2 chars are already compared with
		// previous char.
		response.append(data.substring(i));
		return response.toString();
	}
}
