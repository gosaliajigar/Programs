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
		int oddCount = 0;
		int[] a = new int[26];
		for (char c : s.toCharArray()) {
			a[c - 'a']++;
		}
		for (int i : a) {
			if (i % 2 != 0) oddCount++;
		}
		return (oddCount == 0 || oddCount == 1);
	}

}
