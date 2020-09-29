package string;

import java.util.Arrays;

/**
 * This class shows how to convert String to byte array and byte array to String
 * in java
 *
 * str.getBytes() 			==> byte[] 
 * new String(byte[]) 		==> str
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringToByteToString {
	public static void main(final String[] args) {
		String string = "Hello World";
		// String to byte array
		byte[] byteArray = string.getBytes();
		System.out.println("String -> byte array : " + Arrays.toString(byteArray));
		System.out.println();

		// convert byte array to String
		String byteArrayToString = new String(byteArray);
		System.out.println("byte array -> String : " + byteArrayToString);
	}
}