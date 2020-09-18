package datastructure.quadtree;

/**
 * 
 * - Latitudes range from 0 to 90
 * - The valid range of latitude in degrees is -90 and +90 for the southern and northern hemisphere respectively
 * - Longitudes range from 0 to 180
 * - Longitude is in the range -180 and +180 specifying coordinates west and east of the Prime Meridian respectively
 * 
 * @author Jigar Gosalia
 *
 */
public class Coordinate {
	public int latitude;
	public int longitude;

	public Coordinate(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
}