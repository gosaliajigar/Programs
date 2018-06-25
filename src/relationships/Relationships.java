package relationships;

import java.io.*;
import java.util.*;

/* 

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
            
1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.

Sample output (pseudocode):
[
  [1, 2, 4],   // Individuals with zero parents
  [5, 7, 8, 9] // Individuals with exactly one parent
]

Below is some sample data in JavaScript and Java. Feel free to solve this problem in any language of your choice.

Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
            
1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

Write a function that, for two given individuals in our dataset, returns true if and only if they share at least one ancestor.

Sample input and output:
parentChildPairs, 3, 8 => false
parentChildPairs, 5, 8 => true
parentChildPairs, 6, 8 => true

Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- the one at the farthest distance from the input individual. If there is more than one ancestor tied for “earliest”, return any one of them. If the input individual has no parents, the function should return null (or -1).

Sample input and output:

1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

8 => 4
7 => 4
6 => 1, 2, or 4
 */
public class Relationships {
	public static void main(String[] args) {
		int[][] parentChildPairs = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 },
				{ 8, 9 } };

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		// O(n)
		for (int[] relationship : parentChildPairs) {
			if (map.containsKey(relationship[1])) {
				map.get(relationship[1]).add(relationship[0]);
			} else {
				List<Integer> parents = new ArrayList<Integer>();
				parents.add(relationship[0]);
				map.put(relationship[1], parents);
			}
		}

		Set<Integer> noParent = getNoParents(map);
		Set<Integer> oneParent = getOneParent(map);

		System.out.println(noParent);
		System.out.println(oneParent);

		System.out.println(parentChildPairs(3, 8, map));
		System.out.println(parentChildPairs(5, 8, map));
		System.out.println(parentChildPairs(6, 8, map));

		System.out.println(getFarthestParent(8, map));
		System.out.println(getFarthestParent(7, map));
		System.out.println(getFarthestParent(6, map));
	}

	private static Set<Integer> getNoParents(Map<Integer, List<Integer>> map) {
		Set<Integer> childs = map.keySet();
		Set<Integer> parents = new HashSet<Integer>();

		// linear
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			parents.addAll(entry.getValue());
		}

		Set<Integer> noParent = new HashSet<Integer>();
		for (Integer parent : parents) {
			if (!childs.contains(parent)) noParent.add(parent);
		}
		return noParent;
	}

	private static Set<Integer> getOneParent(Map<Integer, List<Integer>> map) {
		// second collection
		Map<Integer, List<Integer>> nMap = new HashMap<>();
		nMap.putAll(map);
		nMap.entrySet().removeIf(e -> e.getValue().size() != 1);
		// Set<Integer> singleParent = new HashSet<Integer>();
		// for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
		// if (entry.getValue().size() == 1) singleParent.add(entry.getKey());
		// }
		// return singleParent;
		return nMap.keySet();
	}

	private static boolean parentChildPairs(int c1, int c2, Map<Integer, List<Integer>> map) {
		List<Integer> p1 = map.get(c1);
		List<Integer> p2 = map.get(c2);
		if (p1 == null || p1.size() == 0 || p2 == null || p2.size() == 0)
			return false;
		for (Integer parent : p1) {
			// looking recursivley parent
			if (p2.contains(parent) || (map.get(parent) != null && map.get(parent).retainAll(p2))) {
				return true;
			}
		}
		return false;
	}

	// BFS
	private static int getFarthestParent(int c, Map<Integer, List<Integer>> map) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(c);
		while (!queue.isEmpty()) {
			Integer child = queue.remove();
			if (map.get(child) == null) return child;
			queue.addAll(map.get(child));
		}
		return -1;
	}
}
