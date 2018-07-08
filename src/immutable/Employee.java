package immutable;

import java.util.HashMap;
import java.util.Map;

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

	private final int id;

	private final String name;

	private final Map<String, String> departmentsMap;

	public int getId() { return id; }

	public String getName() { return name; }

	/**
	 * Access function for mutable objects
	 */
	public Map<String, String> getDepartmentsMap() {
		Map<String, String> departments = new HashMap<String, String>();
		departments.putAll(this.departmentsMap);
		return departments;
	}

	/**
	 * Constructor performing Deep Copy
	 *
	 * @param id
	 * @param name
	 * @param departmentsMap
	 */
	public Employee(int id, String name, Map<String, String> departmentsMap) {
		this.id = id;
		this.name = name;
		this.departmentsMap = new HashMap<String, String>();
		this.departmentsMap.putAll(departmentsMap);
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
		return "Employee : id[" + id + "], name[" + name + "], departmentsMap["	+ departmentsMap + "]";	}
}