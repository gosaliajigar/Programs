package maze;

/**
 * Maze Traversal from top-left to bottom-right.
 * 
 * @author Jigar Gosalia
 *
 */
public class Maze {

	public static final int UNVISITED = 1;
	public static final int VISITED = 3;
	public static final int CHOSEN = 7;
	
	public static void main(String[] args) {
		int[][] a = {
					{1,1,1,0,1,1,0,0,0,1,1,1,1},
					{1,0,1,1,1,0,1,1,1,1,0,0,1},
					{0,0,0,0,1,0,1,0,1,0,1,0,0},
					{1,1,1,0,1,1,1,0,1,0,1,1,1},
					{1,0,1,0,0,0,0,1,1,1,0,0,1},
					{1,0,1,1,1,1,1,1,0,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,1}
					};
		System.out.println(traverse(a, 0, 0));
		System.out.println();
		display(a);
	}

	public static boolean traverse(int[][] a, int r, int c) {
		boolean reached = false;
		if (canMove(a, r, c)) {
			a[r][c] = VISITED;										// visited
			if (haveReached(a, r, c)) {
				reached = true;
			} else {
				reached = traverse(a, r+1, c);						// right
				if (!reached) reached = traverse(a, r-1, c);		// left
				if (!reached) reached = traverse(a, r, c+1);		// down
				if (!reached) reached = traverse(a, r, c-1);		// up
			}
			a[r][c] = UNVISITED;									// reset visited bit
		}
		if (reached) a[r][c] = CHOSEN;								// chosen
		return reached;
	}

	public static boolean canMove(int[][] a, int r, int c) {
		return (r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == UNVISITED);
	}

	public static boolean haveReached(int[][] a, int r, int c) { return (r == a.length-1 && c == a[0].length-1); };
	
	public static void display(int[][] a) {
		for (int[] row : a) {
			for (int i : row) System.out.print(i + " ");
			System.out.println();
		}
	}
}
