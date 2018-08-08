package pojos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jigar Gosalia
 *
 */
public class File {
	public int size;
	public String label;
	public int value;
	public Map<String, File> map;
	public File() { map = new HashMap<String, File>(); this.label = "/"; }
	public File(String label, int value) {
		this();
		this.label = label;
		this.value = value;
	} 
	public Set<String> getNextValidNodes() { return map.keySet(); }
	public File getValidNode(String label) { return map.get(label); } 
	public File insert(String label, int value) {
		File node = new File(label, value);
		map.put(label, node);
		return node;
	}
	
	@Override
	public String toString() {
		return "T[L:" + label + ";V:" + value + "]";
	}
}
