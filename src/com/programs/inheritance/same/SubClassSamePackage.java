package com.programs.inheritance.same;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SubClassSamePackage extends SuperClass {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.programs.inheritance.SuperClass#publicMethod()
	 */
	@Override
	public void publicMethod() {
		System.out.println("I am public in SubClassSamePackage");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.programs.inheritance.SuperClass#protectedMethod()
	 */
	@Override
	public void protectedMethod() {
		System.out.println("I am public in SubClassSamePackage");
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
		System.out.println("I am public static in SubClassSamePackage");
	}

	/**
	 *
	 */
	protected static void staticProtectedMethod() {
		System.out.println("I am protected static in SubClassSamePackage");
	}
}
