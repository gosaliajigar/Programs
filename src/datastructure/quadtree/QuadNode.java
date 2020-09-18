package datastructure.quadtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * QuadTrees are trees used to efficiently store data of points on a
 * two-dimensional space. In this tree, each node has at most four children.
 * 
 * Source : https://www.geeksforgeeks.org/quad-tree/
 * http://ericandrewlewis.github.io/how-a-quadtree-works/
 * 
 * @author Jigar Gosalia
 *
 */
public class QuadNode {

	// boundaries
	Coordinate topLeft;
	Coordinate bottomRight;

	// to traverse up
	QuadNode parent;

	// children 4 nodes
	QuadNode upperLeft;
	QuadNode upperRight;
	QuadNode lowerLeft;
	QuadNode lowerRight;

	// to traverse neighbour grids
	QuadNode prev;
	QuadNode next;

	// if node has children, then empty as locations will be part of leaf nodes
	// if leaf node, then filled with locations inside the grid bounded by topLeft
	// and bottomRight
	List<Location> locations = new ArrayList<Location>();

	public QuadNode(QuadNode parent, Coordinate topLeft, Coordinate bottomRight) {
		this.parent = parent;
		this.topLeft = new Coordinate(topLeft.latitude, topLeft.longitude);
		this.bottomRight = new Coordinate(bottomRight.latitude, bottomRight.longitude);
	}

	/**
	 * split into 4 kids i.e. QuadNode
	 * 
	 * 		topLeft	O--------B-------O
	 * 				|		 |		 |
	 * 				|	UL	 |	UR	 |
	 * 				|		 |		 |
	 * 				D--------A-------E
	 * 				|		 |		 |
	 * 				|	LL	 |	LR	 |
	 * 				|		 |		 |
	 * 				O--------C-------O bottomRight
	 * 
	 */
	public void split() {
		// A
		Coordinate middleOfGrid = new Coordinate((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		// B
		Coordinate middleOfUpperLatitude = new Coordinate(this.topLeft.latitude,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		// C
		Coordinate middleOfLowerLatitude = new Coordinate(this.bottomRight.latitude,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		// D
		Coordinate middleOfLeftLongitude = new Coordinate((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				this.topLeft.longitude);

		// E
		Coordinate middleOfRightLongitude = new Coordinate((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				this.bottomRight.longitude);

		// topLeft, A
		this.upperLeft = new QuadNode(this, this.topLeft, middleOfGrid);
		// B, E
		this.upperRight = new QuadNode(this, middleOfUpperLatitude, middleOfRightLongitude);
		// D, C
		this.lowerLeft = new QuadNode(this, middleOfLeftLongitude, middleOfLowerLatitude);
		// A, bottomRight
		this.lowerRight = new QuadNode(this, middleOfGrid, this.bottomRight);
	}

	/**
	 * Insert given new location l into root node.
	 * 
	 * @param root
	 * @param l
	 * @return
	 */
	public static boolean insert(QuadNode root, Location l) {
		// coordinates not in boundary of grid
		if (!inBoundary(root, l.coordinates)) return false;
		// doesn't have children && less than 500 locations so insert in this node
		if (!hasChildren(root) && (root.locations.size() < 500)) {
			root.locations.add(new Location(l.id, l.coordinates.latitude, l.coordinates.longitude));
		} else {
			// doesn't have children && more than 500 locations so split QuadNode
			if (!hasChildren(root)) root.split();
			// populate locations to children
			for (Location location : root.locations) {
				QuadNode cnode = find(root, location.coordinates.latitude, location.coordinates.longitude);
				cnode.locations.add(new Location(location.id, location.coordinates.latitude, location.coordinates.longitude));
			}
			// add new location
			QuadNode cnode = find(root, l.coordinates.latitude, l.coordinates.longitude);
			cnode.locations.add(new Location(l.id, l.coordinates.latitude, l.coordinates.longitude));
			// clear all locations from parent
			root.locations.clear();
		}
		return true;
	}

	private static QuadNode find(QuadNode node, int latitude, int longitude) {
		if (!inBoundary(node, latitude, longitude)) return null;
		if (!hasChildren(node)) return node;
		if (((node.topLeft.latitude + node.bottomRight.latitude)/2) >= latitude) {
			// Indicates upperLeft 
	        if (((node.topLeft.longitude + node.bottomRight.longitude)/2) >= longitude) {
	            return (node.upperLeft == null) ? null : find(node.upperLeft, latitude, longitude); 
	        } else {
		        // Indicates lowerLeft
	        	return (node.lowerLeft == null) ? null : find(node.lowerLeft, latitude, longitude);
	        } 
		} else {
			// Indicates upperRight
	        if (((node.topLeft.latitude + node.bottomRight.latitude)/2) >= latitude) {
	            return (node.upperRight == null) ? null : find(node.upperRight, latitude, longitude); 
	        } else {
		        // Indicates lowerRight
	        	return (node.lowerRight == null) ? null : find(node.lowerRight, latitude, longitude);
	        } 
		}
	}
	
	private static boolean inBoundary(QuadNode node, Coordinate p) {
		return inBoundary(node, p.latitude, p.longitude);
	}

	private static boolean inBoundary(QuadNode node, int latitude, int longitude) {
		return (node != null
				&& node.topLeft != null
				&& latitude >= node.topLeft.latitude
				&& node.bottomRight != null
				&& latitude <= node.bottomRight.latitude
				&& node.topLeft != null
				&& longitude >= node.topLeft.longitude
				&& node.bottomRight != null
				&& longitude <= node.bottomRight.longitude);
	}

	private static boolean hasChildren(QuadNode node) {
		return (node != null 
				&& (node.upperLeft != null
					|| node.upperRight != null
					|| node.lowerLeft != null
					|| node.lowerRight != null));
	}
}