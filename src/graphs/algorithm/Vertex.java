/**
 * 
 */
package com.programs.graphs.algorithm;

/**
 * Vertex for Graph Traversal Algorithms
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Vertex {

	char label;

	boolean visited;

	public Vertex(char label, boolean visited) {
		super();
		this.label = label;
		this.visited = visited;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "Vertex[label=" + label + ", visited=" + visited + "]";
	}
}
