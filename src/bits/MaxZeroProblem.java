package bits;

/**
 * Twitter Codility Problem Max binary gap
 * 
 * @author Jigar Gosalia
 *
 */
public class MaxZeroProblem {

	public static void main(String[] args) {
		System.out.println(maxGap(2));
		System.out.println(maxGap(5));
		System.out.println(maxGap(9));
		System.out.println(maxGap(17));
		System.out.println(maxGap(273));
		System.out.println(maxGap(265));
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
			n = n >> 1;
		}
		return max;
	}
}
