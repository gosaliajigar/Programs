package marker.interfaces;

/**
 * Demonstrating Cloned copy
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) throws Exception {
		CloneableClass cloneableClass = new CloneableClass();
		System.out.println("cloneableClass                         : "
				+ cloneableClass);
		System.out.println("cloneableClass.getCompositeClass()     : "
				+ cloneableClass.getCompositeClass());
		System.out.println();

		CloneableClass cloneCopy = cloneableClass.clone();
		System.out.println("cloneCopy                              : "
				+ cloneCopy);
		System.out.println("cloneCopy.getCompositeClass()          : "
				+ cloneCopy.getCompositeClass());
		System.out.println();

		// Will be different references as clone() returns a different copy of
		// CloneableClass
		System.out.println("Comparing cloneableClass and cloneCopy : "
				+ ((cloneableClass == cloneCopy) ? "Same Reference"
						: "Different Reference"));

		// Will be different references as we are using new for composite class
		// in each instance of CloneableClass
		System.out.println("Comparing composite classes in 2 obj.  : "
				+ ((cloneableClass.getCompositeClass() == cloneCopy
						.getCompositeClass()) ? "Same Reference"
						: "Different Reference"));
	}
}
