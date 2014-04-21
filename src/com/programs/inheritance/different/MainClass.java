package com.programs.inheritance.different;

import com.programs.inheritance.same.SubClassSamePackage;
import com.programs.inheritance.same.SuperClass;

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

		subClassSamePackage.publicMethod();
		subClassSamePackage.protectedMethod();

		subClassDifferentPackage.publicMethod();
		subClassDifferentPackage.protectedMethod();

		// Same Package Subclasses in different Package don't have access to
		// inherited default methods
		// subClassSamePackage.defaultMethod();

		// Different Package Subclasses don't have access to inherited default
		// methods
		// subClassDifferentPackage.defaultMethod();
	}
}
