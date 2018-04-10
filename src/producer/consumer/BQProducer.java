package producer.consumer;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Producer implementation.
 * 
 * @author "Jigar Gosalia"
 * 
 */
class BQProducer implements Runnable {

	private BlockingQueue<String> queue;

	private int id;

	/**
	 * @param queue
	 * @param id
	 */
	public BQProducer(BlockingQueue<String> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				String item = String.valueOf(new Date().toString());
				System.out.println("Producer #" + this.id + " put: " + item);
				queue.put(item);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}