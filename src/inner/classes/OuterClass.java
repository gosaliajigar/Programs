package inner.classes;

/**
 * @author "Jigar Gosalia"
 *
 */
public class OuterClass {

	private static String staticField = "OuterClass";

	private int privateField;

	protected int protectedField;

	int packageField;

	public int publicField;

	// OuterClass constructor
	public OuterClass(final int i, final int j, final int k, final int l) {
		this.privateField = i;
		this.protectedField = j;
		this.packageField = k;
		this.publicField = l;
	}

	public int getPrivateField() {
		return privateField;
	}

	// static nested class, can access OuterClass static variables/methods
	static class StaticNestedClass {
		private int staticNestedClassPrivateField;
		protected int staticNestedClassProtectedField;
		int staticNestedClassPackageField;
		public int staticNestedClassPublicField;

		public int getA() {
			return staticNestedClassPrivateField;
		}

		public String getName() {
			return staticField;
		}

		@Override
		public String toString() {
			return staticNestedClassPublicField + ", " + staticNestedClassPackageField + ", "
					+ staticNestedClassProtectedField + ", " + staticNestedClassPrivateField + ", " + getName();
		}
	}

	/**
	 * Non-static Inner class can access all the variables/methods of outer class
	 *
	 */
	class NonStaticInnerClass {
		private int w;
		protected int x;
		int y;
		public int z;

		public int getW() {
			return w;
		}

		public void setValues() {
			w = privateField;
			x = protectedField;
			y = packageField;
			z = publicField;
		}

		@Override
		public String toString() {
			return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z + ":name=" + getName();
		}

		public String getName() {
			return staticField;
		}
	}

	/**
	 * Method to hold local inner class
	 * 
	 * @param initial
	 */
	public void print(final String initial) {
		// local inner class inside the method
		class Logger {
			String name;

			/**
			 * @param name
			 */
			public Logger(final String name) {
				this.name = name;
			}

			/**
			 * @param str
			 */
			public void log(final String str) {
				System.out.println(name + ": " + str);
			}

			/**
			 * Local Inner class accessing OuterClass fields
			 */
			public void logAll() {
				System.out.println(privateField + ", " + protectedField + ", " + packageField + ", " + publicField);
				System.out.println(OuterClass.staticField);
			}
		}

		Logger logger = new Logger(initial);
		logger.log(logger.name);
		logger.logAll();

		// method accessing OuterClass fields
		logger.log(staticField);
		logger.log(privateField + ", " + protectedField + ", " + packageField + ", " + publicField);
	}

	/**
	 * Anonymous inner class
	 * 
	 * @param string
	 */
	public void getHello(final String string) {

		// anonymous inner class implementing AnonymousInterface
		new AnonymousInterface() {

			@Override
			public String print(final String string) {
				logAll();
				return string;
			}
		
			/**
			 * Anonymous class accessing OuterClass fields
			 */
			public void logAll() {
				System.out.println(privateField + ", " + protectedField + ", " + packageField + ", " + publicField);
				System.out.println(OuterClass.staticField);
			}
		};
	}
}