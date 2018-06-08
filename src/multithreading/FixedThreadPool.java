package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Creates a thread pool that reuses a fixed number of threads operating off a
 * shared unbounded queue. At any point, at most nThreads threads will be active
 * processing tasks. If additional tasks are submitted when all threads are
 * active, they will wait in the queue until a thread is available. If any
 * thread terminates due to a failure during execution prior to shutdown, a new
 * one will take its place if needed to execute subsequent tasks. The threads in
 * the pool will exist until it is explicitly shutdown.<br>
 * <br>
 *
 * Executors.newCachedThreadPool and Executors.newFixedThreadPool are both
 * backed by the same thread pool implementation just with different parameters.
 * (thread minimum, maximum, thread kill time, and queue type.<br>
 * <br>
 * 
 * public static ExecutorService newFixedThreadPool(int nThreads) { return new
 * ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new
 * LinkedBlockingQueue<Runnable>()); } <br>
 * 
 * public static ExecutorService newCachedThreadPool() { return new
 * ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new
 * SynchronousQueue<Runnable>()); } <br>
 * <br>
 * 
 * A FixedThreadPool does have its advantages when you do in fact want to work
 * with a fixed number of threads, since then you can submit any number of tasks
 * to the executor service while knowing that the number of threads will be
 * maintained at the level you specified. If you explicitly want to grow the
 * number of threads, then this is not the appropriate choice.<br>
 * <br>
 * 
 * This does however mean that the one issue that you may have with the
 * CachedThreadPool is in regards to limiting the number of threads that are
 * running concurrently. The CachedThreadPool will not limit them for you, so
 * you may need to write your own code to ensure that you do not run too many
 * threads. This really depends on the design of your application and how tasks
 * are submitted to the executor service.<br>
 * <br>
 * 
 * Source:
 * https://stackoverflow.com/questions/17957382/fixedthreadpool-vs-cachedthreadpool-the-lesser-of-two-evils
 * <br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class FixedThreadPool {

	public static void main(final String args[]) throws Exception {
		// cached thread pool
		ExecutorService ft = Executors.newFixedThreadPool(2);
		// submit 10 tasks which be taken care by only 2 threads
		// processing time of each task is 3 seconds
		for (int i = 1; i <= 10; i++) {
			ft.submit(new TaskRunnable("ct task " + i, 3000, true));
		}
		// sleep for 20 seconds as 10 threads (3 seconds worth of work) 
		// would take at least 15 seconds to be executed by 2 threads
		TimeUnit.SECONDS.sleep(20);
		ft.shutdown();
		if (ft.awaitTermination(21, TimeUnit.SECONDS)) {
			System.out.println("ct terminated on time i.e. before timeout!");
		} else {
			System.out.println("ct timeout before tasks completed");
		}
		System.out.println("ct terminated? : " + ft.isTerminated());
		System.out.println();
	}
}
