package string;

/**
 * Java Program to find all permutations of a String recursively
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringPermutationRecursive {

	public static void main(final String[] args) {
		String sample1 = "ABC";
		String sample2 = "123";
		System.out.println("\nPermutations for " + sample1 + " are:");
		permutation("", sample1);
		System.out.println();
		System.out.println("\nPermutations for " + sample2 + " are:");
		permutation("", sample2);
		System.out.println();
	}

	/**
	 * @param prefix
	 * @param input
	 */
	private static void permutation(String prefix, String input) {
	    int n = input.length();
	    // Base Condition
	    if (n == 0) {
	    	System.out.println(prefix);
	    } else {
	    	// Recursive Condition
	    	for (int i = 0; i < n; i++) {
	    		permutation(prefix + input.charAt(i), input.substring(0, i) + input.substring(i+1, n));
	    	}
	    }
	}
}
