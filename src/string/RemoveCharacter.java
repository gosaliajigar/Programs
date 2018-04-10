package string;

/**
 * Remove Character
 *
 * @author "Jigar Gosalia"
 *
 */
public class RemoveCharacter {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String input = "Hello";
		System.out.println("input : " + input);
		System.out.println("final : " + input.replaceAll(Character.toString('l'), ""));
		System.out.println("input : " + input);
	}
}
