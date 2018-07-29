package iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FailSafe Iterators.
 * 
 * @author Jigar Gosalia
 *
 */
public class FailSafeIterators {

	public static void main(String[] args) {
		Map<String, String> premiumPhone = new ConcurrentHashMap<String, String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S5");

		// iterator captures modCount
		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ":" + premiumPhone.get(key));
			premiumPhone.put("Sony", "Xperia Z");
			// size changes but iterator can't see the new changes
			// as it has a copy of map
			System.out.println("size: " + premiumPhone.size());
		}
	}
}