package celebrity;

/**
 * Given node count and edges, find no of sink nodes in graph (all incoming edges).
 * 
 * Source : https://www.geeksforgeeks.org/number-sink-nodes-graph/
 * 
 * O(m+n) : n nodes and m edges
 * 
 * @author Jigar Gosalia
 *
 */
public class NumberOfSinkNodes {
	public static int sinkNodes(int nodesCount, int[][] edges) {
		int[] nodes = new int[nodesCount];
		int sinkNodesCount = 0;
		// increment number when edge start from a node
		for (int i=0; i<edges.length; i++) nodes[edges[i][0]]++;
		// count nodes that do not have any edges starting from
		for (int i=0; i<nodes.length; i++) if (nodes[i] == 0) sinkNodesCount++;
		return sinkNodesCount;
	}

	public static void main(String[] args) {
		//				0
		//		1				3
		//		\				/
		//			\		/
		//				2
		//
		System.out.println(sinkNodes(4, new int[][] {{1, 2}, {3, 2}}));
	}
}
