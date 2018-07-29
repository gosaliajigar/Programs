package graph;

/**
 * Count connected cells in a matrix
 * 
 * Source : https://www.youtube.com/watch?v=R4Nh-EgWjyQ
 * https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
 * 
 * @author Jigar Gosalia
 *
 */
public class DFSConnectedCells {

	private static int[] rowNbr = new int[] { -1, -1, -1,  0, 0,  1, 1, 1 };
	private static int[] colNbr = new int[] { -1,  0,  1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		int[][] a = new int[][] { 	{0,0,0,1,1,0,0},
									{0,1,0,0,1,1,0},
									{1,1,0,1,0,0,1},
									{0,0,0,0,0,1,0},
									{1,1,0,0,0,0,0},
									{0,0,0,1,0,0,0}
								};
		System.out.println(getBiggestRegion(a));
	}
	
	public static int getBiggestRegion(int[][] a) {
		int max = Integer.MIN_VALUE;
		boolean[][] visited = new boolean[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1 && !visited[i][j]) {
					int size = dfs(a, i, j, visited);
					max = Math.max(max, size);
				}
			}
		}
		return max;
	}

	public static int dfs(int[][] a, int i, int j, boolean[][] visited) {
		int size = 1;
		visited[i][j] = true;
		for (int k=0; k<rowNbr.length; k++) {
			if (isSafe(a, i+rowNbr[k], j+colNbr[k], visited)) {
				size += dfs(a, i+rowNbr[k], j+colNbr[k], visited);
			}
		}
		return size;
	}

	public static boolean isSafe(int[][] a, int i, int j, boolean[][] visited) {
		return (i>=0 && i<a.length && j>=0 && j<a[0].length && a[i][j]==1 && !visited[i][j]);
	}
}
