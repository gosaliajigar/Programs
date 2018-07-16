package comparable.comparator;

/**
 * Employee class without Comparable and Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeWithoutComparable {

	private int id;

	private String name;

	private int age;

	private long salary;

	public int getId() { return id; }

	public String getName() { return name; }

	public int getAge() { return age; }

	public long getSalary() { return salary; }

	public EmployeeWithoutComparable(final int id, final String name, final int age, final int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() { return "[id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]"; }
}