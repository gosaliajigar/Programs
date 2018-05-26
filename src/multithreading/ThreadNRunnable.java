package multithreading;

/**
 * @author "Jigar Gosalia"
 *
 */
public class ThreadNRunnable {

	/**
	 * @param args
	 */
	public static void main(final String args[]) {
		new ThreadDemo("Thread-1").start();
		new ThreadDemo("Thread-2").start();
		new Thread(new RunnableDemo("Thread-3")).start();
		new Thread(new RunnableDemo("Thread-4")).start();

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
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
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
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

}
