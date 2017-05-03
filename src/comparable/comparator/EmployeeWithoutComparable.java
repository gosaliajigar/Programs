package com.programs.comparable.comparator;


/**
 * Employee class without Comparable and Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeWithoutComparable {

	/**
	 *
	 */
	private int id;

	/**
	 *
	 */
	private String name;

	/**
	 *
	 */
	private int age;

	/**
	 *
	 */
	private long salary;

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
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 */
	public EmployeeWithoutComparable(final int id, final String name, final int age,
			final int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 *
	 * This is required to print the user friendly information about the
	 * Employee
	 */
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", age=" + age + ", salary="
				+ salary + "]";
	}
}