package multithreading;

import java.time.LocalTime;

/**
 * @author Jigar Gosalia
 *
 */
public class TaskRunnable implements Runnable {
	int sleep;
	String name;
	boolean goToSleep;
	public TaskRunnable(String name, int sleep, boolean goToSleep) {
		this.name = name;
		this.sleep = sleep;
		this.goToSleep = goToSleep;
	}

	@Override
	public void run() {
		System.out.println(LocalTime.now() + ": executing " + name + " ... ");
		if (goToSleep) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" - completing " + name + " ... \n");
	}
}