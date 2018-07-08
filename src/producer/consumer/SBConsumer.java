package producer.consumer;

/**
 * Consumer implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
class SBConsumer extends Thread {

	private SharedBuffer sharedBuffer;
	private int id;

	public SBConsumer(SharedBuffer sharedBuffer, int id) {
		this.sharedBuffer = sharedBuffer;
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int iteration = 0; iteration < 10; iteration++) {
			int value = sharedBuffer.get();
			System.out.println(" - Consumer #" + this.id + " got: " + value);
			System.out.println();
		}
	}
}