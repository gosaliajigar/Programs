package multithreading;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MultithreadingByImplementingRunnable {
	public static void main(final String args[]) {

		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();

		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
	}
}

class RunnableDemo implements Runnable {

	/**
	 *
	 */
	private Thread t;

	/**
	 *
	 */
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
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	/**
	 *
	 */
	public void start() {
		System.out.println("  Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			System.out.println("  Instantiating " + threadName);
			t.start();
		}
	}

}
