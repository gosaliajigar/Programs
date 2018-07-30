package string;

import java.util.Arrays;

/**
 * 
 * Source : https://www.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/
 * https://www.programcreek.com/2014/05/leetcode-multiply-strings-java/ 
 * 
 * @author Jigar Gosalia
 *
 */
public class MultiplyLargeNumbers {

	public static void main(String[] args) {
		System.out.println(multiply("654154154151454545415415454", "63516561563156316545145146514654"));
		System.out.println();
		System.out.println(multiply("16", "16"));
		System.out.println();
		System.out.println(multiply("0", "0"));
	}

	public static String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		// multiply each digit and sum at the corresponding positions
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		StringBuilder sb = new StringBuilder();

		// calculate each digit
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			if (i < d.length-1) d[i + 1] += carry;
			sb.append(mod);
		}
		
		// remove front 0's
		while (sb.charAt(sb.length()-1) == '0' && sb.length() > 1) {
			sb.deleteCharAt(sb.length()-1);
		}

		System.out.println(Arrays.toString(d));
		return sb.reverse().toString();
	}
}
