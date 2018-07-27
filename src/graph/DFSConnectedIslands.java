package graph;

/**
 * @author Jigar Gosalia
 *
 */
public class DFSConnectedIslands {

	// Arrays to get row and column numbers of 8 neighbors of a given cell
	private static int rowNbr[] = new int[] { -1, -1, -1,  0, 0,  1, 1, 1 };
	private static int colNbr[] = new int[] { -1,  0,  1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		int[][] a = new int[][] {
									{1, 1, 0, 0, 0},
						            {0, 1, 0, 0, 1},
						            {1, 0, 0, 1, 1},
						            {0, 0, 0, 0, 0},
						            {1, 0, 1, 0, 1}
					            };
		System.out.println(connected(a));
	}

	public static int connected(int[][] a) {
		boolean visited[][] = new boolean[a.length][a[0].length];
		int count = 0;
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a[0].length; ++j) {
				// cell with value 1 is not visited yet, then new island found, Visit all
				// cells in this island and increment island count
				if (a[i][j] == 1 && !visited[i][j]) {
					dfs(a, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int a[][], int r, int c, boolean visited[][]) {
		// Mark this cell as visited
		visited[r][c] = true;

		// Recur for all connected neighbors
		for (int k = 0; k < rowNbr.length; ++k)
			if (isSafe(a, r + rowNbr[k], c + colNbr[k], visited))
				dfs(a, r + rowNbr[k], c + colNbr[k], visited);
	}

	public static boolean isSafe(int a[][], int r, int c, boolean visited[][]) {
		return (r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == 1 && !visited[r][c]);
	}
}
