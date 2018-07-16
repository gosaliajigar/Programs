package anagrams;

/**
 * Check if given 2 strings are anagrams (same characters in different sequence)
 * 
 * @author Jigar Gosalia
 *
 */
public class CheckAnagrams {

	public static void main(String[] args) {
		System.out.println(isAnagrams("", ""));
		System.out.println(isAnagrams("", null));
		System.out.println(isAnagrams(null, null));
		System.out.println(isAnagrams("Hello", "hello"));
		System.out.println(isAnagrams("hello", "bye"));
	}
	
	public static boolean isAnagrams(String s1, String s2) {
		if (s1 == null && s2 == null) return true;
		if (s1 == null || s2 == null) return false;
		if (s1 != null && s2 != null && s1.length() != s2.length()) return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] letters = new int[1<<8];
		for (int i=0; i<s1.length(); i++) { 
			letters[s1.charAt(i)]++;
			letters[s2.charAt(i)]--;
		}
		for (int i : letters) {
			if (i != 0) return false;
		}
		return true;
	}
}
