package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService is an interface that extends Executor class and represents an
 * asynchronous execution. It provides us mechanisms to manage the end and
 * detect progress of the asynchronous tasks.<br>
 * <br>
 * 
 * ExecutorSevice Methods:<br>
 * - execute(Runnable)<br>
 * - submit(Runnable)<br>
 * - submit(Callable)<br>
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
		ExecutorService st = Executors.newSingleThreadExecutor();
		st.execute(new TaskRunnable("st run task 1", 2000, true));
		st.execute(new TaskRunnable("st run task 2", 2000, true));
		// check if single thread executor terminated
		System.out.println("st terminated? : " + st.isTerminated());
		// callable
		Future<String> result = st.submit(new TaskCallable("st call task 1", 1000, true));
		// shutdown single thread executor
		st.shutdown();
		// await termination - this will be false as timeout is less than thread execution times
		if (st.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
			System.out.println(" - st terminated on time i.e. before timeout!");
		} else {
			System.out.println(" - st timeout before tasks completed");
		}
		System.out.println();
		// await termination - this will be true as timeout is greater than thread execution times
		if (st.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
			System.out.println(" - st terminated on time i.e. before timeout!");
		} else {
			System.out.println(" - st timeout before tasks completed");
		}
		System.out.println();
		// check if single thread executor terminated
		System.out.println("st terminated? : " + st.isTerminated());
		// blocking call to get the results (not blocking as by the time flow reaches here result is ready)
		System.out.println(result.get());
	}
}
