package com.programs.inner.classes;

//nested classes can be used in import for easy instantiation
import com.programs.inner.classes.OuterClass.InnerClass;
import com.programs.inner.classes.OuterClass.StaticNestedClass;

/**
 * @author "Jigar Gosalia"
 *
 */
public class NestedClasses {

	public static void main(final String[] args) {
		OuterClass outer = new OuterClass(1, 2, 3, 4);

		// static nested classes example
		StaticNestedClass staticNestedClass = new StaticNestedClass();
		StaticNestedClass staticNestedClass1 = new StaticNestedClass();

		System.out.println(staticNestedClass.getName());
		staticNestedClass.d = 10;
		System.out.println(staticNestedClass.d);
		System.out.println(staticNestedClass1.d);

		// inner class example
		InnerClass innerClass = outer.new InnerClass();
		System.out.println(innerClass.getName());
		System.out.println(innerClass);
		innerClass.setValues();
		System.out.println(innerClass);

		// calling method using local inner class
		outer.print("Outer");

		// calling method using anonymous inner class
		outer.getHello("Hellow");
	}
}