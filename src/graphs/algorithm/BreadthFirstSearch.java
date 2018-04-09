package graphs.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search algorithm(BFS) traverses a graph in a breadth-wards
 * motion and uses a <b>queue</b> to remember to get the next vertex to start a
 * search when a dead end occurs in any iteration.<br>
 * <br>
 * <b>Rule 1</b> Visit adjacent unvisited vertex. Mark it visited. Display it.
 * Insert it in a queue.<br>
 * <br>
 * <b>Rule 2</b> If no adjacent vertex found, remove the first vertex from
 * queue.<br>
 * <br>
 * <b>Rule 3</b> Repeat Rule 1 and Rule 2 until queue is empty.<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BreadthFirstSearch {

	private static int SIZE = 8;

	private static Vertex[] vertices = new Vertex[SIZE];

	private static int[][] edges = new int[SIZE][SIZE];

	private static int count = 0;

	private static Queue<Integer> queue = new LinkedList<Integer>();

	// graph functions

	/**
	 * Add vertex to the vertex list
	 * 
	 * @param label
	 */
	private static void addVertex(char label) {
		Vertex vertex = new Vertex(label, false);
		vertices[count++] = vertex;
	}

	/**
	 * Add edge to edge array
	 * 
	 * @param start
	 * @param end
	 */
	private static void addEdge(int start, int end) {
		edges[start][end] = 1;
		edges[end][start] = 1;
	}

	/**
	 * Display the vertex
	 * 
	 * @param index
	 */
	private static void displayVertex(int index) {
		System.out.println(vertices[index]);
	}

	/**
	 * Get the adjacent unvisited vertex
	 * 
	 * @param vertexIndex
	 * @return
	 */
	private static int getAdjacentUnvisitedVertex(int vertexIndex) {
		for (int index = 0; index < count; index++) {
			if (edges[vertexIndex][index] == 1 && vertices[index].isVisited() == false) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * BFS
	 * 
	 * @throws Exception
	 */
	private static void breadthFirstSearch() throws Exception {
		// mark first node as visited
		vertices[0].setVisited(true);

		// display the vertex
		displayVertex(0);

		// push vertex index in stack
		queue.add(0);

		while (!queue.isEmpty()) {
			// get the unvisited vertex of vertex which is at top of the stack
			int unvisitedVertex = getAdjacentUnvisitedVertex(queue.peek());

			// no adjacent vertex found
			if (unvisitedVertex == -1) {
				queue.remove();
			} else {
				vertices[unvisitedVertex].setVisited(true);
				displayVertex(unvisitedVertex);
				queue.add(unvisitedVertex);
			}
		}

		// queue is empty, search is complete, reset the visited flag
		for (int index = 0; index < count; index++) {
			vertices[index].setVisited(false);
		}
	}

	private static void displayEdges() {
		System.out.print("  ");
		for (int x = 0; x < count; x++) {
			System.out.print(vertices[x].getLabel() + " ");
		}
		System.out.println();
		for (int x = 0; x < count; x++) {
			System.out.print(vertices[x].getLabel() + " ");
			for (int y = 0; y < count; y++) {
				System.out.print(edges[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void displayVertices() {
		for (int index = 0; index < count; index++) {
			System.out.println("Location(" + index + "): " + vertices[index]);
		}
		System.out.println();
	}

	private static void resetEdges() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				edges[x][y] = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		resetEdges();

		addVertex('S'); // 0
		addVertex('A'); // 1
		addVertex('B'); // 2
		addVertex('C'); // 3
		addVertex('D'); // 4
		addVertex('E'); // 5
		addVertex('F'); // 6
		addVertex('G'); // 7

		addEdge(0, 1); // S - A
		addEdge(0, 2); // S - B
		addEdge(0, 3); // S - C
		addEdge(1, 4); // A - D
		addEdge(2, 5); // B - E
		addEdge(3, 6); // C - F
		addEdge(4, 7); // D - G
		addEdge(5, 7); // E - G
		addEdge(6, 7); // F - G

		displayVertices();

		displayEdges();

		System.out.println("Breadth First Search: ");

		try {
			breadthFirstSearch();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
