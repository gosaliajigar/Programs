package com.programs.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;

/**
 * @author "Jigar Gosalia"
 *
 */
public class DeserializeMainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Employee employee = null;
		String fileName = null;
		try {
			File file = new File("C:/employee.ser");
			fileName = file.getAbsolutePath();
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			employee = (Employee) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			if (file.delete()) {
				System.out.println("Data read from " + file.getAbsolutePath()
						+ " and file is deleted successfully!");
			}
		} catch (NotSerializableException exception) {
			exception.printStackTrace();
			return;
		} catch (IOException exception) {
			exception.printStackTrace();
			return;
		} catch (ClassNotFoundException exception) {
			System.out.println("Employee class not found");
			exception.printStackTrace();
			return;
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee data from file " + fileName);
		System.out.println(employee.toString());
	}
}
