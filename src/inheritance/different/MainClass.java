package inheritance.different;

import inheritance.same.SubClassSamePackage;
import inheritance.same.SuperClass;

/**
 *
 * Demonstrates following in Inheritance ... <br>
 * <br>
 * 1. Access Modifiers (Public, Private, Default and Protected) <br>
 * 2. Upcasting <br>
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
		SuperClass superSubClassSamePackage = new SubClassSamePackage();
		SuperClass superClass = new SuperClass();
		SubClassSamePackage subClassSamePackage = new SubClassSamePackage();
		SubClassDifferentPackage subClassDifferentPackage = new SubClassDifferentPackage();

		superSubClassSamePackage.publicMethod();
		superClass.publicMethod();
		// Different Package classes don't have access to protected methods
		// superClass.protectedMethod();

		subClassSamePackage.publicMethod();
		// Inherited protected methods are not accessible outside super class package
		// subClassSamePackage.protectedMethod();

		subClassDifferentPackage.publicMethod();
		subClassDifferentPackage.protectedMethod();

		// Same Package Subclasses in different Package don't have access to
		// inherited default methods
		// subClassSamePackage.defaultMethod();

		// Different Package Subclasses don't have access to inherited default methods
		// subClassDifferentPackage.defaultMethod();
	}
}
