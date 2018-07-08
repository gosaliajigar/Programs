package string;

/**
 *
 * Explains String.compareTo ([0-9] [A-Z] [a-z])
 *
 * @author "Jigar Gosalia"
 *
 */
public class CompareStrings {
	public static void main(final String[] args) {
		String lowerCase = "abcd";
		String upperCase = "ABCD";

		// A(65) is smaller a(97); hence output is -ve
		System.out.println("Comparing " + upperCase + " with " + lowerCase
				+ " (case-sensitive)   : " + upperCase.compareTo(lowerCase));
		System.out.println();

		// a(97) is bigger A(65); hence output is +ve
		System.out.println("Comparing " + lowerCase + " with " + upperCase
				+ " (case-sensitive)   : " + lowerCase.compareTo(upperCase));
		System.out.println();

		System.out.println("Comparing " + lowerCase + " with " + upperCase
				+ " (case-insensitive) : "
				+ upperCase.compareToIgnoreCase(lowerCase));
		System.out.println();
	}
}
