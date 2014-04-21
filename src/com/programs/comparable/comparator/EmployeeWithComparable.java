package com.programs.comparable.comparator;

import java.util.Comparator;

/**
 * Employee class implementing Comparable and having Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeWithComparable implements
		Comparable<EmployeeWithComparable> {

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
	public EmployeeWithComparable(final int id, final String name,
			final int age, final int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 *
	 * Sort the employee based on id in ascending order, returns a negative
	 * integer, zero, or a positive integer as this employee id is less than,
	 * equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(final EmployeeWithComparable employee) {
		return (id - employee.id);
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

	/**
	 * Comparator to sort employees list or array in order of Salary
	 */
	public static Comparator<EmployeeWithComparable> SalaryComparator = new Comparator<EmployeeWithComparable>() {

		@Override
		public int compare(final EmployeeWithComparable employee1,
				final EmployeeWithComparable employee2) {
			return (int) (employee1.getSalary() - employee2.getSalary());
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Age
	 */
	public static Comparator<EmployeeWithComparable> AgeComparator = new Comparator<EmployeeWithComparable>() {

		@Override
		public int compare(final EmployeeWithComparable employee1,
				final EmployeeWithComparable employee2) {
			return employee1.getAge() - employee2.getAge();
		}
	};

	/**
	 * Comparator to sort employees list or array in order of Name
	 */
	public static Comparator<EmployeeWithComparable> NameComparator = new Comparator<EmployeeWithComparable>() {

		@Override
		public int compare(final EmployeeWithComparable employee1,
				final EmployeeWithComparable employee2) {
			return employee1.getName().compareTo(employee2.getName());
		}
	};
}