package connected;

/**
 * Use Union-Find of disjointed sets to find connected components in an undirected graph.
 * 
 * @author Jigar Gosalia
 *
 */
public class ConnectedComponentsInUndirectedGraphUnionFind {

	public static int countConnectedComponents(int nodes, int[][] edges) {
		int count = nodes;
		int[] root = new int[nodes];
		// each node is root of itself
		for (int i=0; i<nodes; i++) root[i] = i;
		// union nodes that have same roots
		for (int i=0; i<edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			int xRoot = getRoot(x, root);
			int yRoot = getRoot(y, root);
			if (xRoot != yRoot) {
				count--;
				root[xRoot] = yRoot;
			}
		}
		return count;
	}

	private static int getRoot(int i, int[] root) {
		// if not self root
		while(root[i] != i) {
			// if not self root then root of i is root of i's parent
			root[i] = root[root[i]];
			// i is i's parent
			i = root[i];
		}
		return i;
	}
}
