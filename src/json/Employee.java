package json;

import java.util.Arrays;

/**
 * Java Class for JSON conversion.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Employee {

	private long id;
	private String name;
	private int[] tasks;
	private Department department;

	public Employee() {}

	public Employee(long id, String name, int[] tasks) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
		this.department = null;
	}

	public Employee(long id, String name, int[] tasks, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
		this.department = department;
	}

	public long getId() { return id; }

	public String getName() { return name; }

	public int[] getTasks() { return tasks; }

	public Department getDepartment() { return department; }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tasks="
				+ Arrays.toString(tasks) + ", department=" + department + "]";
	}

}
