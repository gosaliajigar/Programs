package string;

/**
 * <b>String automatically calls intern() on literal constants so technically,
 * if required, it should be only called on new String().</b> <br>
 * <br>
 * String Interning is a method of storing only one copy of each distinct String
 * Value, which must be immutable.<br>
 * <br>
 * In Java, String class has a public method intern() that returns a canonical
 * representation for the string object. Java’s String class privately maintains
 * a pool of strings, where String literals are automatically interned.<br>
 * <br>
 * When the intern() method is invoked on a String object it looks the string
 * contained by this String object in the pool, if the string is found there
 * then the string from the pool is returned. Otherwise, this String object is
 * added to the pool and a reference to this String object is returned.<br>
 * <br>
 * The intern() method helps in comparing two String objects with == operator by
 * looking into the pre-existing pool of string literals, no doubt it is faster
 * than equals() method. The pool of strings in Java is maintained for saving
 * space and for faster comparisons. Normally Java programmers are advised to
 * use equals(), not ==, to compare two strings. This is because == operator
 * compares memory locations, while equals() method compares the content stored
 * in two objects.<br>
 * <br>
 * <b>Why and When to Intern?</b><br>
 * <br>
 * Though Java automatically interns all Strings by default, remember that we
 * only need to intern strings when they are not constants, and we want to be
 * able to quickly compare them to other interned strings. The intern() method
 * should be used on strings constructed with new String() in order to compare
 * them by == operator. <br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class StringIntern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		final String s4 = s3.intern();
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println();
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s3));
	}
}
