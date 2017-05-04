package serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SerializeMainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Employee employee = new Employee(100, "Jigar Gosalia",
				"1234 Main Street, San Jose, CA - 95131", "111-22-3333");
		try {
			File file = new File("C:/employee.ser");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(employee);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Serialized Employee is saved in "
					+ file.getAbsolutePath());
			System.out.println(employee.toString());
		} catch (NotSerializableException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
