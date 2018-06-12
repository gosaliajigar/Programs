package maze;

/**
 * @author Jigar Gosalia
 *
 */
public class Maze {

	private static int[][] a = {
								{1,1,1,0,1,1,0,0,0,1,1,1,1},
								{1,0,1,1,1,0,1,1,1,1,0,0,1},
								{0,0,0,0,1,0,1,0,1,0,1,0,0},
								{1,1,1,0,1,1,1,0,1,0,1,1,1},
								{1,0,1,0,0,0,0,1,1,1,0,0,1},
								{1,0,1,1,1,1,1,1,0,1,1,1,1},
								{1,0,0,0,0,0,0,0,0,0,0,0,0},
								{1,1,1,1,1,1,1,1,1,1,1,1,1},
								};

	public static void main(String[] args) {
		System.out.println(traverse(0, 0));
		display(a);
	}

	public static boolean traverse(int r, int c) {
		boolean done = false;
		if (isValid(r, c)) {
			a[r][c] = 3;
			if (isEnd(r, c)) {
				done = true;
			} else {
				done = traverse(r+1, c);
				if (!done) done = traverse(r-1, c);
				if (!done) done = traverse(r, c+1);
				if (!done) done = traverse(r, c-1);
			}
		}
		if (done) a[r][c] = 7;
		return done;
	}

	public static boolean isValid(int r, int c) {
		return (r >= 0 && r < a.length && c >= 0 && c < a[0].length && a[r][c] == 1);
	}

	public static boolean isEnd(int r, int c) { return (r == a.length-1 && c == a[0].length-1); };
	
	public static void display(int[][] a) {
		for (int[] row : a) {
			for (int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
}
