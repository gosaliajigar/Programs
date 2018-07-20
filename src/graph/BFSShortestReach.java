package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find Shortest Path between 2 nodes using BFS.
 * 
 * Source : https://www.youtube.com/watch?v=0XgVhsMOcQM 
 * 
 * @author Jigar Gosalia
 *
 */
public class BFSShortestReach {
	private static Node[] nodes;
	public static int[] shortestReach(int startId, int n) {
		int[] distances = new int[n];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startId);
		distances[startId] = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbour : nodes[node].neighbours) {
				if (distances[neighbour] != -1) {
					queue.add(neighbour);
					distances[neighbour] = distances[node]+1;
				}
			}
		}
		return distances;
	}
}

class Node {
	List<Integer> neighbours;
}