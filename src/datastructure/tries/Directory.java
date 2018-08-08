package datastructure.tries;
import pojos.File;

/**
 * @author Jigar Gosalia
 *
 */
public class Directory {

	private static File root = new File();

	public static void main(String[] args) {
		System.out.println(create("/a", 1));
		System.out.println(create("/a/d", 2));
		System.out.println(create("/f", 3));
		System.out.println(setValue("/a/d", 4));
		System.out.println(setValue("/f", 10));
		System.out.println(getValue("/a"));
		System.out.println(getValue("/a/d"));
		System.out.println(getValue("/f"));
		System.out.println(getValue("/a/f"));
	}
	
	public static boolean create(String path, int value) {
		if (path == null || path.length() == 0) return false;
		String[] nodes = path.split("/");
		File curr = root;
		int i;
		for (i=1; i<nodes.length; i++) {
			if (curr.map.containsKey(nodes[i])) {
				curr = curr.getValidNode(nodes[i]);
			}
		}
		curr.insert(nodes[--i], value);
		return true;
	}

	public static boolean setValue(String path, int value) {
		if (path == null || path.length() == 0) return false;
		String[] nodes = path.split("/");
		File curr = root;
		int i;
		for (i=1; i<nodes.length; i++) {
			if (curr.map.containsKey(nodes[i])) {
				curr = curr.getValidNode(nodes[i]);
				if (curr.label.equals(path.substring(path.length()-1))) break;
			} else {
				throw new RuntimeException("Invalid Path: " + path);
			}
		}
		curr.value = value;
		return true;
	}

	public static int getValue(String path) {
		if (path == null || path.length() == 0) return Integer.MIN_VALUE;
		String[] nodes = path.split("/");
		File curr = root;
		int i = 0;
		for (i=1; i<nodes.length; i++) {
			if (curr.map.containsKey(nodes[i])) {
				curr = curr.getValidNode(nodes[i]);
			} else {
				throw new RuntimeException("Invalid Path: " + path);
			}
		}
		return curr.value;
	}
}
