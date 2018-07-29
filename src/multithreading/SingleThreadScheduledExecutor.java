package multithreading;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService is an interface that extends ExecutorService and
 * that can schedule commands to run after a given delay, or to execute
 * periodically.<br>
 * <br>
 * 
 * ScheduledExecutorSevice Methods:
 * - execute(Runnable)<br>
 * - schedule(Callable<T>, delay, unit)<br>
 * - scheduleAtFixedRate(Runnable, initialDelay, period, unit)<br>
 * - scheduleWithFixedDelay(Runnable, initialDelay, delay, unit)<br>
 * <br>
 * 
 * Source : https://examples.javacodegeeks.com/core-java/util/concurrent/scheduledexecutorservice/java-scheduledexecutorservice-example/ <br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SingleThreadScheduledExecutor {

	public static void main(final String args[]) throws Exception {
		// single thread scheduled executor
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// execute(Runnable)
		service.execute(new TaskRunnable("service task 1", 1000, true));
		// schedule(Callable, delay, unit)
		ScheduledFuture<String> result = service.schedule(new TaskCallable("service task 2", 1000, true), 0, TimeUnit.SECONDS);
		// schedule(Runnable, delay, unit)
		service.schedule(new TaskRunnable("service task 3", 1000, true), 0, TimeUnit.SECONDS);
		// scheduleAtFixedRate(Runnable, initialDelay, period, unit)
		// schedules tasks after a fixed period of 2 seconds without caring about last tasks being completed
		service.scheduleAtFixedRate(new TaskRunnable("service fixed rate task 4", 1000, true), 0, 2, TimeUnit.SECONDS);
		// scheduleWithFixedDelay(Runnable, initialDelay, delay, unit)
		// schedules tasks after a fixed delay of 1 second after completion of last task
		service.scheduleWithFixedDelay(new TaskRunnable("service fixed delay task 5", 3000, true), 0, 1, TimeUnit.SECONDS);
		// sleep 15 seconds before shutting down
		TimeUnit.SECONDS.sleep(15);
		service.shutdown();
		// true as service terminated on time before timeout of 20 seconds
		if (service.awaitTermination(20, TimeUnit.SECONDS)) {
			System.out.println("service terminated on time i.e. before timeout!");
		} else {
			System.out.println("service timeout before tasks completed");
		}
		System.out.println(result.get());
		System.out.println("service terminated? : " + service.isTerminated());
		System.out.println();
	}
}
