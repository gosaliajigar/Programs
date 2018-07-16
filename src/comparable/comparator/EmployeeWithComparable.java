package comparable.comparator;

import java.util.Comparator;

/**
 * Employee class implementing Comparable and having Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeWithComparable implements Comparable<EmployeeWithComparable> {

	private int id;

	private String name;

	private int age;

	private long salary;

	public int getId() { return id; }

	public String getName() { return name; }

	public int getAge() { return age; }

	public long getSalary() { return salary; }

	public EmployeeWithComparable(final int id, final String name, final int age, final int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public int compareTo(final EmployeeWithComparable employee) { return (id - employee.id); }

	@Override
	public String toString() { return "[id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]"; }

	/**
	 * Comparator to sort employees list or array in order of Salary
	 */
	public static Comparator<EmployeeWithComparable> SalaryComparator = new Comparator<EmployeeWithComparable>() {
		@Override
		public int compare(final EmployeeWithComparable employee1, final EmployeeWithComparable employee2) {
			return (int) (employee1.getSalary() - employee2.getSalary());
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Age
	 */
	public static Comparator<EmployeeWithComparable> AgeComparator = new Comparator<EmployeeWithComparable>() {
		@Override
		public int compare(final EmployeeWithComparable employee1, final EmployeeWithComparable employee2) {
			return employee1.getAge() - employee2.getAge();
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Name
	 */
	public static Comparator<EmployeeWithComparable> NameComparator = new Comparator<EmployeeWithComparable>() {
		@Override
		public int compare(final EmployeeWithComparable employee1, final EmployeeWithComparable employee2) {
			return employee1.getName().compareTo(employee2.getName());
		}
	};
}