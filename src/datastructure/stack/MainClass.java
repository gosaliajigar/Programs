package datastructure.stack;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {
	public static void main(final String[] args) {
		Stack integerStack = new Stack(10);
		System.out.println(integerStack.toString());
		for (int i = 0; i < integerStack.getCapacity() + 1; i++) {
			System.out.println("Pushing      -> " + i + " at location (" + i + ")");
			integerStack.push(i);
		}
		System.out.println(integerStack.toString());
		for (int i = integerStack.getSize() - 1; i >= 0; i--) {
			System.out.println("Popping      <- " + integerStack.pop() + " from location (" + i + ")");
		}
		System.out.println(integerStack.toString());
	}
}
