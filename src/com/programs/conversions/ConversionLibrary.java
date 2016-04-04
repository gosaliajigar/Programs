package com.programs.conversions;

/**
 * Conversion Library for conversion between ... <br>
 * 1. Decimal, Binary, Octal and Hexadecimal<br>
 * 2. ASCII and Integer<br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ConversionLibrary {

	/**
	 * Decimal to Binary converter.
	 * 
	 * @param decimal
	 * @return
	 */
	public static String dec2bin(int decimal) {
		if (decimal <= 0) {
			return "0";
		}
		String binary = new String();
		while (decimal != 0) {
			int remainder = decimal % 2;
			decimal /= 2;
			binary = remainder + binary;
		}
		return binary;
	}

	/**
	 * Binary to Decimal converter
	 * 
	 * @param binary
	 * @return
	 */
	public static int bin2dec(String binary) {
		int decimal = 0;
		for (int index = 0; index < binary.length(); index++) {
			int multiplier = ((binary.charAt(index) == '1') ? 1 : 0); 
			decimal = (multiplier * (int) Math.pow(2, binary.length() - 1 - index))
					+ decimal;
		}
		return decimal;
	}

	/**
	 * Decimal to Octal converter.
	 * 
	 * @param decimal
	 * @return
	 */
	public static String dec2oct(int decimal) {
		String octal = new String();
		while (decimal != 0) {
			int remainder = decimal % 8;
			decimal /= 8;
			octal = remainder + octal;
		}
		if (octal.length() == 0) {
			octal = "000" + octal;
		}
		if (octal.length() == 1) {
			octal = "00" + octal;
		}
		if (octal.length() == 2) {
			octal = "0" + octal;
		}
		return octal;
	}

	/**
	 * Octal to Decimal converter.
	 * 
	 * @param octal
	 * @return
	 */
	public static int oct2dec(String octal) {
		int decimal = 0;
		for (int index = 0; index < octal.length(); index++) {
			decimal = (Integer.parseInt(String.valueOf(octal.charAt(index)))
					* (int) Math.pow(8, octal.length() - 1 - index)) + decimal;
		}
		return decimal;
	}

	/**
	 * Decimal to Hexadecimal converter.
	 * 
	 * @param decimal
	 * @return
	 */
	public static String dec2hex(int decimal) {
		if (decimal <= 0) {
			return "0";
		}
		String hex = new String();
		while (decimal != 0) {
			int remainder = decimal % 16;
			decimal /= 16;
			hex = getHexValue(remainder) + hex;
		}
		return hex;
	}

	/**
	 * Hexadecimal to Decimal converter.
	 * 
	 * @param hex
	 * @return
	 */
	public static int hex2dec(String hex) {
		int decimal = 0;
		for (int index = 0; index < hex.length(); index++) {
			if (hex.charAt(index) >= 'A' && hex.charAt(index) <= 'F') {
				decimal = (getDecValue(hex.charAt(index)) * (int) Math.pow(16, hex.length() - 1 - index)) + decimal;
			} else {
				decimal = (Integer.parseInt(String.valueOf(hex.charAt(index)))
						* (int) Math.pow(16, hex.length() - 1 - index)) + decimal;
			}
		}
		return decimal;
	}

	/**
	 * Get Hexadecimal character for decimal value between 10-15.
	 * 
	 * @param remainder
	 * @return
	 */
	private static String getHexValue(int remainder) {
		String hex;
		switch (remainder) {
		case 10:
			hex = "A";
			break;
		case 11:
			hex = "B";
			break;
		case 12:
			hex = "C";
			break;
		case 13:
			hex = "D";
			break;
		case 14:
			hex = "E";
			break;
		case 15:
			hex = "F";
			break;
		default:
			hex = String.valueOf(remainder);
		}
		return hex;
	}

	/**
	 * Get Decimal value for some of the characters.
	 * 
	 * @param remainder
	 * @return
	 */
	private static int getDecValue(char hex) {
		int dec = 0;
		switch (hex) {
		case '0':
			dec = 0;
			break;
		case '1':
			dec = 1;
			break;
		case '2':
			dec = 2;
			break;
		case '3':
			dec = 3;
			break;
		case '4':
			dec = 4;
			break;
		case '5':
			dec = 5;
			break;
		case '6':
			dec = 6;
			break;
		case '7':
			dec = 7;
			break;
		case '8':
			dec = 8;
			break;
		case '9':
			dec = 9;
			break;
		case 'A':
			dec = 10;
			break;
		case 'B':
			dec = 11;
			break;
		case 'C':
			dec = 12;
			break;
		case 'D':
			dec = 13;
			break;
		case 'E':
			dec = 14;
			break;
		case 'F':
			dec = 15;
			break;
		default:
			// do nothing
		}
		return dec;
	}

	/**
	 * ASCII to Integer converter.
	 * 
	 * @param ascii
	 * @return
	 */
	public static int atoi(String ascii) throws Exception {
		int integer = 0;
		for (int index = 0; index < ascii.length(); index++) {
			if (ascii.charAt(index) >= '0' && ascii.charAt(index) <= '9') {
				integer = (integer*10) + getDecValue(ascii.charAt(index));
			} else {
				throw new Exception("Is not an Integer : " + ascii.charAt(index));
			}
		}
		return integer;
	}

	/**
	 * Integer to ASCII converter.
	 * 
	 * @param integer
	 * @return
	 */
	public static String itoa(int integer) {
		String ascii = "";
		if (integer == 0) {
			return "0";
		}
		while (integer != 0) {
			int remainder = integer % 10;
			ascii = remainder + ascii;
			integer = integer / 10;
		}
		return ascii;
	}
}
