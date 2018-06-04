package graphs.algorithm;

/**
 * @author Jigar Gosalia
 *
 */
public class Dijkstra {

	// Dijkstra is Single Source shortest paths from a give source without negative paths
	// Dijkstra is BFS without weights
	//
	// O(V)*EXTRACT-MIN + O(E)*DECREASE-KEY
	// 
	// d[s] = 0
	// for each v in V-{s}
	//  	do d[v] = Integer.MAX_VALUE (infinite)
	// S = null
	// Q = V (min priority queue)
	// while !Q.isEmpty()
	//		do u = EXTRACT_MIN(Q)
	//			S = S union {u}
	//			for each v in Adj[u]
	//				do if d[v] > d[u] + w(u, v)
	//					then d[v] = d[u] + w(u, v)	==> RELAX EDGE
	//
	//
	// Array 			: O(V^2)
	// Binary Heap		: O(E*logV)
	// Fibonacci Heap	: O(E+VlogV)

}
