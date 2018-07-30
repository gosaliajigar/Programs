package conversions;

/**
 * Conversion between ASCII and Integer.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class AsciiInteger {

	public static void main(String[] args) {
		System.out.printf("%3s %5s", "INT", "ASCII");
		System.out.println();
		for (int index = 0; index < 256; index++) {
			System.out.printf("%3d %5s", index, ConversionLibrary.itoa(index));
			if (!verify(index)) break;
			System.out.println();
		}
	}

	/**
	 * @param index
	 * @return
	 */
	public static boolean verify(int index) {
		boolean match = true;
		try {
			if (index != ConversionLibrary.atoi(ConversionLibrary.itoa(index))) {
				System.out.println();
				System.out.println("atoi and itoa failed <" + index + "> != <" + ConversionLibrary.atoi(ConversionLibrary.itoa(index)) + ">");
				match = false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			match = false;
		}
		return match;
	}
}
