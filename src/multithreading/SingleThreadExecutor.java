package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService is an interface that extends Executor and represents an
 * asynchronous execution. It provides us mechanisms to manage the end and
 * detect progress of the asynchronous tasks.<br>
 * <br>
 * 
 * ExecutorSevice Methods:<br>
 * - execute(Runnable)<br>
 * - submit(Runnable)<br>
 * - submit(Callable<T>)<br>
 * - shutdown()<br>
 * - isShutdown()<br>
 * - isTerminated()<br>
 * - awaitTermination(long timeout, TmeUnit unit)<br>
 * <br>
 * 
 * Source : https://examples.javacodegeeks.com/core-java/util/concurrent/executorservice/java-executorservice-example-tutorial/ <br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class SingleThreadExecutor {

	public static void main(final String args[]) throws Exception {
		// single thread executor
		ExecutorService service = Executors.newSingleThreadExecutor();
		// sleeps for 2 seconds i.e. 2 seconds for execution
		service.execute(new TaskRunnable("service run task 1", 2000, true));
		service.execute(new TaskRunnable("service run task 2", 2000, true));
		// check if single thread executor terminated
		System.out.println("service terminated? : " + service.isTerminated());
		// callable
		Future<String> result = service.submit(new TaskCallable("service call task 1", 1000, true));
		// shutdown single thread executor
		service.shutdown();
		// await termination - this will be false as timeout is less than thread execution times
		if (service.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
			System.out.println(" - service terminated on time i.e. before timeout!");
		} else {
			System.out.println(" - service timeout before tasks completed");
		}
		System.out.println();
		// await termination - this will be true as timeout is greater than thread execution times
		if (service.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
			System.out.println(" - service terminated on time i.e. before timeout!");
		} else {
			System.out.println(" - service timeout before tasks completed");
		}
		System.out.println();
		// check if single thread executor terminated
		System.out.println("service terminated? : " + service.isTerminated());
		// blocking call to get the results (not blocking as by the time flow reaches here result is ready)
		System.out.println(result.get());
	}
}
