package spiral;

import java.util.ArrayList;
import java.util.List;

/**
 * Print matrix in spiral format.
 * 
 * @author Jigar Gosalia
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(printMatrixSpirally(a));
		System.out.println();
		int[][] b = { { 1, 2, 3 } };
		System.out.println(printMatrixSpirally(b));
		System.out.println();
		int[][] c = { { 1 }, { 4 }, { 7 } };
		System.out.println(printMatrixSpirally(c));
		System.out.println();
		a = generateSpiralMatrix(4, 4);
		display(a);
		System.out.println();
		System.out.println(printMatrixSpirally(a));
	}

	public static List<Integer> printMatrixSpirally(int[][] a) {
		List<Integer> spiral = new ArrayList<Integer>();
		if (a != null && a.length > 0 && a[0].length > 0) {
			// rows and columns
			int rows = a.length;
			int columns = a[0].length;

			// row and column pointers / sliders
			int row = 0, column = 0;

			while (rows > 0 && columns > 0) {
				// single row matrix
				if (rows == 1) {
					for (int i = 0; i < columns; i++) spiral.add(a[row][column++]);
					break;
					// single column matrix
				} else if (columns == 1) {
					for (int i = 0; i < rows; i++) spiral.add(a[row++][column]);
					break;
				}
				// top -> right
				for (int i = 0; i < columns - 1; i++) spiral.add(a[row][column++]);
				// right -> bottom
				for (int i = 0; i < rows - 1; i++) spiral.add(a[row++][column]);
				// bottom -> left
				for (int i = 0; i < columns - 1; i++) spiral.add(a[row][column--]);
				// left -> top
				for (int i = 0; i < rows - 1; i++) spiral.add(a[row--][column]);
				row++; column++;
				rows -= 2;
				columns -= 2;
			}
		}
		return spiral;
	}

	public static int[][] generateSpiralMatrix(int rows, int columns) {
		int count = 1;
		int[][] a = new int[rows][columns];
		int row=0, column=0;
		while (rows>0 && columns>0) {
			if (rows==1) {
				for (int i=0; i<columns; i++) a[row][column++] = count++; 
				break;
			} else if (columns==1) {
				for (int i=0; i<columns; i++) a[row++][column] = count++;
				break;
			}
			// top -> right
			for (int i=0; i<columns-1; i++) a[row][column++] = count++;
			// right -> bottom
			for (int i=0; i<rows-1; i++) a[row++][column] = count++;
			// bottom -> left
			for (int i=0; i<columns-1; i++) a[row][column--] = count++;
			// left -> top
			for (int i=0; i<rows-1; i++) a[row--][column] = count++;
			row++; column++;
			rows -= 2;
			columns -= 2;
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
