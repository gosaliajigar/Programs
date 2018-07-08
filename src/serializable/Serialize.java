package serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author "Jigar Gosalia"
 *
 */
public class Serialize {
	public static void main(final String[] args) {
		File file = null;;
		FileOutputStream fOutputStream = null;
		ObjectOutputStream oOutputStream = null;
		Employee employee = new Employee(100, "Jigar Gosalia", "1234 Main Street, San Jose, CA - 95131", "111-22-3333");
		try {
			file = new File("C:/employee.ser");
			fOutputStream = new FileOutputStream(file);
			oOutputStream = new ObjectOutputStream(fOutputStream);
			oOutputStream.writeObject(employee);
			System.out.println("Serialized Employee Saved : " + file.getAbsolutePath());
			System.out.println(employee.toString());
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				oOutputStream.close();	
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			try {
				fOutputStream.close();	
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
