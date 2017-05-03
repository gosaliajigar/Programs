package com.programs.multithreading;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MultithreadingByExtendingThread {

	/**
	 * @param args
	 */
	public static void main(final String args[]) {

		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.start();

		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.start();
	}
}

class ThreadDemo extends Thread {

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
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Thread#start()
	 */
	@Override
	public void start() {
		System.out.println("  Starting " + threadName);
		if (t == null) {
			System.out.println("  Instantiating " + threadName);
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
