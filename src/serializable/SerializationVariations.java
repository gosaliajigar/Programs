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
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SerializationVariations {

	private static File file = new File("car.ser");

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Car blackNissan = new Car("Nissan", false, 1000, 20000, "BLACK", true);
		System.out.println("Before Serialization");
		System.out.println("--------------------");
		blackNissan.print();
		System.out.println();

		// serializing object
		write(blackNissan);

		System.out.println("Create new object with different non-final static");
		// creating another object with different make (non-final static)
		Car redToyota = new Car("Toyota", true, 2000, 23000, "RED", true);
		System.out.println();

		// de-serializing object (NOTE: constructor is not called)
		blackNissan = (Car) read();
		System.out.println("After DeSerialization");
		System.out.println("--------------------");
		blackNissan.print();
	}

	private static void write(Serializable object) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(object);
		oos.close();
	}

	private static Object read() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		return obj;
	}
}