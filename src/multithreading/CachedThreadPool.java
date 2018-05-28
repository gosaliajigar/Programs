package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Creates a thread pool that creates new threads as needed, but will reuse
 * previously constructed threads when they are available. These pools will
 * typically improve the performance of programs that execute many short-lived
 * asynchronous tasks. Calls to execute will reuse previously constructed
 * threads if available. If no existing thread is available, a new thread will
 * be created and added to the pool. Threads that have not been used for sixty
 * seconds are terminated and removed from the cache. Thus, a pool that remains
 * idle for long enough will not consume any resources. Note that pools with
 * similar properties but different details (for example, timeout parameters)
 * may be created using ThreadPoolExecutor constructors<br>
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
public class CachedThreadPool {

	public static void main(final String args[]) throws Exception {
		// cached thread pool
		ExecutorService ct = Executors.newCachedThreadPool();
		// creates 100 threads that take 3 seconds each to process
		for (int i = 1; i <= 100; i++) {
			ct.submit(new TaskRunnable("ct task " + i, 3000, true));
		}
		TimeUnit.SECONDS.sleep(6);
		ct.shutdown();
		if (ct.awaitTermination(8, TimeUnit.SECONDS)) {
			System.out.println("ct terminated on time i.e. before timeout!");
		} else {
			System.out.println("ct timeout before tasks completed");
		}
		System.out.println("ct terminated? : " + ct.isTerminated());
		System.out.println();
	}
}
