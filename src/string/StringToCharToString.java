package string;

import java.util.Arrays;

/**
 * This class show how to convert String to char to String in java
 * 
 * str.charAt(index)		==> char
 * str.toCharArray() 		==> char[]
 * new String(char[]) 		==> str
 * Character.toString(char)	==> str
 * String.valueOf(char)		==> str
 * 
 * @author Jigar Gosalia
 *
 */
public class StringToCharToString {
	public static void main(final String[] args) {
		// String to char array
		String string = "123";
		char[] charArray = string.toCharArray();
		System.out.println("String -> char array : " + Arrays.toString(charArray));
		System.out.println();

		// char array to String
		// We can also use String Constructor new String(char[] charArray)
		String charArrayToString = String.valueOf(charArray);
		System.out.println("char array -> String : " + charArrayToString);
		System.out.println();

		// String to char
		char c = string.charAt(1);
		System.out.println("String -> char : " + c);
		System.out.println();

		// char to String
		// We can also use String.valueOf(char c) or String Constructor
		// new String(char c)
		String s = Character.toString(c);
		System.out.println("char -> String : " + s);
	}
}