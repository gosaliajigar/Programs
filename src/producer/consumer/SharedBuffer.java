package producer.consumer;

/**
 * Synchronized SharedBuffer implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SharedBuffer {

	private int contents;

	private boolean isReadyForReading = false;

	/**
	 * @return
	 */
	public synchronized int get() {
		// while not ready for reading WAIT
		while (!isReadyForReading) {
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		int data = contents; 
		isReadyForReading = false;
		notifyAll();
		return data;
	}

	/**
	 * @param value
	 */
	public synchronized void put(int value) {
		// while ready for reading WAIT to write
		while (isReadyForReading) {
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		contents = value;
		isReadyForReading = true;
		notifyAll();
	}
}