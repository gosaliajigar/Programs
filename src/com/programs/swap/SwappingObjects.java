package com.programs.swap;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SwappingObjects {

	class Point {

		/**
		 *
		 */
		private int x;

		/**
		 *
		 */
		private int y;

		/**
		 * @param x
		 * @param y
		 */
		public Point(final int x, final int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SwappingObjects s = new SwappingObjects();
		Point A = s.new Point(0, 0);
		Point B = s.new Point(10, 10);
		swapShallowCopy(A, B);
		System.out.println("A.x:" + A.x + " " + "A.y:" + A.y);
		System.out.println("B.x:" + B.x + " " + "B.y:" + B.y);
		System.out.println();
		swapDeepCopy(A, B);
		System.out.println("A.x:" + A.x + " " + "A.y:" + A.y);
		System.out.println("B.x:" + B.x + " " + "B.y:" + B.y);
	}

	/**
	 * @param a
	 * @param b
	 */
	private static void swapShallowCopy(Point a, Point b) {
		System.out.println("Shallow Copy ...");
		Point temp = a;
		a = b;
		b = temp;
	}

	/**
	 * @param a
	 * @param b
	 */
	private static void swapDeepCopy(final Point a, final Point b) {
		System.out.println("Deep Copy ...");
		int temp = a.x;
		a.x = b.x;
		b.x = temp;

		temp = a.y;
		a.y = b.y;
		b.y = temp;
	}
}
