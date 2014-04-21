package com.programs.nested.vo;

import java.lang.reflect.Field;

public class MainClass {

	public static final String PACKAGE_NAME = "com.programs.nested.vo.";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Object parentObject = createObject(PACKAGE_NAME + "BankVO");
	}

	public static Object createObject(String vo) throws Exception {

		Object 	object = Class.forName(vo).newInstance();
		System.out.println("Creating Object : " + object.getClass());

		if (Class.forName(vo).getDeclaredFields().length > 0) {
			for (Field field : Class.forName(vo).getDeclaredFields()) {
				field.setAccessible(true);
				field.set(object, createObject(field.getType().getName()));
			}
		}
		return object;
	}
}
