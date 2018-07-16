package comparable.comparator;

import java.util.Comparator;

/**
 * Employee class implementing Comparator
 *
 * @author "Jigar Gosalia"
 *
 */
public class EmployeeComparatorByIdAndName implements Comparator<EmployeeWithComparable> {

	@Override
	public int compare(final EmployeeWithComparable employee1, final EmployeeWithComparable employee2) {
		int result = employee1.getId() - employee2.getId();
		if (result == 0) result = employee1.getName().compareTo(employee2.getName());
		return result;
	}

}