package multithreading;

/**
 * @author "Jigar Gosalia"
 *
 */
public class ByImplementingRunnable {
	public static void main(final String args[]) {
		new Thread(new RunnableDemo("Thread-1")).start();

		new Thread(new RunnableDemo("Thread-2")).start();
	}
}

class RunnableDemo implements Runnable {

	private String threadName;

	/**
	 * @param name
	 */
	RunnableDemo(final String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("  Running " + threadName);
		try {
			for (int i = 1000; i > 100; i -= 100) {
				System.out.println("Thread " + threadName + ", " + i);
				// Let the thread sleep for a while.
				// Thread.sleep(50);
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

}
