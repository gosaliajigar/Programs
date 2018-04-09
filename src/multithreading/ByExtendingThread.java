package multithreading;

/**
 * @author "Jigar Gosalia"
 *
 */
public class ByExtendingThread {

	/**
	 * @param args
	 */
	public static void main(final String args[]) {
		new ThreadDemo("Thread-1").start();

		new ThreadDemo("Thread-2").start();
	}
}

class ThreadDemo extends Thread {

	private String threadName;

	/**
	 * @param name
	 */
	ThreadDemo(final String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("  Running " + threadName);
		try {
			for (int i = 1000; i >= 100; i -= 100) {
				System.out.println("Thread " + threadName + " - " + i);
				// Let the thread sleep for a while.
				Thread.sleep(10);
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

}
