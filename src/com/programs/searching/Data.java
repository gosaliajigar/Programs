package com.programs.searching;

/**
 * Data element for Hash Table
 * 
 * @author "Jigar Gosalia"
 *
 */
public class Data {

	int key;

	int value;

	public Data(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Data[key=" + key + ";value=" + value + "]";
	}
}