package com.programs.object.casting;

/**
 * @author "Jigar Gosalia"
 *
 */
class SubClass extends SuperClass {

	/* (non-Javadoc)
	 * @see com.programs.object.casting.SuperClass#print()
	 */
	@Override
	public void print() {
		System.out.println("print : I am from SubClass");
	}

	/**
	 *
	 */
	public void display() {
		System.out.println("display : I am from SubClass");
	}
}