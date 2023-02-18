package c3_linked_lists;

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

	// access methods
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
	
	// insert methods
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

	public void addMiddle(E e, int position) {
		if (position < 0 || position > size) {
			System.err.println("Invalid input!!");
			return;
		}
		
		if (position == 0) {
			addFirst(e);
		} else if (position == size) {
			addLast(e);
		} else {
			Node<E> currentNode = head;
			for (int i = 0; i < position - 1; i++) {
				currentNode = currentNode.getNext();
			}
			Node<E> newNode = new Node<>(e, currentNode.getNext());
			currentNode.setNext(newNode);
		}
		size++;
	}
	
	// delete methods
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

	public E remove(E e) {
		if (isEmpty()) {
			return null;
		}
		if (e.equals(head.getElement())) {
			return removeFirst();
		} else if (e.equals(tail.getElement())) {
			return removeLast();
		} else {
			Node<E> currentNode = head;
			while (currentNode.getNext().getNext() != null) {
				if (e.equals(currentNode.getNext().getElement())) {
					E removedElement = currentNode.getNext().getElement();
					currentNode.setNext(currentNode.getNext().getNext());

					return removedElement;
				}
				currentNode = currentNode.getNext();
			}
		}
		return null;
	}
	
	public E remove(int position) {
		if (isEmpty()) {
			return null;
		}

		if (position < 0 || position > size - 1) {
			System.err.println("Invalid input!!");
			return null;
		}
		if (position == 0) {
			return removeFirst();
		} else {
			Node<E> currentNode = head;
			for (int i = 0; i < position - 1; i++) {
				currentNode = currentNode.getNext();
			}
			E removedElement = currentNode.getNext().getElement();
			currentNode.setNext(currentNode.getNext().getNext());

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
		listNode.addFirst("Dong");
		listNode.addFirst("Nam");
		listNode.addLast("Bac");
		
		listNode.addMiddle("11", 2);
		
		listNode.printList();
	}

}











