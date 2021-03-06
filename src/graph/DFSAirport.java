package graph;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import pojos.Trip;

/**
 * 
 * 
 * 
 * Europe 	-Swiss(150) 	- China(1000)<br>
 * 			- Japan(300) - China(120)<br>
 * - Indonesia(50) - Japan(55)<br>
 * - China(65)<br>
 * -Istanbul(1100) - Thailand(200) - China(200)<br>
 * -Thailand(400) - China(200)<br>
 * <br>
 * 
 * P-L-T (150 + 1000 = 1150)<br>
 * P-L-B-T (150 + 300 + 120 = 570)<br>
 * P-I-D-T (1100 + 200 + 200 = 1500)<br>
 * P-D-T (400 + 200 = 600)<br>
 * 
 * P-L-B-S-T (150 + 300 + 50 + 65 = 565)<br>
 * 
 * 
 * @author Jigar Gosalia
 *
 */
public class DFSAirport {

	// flights [n][3]	==> from, to, price
	private static String[][] flights = { { "Europe", "Swiss", "150" }, { "Europe", "Istanbul", "1100" },
			{ "Europe", "Thailand", "400" }, { "Swiss", "China", "1000" }, { "Istanbul", "Thailand", "200" },
			{ "Thailand", "China", "200" }, { "Japan", "Indonesia", "50" }, { "Indonesia", "Japan", "55" },
			{ "Swiss", "Japan", "300" }, { "Japan", "China", "120" }, { "Indonesia", "China", "65" }, };

	public static Comparator<Trip> sortByPrices = new Comparator<Trip>() {
		@Override
		public int compare(Trip o1, Trip o2) {
			return o1.cost - o2.cost;
		}
	};

	public static void main(String[] args) {
		List<List<Trip>> routes = cheapDFS(flights, 4, "Europe", "China");
		System.out.println("All routes from Europe to China (max 4 flights):");
		routes.forEach(System.out::println);
		System.out.println();
		System.out.println(getCheapest(routes));
	}

	public static List<List<Trip>> cheapDFS(String[][] flights, int maxConnections, String source, String destination) {
		Map<String, PriorityQueue<Trip>> map = getMap(flights);
		Trip trip = map.get(source).peek();

		List<List<Trip>> results = new ArrayList<List<Trip>>();
		List<Trip> curr = new ArrayList<Trip>();
		curr.add(trip);
		dfs(destination, maxConnections, trip, curr, results, map);
		return results;
	}

	private static void dfs(String destination, int k, Trip trip, List<Trip> curr, List<List<Trip>> results, Map<String, PriorityQueue<Trip>> map) {
		if (curr.size() >= k && !trip.to.equals(destination)) return;
		if (curr.size() <= k && trip.to.equals(destination)) {
			results.add(new ArrayList<Trip>(curr));
			return;
		}
		// check if any connections from destination of last trip
		if (map.get(trip.to) != null && map.get(trip.to).size() > 0) {
			for (Trip t : map.get(trip.to)) {
				curr.add(t);
				dfs(destination, k, t, curr, results, map);
				curr.remove(curr.size() - 1);
			}
		}
	}

	private static Map<String, PriorityQueue<Trip>> getMap(String[][] flights) {
		Map<String, PriorityQueue<Trip>> map = new HashMap<String, PriorityQueue<Trip>>();
		for (String[] flight : flights) {
			map.computeIfAbsent(flight[0], key -> new PriorityQueue<Trip>(sortByPrices)).add(new Trip(flight[0], flight[1], Integer.valueOf(flight[2])));
		}
		return map;
	}

	private static List<Trip> getCheapest(List<List<Trip>> list) {
		PriorityQueue<List<Trip>> queue = new PriorityQueue<List<Trip>>(new Comparator<List<Trip>>() {
			@Override
			public int compare(List<Trip> o1, List<Trip> o2) {
				int sumo1 = 0, sumo2 = 0;
				for (Trip t : o1) sumo1 += t.cost;
				for (Trip t : o2) sumo2 += t.cost;
				return sumo1-sumo2;
			}
		});
		for (List<Trip> trip : list) {
			queue.offer(trip);
		}
		return queue.poll();
	}
}