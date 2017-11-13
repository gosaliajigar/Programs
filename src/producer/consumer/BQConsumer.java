package producer.consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer implementation.
 * 
 * @author "Jigar Gosalia"
 * 
 */
class BQConsumer implements Runnable {

	private BlockingQueue<String> queue;

	private int id;

	/**
	 * @param sharedBuffer
	 * @param id
	 */
	public BQConsumer(BlockingQueue<String> queue, int id) {
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
				String item = consume(queue.take());
				System.out.println(" - Consumer #" + this.id + " got: " + item);
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String consume(String item) {
		return item;
	}
}