package datastructure.quadtree;

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
	Coordinates topLeft;
	Coordinates bottomRight;

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
	
	public QuadNode(QuadNode parent, Coordinates topLeft, Coordinates bottomRight) {
		this.parent = parent;
		this.topLeft = new Coordinates(topLeft.latitude, topLeft.longitude);
		this.bottomRight = new Coordinates(bottomRight.latitude, bottomRight.longitude);
	}

	/**
	 * split into 4 kids i.e. QuadNode
	 */
	public void split() {
		Coordinates middleOfGrid = new Coordinates((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		Coordinates middleOfUpperLatitude = new Coordinates(this.topLeft.latitude,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		Coordinates middleOfLowerLatitude = new Coordinates(this.bottomRight.latitude,
				(this.topLeft.longitude + this.bottomRight.longitude) / 2);

		Coordinates middleOfLeftLongitude = new Coordinates((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				this.topLeft.longitude);

		Coordinates middleOfRightLongitude = new Coordinates((this.topLeft.latitude + this.bottomRight.latitude) / 2,
				this.bottomRight.longitude);

		this.upperLeft = new QuadNode(this, this.topLeft, middleOfGrid);
		this.upperRight = new QuadNode(this, middleOfUpperLatitude, middleOfRightLongitude);
		this.lowerLeft = new QuadNode(this, middleOfLeftLongitude, middleOfLowerLatitude);
		this.lowerRight = new QuadNode(this, middleOfGrid, this.bottomRight);
	}
}