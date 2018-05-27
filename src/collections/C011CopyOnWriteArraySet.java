package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A Set that uses an internal CopyOnWriteArrayList for all of its operations.
 * Thus, it shares the same basic properties: <br>
 * <br>
 * 1. It is best suited for applications in which set sizes generally stay
 * small, read-only operations vastly outnumber mutative operations, and you
 * need to prevent interference among threads during traversal.<br>
 * 2. It is thread-safe.<br>
 * 3. Mutative operations (add, set, remove, etc.) are expensive since they
 * usually entail copying the entire underlying array.<br>
 * 4. Iterators do not support the mutative remove operation.<br>
 * 5. Traversal via iterators is fast and cannot encounter interference from
 * other threads.<br>
 * 6. Iterators rely on unchanging snapshots of the array at the time the
 * iterators were constructed.<br>
 * <br>
 * Source:
 * https://examples.javacodegeeks.com/core-java/util/concurrent/copyonwritearrayset/java-util-concurrent-copyonwritearrayset-example/
 * <br>
 * 
 * @author Jigar Gosalia
 *
 */
public class C011CopyOnWriteArraySet {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ForumTopics[] timeline = new ForumTopics[5];

		// Create five Topics
		// Costly operation - A new copy of the collection is created each time
		timeline[0] = new ForumTopics(new Topic("Topic1", "Description1"), ForumTopics.Operation.ADD);
		timeline[1] = new ForumTopics(new Topic("Topic2", "Description2"), ForumTopics.Operation.ADD);
		timeline[2] = new ForumTopics(new Topic("Topic3", "Description3"), ForumTopics.Operation.ADD);
		timeline[3] = new ForumTopics(new Topic("Topic4", "Description4"), ForumTopics.Operation.ADD);
		timeline[4] = new ForumTopics(new Topic("Topic5", "Description5"), ForumTopics.Operation.ADD);

		for (int i = 0; i < 5; i++) {
			executorService.submit(timeline[i]);
		}

		// Print Topics
		ForumTopics.printTopics();

		// Costly operation - A new copy of the collection is created each time
		timeline[0].setOperation(ForumTopics.Operation.REMOVE);
		executorService.submit(timeline[0]);

		// Print Topics
		ForumTopics.printTopics();

		// Try to remove an Topic using the iterator
		Iterator<Topic> it = ForumTopics.getTopics().iterator();
		try {
			it.remove();
		} catch (UnsupportedOperationException uoe) {
			uoe.printStackTrace(System.err);
		}

		executorService.shutdown();
	}
}

class Topic {
	private String title;
	private String description;

	public Topic(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [title = " + title + ", description = " + description + "]";
	}
}

class ForumTopics implements Runnable {
	public static enum Operation {
		ADD, REMOVE
	}

	private Topic topic;
	private Operation operation;
	private static final CopyOnWriteArraySet<Topic> topics = new CopyOnWriteArraySet<Topic>();

	public ForumTopics(Topic topic, Operation operation) {
		this.topic = topic;
		this.operation = operation;
	}

	public void addTopic(Topic topic) { topics.add(topic); }

	public void removeTopic(Topic topic) { topics.remove(topic); }

	public static void printTopics() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Topics:");
			Iterator<Topic> it = topics.iterator();
			while (it.hasNext()) {
				System.out.printf(it.next() + " ");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public static CopyOnWriteArraySet<Topic> getTopics() {
		return topics;
	}

	@Override
	public void run() {
		switch (this.operation) {
		case ADD:
			this.addTopic(this.topic);
			break;
		case REMOVE:
			this.removeTopic(this.topic);
			break;
		}
	}
}