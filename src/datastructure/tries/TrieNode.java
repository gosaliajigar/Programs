package datastructure.tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TrieNode to be used along with RecommendationTrie for recommending based on
 * user entered text.
 * 
 * @author Jigar Gosalia
 *
 */
public class TrieNode {

	private Map<Character, TrieNode> characters;

	private String text;

	private boolean isWord;

	public TrieNode() {
		this.characters = new HashMap<Character, TrieNode>();
	}

	public TrieNode(String word) {
		this();
		this.text = word;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public void setIsWord(boolean isWord) {
		this.isWord = isWord;
	}

	public boolean isWord() {
		return this.isWord;
	}

	public TrieNode getNextCharacter(Character c) {
		return characters.get(c);
	}

	public Set<Character> getNextValidCharacters() {
		return characters.keySet();
	}

	public TrieNode insert(Character c) {
		TrieNode node = new TrieNode(((text != null && text.length() > 0) ? text : "") + c);
		characters.put(c, node);
		return node;
	}

	public void print(TrieNode node, List<String> all) {
		if (node == null || all == null) {
			return;
		}
		// base condition
		if (node.isWord()) {
			all.add(node.getText());
		}
		// recursive condition
		for (Character c : node.getNextValidCharacters()) {
			print(node.getNextCharacter(c), all);
		}
	}
}
