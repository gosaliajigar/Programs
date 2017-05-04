package producer.consumer;

/**
 * Synchronized SharedBuffer implementation.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SharedBuffer {

	private int contents;

	private boolean available = false;

	/**
	 * @return
	 */
	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	/**
	 * @param value
	 */
	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
		available = true;
		contents = value;
		notifyAll();
	}
}