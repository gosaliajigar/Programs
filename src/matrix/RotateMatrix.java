package matrix;

/**
 * Rotate Matrix by 90 degrees.
 * 
 * row    0-n/2
 * column 0-ceil(n/2.0)
 * 
 * relationship a[i][j] = a[n-1-j][i]
 * 
 * @author "Jigar Gosalia"
 *
 */
public class RotateMatrix {

	private static final int SIZE = 4;

	public static void main(String[] args) {
		int[][] matrix = new int[SIZE][SIZE];
		populate(matrix);
		display(matrix);
		System.out.println();
		rotate(matrix);
		System.out.println();
		display(matrix);
	}

	/**
	 * @param matrix
	 */
	private static void populate(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				matrix[x][y] = (int) Math.round((Math.random() * 10) % 9);
			}
		}
	}

	/**
	 * @param matrix
	 */
	private static void display(int[][] matrix) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 */
	private static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			return;
		}
		int n = matrix.length;
		// layer stands for range of possible x-coordinate of matrix during rotation
		for (int x = 0; x < (n / 2); x++) {
			// first stands for starting x and y coordinate of elements
			int first = x;
			// last stands for ending x and y coordinate of elements
			int last = n - 1 - x;
			// y stands for range of possible y-coordinate of matrix during rotation
			for (int y = first; y < last; y++) {
				int shift = y - first;
				int top = matrix[first][y];
				// top = left
				matrix[first][y] = matrix[last - shift][first];
				// left = bottom
				matrix[last - shift][first] = matrix[last][last - shift];
				// bottom = right
				matrix[last][last - shift] = matrix[y][last];
				// right = top
				matrix[y][last] = top;
			}
		}
	}
}
