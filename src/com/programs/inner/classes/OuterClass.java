package com.programs.inner.classes;

/**
 * @author "Jigar Gosalia"
 *
 */
public class OuterClass {

	private static String name = "OuterClass";
	private int i;
	protected int j;
	int k;
	public int l;

	// OuterClass constructor
	public OuterClass(final int i, final int j, final int k, final int l) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.l = l;
	}

	public int getI() {
		return i;
	}

	// static nested class, can access OuterClass static variables/methods
	static class StaticNestedClass {
		private int a;
		protected int b;
		int c;
		public int d;

		public int getA() {
			return a;
		}

		public String getName() {
			return name;
		}
	}

	// inner class, non static and can access all the variables/methods of outer
	// class
	class InnerClass {
		private int w;
		protected int x;
		int y;
		public int z;

		public int getW() {
			return w;
		}

		public void setValues() {
			w = i;
			x = j;
			y = k;
			z = l;
		}

		@Override
		public String toString() {
			return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z;
		}

		public String getName() {
			return name;
		}
	}

	// local inner class
	public void print(final String initial) {
		// local inner class inside the method
		class Logger {
			String name;

			public Logger(final String name) {
				this.name = name;
			}

			public void log(final String str) {
				System.out.println(name + ": " + str);
			}
		}

		Logger logger = new Logger(initial);
		logger.log(name);
		logger.log("" + i);
		logger.log("" + j);
		logger.log("" + k);
		logger.log("" + l);
	}

	// anonymous inner class
	public void getHello(final String string) {

		// anonymous inner class implementing AnonymousInterface
		new AnonymousInterface() {

			@Override
			public String print(final String string) {
				return string;
			}
		};
	}
}