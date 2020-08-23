package array;

import java.util.Arrays;

/**
 * 
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example: Input: [1,2,3,4] Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ProductExceptItself {

	public static void main(String[] args) {
		ProductExceptItself.productExceptSelf(new int[] { 1, 2, 3, 4, 5, 6 });
	}

	public static void productExceptSelf(int[] nums) {
		int[] l = new int[nums.length];
		int[] r = new int[nums.length];
		int[] o = new int[nums.length];
		// initialize left's 1st element and right's last element
		l[0] = r[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			l[i] = nums[i - 1] * l[i - 1];
		}
		for (int j = nums.length - 2; j >= 0; j--) {
			r[j] = nums[j + 1] * r[j + 1];
		}
		for (int i = 0; i < o.length; i++) {
			o[i] = l[i] * r[i];
		}
		System.out.println("L:" + Arrays.toString(l));
		System.out.println("R:" + Arrays.toString(r));
		System.out.println("A:" + Arrays.toString(o));
	}
}
