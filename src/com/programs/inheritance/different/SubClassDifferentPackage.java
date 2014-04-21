package com.programs.inheritance.different;

import com.programs.inheritance.same.SuperClass;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SubClassDifferentPackage extends SuperClass {

	/* (non-Javadoc)
	 * @see com.programs.inheritance.SuperClass#publicMethod()
	 */
	@Override
	public void publicMethod() {
		System.out.println("I am public in SubClassDifferentPackage");
	}

	/* (non-Javadoc)
	 * @see com.programs.inheritance.SuperClass#protectedMethod()
	 */
	@Override
	public void protectedMethod() {
		System.out.println("I am public in SubClassDifferentPackage");
	}

	/**
	 *
	 */
	public void notPresentInSuperClass() {
		System.out.println("I am not present in SuperClass");
	}

	/**
	 *
	 */
	public static void staticPublicMethod() {
		System.out.println("I am public static in SubClassDifferentPackage");
	}

	/**
	 *
	 */
	protected static void staticProtectedMethod() {
		System.out.println("I am protected static in SubClassDifferentPackage");
	}
}
