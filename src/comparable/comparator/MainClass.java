package comparable.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class shows how to sort custom objects array/list implementing
 * Comparable and Comparator interfaces
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 *
	 * @param args
	 */
	public static void main(final String[] args) {

		EmployeeWithoutComparable[] employeeWithoutComparable = new EmployeeWithoutComparable[4];
		employeeWithoutComparable[0] = new EmployeeWithoutComparable(10, "Mikey", 25, 10000);
		employeeWithoutComparable[1] = new EmployeeWithoutComparable(20, "Arun", 29, 20000);
		employeeWithoutComparable[2] = new EmployeeWithoutComparable(5, "Lisa",	35, 5000);
		employeeWithoutComparable[3] = new EmployeeWithoutComparable(1, "Pankaj", 32, 50000);

		// Sorting employees array without using Comparable interface
		// implementation throws java.lang.ClassCastException as
		// EmployeeWithoutComparable cannot be cast to Comparable
		// Arrays.sort(employeeWithoutComparable);
		// System.out.println("Default Sorting of Employees list:\n"
		//		+ Arrays.toString(employeeWithoutComparable));
		// System.out.println();
		// BUT if you pass a comparator along with it then it can be sorted
		System.out.println("Sort an array without comparable but with comparator: ");
		Arrays.sort(employeeWithoutComparable, new Comparator<EmployeeWithoutComparable>() {
			@Override
			public int compare(EmployeeWithoutComparable o1, EmployeeWithoutComparable o2) {
				return ((Integer)o1.getId()).compareTo(o2.getId());
			}
		});
		System.out.println(Arrays.toString(employeeWithoutComparable));
		System.out.println();

		// sorting custom object array
		EmployeeWithComparable[] employeeWithComparable = new EmployeeWithComparable[4];
		employeeWithComparable[0] = new EmployeeWithComparable(10, "Mikey", 25, 10000);
		employeeWithComparable[1] = new EmployeeWithComparable(20, "Arun", 29, 20000);
		employeeWithComparable[2] = new EmployeeWithComparable(5, "Lisa", 35, 5000);
		employeeWithComparable[3] = new EmployeeWithComparable(1, "Pankaj", 32, 50000);

		// sorting employees array using Comparable interface implementation
		Arrays.sort(employeeWithComparable);
		System.out.println("Default Sorting of Employees list by Comparable:\n"	+ Arrays.toString(employeeWithComparable));
		System.out.println();

		// sort employees array using Comparator by Salary
		Arrays.sort(employeeWithComparable, EmployeeWithComparable.SalaryComparator);
		System.out.println("Employees list sorted by Salary:\n" + Arrays.toString(employeeWithComparable));
		System.out.println();

		// sort employees array using Comparator by Age
		Arrays.sort(employeeWithComparable,	EmployeeWithComparable.AgeComparator);
		System.out.println("Employees list sorted by Age:\n" + Arrays.toString(employeeWithComparable));
		System.out.println();

		// sort employees array using Comparator by Name
		Arrays.sort(employeeWithComparable, EmployeeWithComparable.NameComparator);
		System.out.println("Employees list sorted by Name:\n" + Arrays.toString(employeeWithComparable));
		System.out.println();

		// Employees list sorted by ID and then name using Comparator class
		employeeWithComparable[0] = new EmployeeWithComparable(1, "Mikey", 25, 10000);
		Arrays.sort(employeeWithComparable, new EmployeeComparatorByIdAndName());
		System.out.println("Employees list sorted by ID and Name:\n" + Arrays.toString(employeeWithComparable));
		System.out.println();
	}
}