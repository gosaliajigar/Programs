package string;

/**
 * 
 * Subtract 2 large numbers. Source :
 * https://www.geeksforgeeks.org/difference-of-two-large-numbers/
 * 
 * @author Jigar Gosalia
 *
 */
public class SubtractLargeNumbers {

	public static void main(String[] args) {
		System.out.println(subtract("654154154151454545415415454", "63516561563156316545145146514654"));
		System.out.println(subtract("63516561563156316545145146514654", "654154154151454545415415454"));
		System.out.println();
		System.out.println(subtract("15", "16"));
		System.out.println();
		System.out.println(subtract("0", "0"));
	}

	public static String subtract(String str1, String str2) {
		boolean isNegative = false;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		if (isSmaller(str1, str2)) {
			String smaller = str1;
			str1 = str2;
			str2 = smaller;
			isNegative = true;
		}
		String num1 = new StringBuilder(str1).reverse().toString();
		String num2 = new StringBuilder(str2).reverse().toString();
		for (int i = 0; i < num1.length(); i++) {
			int sub = ((i < num1.length()) ? (num1.charAt(i) - '0') : 0)
					- ((i < num2.length()) ? (num2.charAt(i) - '0') : 0) - carry;
			carry = (sub < 0) ? 1 : 0;
			// If subtraction is less then zero, add 10 into sub and
			// take carry as 1 for calculating next step
			sub = (sub < 0) ? sub + 10 : sub;
			sb.append(sub);
		}
		// remove front 0's
		while (sb.charAt(sb.length()-1) == '0' && sb.length() > 1) {
			sb.deleteCharAt(sb.length()-1);
		}
		return isNegative ? "-" + sb.reverse().toString() : sb.reverse().toString();
	}

	private static boolean isSmaller(String str1, String str2) {
		int n1 = str1.length(), n2 = str2.length();
		if (n1 < n2)
			return true;
		if (n2 < n1)
			return false;

		for (int i = 0; i < n1; i++)
			if (str1.charAt(i) < str2.charAt(i))
				return true;
			else if (str1.charAt(i) > str2.charAt(i))
				return false;

		return false;
	}
}
