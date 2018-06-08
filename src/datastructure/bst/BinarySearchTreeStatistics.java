package datastructure.bst;

import java.util.LinkedList;
import java.util.List;

import datastructure.bst.BinarySearchTree.Node;

/**
 * Find statistics of Binary Search Tree.
 * 
 * 					27						h(27)=3;d(27)=0
 * 			14				35				h(35)=2;d(35)=1
 * 		10		19		31		42			h(42)=1;d(42)=2
 * 									57		h(57)=0;d(57)=3
 * 
 * height = max. edges from node to leaf node	(start from node)
 * depth  = edges from root to node				(start from root)
 * level  = depth + 1							(start from root)
 * 
 * https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearchTreeStatistics {

	private static int[] array = new int[] { 27, 14, 35, 10, 19, 31, 42, 57 };

	private static List<Integer> path = new LinkedList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.create(array);
		TreeTraversal.inOrderTraversal(tree.getRoot());
		System.out.println();
		System.out.println();
		System.out.println("Height of binary tree  : " + findHeight(tree.getRoot()));
		System.out.println();
		System.out.println("No of nodes            : " + findTotalNodes(tree.getRoot()));
		System.out.println();
		System.out.println("Sum of nodes data      : " + sumOfNodeData(tree.getRoot()));
		System.out.println();
		System.out.println("No of leaf nodes       : " + noOfLeafNodes(tree.getRoot()));
		System.out.println();
		System.out.println("No of internal nodes   : " + noOfInternalNodes(tree.getRoot()));
		System.out.println();
		System.out.println("No of edges            : " + noOfEdges(tree.getRoot()));
		System.out.println();
		findDepth(tree.getRoot(), 0);
		System.out.println("Depth of node          : " + tree.getRoot().right.right.depth);
		System.out.println();
		System.out.println("Max Depth              : " + findMaxDepth(tree.getRoot()));
		System.out.println();
		System.out.println("No of left nodes only  : " + noOfLeftNodes(tree.getRoot()));
		System.out.println();
		System.out.println("No of right nodes only : " + noOfRightNodes(tree.getRoot()));
		System.out.println();
		System.out.println("Has Path sum           : " + hasPathSum(tree.getRoot(), 60) + "; Path : " + path.toString());
		System.out.println();
		System.out.println("All Paths              : ");
		List<Integer> allPathsList = new LinkedList<Integer>();
		allPaths(tree.getRoot(), allPathsList, 0);
		System.out.println();
		Node mirrorRoot = mirror();
		System.out.println();
		// compare tree and its mirror
		System.out.println("Compare 2 trees        : " + compare2Trees(tree.getRoot(), mirrorRoot));
		System.out.println();
		BinarySearchTree newTree = new BinarySearchTree();
		newTree.create(array);
		// compare tree and newTree which are same
		System.out.println("Compare 2 trees        : " + compare2Trees(tree.getRoot(), newTree.getRoot()));
		System.out.println();
		System.out.println("Is BST                 : " + isBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println();
		System.out.println("Is BST                 : " + isBST(mirrorRoot, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println();
	}

	public static int findHeight(Node node) {
		return ((node == null) ? 0 : (1 + Math.max(findHeight(node.left), findHeight(node.right))));
	}

	public static int findTotalNodes(Node node) {
		return ((node == null) ? 0 : (1 + findTotalNodes(node.left) + findTotalNodes(node.right)));
	}

	public static int sumOfNodeData(Node node) {
		return ((node == null) ? 0 : (node.getData() + sumOfNodeData(node.left) + sumOfNodeData(node.right)));
	}

	public static int noOfLeafNodes(Node node) {
		if (node == null) {
			return 0;
		} else if (node.getLeft() == null
				&& node.getRight() == null) {
			return 1;
		} else {
			return (noOfLeafNodes(node.getLeft()) + noOfLeafNodes(node.getRight()));
		}
	}

	public static int noOfInternalNodes(Node node) {
		if (node == null) {
			return 0;
		} else if (node.getLeft() == null
				&& node.getRight() == null) {
			return 0;
		} else {
			return (1 + noOfInternalNodes(node.getLeft()) + noOfInternalNodes(node.getRight()));
		}
	}

	public static int noOfEdges(Node node) {
		if (node == null) {
			return 0;
		} else if (node.getLeft() == null
				&& node.getRight() == null) {
			return 0;
		} else if (node.getLeft() != null
				&& node.getRight() != null) {
			return (2 + noOfEdges(node.getLeft()) + noOfEdges(node.getRight()));
		} else {
			return (1 + noOfEdges(node.getLeft()) + noOfEdges(node.getRight()));
		}
	}

	public static void findDepth(Node node, int depth) {
		if (node != null) {
			node.depth = depth;
			findDepth(node.left, depth+1);
			findDepth(node.right, depth+1);
		}
	}

	public static int findMaxDepth(Node node) {
		// max depth of node = height of the node
		if (node == null) {
			return 0;
		} else if (node.getLeft() == null
				&& node.getRight() == null) {
			return 0;
		} else {
			return (1 + Math.max(findMaxDepth(node.getLeft()), findMaxDepth(node.getRight())));
		}
	}

	public static int noOfLeftNodes(Node node) {
		if (node == null) {
			return 0;
		} else if(node.getLeft() == null) {
			return 0;
		} else {
			return (1 + noOfLeftNodes(node.getLeft()) + noOfLeftNodes(node.getRight()));
		}
	}

	public static int noOfRightNodes(Node node) {
		if (node == null) {
			return 0;
		} else if(node.getRight() == null) {
			return 0;
		} else {
			return (1 + noOfRightNodes(node.getLeft()) + noOfRightNodes(node.getRight()));
		}
	}

	public static boolean hasPathSum(Node node, int sum) {
		if (node == null) {
			return (sum == 0);
		} else {
			boolean result = false;
			int subSum = sum - node.getData();
			if (subSum == 0 && node.getLeft() == null && node.getRight() == null) {
				result = true;
			}
			if (node.getLeft() != null) {
				result = result || hasPathSum(node.getLeft(), subSum); 
			}
			if (node.getRight() != null) {
				result = result || hasPathSum(node.getRight(), subSum);
			}
			if (result) {
				path.add(node.getData());
			}
			return result;
		}
	}

	public static void allPaths(Node node, List<Integer> path, int length) {
		if (node == null) {
			return;
		} else {
			path.add(length, node.getData());
			length++;
			if (node.getLeft() == null && node.getRight() == null) {
				printArray(path, length);
			} else {
				allPaths(node.getLeft(), path, length);
				allPaths(node.getRight(), path, length);
			}
		}
	}

	private static void printArray(List<Integer> path, int length) {
		for (int index = 0; index < length; index++) {
			System.out.print(path.get(index) + " ");
		}
		System.out.println();
	}

	public static Node mirror() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.create(array);
		System.out.print("Before mirroring       : ");
		TreeTraversal.inOrderTraversal(tree.getRoot());
		System.out.println();
		Node node = tree.getRoot();
		mirrorTree(node);
		System.out.print("After mirroring        : ");
		TreeTraversal.inOrderTraversal(tree.getRoot());
		System.out.println();
		return node;
	}

	private static void mirrorTree(Node node) {
		if (node == null) {
			return;
		} else {
			Node temp = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(temp);
			mirrorTree(node.getLeft());
			mirrorTree(node.getRight());
		}
	}

	public static boolean compare2Trees(Node nodeA, Node nodeB) {
		if (nodeA == null && nodeB == null) {
			return true;
		} else if (nodeA.getData() == nodeB.getData()
				&& compare2Trees(nodeA.getLeft(), nodeB.getLeft())
				&& compare2Trees(nodeA.getRight(), nodeB.getRight())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		} 
		if (node.getData() < min || node.getData() > max) {
			return false;
		}
		return (isBST(node.getLeft(), min, node.getData()-1) 
				|| isBST(node.getRight(), node.getData()+1, max));
	}
}
