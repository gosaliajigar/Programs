package algorithms;

/**
 * Rabin-Karp algorithm for substring matching.
 *
 * Time complexity in worst case O(n^2)(depends on hash function)
 * Space complexity O(1) 
 * 
 * @author Jigar Gosalia
 *
 */
public class RabinKarpSearch {

	private static int prime = 101;

	public static int patternSearch(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		double textHash = calculateHash(text, m-1);
		double patternHash = calculateHash(pattern, m-1);
		for (int i = 0; i < n-(m-1); i++) {
			// check if text(i, i+m-1) equal to pattern(0, m-1)
			if (patternHash == textHash && isEqual(text, i, i+m-1, pattern, 0, m-1)) return i;
			if (i < n-1-(m-1)) textHash = reCalculateHash(text, i, i+m, textHash, m);
		}
		return -1;
	}

	private static double reCalculateHash(char[] str, int oldIndex, int newIndex, double oldHash, int patternLen) {
		double newHash = oldHash - str[oldIndex];
		newHash = newHash / prime;
		newHash += str[newIndex] * Math.pow(prime, patternLen - 1);
		return newHash;
	}

	private static double calculateHash(char[] s, int end) {
		double hash = 0;
		for (int i = 0; i <= end; i++) hash += s[i] * Math.pow(prime, i);
		return hash;
	}

	private static boolean isEqual(char s1[], int start1, int end1, char s2[], int start2, int end2) {
		if (end1 - start1 != end2 - start2) return false;
		while (start1 <= end1 && start2 <= end2) {
			if (s1[start1] != s2[start2]) return false;
			start1++; start2++;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(patternSearch("TusharRoy".toCharArray(), "sharRoy".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "Roy".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "shas".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "usha".toCharArray()));
		System.out.println(patternSearch("TusharRoy".toCharArray(), "Tus".toCharArray()));
	}
}