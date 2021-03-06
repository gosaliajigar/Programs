package braces;
import java.util.HashMap;
import java.util.Map;

/**
 * Find given opening brackets closing bracket.
 * 
 * @author Jigar Gosalia
 *
 */
public class BracketPosition {

	private static Map<Character, Character> brackets = new HashMap<Character, Character>();

	static {
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');
	}
	
	public static void main(String[] args) {
		System.out.println(findPosition("cld{sd{dssd}ds}sdsd", 3));
		System.out.println(findPosition("cld{sd{dssdds}sdsd", 3));
		System.out.println(findPosition("cld{sddssd}ds}sdsd", 3));
		System.out.println(findPosition("cld{sd{d[]s()s(dds)}}sdsd", 3));
		System.out.println();
	}

	public static int findPosition(String s, int position) {
		if (s != null && s.length() > 0 && position >= 0 && position != s.length()-1) {
			// no of brackets in middle of opening and closing bracket position
			int count = 0;
			char bracket = s.charAt(position);
			if (brackets.containsKey(bracket)) {
				for (int index = position + 1; index < s.length(); index++) {
					if (brackets.containsKey(s.charAt(index))) {
						count++;
					} else if (brackets.containsValue(s.charAt(index))) {
						// check if it is closing bracket
						if (count == 0 && s.charAt(index) == brackets.get(bracket)) {
							return index;
						} else {
							count--;
						}
					} // do nothing if its not a bracket
				}				
			}
		}
		return -1;
	}

}
