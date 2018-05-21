package array;

/**
 * find two smallest element in an array
 * 
 * @author Jigar Gosalia
 *
 */
public class TwoSmallestElements {

	public static void main(String[] args) {
		lastTwoSmallestElements(new int[] {12, 12, 1, 13, 10, 34, 1});
	}
	
	public static void lastTwoSmallestElements(int[] a) {
		if (a != null) {
			if (a.length <= 1) {
				return;
			} else if (a.length == 2) {
				System.out.println(a[0] < a[1] ? (a[0] + " " + a[1]) : (a[1] + " " + a[0]));
			} else {
				int min = Math.min(a[0], a[1]);
				int secondLastMin = Math.max(a[0], a[1]);
				for (int i = 2; i < a.length; i++) {
					if (a[i] < min) {
						secondLastMin = min;
						min = a[i];
					} else if (a[i] < secondLastMin && min != a[i]){
						secondLastMin = a[i];
					}
				}
				System.out.println(min + " " + secondLastMin);
			}
		}
	}
}
