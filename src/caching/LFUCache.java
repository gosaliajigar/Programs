package caching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
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
		int key;
		int value;
		int frequency;
	
		public Data(int key, int value) {
			this.key = key;
			this.value = value;
			this.frequency = 0;
		}
		
		@Override
		public String toString() {
			return "(K=" + key + ";V=" + value + ";F:" + frequency + ")";
		}
	}

	// key->Data
	Map<Integer, Data> valueMap;
	// frequency-><key, key, key>
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
			node.value = value;
		} else {
			node = new Data(key, value);
			if (valueMap.size() >= capacity)
				deleteLeastFrequent();
			minFrequency = 1;
			valueMap.put(key, node);
		}
		updateFrequency(key);
	}

	private void updateFrequency(int key) {
		Data data = valueMap.get(key);
		int frequency = data.frequency;
		data.frequency = frequency + 1;
		valueMap.put(key, data);
		// this can get linear if there are lot of collisions
		// remove key from old frequency
		if (frequencyMap.containsKey(frequency) && frequencyMap.get(frequency).contains(key))
			frequencyMap.get(frequency).remove(key);
		// add set for new frequency if doesn't exists
		if (!frequencyMap.containsKey(frequency + 1))
			frequencyMap.put(frequency + 1, new LinkedHashSet<Integer>());
		frequencyMap.get(frequency+1).add(key);
		// update minFrequency if no data exists for it to next minFrequency available 
		if (minFrequency == frequency && frequencyMap.get(frequency) != null
				&& frequencyMap.get(frequency).size() == 0)
			minFrequency = frequency + 1;
	}

	private void deleteLeastFrequent() {
		int key = frequencyMap.get(minFrequency).iterator().next();
		frequencyMap.get(minFrequency).remove(key);
		valueMap.remove(key);
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		List<Integer> frequencies = new ArrayList<Integer>(frequencyMap.keySet());
		Collections.sort(frequencies);
		for (int frequency : frequencies) {
			data.append("F:" + frequency + " = " + frequencyMap.get(frequency) + " ");
		}
		return data.toString();
	}
}
