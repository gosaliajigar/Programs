package maze;

/**
 * @author Jigar Gosalia
 *
 */
public class Maze {

	public static void main(String[] args) {
		int[][] a = {
				{1,1,1,0,1,1,0,0,0,1,1,1,1},
				{1,0,1,1,1,0,1,1,1,1,0,0,1},
				{0,0,0,0,1,0,1,0,1,0,1,0,0},
				{1,1,1,0,1,1,1,0,1,0,1,1,1},
				{1,0,1,0,0,0,0,1,1,1,0,0,1},
				{1,0,1,1,1,1,1,1,0,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1},
				};
		System.out.println(traverse(a, 0, 0));
		System.out.println();
		display(a);
	}

	public static boolean traverse(int[][] a, int r, int c) {
		boolean done = false;
		if (isValid(a, r, c)) {
			a[r][c] = 3;									// visited
			if (isEnd(a, r, c)) { done = true;
			} else {
				done = traverse(a, r+1, c);					// right
				if (!done) done = traverse(a, r-1, c);		// left
				if (!done) done = traverse(a, r, c+1);		// down
				if (!done) done = traverse(a, r, c-1);		// up
			}
		}
		if (done) a[r][c] = 7;								// chosen
		return done;
	}

	public static boolean isValid(int[][] a, int r, int c) {
		return (r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == 1);
	}

	public static boolean isEnd(int[][] a, int r, int c) { return (r == a.length-1 && c == a[0].length-1); };
	
	public static void display(int[][] a) {
		for (int[] row : a) {
			for (int i : row) System.out.print(i + " ");
			System.out.println();
		}
	}
}
