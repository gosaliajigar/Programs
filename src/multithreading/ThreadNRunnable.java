package multithreading;

/**
 * Create threads by extending Thread class and implementing Runnable interface.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ThreadNRunnable {
	public static void main(final String args[]) {
		new ThreadDemo("Thread-1").start();
		new ThreadDemo("Thread-2").start();
		new Thread(new RunnableDemo("Runnable-3")).start();
		new Thread(new RunnableDemo("Runnable-4")).start();
		// using functional interface
		// new Thread(() -> System.out.println("Hello")).start();
	}
}

class ThreadDemo extends Thread {
	private String threadName;
	public ThreadDemo(final String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("\tRunning " + threadName);
		try {
			for (int i = 10000; i >= 100; i -= 100) {
				System.out.println("\t\t" + threadName + " - " + i);
			}
		} catch (Exception e) {
			System.out.println("\t" + threadName + " interrupted.");
		}
		System.out.println("\t" + threadName + " exiting.");
	}
}

class RunnableDemo implements Runnable {
	private String threadName;
	public RunnableDemo(final String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		System.out.println("\tRunning " + threadName);
		try {
			for (int i = 1000; i > 100; i -= 100) {
				System.out.println("\t\t" + threadName + ", " + i);
			}
		} catch (Exception e) {
			System.out.println("\t" + threadName + " interrupted.");
		}
		System.out.println("\t" + threadName + " exiting.");
	}
}
