package inverse;

/**
 * Binary inverse of a number. (flip 1<->0; try ^ with 1)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Inverse {

	public static void main(String[] args) {
		int value = 23918231;
		System.out.println("Original   : " + value);
		String dec2binValue = dec2bin(value);
		System.out.println("dec2bin    : " + dec2binValue);
		String complementValue = complement(dec2binValue);
		System.out.println("Complement : " + complementValue);
		int inverseValue = bin2dec(complementValue);
		System.out.println("Inverse    : " + inverseValue);
	}

	private static int bin2dec(String binary) {
		int decimal = 0;
		if (binary != null && binary.length() > 0) {
			StringBuilder value = new StringBuilder(binary);
			for (int index = 0; index < value.length(); index++) {
				int multiplier = ((value.charAt(index) == '1') ? 1 : 0);
				decimal += multiplier * (int)(Math.pow(2, value.length() - 1 - index));
			}
		}
		return decimal;
	}

	private static String complement(String binary) {
		StringBuilder complement = new StringBuilder();
		for (int index = 0; index < binary.length(); index++) {
			// complement.append((Integer.parseInt("" + binary.charAt(index)) ^ 1));
			complement.append((binary.charAt(index) == '0') ? "1" : "0");
		}
		return complement.toString();
	}

	private static String dec2bin(int decimal) {
		StringBuilder binary = new StringBuilder();
		while (decimal != 0) {
			binary.append(decimal % 2);
			decimal /= 2;
		}
		return binary.reverse().toString();
	}
}
