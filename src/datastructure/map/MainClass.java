package datastructure.map;

/**
 * Demonstrate Custom HashMap implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(21, 12);
		map.put(29, 100);
		map.put(83, 100);
		map.put(30, 151);
		map.put(33, 15);
		map.put(35, 89);
		map.put(28, 28);
		System.out.println("HashMap size: " + map.size());

		System.out.println();
		map.display();
		
		System.out.println();
		System.out.println(map.keySet());
		System.out.println();

		System.out.println("Key(21)=" + map.get(21));
		System.out.println("Key(51)=" + map.get(51));
		System.out.println();

		System.out.println("Add Key(33) again with value 66");
		map.put(33, 66);
		map.display();
		System.out.println();

		System.out.println("Remove Key(21): " + map.remove(21));
		System.out.println("Remove Key(51): " + map.remove(51));
		System.out.println("HashMap size: " + map.size());
		map.display();
		System.out.println();

		System.out.println("Remove Key(21): " + map.remove(21));
		System.out.println("Remove Key(51): " + map.remove(51));
		System.out.println("HashMap size: " + map.size());
		map.display();
		System.out.println();

		System.out.println("Remove Key(29): " + map.remove(29));
		System.out.println("HashMap size: " + map.size());
		map.display();		
		System.out.println();

		System.out.println("Adding Key(81)");
		map.put(81, 81);
		System.out.println("HashMap size: " + map.size());
		map.display();
		System.out.println();

		System.out.println("Remove Key(81): " + map.remove(81));
		System.out.println("HashMap size: " + map.size());
		map.display();
		System.out.println();
	}
}