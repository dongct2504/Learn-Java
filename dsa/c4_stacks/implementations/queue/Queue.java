package implementations.queue;

public interface Queue<E> {

	int getSize();
	boolean isEmpty();
	E first();
	void enqueue(E element);
	E dequeue();
}
