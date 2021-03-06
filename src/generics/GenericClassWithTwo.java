package generics;

/**
 *
 * Generic Class with two Generic Types
 *
 * @author "Jigar Gosalia"
 *
 * @param <T>
 * @param <E>
 */
public class GenericClassWithTwo<T, E> {

	private T name;
	private E value;

	public T getName() { return name; }

	public void setName(final T name) { this.name = name; }

	public E getValue() { return value; }

	public void setValue(final E value) { this.value = value; }

	public GenericClassWithTwo(final T name, final E value) {
		this.setName(name);
		this.setValue(value);
	}

	public static void main(final String[] args) {
		GenericClassWithTwo<String, Integer> integerClass = new GenericClassWithTwo<String, Integer>("Integer", 1);
		System.out.println("Name-Value : " + integerClass.getName() + "-" + integerClass.getValue());

		GenericClassWithTwo<String, String> stringClass = new GenericClassWithTwo<String, String>("String", "Hello");
		System.out.println("Name-Value : " + stringClass.getName() + "-" + stringClass.getValue());
	}
}
