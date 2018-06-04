package datastructure.heap;

/**
 * @author "Jigar Gosalia"
 *
 */
public class Heap {
	int[] a;
	int heapSize;

	public Heap(int[] a, int size) {
		if (size > a.length) {
			throw new IllegalArgumentException("Invalid Size");
		}
		this.a = a;
		this.heapSize = size;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		for (int index = 0; index < heapSize; index++) {
			data.append(a[index]).append(",");
		}
		if (data.charAt(data.length()-1) == ',') {
			data.deleteCharAt(data.length()-1);
		}
		return data.toString();
	}
}
