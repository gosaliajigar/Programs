package pojos;

/**
 * @author Jigar Gosalia
 *
 */
public class Trip {
	public String from;
	public String to;
	public int cost;
	public Trip(String from, String to, int cost) {
		this.from = from;
		this.to= to;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "T[" + from + "->" + to + "(" + cost + ")";
	}
}