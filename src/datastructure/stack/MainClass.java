package datastructure.stack;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {
	public static void main(final String[] args) {
		Stack s = new Stack(10);
		int i = 0;
		while (!s.isFull()) {
			System.out.println("Pushing      -> " + i + " at location (" + i + ")");
			s.push(i++);
		}
		System.out.println(s.toString());
		i = s.getSize() - 1;
		while (!s.isEmpty()) {
			System.out.println("Popping      <- " + s.pop() + " from location (" + i-- + ")");
		}
	}
}
