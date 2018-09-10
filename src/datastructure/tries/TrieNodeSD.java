package datastructure.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jigar Gosalia
 *
 */
public class TrieNodeSD {
	Map<Character, TrieNodeSD> characters;
	char character;

	public TrieNodeSD(char c) {
		this.characters = new HashMap<Character, TrieNodeSD>();
		this.character = c;
	}

	@Override
	public String toString() {
		return this.character + "";
	}
}
