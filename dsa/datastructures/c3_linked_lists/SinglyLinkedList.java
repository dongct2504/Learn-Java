package c3_linked_lists;

import java.util.ArrayList;

/**
 * @author blackd000
 * @param <E>
 */
public class SinglyLinkedList<E> {

	// inner class
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

	/* ***** public access methods ***** */

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

	/* ***** public update methods ***** */

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e, null);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	public void addMiddle(int index, E e) {
		if (index < 0 || index > size) {
			System.err.println("Invalid input!!");
			return;
		}

		if (index == 0) {
			addFirst(e);
		} else if (index == size) {
			addLast(e);
		} else {
			// move to the position node
			Node<E> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNext();
			}
			Node<E> newNode = new Node<>(e, currentNode.getNext());
			currentNode.setNext(newNode);
		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E removedElement = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}

		return removedElement;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		Node<E> currentNode = head;
		while (currentNode.getNext() != tail) {
			currentNode = currentNode.getNext();
		}

		E removedElement = tail.getElement();
		tail = currentNode;
		tail.setNext(null);

		return removedElement;
	}

	public E removeMiddle(E e) {
		if (isEmpty()) {
			return null;
		}

		if (e.equals(head.getElement())) {
			return removeFirst();
		} else if (e.equals(tail.getElement())) {
			return removeLast();
		} else {
			// move to the position node (before the node to be deleted)
			try {
				Node<E> currentNode = head;
				while (!e.equals(currentNode.getNext().getElement())) {
					currentNode = currentNode.getNext();
				}
				E removedElement = currentNode.getNext().getElement();
				currentNode.setNext(currentNode.getNext().getNext());
				size--;

				return removedElement;
			} catch (NullPointerException ex) {
				System.err.println("Can't find '" + e + "' try another");
				return null;
			}
		}
	}

	public E removeMiddle(int index) {
		if (isEmpty()) {
			return null;
		}

		if (index < 0 || index > size - 1) {
			System.err.println("Invalid input!!");
			return null;
		}

		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			// move to the position node
			Node<E> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNext();
			}
			E removedElement = currentNode.getNext().getElement();
			currentNode.setNext(currentNode.getNext().getNext());
			size--;

			return removedElement;
		}
	}

	public void clearList() {
		head = null;
		tail = null;
		size = 0;
	}

	// print list
	public void printList() {
		Node<E> currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNext();
		}
	}

	// test drive
	public static void main(String[] args) {
		SinglyLinkedList<String> listNode = new SinglyLinkedList<>();
		listNode.addLast("Dong");
		listNode.addLast("Tay");
		listNode.addLast("Nam");
		listNode.addMiddle(2, "55");
		listNode.removeMiddle("dd");
		listNode.printList();

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add(2, "33");
		System.out.println(arrayList);
	}

}
