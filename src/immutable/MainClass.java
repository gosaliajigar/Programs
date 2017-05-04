package immutable;

import java.util.HashMap;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * To test the consequences of Shallow Copy and how to avoid it with Deep
	 * Copy for creating immutable classes
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		HashMap<String, String> departmentsMap = new HashMap<String, String>();
		departmentsMap.put("1", "first");
		departmentsMap.put("2", "second");
		String name = "original";
		int id = 10;
		Employee employee = new Employee(id, name, departmentsMap);

		System.out.println("Is name same as employee.name? "
				+ (name == employee.getName()));
		System.out
				.println("Is departmentsMap same as employee.departmentsMap? "
						+ (departmentsMap == employee.getDepartmentsMap()));
		System.out.println();

		System.out.println("Printing Employee ... ");
		System.out.println(employee.toString());
		System.out.println();

		// change the local variable values
		id = 20;
		name = "modified";
		departmentsMap.put("3", "third");
		System.out
				.println("Printing Employee after local variable change ... ");
		System.out.println(employee.toString());
		System.out.println();

		HashMap<String, String> departmentsMapTest = employee
				.getDepartmentsMap();
		departmentsMapTest.put("4", "fourth");
		employee.getDepartmentsMap().put("5", "fivth");
		System.out
				.println("Printing Employee after changing variable from accessor methods ... ");
		System.out.println(employee.toString());
	}
}
