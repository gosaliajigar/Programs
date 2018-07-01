package medians;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * You have election data and you need to display the winner of the election data.
 * 
 * @author Jigar Gosalia
 *
 */
public class Election {

	public static void main(String[] args) {
		Map<Integer, Candidate> map = new HashMap<Integer, Candidate>();
		for (int i=0; i < 5; i++) {
			map.put(i, new Candidate(i, 0));
		}

		Scanner scanner = new Scanner(System.in);
		while(true) {
			int id = scanner.nextInt();
			if (map.containsKey(id)) {
				map.get(id).incrementCount();
				getWinner(map);
				getWinnerJava8(map);
			} else {
				// terminate when vote for unknown candidate received
				break;
			}
		}
		scanner.close();
	}

	private static void getWinner(Map<Integer, Candidate> map) {
		Queue<Candidate> electionQueue = new PriorityQueue<Candidate>(new Comparator<Candidate>() {
			@Override
			public int compare(Candidate o1, Candidate o2) {
				return o2.getCount() - o1.getCount();
			}
		});
		for (Integer key : map.keySet()) {
			electionQueue.offer(map.get(key));	
		}
		while (!electionQueue.isEmpty()) {
			System.out.print(electionQueue.poll() + " ");
		}
		System.out.println();
	}

	private static void getWinnerJava8(Map<Integer, Candidate> map) {
		Map<Integer, Candidate> sortedMap = 
			     map.entrySet()
			     .stream()
			     .sorted(Entry.comparingByValue())
			     .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedMap);
	}
}

class Candidate implements Comparable<Candidate> {
	private int id;
	private int count;
	public Candidate(int id) { this.id = id; }
	public Candidate(int id, int count) { this.id = id; this.count = count; }
	public int getId() { return this.id; }
	public int getCount() { return this.count; }
	public void incrementCount() { this.count++; }
	@Override
	public String toString() { return this.id + ":" + this.count; }
	@Override
	public boolean equals(Object obj) {	return this.id == ((Candidate) obj).id;	}
	@Override
	public int hashCode() { return this.id;	}
	@Override
	public int compareTo(Candidate c) {
		return c.getCount() - this.getCount();
	}
}