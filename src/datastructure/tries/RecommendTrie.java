package datastructure.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Recommendations from a Trie Data Structure
 * 
 * @author Jigar Gosalia
 *
 */
public class RecommendTrie {

	private TrieNode root;
	private int size;
	public TrieNode getRoot() { return this.root; }
	public int getSize() { return this.size; }
	public RecommendTrie() { this.root = new TrieNode(); }

	public boolean addWord(String word) {
		if (word != null && word.length() > 0) {
			word = word.toLowerCase();
			TrieNode current = root;
			for (char c : word.toCharArray()) {
				if (current.getNextValidCharacters().contains(c)) {
					current = current.getNextCharacter(c);
				} else {
					current = current.insert(c);
				}
			}
			if (!current.isWord()) {
				current.setWord(true);
				size++;
			}
			return true;
		}
		return false;
	}

	public List<String> recommend(String prefix) {
		prefix = prefix.toLowerCase();
		List<String> recommendations = new LinkedList<String>();
		TrieNode current = root;
		for (char c : prefix.toCharArray()) {
			if (current.getNextValidCharacters().contains(c)) {
				current = current.getNextCharacter(c);
			} else {
				return recommendations;
			}
		}
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		queue.offer(current);
		while (!queue.isEmpty()) {
			TrieNode node = queue.poll();
			if (node != null && node.isWord()) recommendations.add(node.getText());
			for (char c : node.getNextValidCharacters()) {
				queue.offer(node.getNextCharacter(c));
			}
		}
		return recommendations;
	}

	public static void main(String[] args) {
		RecommendTrie trie = new RecommendTrie();
		List<String> cities = Arrays.asList("San Jose", "San Carlos", "New York", "New York City", "New Orleans");
		for (String city : cities) {
			System.out.printf("Inserted %-20s : %s\n", city, trie.addWord(city));
		}
		List<String> all = new ArrayList<String>();
		trie.getRoot().print(trie.getRoot(), all);
		System.out.println();
		System.out.println(all);
		System.out.println();

		System.out.println("`San `      : " + trie.recommend("San "));
		System.out.println("`New `      : " + trie.recommend("New "));
		System.out.println("`New York`  : " + trie.recommend("New York"));
		System.out.println("`New York ` : " + trie.recommend("New York "));
	}
}
