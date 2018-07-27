Sorting			Average			Worst		Stable		In-Place	Space
---------------------------------------------------------------------
Bubble			n2				n2			YES			YES			1
Insertion		n2				n2			YES			YES			1
Selection		n2				n2			YES & NO	YES			1

Quick			nlogn			n2			NO			YES			logn
Merge			nlogn			nlogn		YES			NO			n
Heap			nlogn			nlogn		NO			YES			1

Counting		n+k				n+k			YES			NO			k
Bucket			n+k				n2			YES			NO			n
										(underlying
											sort)
											
Q: Which sorting algorithm makes minimum number of memory writes?
Minimizing the number of writes is useful when making writes to some huge data set is very expensive, such as with EEPROMs or Flash memory, where each write reduces the life span of the memory.
A: Selection sort makes least number of writes (it makes O(n) swaps), but Cycle sort almost always makes less number of writes compared to Selection Sort.

In Cycle sort, each value is either written zero times, if it’s already in its correct position, or written one time to its correct position. This matches the minimal number of overwrites required for a completed in-place sort.

Q: Sorting 24,000,000 evenly distributed real numbers between 1 and 6,006?
A: Bucket sort, the input is uniformly distributed, so Bucket sort runs in linear time.

Q: Sorting an array of 32,000,000 integers between 0 and 32,000,000.
A: Counting sort or Radix sort, both run in linear time on the bounded input.

Q: Independently sorting each of 1,000,000 arrays, each with 5 elements.
A: Insertion sort, due to the very low constant factors involved in running it on small inputs. 

Q: Sorting a set of 4,000,000 numbers in worst case O(n lg n) time.
A: Merge sort, as it has the required running time

