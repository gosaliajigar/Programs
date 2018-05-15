package intervals;

public class PrintRanges {

	public static void main(String[] args) {
		printRanges(new int[] { 0, 1, 3, 3, 8 });
		System.out.println();
		printRanges(new int[] { 0, 8, 8, 8 });
	}

	public static void printRanges(int[] a) {
		int start = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1] + 1 || a[i] == a[i - 1]) {
				continue;
			} else {
				System.out.printf(start + "-" + a[i - 1] + " ");
				start = a[i];
			}
			if (i == a.length - 1) {
				System.out.printf(start + "-" + a[a.length - 1] + " ");
			}
		}
	}
}
