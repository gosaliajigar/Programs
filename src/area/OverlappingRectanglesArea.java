package area;

import pojos.Point;

/**
 * 
 * Source : https://www.geeksforgeeks.org/total-area-two-overlapping-rectangles/
 * 
 * @author Jigar Gosalia
 *
 */
public class OverlappingRectanglesArea {

	public static void main(String[] args) {
		Point l1 = new Point(2, 2), r1 = new Point(5, 7);
		Point l2 = new Point(3, 4), r2 = new Point(6, 9);
		System.out.println(overlappingArea(l1, r1, l2, r2));
		System.out.println();
		l1 = new Point(2, 1); r1 = new Point(5, 5);
	    l2 = new Point(3, 2); r2 = new Point(5, 7);
	    System.out.println(overlappingArea(l1, r1, l2, r2));
	}

	public static int overlappingArea(Point l1, Point r1, Point l2, Point r2) {
		// Area of 1st Rectangle
		int area1 = (r1.x - l1.x) * (r1.y - l1.y);
		// Area of 2nd Rectangle
		int area2 = (r2.x - l2.x) * (r2.y - l2.y);
		// Area of intersection
		int areaI = (Math.min(r1.x, r2.x) - Math.max(l1.x, l2.x)) * (Math.min(r1.y, r2.y) - Math.max(l1.y, l2.y));
		System.out.println("A1:" + area1 + ";A2:" + area2 + ";AI:" + areaI);
		if (area1<0 || area2<0 || areaI<0) throw new IllegalArgumentException("No intersection");
		return (area1 + area2 - areaI);
	}
}
