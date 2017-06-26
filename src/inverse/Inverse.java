package inverse;

/**
 * Binary inverse of a number.
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

	private static int bin2dec(String complementValue) {
		int decimal = 0;
		if (complementValue != null
				&& complementValue.length() > 0) {
			StringBuilder value = new StringBuilder(complementValue);
			String reverse = value.reverse().toString();
			for (int index = 0; index < reverse.length(); index++) {
				int multiplier = ((reverse.charAt(index) == '1') ? 1 : 0);
				decimal += multiplier * (int)(Math.pow(2, index));
			}
		}
		return decimal;
	}

	private static String complement(String dec2binValue) {
		StringBuilder complement = new StringBuilder();
		for (int index = 0; index < dec2binValue.length(); index++) {
			if (dec2binValue.charAt(index) == '0') {
				complement.append("1");
			} else {
				complement.append("0");
			}
		}
		return complement.toString();
	}

	private static String dec2bin(int value) {
		StringBuilder binary = new StringBuilder();
		while (value != 0) {
			int remainder = value % 2;
			int quotient = value / 2;
			binary.append(remainder);
			value = quotient;
		}
		return binary.reverse().toString();
	}
}
