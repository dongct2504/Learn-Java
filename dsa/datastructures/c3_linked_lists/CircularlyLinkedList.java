package c3_linked_lists;

/**
 * @author blackd000
 * @param <E>
 */
public class CircularlyLinkedList<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;

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

	private Node<E> tail; // unlike SinglyLinkedList, I only store tail but not head
	private int size;

	public CircularlyLinkedList() {}

	/* ***** public access methods ***** */

	public boolean isEmpty() {
		return (size == 0);
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}

		return tail.getNext().getElement();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}

		return tail.getElement();
	}

	/* ***** public update methods ***** */

	// rotate the first element to the back of the list
	public void rotate() {
		if (!isEmpty()) {
			tail = tail.getNext();
		}
	}

	public void addFirst(E e) {
		if (isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail); // link to itself circularly
		} else {
			Node<E> newNode = new Node<>(e, tail.getNext());
			tail.setNext(newNode);
		}
		size++;
	}

	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		Node<E> head = tail.getNext();
		if (head == tail) {
			tail = null; // must be the only node left
		} else {
			tail.setNext(head.getNext()); // removes "head" (tail.getNext().getNext()) from the list
		}
		size--;

		return head.getElement();
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		Node<E> currentNode = tail.getNext(); // get head node
		if (currentNode == tail) {
			tail = null;
			return currentNode.getElement();
		} else {
			while (currentNode.getNext() != tail) {
				currentNode = currentNode.getNext();
			}
			E removedElement = tail.getElement();
			tail = currentNode;
			tail.setNext(currentNode.getNext().getNext());

			return removedElement;
		}
	}

	public void printList() {
		if (isEmpty()) {
			System.err.println("Empty list");
			return;
		}

		Node<E> currentNode = tail.getNext();
		while (currentNode != tail) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNext();
		}
		System.out.println(tail.getElement()); // print the last element (tail node)
	}

	public static void main(String[] args) {
		CircularlyLinkedList<String> list = new CircularlyLinkedList<>();
		list.addFirst("hh");
		list.addLast("Dong");
		list.addLast("Tay");

		list.printList();
	}

}
