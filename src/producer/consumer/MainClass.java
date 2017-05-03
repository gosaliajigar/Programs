package com.programs.producer.consumer;

/**
 * Demonstrate Producer Consumer Problem.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedBuffer sharedBuffer = new SharedBuffer();
		Producer producer = new Producer(sharedBuffer, 1);
		Consumer consumer = new Consumer(sharedBuffer, 1);
		producer.start();
		consumer.start();
	}
}