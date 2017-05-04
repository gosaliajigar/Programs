package swap;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SwapUsingXOR {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int a = 2, b = 3;
		System.out.println("Swapping using XOR Operator ...");
		System.out.println("Before - a:" + a + " " + "b:" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After  - a:" + a + " " + "b:" + b);
	}
}
