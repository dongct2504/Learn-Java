package c4_stacks;

import c3_linked_lists.SinglyLinkedList;

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
	public boolean isEmpty() {
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








