package producer.consumer;

/**
 * Demonstrate Producer Consumer Problem.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SBMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedBuffer sharedBuffer = new SharedBuffer();
		SBProducer producer = new SBProducer(sharedBuffer, 1);
		SBConsumer consumer = new SBConsumer(sharedBuffer, 1);
		producer.start();
		consumer.start();
	}
}