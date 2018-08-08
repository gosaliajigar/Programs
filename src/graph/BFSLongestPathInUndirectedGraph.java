package graph;

/**
 * 
 * We can find longest path using two BFSs. The idea is based on the following
 * fact: If we start BFS from any node x and find a node with the longest
 * distance from x, it must be an end point of the longest path. It can be
 * proved using contradiction. So our algorithm reduces to simple two BFSs.
 * First BFS to find an end point of the longest path and second BFS from this
 * end point to find the actual longest path.
 * 
 * 
 * 1. Run BFS from any node a and find the farthest node b <br>
 * 2. Run BFS from node b and find the farthest node c <br>
 * 3. node b and node c are the farthest nodes <br>
 * <br>
 * 
 * Source : https://www.geeksforgeeks.org/longest-path-undirected-tree/
 * 
 * @author Jigar Gosalia
 *
 */
public class BFSLongestPathInUndirectedGraph {}
