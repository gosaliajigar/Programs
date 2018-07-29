package string.algorithms;

/**
 * Do pattern matching using KMP algorithm (Knuth–Morris–Pratt)
 * 
 * Time complexity  - O(m + n); m=len(text) & n=len(pattern)
 * Space complexity - O(n)
 * 
 * @author Jigar Gosalia
 *
 */
public class KMPSubstringSearch {

	/**
	 * Compute temporary array to maintain size of suffix which is same as prefix
	 * Time/space complexity is O(size of pattern)
	 */
	private static int[] computeTemporaryArray(char pattern[]) {
		int[] lps = new int[pattern.length];
		int i = 0, j = 1;
		while (j < pattern.length) {
			if (pattern[j] == pattern[i]) {
				lps[j] = i+1; i++; j++;
			} else {
				if (i != 0) {
					i = lps[i - 1];
				} else {
					lps[j] = 0; j++;
				}
			}
		}
		return lps;
	}

	/**
	 * KMP algorithm of pattern matching.
	 */
	public static boolean KMP(char[] text, char[] pattern) {
		int lps[] = computeTemporaryArray(pattern);
		int j = 0, i = 0;
		while (j < text.length && i < pattern.length) {
			if (text[j] == pattern[i]) {
				i++; j++;
			} else {
				if (i != 0) i = lps[i - 1];
				else j++;
			}
		}
		
		if (i == pattern.length) {
			System.out.println(j-i);
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.print(KMP("abcxabcdabcdabcy".toCharArray(), "abcdabcy".toCharArray()));
		System.out.println();
		System.out.print(KMP("abcdabcyabcxabcd".toCharArray(), "abcdabcy".toCharArray()));
	}
}