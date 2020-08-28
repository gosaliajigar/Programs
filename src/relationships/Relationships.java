package relationships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* 

Suppose we have some input data describing a graph of relationships between parents and children over multiple 
generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned an 
unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
            
1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

Write a function that takes this data as input and returns two collections: one containing all individuals 
with zero known parents, and one containing all individuals with exactly one known parent.

Sample output (pseudocode):
[
  [1, 2, 4],   // Individuals with zero parents
  [5, 7, 8, 9] // Individuals with exactly one parent
]

Below is some sample data in JavaScript and Java. Feel free to solve this problem in any language of your choice.

Suppose we have some input data describing a graph of relationships between parents and children over multiple 
generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a 
unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
            
1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   9

Write a function that, for two given individuals in our dataset, returns true if and only if they share at 
least one ancestor.

Sample input and output:
parentChildPairs, 3, 8 => false
parentChildPairs, 5, 8 => true
parentChildPairs, 6, 8 => true

Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- 
the one at the farthest distance from the input individual. If there is more than one ancestor tied 
for earliest, return any one of them. If the input individual has no parents, the function should 
return null (or -1).

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
		int[][] parentChildPairs = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, 
												 { 5, 6 }, { 5, 7 }, { 4, 5 }, 
												 { 4, 8 }, { 8, 9 } };

		Map<Integer, List<Integer>> childToParentsMap = prepareChildToParent(parentChildPairs);

		System.out.println(getNoParents(childToParentsMap));
		System.out.println(getOneParent(childToParentsMap));

		System.out.println(shareAtLeastOneAncestor(3, 8, childToParentsMap));
		System.out.println(shareAtLeastOneAncestor(5, 8, childToParentsMap));
		System.out.println(shareAtLeastOneAncestor(6, 8, childToParentsMap));

		System.out.println(getFarthestParent(8, childToParentsMap));
		System.out.println(getFarthestParent(7, childToParentsMap));
		System.out.println(getFarthestParent(6, childToParentsMap));
		
		System.out.println(getParentChain(8, childToParentsMap));
		System.out.println(getParentChain(7, childToParentsMap));
		System.out.println(getParentChain(6, childToParentsMap));
	}

	private static Map<Integer, List<Integer>> prepareChildToParent(int[][] parentChildPairs) {
		Map<Integer, List<Integer>> childToParentsMap = new HashMap<Integer, List<Integer>>();
		for (int[] relationship : parentChildPairs) {
			if (childToParentsMap.containsKey(relationship[1])) {
				childToParentsMap.get(relationship[1]).add(relationship[0]);
			} else {
				List<Integer> parents = new ArrayList<Integer>();
				parents.add(relationship[0]);
				childToParentsMap.put(relationship[1], parents);
			}
		}
		return childToParentsMap;
	}

	private static Set<Integer> getNoParents(Map<Integer, List<Integer>> childToParentsMap) {
		Set<Integer> parents = new HashSet<Integer>();
		Set<Integer> noParent = new HashSet<Integer>();

		// linear
		for (Map.Entry<Integer, List<Integer>> entry : childToParentsMap.entrySet()) {
			parents.addAll(entry.getValue());
		}

		for (Integer parent : parents) {
			if (!childToParentsMap.containsKey(parent)) noParent.add(parent);
		}
		return noParent;
	}

	private static Set<Integer> getOneParent(Map<Integer, List<Integer>> childToParentsMap) {
		// second collection
		Map<Integer, List<Integer>> nMap = new HashMap<>(childToParentsMap);
		nMap.entrySet().removeIf(e -> e.getValue().size() != 1);
		// Set<Integer> singleParent = new HashSet<Integer>();
		// for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
		// if (entry.getValue().size() == 1) singleParent.add(entry.getKey());
		// }
		// return singleParent;
		return nMap.keySet();
	}

	private static boolean shareAtLeastOneAncestor(int c1, int c2, Map<Integer, List<Integer>> childToParentsMap) {
		// check each of the chain if there is any common
		// Set<Integer> p11 = getParentChain(c1, map);
		// Set<Integer> p12 = getParentChain(c2, map);
		List<Integer> p1 = childToParentsMap.get(c1);
		List<Integer> p2 = childToParentsMap.get(c2);
		if (p1 == null || p1.size() == 0 || p2 == null || p2.size() == 0) return false;
		for (Integer parent : p1) {
			// looking recursively parent
			if (p2.contains(parent) 
					|| (childToParentsMap.get(parent) != null && childToParentsMap.get(parent).retainAll(p2))) {
				return true;
			}
		}
		return false;
	}

	// BFS
	private static int getFarthestParent(int c, Map<Integer, List<Integer>> childToParentsMap) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(c);
		while (!queue.isEmpty()) {
			Integer child = queue.remove();
			if (childToParentsMap.get(child) == null) return child;
			queue.addAll(childToParentsMap.get(child));
		}
		return -1;
	}

	private static Set<Integer> getParentChain(int c, Map<Integer, List<Integer>> childToParentsMap) {
		Set<Integer> chain = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(c);
		while (!queue.isEmpty()) {
			Integer child = queue.poll();
			if (childToParentsMap.get(child) != null) {
				chain.addAll(childToParentsMap.get(child));
				queue.addAll(childToParentsMap.get(child));
			}
		}
		return chain;
	}

}
