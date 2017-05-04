package inner.classes;

//nested classes can be used in import for easy instantiation
// import inner.classes.OuterClass.NonStaticInnerClass;
// import inner.classes.OuterClass.StaticNestedClass;

/**
 * @author "Jigar Gosalia"
 *
 */
public class NestedClasses {

	public static void main(final String[] args) {
		OuterClass outer = new OuterClass(1, 2, 3, 4);

		// Static nested classes
		OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
		staticNestedClass.staticNestedClassPackageField = 10;
		staticNestedClass.staticNestedClassProtectedField = 20;
		staticNestedClass.staticNestedClassPublicField = 30;
		System.out.println("StaticInnerClass: " + staticNestedClass);
		System.out.println();

		// Non Static Inner class
		OuterClass.NonStaticInnerClass nonStaticInnerClass = outer.new NonStaticInnerClass();
		System.out.println("NonStaticInnerClass: " + nonStaticInnerClass);
		nonStaticInnerClass.setValues();
		System.out.println("NonStaticInnerClass: " + nonStaticInnerClass);
		System.out.println();

		// Calling method having local inner class
		outer.print("Outer");

		// Calling method having anonymous inner class
		outer.getHello("Hellow");
	}
}