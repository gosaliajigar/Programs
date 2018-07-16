package serializable;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Serialized POJO (Only non-static and non-transient fields are serialized)
 * 
 * @author "Jigar Gosalia"
 *
 */
class Car implements Serializable {

	// static final variable
	private static final long serialVersionUID = 40L;
	private static final Logger logger = Logger.getLogger(Car.class.getName());

	// static variable but not final
	private static String make;

	// final variable but not static
	private final boolean isCoupe;

	// instance variable
	private int id;
	private int price;
	private String color;

	// transient variable
	private transient boolean isAutomatic;

	// non-serializable field
	// if instantiated then throws java.io.NotSerializableException
	Thread thread;

	public Car(String make, boolean isCoupe, int id, int price, String color, boolean isAutomatic) {
		Car.make = make;
		this.isCoupe = isCoupe;
		this.id = id;
		this.price = price;
		this.color = color;
		this.isAutomatic = isAutomatic;
		System.out.println("Calling Constructor:" + this);
	}

	public String getMake() { return make; }
	public boolean isCoupe() { return isCoupe; }
	public int getId() { return id; }
	public int getPrice() { return price; }
	public String getColor() { return color; }

	public void print() {
		System.out.println("SerialVersionUID (final static field) : " + serialVersionUID);
		System.out.println("logger      (final static field)      : " + logger);
		System.out.println("make        (static field)            : " + make);
		System.out.println("isCouple    (final field)             : " + isCoupe);
		System.out.println("id          (instance variable)       : " + id);
		System.out.println("price       (instance variable)       : " + price);
		System.out.println("color       (instance variable)       : " + color);
		System.out.println("isAutomatic (transient variable)      : " + isAutomatic);
		System.out.println("thread      (non-serializable field)  : " + thread);
	}

	@Override
	public String toString() {
		return "Car [isCoupe=" + isCoupe + ", id=" + id + ", price=" + price
				+ ", color=" + color + ", isAutomatic=" + isAutomatic
				+ ", thread=" + thread + "]";
	}
}
