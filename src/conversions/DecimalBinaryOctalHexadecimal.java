package com.programs.conversions;

/**
 * Conversion between Decimal, Binary, Octal and Hexadecimal.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class DecimalBinaryOctalHexadecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.printf("%3s %3s %3s %10s", "Dec", "Oct", "Hex", "Bin");
		System.out.println();
		for (int index = 0; index < 256; index++) {
			System.out.printf("%3d %3s %3s %10s", index, ConversionLibrary.dec2oct(index),
					ConversionLibrary.dec2hex(index), ConversionLibrary.dec2bin(index));
			if (!verify(index)) {
				break;
			}
			System.out.println();
		}
	}

	/**
	 * @param index
	 * @return
	 */
	public static boolean verify(int index) {
		if (index != ConversionLibrary.oct2dec(ConversionLibrary.dec2oct(index))) {
			System.out.println("Dec2Oct and Oct2Dec failed for " + index);
			return false;
		}
		if (index != ConversionLibrary.hex2dec(ConversionLibrary.dec2hex(index))) {
			System.out.println("Dec2Hex and Hex2Dec failed for " + index);
			return false;
		}
		if (index != ConversionLibrary.bin2dec(ConversionLibrary.dec2bin(index))) {
			System.out.println("Dec2Bin and Bin2Dec failed for " + index);
			return false;
		}
		return true;
	}
}
