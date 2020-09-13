package multithreading;

import java.time.LocalTime;
import java.util.concurrent.Callable;

/**
 * 
 * The need for Callable
 * 
 * - There are two ways of creating threads – one by extending the Thread class and other by creating a 
 *   thread with a Runnable. However, one feature lacking in Runnable is that we cannot make a thread 
 *   return result when it terminates, i.e. when run() completes.
 * 
 * @author Jigar Gosalia
 *
 */
public class TaskCallable implements Callable<String> {
	int sleep;
	String name;
	boolean goToSleep;

	public TaskCallable(String name, int sleep, boolean goToSleep) {
		this.name = name;
		this.sleep = sleep;
		this.goToSleep = goToSleep;
	}

	@Override
	public String call() throws Exception {
		if (goToSleep) {
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(LocalTime.now() + ": executing " + name + " ... ");
		return " - " + name + " completed";
	}
}