package object.casting;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	public static void main(final String[] args) {
		// Implicit Upcasting : Legal in Java
		SuperClass subClass = new SubClass();
		subClass.print();

		// Explicit Downcasting : Dangerous and Not-Legal in Java
		((SubClass) subClass).display();
	}
}
