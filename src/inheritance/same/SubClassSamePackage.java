package inheritance.same;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SubClassSamePackage extends SuperClass {

	/*
	 * (non-Javadoc)
	 *
	 * @see inheritance.SuperClass#publicMethod()
	 */
	@Override
	public void publicMethod() {
		System.out.println("I am public in SubClassSamePackage");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see inheritance.SuperClass#protectedMethod()
	 */
	@Override
	protected void protectedMethod() {
		System.out.println("I am protected in SubClassSamePackage, who was protected in SuperClass");
	}

	public void notPresentInSuperClass() {
		System.out.println("I am in SubClassSamePackage and not present in SuperClass");
	}

	public static void staticPublicMethod() {
		System.out.println("I am public static in SubClassSamePackage");
	}

	protected static void staticProtectedMethod() {
		System.out.println("I am protected static in SubClassSamePackage");
	}

	static void staticDefaultMethod() {
		System.out.println("I am default static in SubClassSamePackage");
	}
}
