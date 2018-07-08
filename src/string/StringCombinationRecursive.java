package string;

/**
 * Java Program to find all combination of a String recursive<br>
 * <br>
 * The call of output.deleteCharAt counters the effect of output.append by deleting last character of output.<br>
 * <br>
 * Each loop iteration proceeds as follows:<br>
 * 1. append a character<br>
 * 2. print the result<br>
 * 3. perform a recursive invocation at the level i+1<br>
 * 4. remove the character added at step 1<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class StringCombinationRecursive {

	public static void main(final String[] args) {
		String input = "ABC";
		combinationsR(input, new StringBuilder(), 0);
	}

	public static void combinationsR(String s, StringBuilder output, int index) {
		for (int i = index; i < s.length(); i++) {
			output.append(s.charAt(i));
			System.out.println(output);
			combinationsR(s, output, i+1);
			output.deleteCharAt(output.length() - 1);
		}
	}
}
