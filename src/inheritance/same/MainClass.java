package inheritance.same;

/**
 * Demonstrates following in Inheritance ... <br>
 * <br>
 * 1. Access Modifiers (Public, Private, Default and Protected) <br>
 * 2. Upcasting and Downcasting <br>
 * 3. Overriding (non-static methods) and Hiding (static methods) <br>
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		// Upcasting
		SuperClass superClass = new SubClassSamePackage();
		// Compilation Error as although the superClass is referencing to
		// SubClass type but the reference type i.e. SuperClass doesn't have
		// notPresentInSuperClass method hence it can't call it
		// superClass.notPresentInSuperClass();

		// During compilation, compiler checks publicMethod in SuperClass but
		// during runtime it identifies that although superClass is of type
		// SuperClass but it is referencing to SubClass, hence it will call
		// publicMethod() from SubClass.
		// Overriding
		superClass.publicMethod();

		// Downcasting
		// Downcasting allows us to call methods present in subclass but
		// not present in super class provided the reference type is 
		// super class
		((SubClassSamePackage) superClass).notPresentInSuperClass();

		SuperClass.staticPublicMethod();

		// Hiding
		SubClassSamePackage.staticPublicMethod();

		SubClassSamePackage subClassSamePackage = new SubClassSamePackage();
		// Same Package has access to inherited default methods
		subClassSamePackage.defaultMethod();

		// Protected methods are accessible in same package
		subClassSamePackage.protectedMethod();
	}
}
