package iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * FailFast Iterators.
 * 
 * @author Jigar Gosalia
 *
 */
public class FailFastIterators {
	public static void main(String[] args) {
		Map<String, String> premiumPhone = new HashMap<String, String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S5");

		// iterator captures modCount
		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			// on every next() call, iterator checks modCount, if it has changed then
			// throw ConcurrentModificationException
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}
	}
}