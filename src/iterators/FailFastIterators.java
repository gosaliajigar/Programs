package iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Jigar Gosalia
 *
 */
public class FailFastIterators {

	public static void main(String[] args) {
		Map<String, String> premiumPhone = new HashMap<String, String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S5");

		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}
	}
}