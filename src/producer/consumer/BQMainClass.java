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
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();
		BQProducer producer = new BQProducer(queue, 1);
		BQConsumer consumer = new BQConsumer(queue, 1);
		BQProducer producer2 = new BQProducer(queue, 2);
		BQConsumer consumer2 = new BQConsumer(queue, 2);
		new Thread(consumer).start();
		new Thread(consumer2).start();
		Thread.sleep(2000);
		new Thread(producer).start();
		new Thread(producer2).start();
	}
}