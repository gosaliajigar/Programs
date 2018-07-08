package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author "Jigar Gosalia"
 *
 */
public class Deserialize {
	public static void main(final String[] args) {
		Employee employee = null;
		String fileName = null;
		FileInputStream fInputStream = null;
		ObjectInputStream oInputStream = null;
		try {
			File file = new File("C:/employee.ser");
			fileName = file.getAbsolutePath();
			fInputStream = new FileInputStream(file);
			oInputStream = new ObjectInputStream(fInputStream);
			employee = (Employee) oInputStream.readObject();
			if (file != null && file.delete()) {
				System.out.println("Data read " + file.getAbsolutePath() + " and file is deleted successfully!");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				fInputStream.close();	
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			try {
				oInputStream.close();	
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		System.out.println("Deserialized Employee data from file " + fileName);
		System.out.println(employee.toString());
	}
}
