package spiral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jigar Gosalia
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralMatrix(a));
		int[][] b = { { 1, 2, 3 } };
		System.out.println(spiralMatrix(b));
		int[][] c = { { 1 }, { 4 }, { 7 } };
		System.out.println(spiralMatrix(c));
		System.out.println();
		a = generateSpiral(4, 4);
		display(a);
		System.out.println(spiralMatrix(a));
	}

	public static List<Integer> spiralMatrix(int[][] a) {
		List<Integer> spiral = new ArrayList<Integer>();
		if (a != null && a.length > 0 && a[0].length > 0) {
			// rows and columns
			int rows = a.length;
			int columns = a[0].length;

			// row and column pointers / sliders
			int x = 0, y = 0;

			while (rows > 0 && columns > 0) {
				if (rows == 1) {
					for (int i = 0; i < columns; i++) {
						spiral.add(a[x][y++]);
					}
					break;
				} else if (columns == 1) {
					for (int i = 0; i < rows; i++) {
						spiral.add(a[x++][y]);
					}
					break;
				}
				// top -> right
				for (int i = 0; i < columns - 1; i++) {
					spiral.add(a[x][y++]);
				}

				// right -> bottom
				for (int i = 0; i < rows - 1; i++) {
					spiral.add(a[x++][y]);
				}

				// bottom -> left
				for (int i = 0; i < columns - 1; i++) {
					spiral.add(a[x][y--]);
				}

				// left -> top
				for (int i = 0; i < rows - 1; i++) {
					spiral.add(a[x--][y]);
				}
				x++; y++;
				rows = rows - 2;
				columns = columns - 2;
			}
		}
		return spiral;
	}

	public static int[][] generateSpiral(int row, int column) {
		int count = 1;
		int[][] a = new int[row][column];
		int m=row, n=column, x=0, y=0;
		while (m>0 && n>0) {
			if (m==1) {
				for (int i=0; i<n; i++) a[x][y++] = count++; 
				break;
			} else if (n==1) {
				for (int i=0; i<m; i++) a[x++][y] = count++;
				break;
			}
			// left to right
			for (int i=0; i<n-1; i++) a[x][y++] = count++;
			// right to bottom
			for (int i=0; i<m-1; i++) a[x++][y] = count++;
			// bottom to left
			for (int i=0; i<n-1; i++) a[x][y--] = count++;
			// left to top
			for (int i=0; i<m-1; i++) a[x--][y] = count++;
			x++; y++;
			m=m-2;
			n=n-2;
		}
		return a;
	}

	private static void display(int[][] a) {
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				System.out.printf("%4d ", a[i][j]);
			}
			System.out.println();
		}
	}
}
