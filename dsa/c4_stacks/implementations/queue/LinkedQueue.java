package implementations.queue;

import implementations.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E first() {
		return list.first();
	}

	@Override
	public void enqueue(E element) {
		list.addLast(element);
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}

}
