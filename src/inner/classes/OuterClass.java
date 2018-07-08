package inner.classes;

/**
 * @author "Jigar Gosalia"
 *
 */
public class OuterClass {

	private static String ostatic = "OuterClass";
	private int oprivate;
	protected int oprotected;
	int opackage;
	public int opublic;

	// OuterClass constructor
	public OuterClass(final int i, final int j, final int k, final int l) {
		this.oprivate = i;
		this.oprotected = j;
		this.opackage = k;
		this.opublic = l;
	}

	public int getPrivateField() { return oprivate; }

	/**
	 * static nested class can access OuterClass static variables/methods
	 */
	static class StaticNestedClass {
		private int staticNestedClassPrivateField;
		protected int staticNestedClassProtectedField;
		int staticNestedClassPackageField;
		public int staticNestedClassPublicField;

		public int getA() { return staticNestedClassPrivateField; }

		public String getName() { return ostatic; }

		@Override
		public String toString() {
			return staticNestedClassPublicField + ", " + staticNestedClassPackageField + ", "
					+ staticNestedClassProtectedField + ", " + staticNestedClassPrivateField + ", " + getName();
		}
	}

	/**
	 * Non-static Inner class can access all the variables/methods of outer class
	 */
	class NonStaticInnerClass {
		private int w;
		protected int x;
		int y;
		public int z;

		public int getW() { return w; }

		public void setValues() {
			w = oprivate;
			x = oprotected;
			y = opackage;
			z = opublic;
		}

		@Override
		public String toString() {
			return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z + ":name=" + getName();
		}

		public String getName() { return ostatic; }
	}

	/**
	 * Method to hold local inner class
	 * 
	 * @param initial
	 */
	public void print(final String initial) {
		/**
		 * local inner class inside the method
		 * local Inner class has access to OuterClass fields
		 */
		class Logger {
			String name;
			public Logger(final String name) { this.name = name; }
			public void log(final String str) { System.out.println(name + ": " + str); }
			public void logAll() {
				System.out.println(oprivate + ", " + oprotected + ", " + opackage + ", " + opublic);
				System.out.println(OuterClass.ostatic);
			}
		}

		Logger logger = new Logger(initial);
		logger.log(logger.name);
		logger.logAll();

		// method accessing OuterClass fields
		logger.log(ostatic);
		logger.log(oprivate + ", " + oprotected + ", " + opackage + ", " + opublic);
	}

	/**
	 * Anonymous inner class
	 * 
	 * @param string
	 */
	public void getHello(final String string) {
		// anonymous inner class implementing AnonymousInterface
		// Anonymous class accessing OuterClass fields
		(new AnonymousInterface() {
			@Override
			public String print(final String string) {
				logAll();
				return string;
			}
			public void logAll() {
				System.out.println(oprivate + ", " + oprotected + ", " + opackage + ", " + opublic);
				System.out.println(OuterClass.ostatic);
			}
		}).print(string);
	}
}