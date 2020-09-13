package graph;

import java.util.Arrays;

/**
 * Use Union-Find of disjointed sets to find connected components in an undirected graph.
 * 
 * 							1				5
 * 						/		\		/		\	
 * 						2		3		6		7
 * 
 * 
 * 						0			4
 * 
 * 
 * edges[][] = {{1, 2}, {1, 3}, {5, 6}, {5, 7}}
 * 
 * root[] = 0, 1, 2, 3, 4, 5, 6, 7
 * 
 * count = 8
 * 
 * Processing:
 * 	{1, 2}		xRoot=root[1]=1; yRoot=root[2]=2 ==> root[] =  0, 2, 2, 3, 4, 5, 6, 7 & count=7
 * 	{1, 3}		xRoot=root[1]=2; yRoot=root[3]=3 ==> root[] =  0, 2, 3, 3, 4, 5, 6, 7 & count=6
 * 	{5, 6}		xRoot=root[5]=5; yRoot=root[6]=6 ==> root[] =  0, 2, 3, 3, 4, 6, 6, 7 & count=5
 *  {5, 7}		xRoot=root[5]=6; yRoot=root[7]=7 ==> root[] =  0, 2, 3, 3, 4, 6, 7, 7 & count=4
 * 
 * @author Jigar Gosalia
 *
 */
public class UnionFindConnectedComponentsInUndirectedGraph {

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
			System.out.println(Arrays.toString(root));
		}
		return count;
	}

	/**
	 * Traverse up the tree using node and its parent info.
	 * 
	 * @param node
	 * @param root
	 * @return
	 */
	private static int getRoot(int node, int[] root) {
		// if not self root
		while(root[node] != node) {
			// if not self root then root of node is root of node's parent
			root[node] = root[root[node]];
			// node is node's parent
			node = root[node];
		}
		return node;
	}

	public static void main(String[] args) {
		int edges[][] = {{1, 2}, {1, 3}, {5, 6}, {5, 7}};
		System.out.println(countConnectedComponents(8, edges));
	}
}
