package hashcode.value;

/**
 * HashCode for any Object
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		MainClass mainClass = new MainClass();

		// Prints hashcode.value.MainClass + @ +
		// Integer.toHexString(mainClass.hashCode())
		System.out.println(mainClass);
		System.out.println(Integer.toHexString(mainClass.hashCode()));
		// Actual value of mainClass.hashCode()
		System.out.println(mainClass.hashCode());
	}
}
