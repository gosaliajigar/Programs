package com.programs.immutable;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Immutable Employee Class<br>
 * 	1. Class must be final so that it can be extended<br>
 * 	2. Class shouldn't have any setters<br>
 * 	3. Constructor and Getters must return clone of objects instead of address<br>
 *
 * @author "Jigar Gosalia"
 *
 */
public final class Employee {

	/**
	 *
	 */
	private final int id;

	/**
	 *
	 */
	private final String name;

	/**
	 *
	 */
	private final HashMap<String, String> departmentsMap;

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Access function for mutable objects
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getDepartmentsMap() {
		return (HashMap<String, String>) departmentsMap.clone();
	}

	/**
	 * Constructor performing Deep Copy
	 *
	 * @param id
	 * @param name
	 * @param departmentsMap
	 */
	public Employee(final int id, final String name,
			final HashMap<String, String> departmentsMap) {
		this.id = id;
		this.name = name;
		HashMap<String, String> tempMap = new HashMap<String, String>();
		for (Entry<String, String> entry : departmentsMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.departmentsMap = tempMap;
	}


	/**
	 * Constructor performing Shallow Copy
	 *
	 * @param id
	 * @param name
	 * @param departmentsMap
	 */
	/*
	public Employee(final int id, final String name, final HashMap<String, String> departmentsMap) {
		System.out.println("Performing Shallow Copy for Object initialization");
		this.id = id;
		this.name = name;
		this.departmentsMap = departmentsMap;
	}
	*/

	@Override
	public String toString() {
		return "Employee : id[" + id + "], name[" + name + "], departmentsMap["
				+ departmentsMap + "]";
	}
}