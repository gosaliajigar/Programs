package matrix;

import java.util.Arrays;

/**
 * @author Jigar Gosalia
 *
 */
public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] a = { { 3, -2, 5 }, { 3, 0, 4 } };
		int[][] b = { { 2, 3 }, { -9, 0 }, { 0, 4 } };
		display(a);
		System.out.println();
		display(b);
		System.out.println();
		int[][] c = multiply(a, b);
		display(c);
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		if (a==null || b==null 
				|| a.length==0 || b.length==0 
				|| a[0].length== 0|| b[0].length==0
				|| a[0].length != b.length)
			return null;
		int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	public static void display(int[][] a) {
		if (a == null) {
			System.out.println("Error");
		}
		for (int[] row : a) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}
