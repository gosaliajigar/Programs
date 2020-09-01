package string;

/**
 * 
 * Add 2 large numbers. 
 * 
 * @author Jigar Gosalia
 *
 */
public class AddLargeNumbers {

	public static void main(String[] args) {
		System.out.println(add("654154154151454545415415454", "63516561563156316545145146514654"));
		System.out.println();
		System.out.println(add("16", "16"));
		System.out.println();
		System.out.println(add("0", "0"));
	}

	public static String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
			int sum = carry + ((i < num1.length()) ? (n1.charAt(i) - '0') : 0)
					+ ((i < num2.length()) ? (n2.charAt(i) - '0') : 0);
			carry = sum / 10;
			sb.append(sum % 10);
		}
		// remove front 0's
		while (sb.charAt(sb.length()-1) == '0' && sb.length() > 1) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.reverse().toString();
	}
}
