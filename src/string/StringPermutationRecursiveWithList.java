package string;

import java.util.LinkedList;
import java.util.List;

/**
 * Java Program to find all permutations of a String recursively using list
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringPermutationRecursiveWithList {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String sample1 = "ABC";
		List<String> list = permutation("", sample1, new LinkedList<String>());
		System.out.println("\nPermutations for " + sample1 + " are: " + list);
	}

	/**
	 * @param prefix
	 * @param str
	 * @param list
	 * @return
	 */
	private static List<String> permutation(String prefix, String str, List<String> list) {
	    int n = str.length();
	    if (n == 0) {
	    	list.add(prefix);
	    } else {
	    	for (int i = 0; i < n; i++) {
	    		permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list);
	    	}
	    }
	    return list;
	}
}