package serializable;

import java.io.Serializable;

/**
 * Employee class to be serialized
 *
 * @author "Jigar Gosalia"
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -8215836970789336272L;
	private int number;
	private String name;
	private String address;
	private transient String SSN;

	public Employee(int number, String name, String address, String SSN) {
		this.number = number;
		this.name = name;
		this.address = address;
		this.SSN = SSN;
	}

	public int getNumber() { return number; }
	public String getName() { return name; }
	public String getAddress() { return address; }
	public String getSSN() { return SSN; }

	@Override
	public String toString() {
		return "Number[" + getNumber() + "], Name[" + getName() + "], Address["
				+ getAddress() + "], SSN["
				+ ((getSSN() == null) ? "000-00-0000" : getSSN()) + "]";
	}
}
