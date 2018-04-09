package matrix;

import java.util.Scanner;

/**
 * Sample Matrix program to substitute row 2 and column 4 elements with 0
 *
 * @author "Jigar Gosalia"
 *
 */
public class Matrix {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int row = -1, column = -1;
		int[][] multi = new int[][] { { 1, 1, 2, 3 }, { 2, 2, 1, 4 },
				{ 8, 7, 6, 1 }, { 9, 6, 3, 8 } };

		Scanner scanner = new Scanner(System.in);

		displayMatrix(multi);

		do {
			System.out
					.println("Enter valid row(0-3) that you want to substitue by 0 : ");
			row = scanner.nextInt();
		} while (row < 0 || row > 3);

		do {
			System.out
					.println("Enter the column(0-3) that you want to substitue by 0 : ");
			column = scanner.nextInt();
		} while (column < 0 || column > 3);

		scanner.close();

		substituteMatrix(multi, row, column);

		System.out.println();

		displayMatrix(multi);
	}

	/**
	 * @param array
	 */
	public static void displayMatrix(final int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @param array
	 */
	public static void substituteMatrix(final int[][] array, final int row, final int column) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == row || j == column) {
					array[i][j] = 0;
				}
			}
		}
	}
}
