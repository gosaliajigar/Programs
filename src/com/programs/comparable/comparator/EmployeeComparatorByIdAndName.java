package com.programs.comparable.comparator;

import java.util.Comparator;

/**
 * Employee class implementing Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeComparatorByIdAndName implements
		Comparator<EmployeeWithComparable> {

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(final EmployeeWithComparable employee1,
			final EmployeeWithComparable employee2) {
		int flag = employee1.getId() - employee2.getId();
		if (flag == 0)
			flag = employee1.getName().compareTo(employee2.getName());
		return flag;
	}

}