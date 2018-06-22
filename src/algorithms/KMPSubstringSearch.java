package algorithms;

/**
 * Do pattern matching using KMP algorithm (Knuth–Morris–Pratt)
 * Runtime complexity - O(m + n); m=len(text) & n=len(pattern)
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
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1; index++; i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0; i++;
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
		int i = 0, j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++; j++;
			} else {
				if (j != 0) j = lps[j - 1];
				else i++;
			}
		}
		if (j == pattern.length) return true;
		return false;
	}

	public static void main(String args[]) {
		boolean result = KMP("abcxabcdabcdabcy".toCharArray(), "abcdabcy".toCharArray());
		System.out.print(result);
	}
}