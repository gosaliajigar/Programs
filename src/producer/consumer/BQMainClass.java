package producer.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Demonstrate Producer Consumer Problem.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BQMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();
		BQProducer producer = new BQProducer(queue, 1);
		BQConsumer consumer = new BQConsumer(queue, 1);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}