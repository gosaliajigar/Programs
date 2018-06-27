package celebrity;

/**
 * 
 * Source : https://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * @author Jigar Gosalia
 *
 */
public class Celebrity {

	private static int MATRIX[][] = { { 0, 0, 1, 0 }, 
									  { 0, 0, 1, 0 },
									  { 0, 0, 0, 0 },
									  { 0, 0, 1, 0 } };

	// Returns true if a knows b, false otherwise
	private static boolean knows(int a, int b) {
		return (MATRIX[a][b] == 1);
	}

	// Returns -1 if celebrity is not present. If present,
	// returns id (value from 0 to n-1).
	public static int findCelebrity(int n) {
		int a = 0, b = n-1;

		// find a that doesn't know b
		while (a < b) {
			if (knows(a, b)) a++;
			else b--;
		}

		// Check if a is actually a celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't know 'a' or 'a' knows any person, return -1
			if (i != a && (knows(a, i) || !knows(i, a))) return -1;
		}
		return a;
	}

	public static void main(String[] args) {
		int result = findCelebrity(4);
		System.out.println((result == -1) ? "No Celebrity" : "Celebrity #" + result);
	}
}