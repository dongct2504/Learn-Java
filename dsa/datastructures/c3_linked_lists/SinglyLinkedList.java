package c3_linked_lists;

public class SinglyLinkedList<E> implements Cloneable {
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public SinglyLinkedList() {}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public E first() {
		if (isEmpty()) {
			return null;
		}
		
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty()) {
			return null;
		}
		
		return tail.getElement();
	}

}












