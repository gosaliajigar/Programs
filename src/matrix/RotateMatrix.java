package matrix;

/**
 * Rotate Matrix by 90 degrees.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class RotateMatrix {

	private static final int SIZE = 4;

	/**
	 * @param args
	 */
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
		int n = matrix.length;
		// x stands for range of possible x-coordinate of matrix during rotation
		for (int x = 0; x < (n / 2); x++) {
			// start stands for starting x and y coordinate of elements
			int start = x;
			// end stands for ending x and y coordinate of elements
			int end = n - x - 1;
			// y stands for range of possible y-coordinate of matrix during
			// rotation
			for (int y = start; y < end; y++) {
				int shift = y - start;
				int temp = matrix[start][y];
				matrix[start][y] = matrix[end - shift][start];
				matrix[end - shift][start] = matrix[end][end - shift];
				matrix[end][end - shift] = matrix[y][end];
				matrix[y][end] = temp;
			}
		}
	}
}
