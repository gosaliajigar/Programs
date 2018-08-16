package caching;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Least Frequently Used Cache <br>
 * - raw heap for O(log n) addition/deletion (increase-key and decrease-key operations)<br>
 * - map for O(1) retrieval<br>
 * <br>
 * Alternative approach using 2 HashMap and 1 LinkedHashSet<br>
 * - map for O(1) retrieval and addition<br>
 * 
 * @author Jigar Gosalia
 *
 */
public class LFUCache {

	class Data {
		int value;
		int frequency;
	}

	// value->Data
	Map<Integer, Data> valueMap;
	// frequency-><value, value, value>
	Map<Integer, Set<Integer>> frequencyMap;
	int minFrequency = -1;
	int capacity;

	public LFUCache(int capacity) {
		this.valueMap = new HashMap<Integer, Data>();
		this.frequencyMap = new HashMap<Integer, Set<Integer>>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (valueMap.containsKey(key)) {
			updateFrequency(key);
			return valueMap.get(key).value;
		}
		return Integer.MIN_VALUE;
	}

	public void put(int key, int value) {
		Data node;
		if (valueMap.containsKey(key)) {
			node = valueMap.get(key);
		} else {
			node = new Data();
			if (valueMap.size() >= capacity)
				deleteLeastFrequent();
			minFrequency = 1;
		}
		node.value = value;
		valueMap.put(key, node);
		updateFrequency(key);
	}

	private void updateFrequency(int key) {
		Data data = valueMap.get(key);
		int frequency = data.frequency;
		data.frequency = frequency + 1;
		valueMap.put(key, data);
		// this can get linear if there are lot of collisions
		if (frequencyMap.containsKey(frequency) && frequencyMap.get(frequency).contains(key))
			frequencyMap.get(frequency).remove(key);
		if (!frequencyMap.containsKey(frequency + 1))
			frequencyMap.put(frequency + 1, new LinkedHashSet<Integer>());
		frequencyMap.get(frequency+1).add(key);
		if (minFrequency == frequency && frequencyMap.get(frequency).size() == 0)
			minFrequency = frequency + 1;
	}

	private void deleteLeastFrequent() {
		int key = frequencyMap.get(minFrequency).iterator().next();
		frequencyMap.get(minFrequency).remove(key);
		valueMap.remove(key);
	}
}
