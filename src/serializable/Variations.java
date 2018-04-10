package serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization of different types of fields.<br>
 * 	1. static final variable <br>
 * 	2. static variable but not final <br>
 * 	3. final variable but not static <br>
 * 	4. instance variable <br>
 * 	5. transient variable <br>
 * 	6. non-serializable field <br>
 * <br>
 * <br>
 * 1. If a parent class has implemented Serializable interface then child class doesn’t 
 * 		need to implement it but vice-versa is not true.<br>
 * 2. Only <b>non-static data members</b> are saved via Serialization process.<br>
 * 3. <b>Static and transient data members</b> are not saved via Serialization process.
 * 		So, if you don’t want to save value of a non-static data member then
 * 		make it transient.<br>
 * 4. Constructor of object is never called when an object is deserialized.<br>
 * 5. Associated objects must be implementing Serializable interface.<br>
 * 6. Have access to no-arg constructor of its first nonserializable superclass.<br>
 * <br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class Variations {

	private static File file = new File("car.ser");

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Car blackNissan = new Car("Nissan", false, 1000, 20000, "BLACK", true);
		System.out.println("Before Serialization");
		System.out.println("--------------------");
		blackNissan.print();
		System.out.println("HashCode : " + blackNissan.hashCode());
		System.out.println();

		// serializing object
		write(blackNissan);

		System.out.println("Create new object with different make (non-final static)");
		@SuppressWarnings("unused")
		// creating another object with different make (non-final static)
		Car redToyota = new Car("Toyota", true, 2000, 23000, "RED", true);
		System.out.println();

		// de-serializing object (NOTE: constructor is not called)
		blackNissan = (Car) read();
		System.out.println("After DeSerialization");
		System.out.println("--------------------");
		blackNissan.print();
		System.out.println("HashCode : " + blackNissan.hashCode());
	}

	private static void write(Serializable object) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(object);
		System.out.println("Writing : " + file.getAbsolutePath());
		oos.close();
	}

	private static Object read() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		System.out.println("Reading : " + file.getAbsolutePath());
		ois.close();
		return obj;
	}
}