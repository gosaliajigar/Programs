package generics;

/**
 *
 * Generic Class with one Generic Type
 *
 * @author "Jigar Gosalia"
 *
 * @param <T>
 */
public class GenericClass<T> {

	private T value;

	/**
	 * @return
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param name
	 */
	public void setValue(final T name) {
		this.value = name;
	}

	/**
	 * @param value
	 */
	public GenericClass(final T value) {
		this.setValue(value);
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		GenericClass<Integer> integerClass = new GenericClass<Integer>(1);
		System.out.println("Value : " + integerClass.getValue());

		GenericClass<String> stringClass = new GenericClass<String>("Hello");
		System.out.println("Value : " + stringClass.getValue());
	}
}
