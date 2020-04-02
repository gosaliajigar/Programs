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

		l[0] = r[nums.length - 1] = 1;
		l[1] = nums[0];
		r[nums.length - 2] = nums[nums.length - 1];
		for (int i = 2; i < nums.length; i++) {
			l[i] = nums[i - 1] * l[i - 1];
		}
		for (int j = nums.length - 2; j >= 0; j--) {
			r[j] = nums[j + 1] * r[j + 1];
		}

		o[0] = r[0];
		o[nums.length - 1] = l[nums.length - 1];
		for (int i = 1; i < o.length - 1; i++) {
			o[i] = l[i] * r[i];
		}
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(o));
	}
}
