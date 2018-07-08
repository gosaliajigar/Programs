package producer.consumer;

/**
 * Producer implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
class SBProducer extends Thread {

	private SharedBuffer sharedBuffer;
	private int id;

	public SBProducer(SharedBuffer sharedBuffer, int id) {
		this.sharedBuffer = sharedBuffer;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int data = 0; data < 10; data++) {
			sharedBuffer.put(data);
			System.out.println("Producer #" + this.id + " put: " + data);
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
}