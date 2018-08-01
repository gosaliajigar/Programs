package datastructure.heap;

/**
 * Heap Operations <br>
 * 1. maxHeapify   : O(logn)<br>
 * 2. buildMaxHeap : O(n)<br>
 * 3. heapSort     : O(nlogn)<br>
 * 4. max          : O(1)<br>
 * 5. extractMax   : O(logn)<br>
 * 6. increase     : O(logn)<br>
 * 7. insert       : O(logn)<br>
 * 8. delete       : O(logn)<br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class HeapOperations {

	public static int getLeft(int location) { return ((2 * location) + 1); }
	public static int getRight(int location) { return (2 * (location + 1));	}
	public static int getParent(int location) { return (int) Math.floor((location - 1) / 2); }

	/**
	 * bubble down the smaller element.
	 * 
	 * (log n)
	 * 
	 * @param heap
	 * @param location
	 */
	public static void maxHeapify(Heap heap, int location) {
		int largest = location;
		int left = getLeft(location);
		int right = getRight(location);
		if (left < heap.heapSize && heap.a[left] > heap.a[location]) {
			largest = left;
		}
		if (right < heap.heapSize && heap.a[right] > heap.a[largest]) {
			largest = right;
		}
		if (largest != location) {
			exchange(heap, largest, location);
			maxHeapify(heap, largest);
		}
	}

	// (n)
	public static void buildMaxHeap(Heap heap) {
		heap.heapSize = heap.a.length;
		for (int i = heap.a.length / 2; i >= 0; i--) {
			maxHeapify(heap, i);
		}
	}

	// (n logn)
	public static void heapSort(Heap heap) {
		buildMaxHeap(heap);
		for (int i = heap.a.length - 1; i > 0; i--) {
			exchange(heap, i, 0);
			heap.heapSize = heap.heapSize - 1;
			maxHeapify(heap, 0);
		}
	}

	// (1)
	public static int max(Heap heap) { return heap.a[0]; }

	// (logn)
	public static int extractMax(Heap heap) {
		if (heap.heapSize <= 0) return -1;
		int max = heap.a[0];
		heap.a[0] = heap.a[heap.heapSize - 1];
		heap.heapSize = heap.heapSize - 1;
		maxHeapify(heap, 0);
		return max;
	}

	/**
	 * Bubble up the increased element.
	 * 
	 * 	(logn)
	 * 
	 * @param heap
	 * @param location
	 * @param value
	 * @return
	 */
	public static boolean increase(Heap heap, int location, int value) {
		if (heap != null && heap.a != null && heap.heapSize > 0 && heap.a[location] < value) {
			heap.a[location] = value;
			while (location > 0 && heap.a[getParent(location)] < heap.a[location]) {
				exchange(heap, location, getParent(location));
				location = getParent(location);
			}
			return true;
		}
		return false;
	}

	// (logn)
	public static void insert(Heap heap, int key) {
		if (heap.heapSize >= heap.a.length) throw new IllegalArgumentException("Heap Full");
		heap.heapSize = heap.heapSize + 1;
		heap.a[heap.heapSize - 1] = Integer.MIN_VALUE;
		increase(heap, heap.heapSize - 1, key);
	}

	// (logn)
	public static void delete(Heap heap, int location) {
		exchange(heap, location, heap.heapSize - 1);
		heap.heapSize = heap.heapSize - 1;
		maxHeapify(heap, location);
	}

	public static void exchange(Heap heap, int src, int dest) {
		int temp = heap.a[src];
		heap.a[src] = heap.a[dest];
		heap.a[dest] = temp;
	}

	public static Heap copy(Heap heap, int heapSize) {
		Heap newHeap = new Heap(new int[heapSize], heapSize);
		for (int index = 0; index < heap.heapSize; index++) {
			newHeap.a[index] = heap.a[index];
		}
		return newHeap;
	}

	public static int[] populateArray() {
		int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		return array;
	}

	public static void main(String[] args) throws Exception {
		int[] array = populateArray();

		Heap heap = new Heap(array, array.length - 1);
		System.out.println("Display     : " + heap);
		System.out.println();

		// maxHeapify
		HeapOperations.maxHeapify(heap, 1);
		System.out.println("Max Heapify : " + heap);
		System.out.println();

		// increase key's value
		HeapOperations.increase(heap, 8, 15);
		System.out.println("Increase    : " + heap);
		System.out.println();

		// insert a new key
		HeapOperations.insert(heap, 20);
		System.out.println("Insert      : " + heap);
		System.out.println();

		// delete a key
		HeapOperations.delete(heap, 0);
		System.out.println("Delete      : " + heap);
		System.out.println();

		// peek max value
		System.out.println("Get Max     : " + HeapOperations.max(heap));
		System.out.println("Display     : " + heap);
		System.out.println();

		// extract max value
		System.out.println("Extract Max : " + HeapOperations.extractMax(heap));
		System.out.println("Display     : " + heap);
		System.out.println();

		// copying heap to newHeap as heapSize is 0 at end of sorting
		// which will be a problem to display heap
		Heap newHeap = HeapOperations.copy(heap, 8);
		System.out.println("Display     : " + newHeap);
		// heap sort
		HeapOperations.heapSort(newHeap);
		heap = HeapOperations.copy(newHeap, 8);
		newHeap.heapSize = newHeap.a.length;
		System.out.println("Sort        : " + newHeap);
	}
}

