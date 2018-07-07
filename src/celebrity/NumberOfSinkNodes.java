package celebrity;

/**
 * 
 * Source : https://www.geeksforgeeks.org/number-sink-nodes-graph/
 * 
 * O(m+n) : n nodes and m edges
 * 
 * @author Jigar Gosalia
 *
 */
public class NumberOfSinkNodes {

	public static void main(String[] args) {
		
	}

	public static int sinkNodes(int nodesCount, int[][] edges) {
		int[] nodes = new int[nodesCount];
		int count = 0;
		// increment number when edge start from a node
		for (int i=0; i<edges.length; i++) nodes[edges[i][0]]++;
		// count nodes that do not have any edges starting from
		for (int i=0; i<nodes.length; i++) if (nodes[i] == 0) count++;
		return count;
	}
}
