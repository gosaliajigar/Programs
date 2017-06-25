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
		while (isReadyForReading == false) {
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
		while (isReadyForReading == true) {
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		isReadyForReading = true;
		contents = value;
		notifyAll();
	}
}