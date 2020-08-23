package bits;

/**
 * Twitter Codility Problem Max binary gap
 * 
 * @author Jigar Gosalia
 *
 */
public class MaxZeroProblem {

	public static void main(String[] args) {
		int[] a = {2,5,9,17,273,265};
		for (int i : a) {
			System.out.printf("%-20s - %d\n", toBinary(i), maxGap(i));
		}
	}

	public static int maxGap(int n) {
		int count = -1, max = 0;
		while (n > 0) {
			// very important as it will set count=0 only
			// if first 1 encountered (e.g. 2, 8, 16)
			if ((n & 1) == 1) {
				max = Math.max(count, max);
				count = 0;
			}
			if ((n & 1) == 0 && count >= 0) {
				count++;
			}
			n >>= 1;
		}
		return max;
	}

	public static String toBinary(int i) {
		StringBuilder binary = new StringBuilder();
		while (i > 0) {
			binary.append(i%2);
			i /= 2;
		}
		return binary.reverse().toString();
	}
}
