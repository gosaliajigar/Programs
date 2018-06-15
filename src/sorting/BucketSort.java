package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Bucket sorting O(n+k) is stable if underlying sort is stable.<br>
 * 
 * @author Jigar Gosalia
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		int[] input = {80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};
		System.out.println(Arrays.toString(input));
		bucket(input, 5);
		System.out.println(Arrays.toString(input));
	}

	public static void bucket(int[] a, int bucketSize) {
		if (a == null || a.length == 0 || a.length == 1 || bucketSize == 0) {
			return;
		}

		int min = a[0], max = a[0];
		
		for (int index = 0; index < a.length; index++) {
			min = Math.min(min, a[index]);
			max = Math.max(max, a[index]);
		}
		
		int bucketCount = ((max - min) / bucketSize) + 1;

		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		for (int index = 0; index < bucketCount; index++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		for (int index = 0; index < a.length; index++) {
			buckets.get((a[index] - min)/bucketSize).add(a[index]);
		}
		
		int position = 0;
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
			for (int item : bucket) {
				a[position++] = item;
			}
		}
	}
}
