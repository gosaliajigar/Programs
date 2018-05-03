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
				String item = queue.take();
				System.out.println(" - Consumer #" + this.id + " got: " + item);
				System.out.println();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}