package swap;

/**
 * Limitation: any of the number can't be 0.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SwapUsingMultiplicationDivision {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int a = 2, b = 3;
		System.out
				.println("Swapping using Multiplication-Division Operator ...");
		System.out.println("Before - a:" + a + " " + "b:" + b);
		a = a * b;
		b = a / b; // a * b / b nullifies b ==> a
		a = a / b; // a * b / a nullifies a ==> b
		System.out.println("After  - a:" + a + " " + "b:" + b);
	}
}
