package graph.algorithms;

/**
 * @author Jigar Gosalia
 *
 */
public class Dijkstra {
	// Dijkstra is Single Source shortest paths from a given source without negative paths
	// Dijkstra is BFS without weights
	//
	// O(V)*EXTRACT-MIN + O(E)*DECREASE-KEY
	// 
	// d[s] = 0
	// for each v in V-{s}
	//  	do d[v] = Integer.MAX_VALUE (infinite)				// d[v] is distance of node v from s
	// S = null
	// Q = V (min priority queue)
	// while !Q.isEmpty()
	//		do u = EXTRACT_MIN(Q)								// extracts the node which is closest to s
	//			S = S union {u}
	//			for each v in Adj[u]							// relax all edges leaving from u
	//				do if d[v] > d[u] + w(u, v)					// if d[v] is greater than path from u then relax
	//					then d[v] = d[u] + w(u, v)				==> RELAX EDGE
	//
	//
	// Array 			: O(V^2)					: EXTRACT-MIN = V		& DECREASE-KEY = 1
	// Binary Heap		: O(ElogV)					: EXTRACT-MIN = logV 	& DECREASE-KEY = logV
	// Fibonacci Heap	: O(E+VlogV)				: EXTRACT-MIN = logV	& DECREASE-KEY = 1
}
