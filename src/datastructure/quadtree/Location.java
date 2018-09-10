package datastructure.quadtree;

/**
 * @author Jigar Gosalia
 *
 */
public class Location {

	public int id;
	public Coordinate coordinates;

	public Location(int id, Coordinate coordinates) {
		this(0, coordinates.latitude, coordinates.longitude);
	}

	public Location(int latitude, int longitude) {
		this(0, latitude, longitude);
	}

	public Location(Coordinate coordinates) {
		this(0, coordinates.latitude, coordinates.longitude);
	}

	public Location(int id, int latitude, int longitude) {
		this.id = id;
		this.coordinates = new Coordinate(latitude, longitude);
	}

	public void setId(int id) { this.id = id; }
}
