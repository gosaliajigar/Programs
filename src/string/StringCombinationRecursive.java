package string;

/**
 * Java Program to find all combination of a String recursive
 * 
 * @author "Jigar Gosalia"
 *
 */
public class StringCombinationRecursive {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String input = "ABCDEF";
		combineRecursive(input, new StringBuilder(), 0);
	}

	/**
	 * @param input
	 * @param output
	 * @param index
	 */
	public static void combineRecursive(final String input, final StringBuilder output, final int index) {
		for (int i = index; i < input.length(); i++) {
			output.append(input.charAt(i));
			System.out.println(output);
			combineRecursive(input, output, i + 1);
			output.deleteCharAt(output.length() - 1);
		}
	}
}
