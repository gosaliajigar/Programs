package producer.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * - A Queue that additionally supports operations that wait for the queue to become non-empty when 
 *   retrieving an element, and wait for space to become available in the queue when storing an element.
 * - BlockingQueue methods come in four forms, with different ways of handling operations that cannot 
 *   be satisfied immediately, but may be satisfied at some point in the future: 
 *   - one throws an exception, 
 *   - second returns a special value (either null or false, depending on the operation), 
 *   - third blocks the current thread indefinitely until the operation can succeed, 
 *   - fourth blocks for only a given maximum time limit before giving up. 
 *   
 *   These methods are summarized in the following table:
 *   
 *   			Throws exception	Special value	Blocks		Times out
 *   Insert			add(e)			offer(e)		put(e)		offer(e, time, unit)
 *   Remove			remove()		poll()			take()		poll(time, unit)
 *   Examine		element()		peek()			n/a			n/a
 * 
 * 
 * 
 * - BlockingQueue implementations are designed to be used primarily for producer-consumer queues, 
 *   but additionally support the Collection interface. So, for example, it is possible to remove 
 *   an arbitrary element from a queue using remove(x). However, such operations are in general not 
 *   performed very efficiently, and are intended for only occasional use, such as when a queued 
 *   message is cancelled.
 * - BlockingQueue implementations are thread-safe. All queuing methods achieve their effects 
 *   atomically using internal locks or other forms of concurrency control. However, the bulk 
 *   Collection operations addAll, containsAll, retainAll and removeAll are not necessarily performed 
 *   atomically unless specified otherwise in an implementation. So it is possible, for example, 
 *   for addAll(c) to fail (throwing an exception) after adding only some of the elements in c.
 * 
 * 
 * Demonstrate Producer Consumer Problem.
 * 
 * 
 * Source: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BQMainClass {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();
		BQProducer producer1 = new BQProducer(queue, 1);
		BQConsumer consumer1 = new BQConsumer(queue, 1);
		BQProducer producer2 = new BQProducer(queue, 2);
		BQConsumer consumer2 = new BQConsumer(queue, 2);
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		Thread.sleep(2000);
		new Thread(producer1).start();
		new Thread(producer2).start();
	}
}