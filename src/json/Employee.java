package json;

import java.util.Arrays;

public class Employee {

	private long id;

	private String name;

	private int[] tasks;

	public Employee() {}

	public Employee(long id, String name, int[] tasks) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int[] getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tasks="
				+ Arrays.toString(tasks) + "]";
	}

}
