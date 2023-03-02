package implementations;

/**
 * @author blackd000
 * @param <E> Element
 */
public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> list;

	public LinkedStack() {
		list = new SinglyLinkedList<>();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean empty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		return list.first();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

}
