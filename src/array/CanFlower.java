package array;

/**
 * 
 * Given a flower bed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Input: flower bed = [1,0,0,0,1], n = 1
 * 
 * Output: True
 * 
 * @author Jigar Gosalia
 *
 */
public class CanFlower {

	public static void main(String[] args) {
		System.out.println(canFlower(new int[] {1,0,0,0,1}, 1));
		System.out.println(canFlower(new int[] {1,0,0,0,0,0,1,0,0,0}, 4));
	}

	public static boolean canFlower(int[] flowerbed, int n) {
		if (flowerbed == null || n <= 0) return false;
		if (flowerbed != null && flowerbed.length == 0 && n > 0) return false;
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			// if empty spot
			if (flowerbed[i] == 0) {
				// check if empty spot has no flowers adjacent to it
				if ((i == 0 || flowerbed[i - 1] == 0) 
						&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
					flowerbed[i] = 1;
					count++;
					if (count >= n) return true;
				}
			}
		}
		return count >= n;
	}
}
