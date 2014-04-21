package com.programs.string;

/**
 * Remove Character
 *
 * @author "Jigar Gosalia"
 *
 */
public class RemoveCharacter {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String inputString = "Hello";
		System.out.println("inputString : " + inputString);
		System.out.println("finalString : "
				+ inputString.replaceAll(Character.toString('l'), ""));
		System.out.println("inputString : " + inputString);
	}
}
