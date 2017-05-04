/**
 *
 */
package serializable;

import java.io.Serializable;

/**
 * Employee class to be serialized
 *
 * @author "Jigar Gosalia"
 *
 */
public class Employee implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8215836970789336272L;

	/**
	 *
	 */
	private int number;

	/**
	 *
	 */
	private String name;

	/**
	 *
	 */
	private String address;

	/**
	 *
	 */
	private transient String SSN;

	/**
	 * @param number
	 * @param name
	 * @param address
	 * @param SSN
	 */
	public Employee(final int number, final String name, final String address,
			final String SSN) {
		this.number = number;
		this.name = name;
		this.address = address;
		this.SSN = SSN;
	}

	/**
	 * @return
	 */
	public int getNumber() {
		return number;
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
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getSSN() {
		return SSN;
	}

	/**
	 * @return
	 */
	public static long getSerialVersionUID() {
		return Employee.serialVersionUID;
	}

	@Override
	public String toString() {
		return "Number[" + getNumber() + "], Name[" + getName() + "], Address["
				+ getAddress() + "], SSN["
				+ ((getSSN() == null) ? "000-00-0000" : getSSN()) + "]";
	}
}
