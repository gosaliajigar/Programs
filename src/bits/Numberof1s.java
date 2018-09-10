package bits;

/**
 * Number of 1s (right shift number and count 1 by checking %2)
 * 
 * @author Jigar Gosalia
 *
 */
public class Numberof1s {

	public static void main(String[] args) {
		System.out.println("11 has 1s  : " + get1s(11));
		System.out.println("7 has 1s   : " + get1s(7));
		System.out.println("16 has 1s  : " + get1s(16));
		System.out.println("8 has 1s   : " + get1s(8));
		System.out.println("256 has 1s : " + get1s(256));
	}

	public static int get1s(int n) {
		// count = n&1;
		int count = n%2;
		while ((n = n >> 1) > 0) {
			count += n%2;
		}
		return count;
	}
}

