package palindrome;

/**
 * @author Jigar Gosalia
 *
 */
public class AnyPermutationIsPalindrome {

	public static void main(String[] args) {
		System.out.println(isAnyPermutationPalindrome("hello".toLowerCase()));
		System.out.println(isAnyPermutationPalindrome("hellohe".toLowerCase()));
		System.out.println(isAnyPermutationPalindrome("hellhe".toLowerCase()));
		System.out.println();
	}

	public static boolean isAnyPermutationPalindrome(String s) {
		int oddCountCharacters = 0;
		int[] a = new int[26];
		for (char c : s.toCharArray()) {
			a[c - 'a']++;
		}
		for (int i : a) {
			if (i % 2 != 0) oddCountCharacters++;
		}
		return (oddCountCharacters == 0 || oddCountCharacters == 1);
	}

}
