package inheritance.same;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SuperClass {

	void defaultMethod() {
		System.out.println("I am default in SuperClass");
	}

	/**
	 *
	 */
	public void publicMethod() {
		System.out.println("I am public in SuperClass");
	}

	/**
	 *
	 */
	protected void protectedMethod() {
		System.out.println("I am protected in SuperClass");
	}

	/**
	 *
	 */
	@SuppressWarnings("unused")
	private void privateMethod() {
		System.out.println("I am private in SuperClass");
	}

	/**
	 *
	 */
	public static void staticPublicMethod() {
		System.out.println("I am public static in SuperClass");
	}

	/**
	 *
	 */
	protected static void staticProtectedMethod() {
		System.out.println("I am protected static in SuperClass");
	}
}
