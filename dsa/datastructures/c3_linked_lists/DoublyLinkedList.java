package c3_linked_lists;

public class DoublyLinkedList<E> {

	private class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.prev = prev;
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

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
	
	// make header and trailer as a node that DOES NOT hold data, they work like sentinel, not a 
	// first node like head, or last node like tail in SinglyLinkedList
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(header);
	}
	
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
		
		return header.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty()) {
			return null;
		}
		
		return trailer.getPrev().getElement();
	}

	/* ***** public update methods ***** */
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
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
			Node<E> currentNode = header.getNext();
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNext();
			}
			addBetween(e, currentNode, currentNode.getNext());
		}
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		
		return removeBetween(header.getNext());
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		
		return removeBetween(trailer.getPrev());
	}
	
	public E removeMiddle(E e) {
		if (isEmpty()) {
			return null;
		}
		
		if (e.equals(header.getNext().getElement())) {
			return removeFirst();
		} else if (e.equals(trailer.getPrev().getElement())) {
			return removeLast();
		} else {
			// Move to the node that need to be deleted (not the position node).
			try {
				Node<E> currentNode = header.getNext();
				while (!e.equals(currentNode.getElement())) {
					currentNode = currentNode.getNext();
				}

				return removeBetween(currentNode);
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
			// Move to the node that need to be deleted (not the position node).
			Node<E> currentNode = header.getNext();
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.getNext();
			}

			return removeBetween(currentNode);
		}
	}
	
	private E removeBetween(Node<E> deleteNode) {
		Node<E> predecessor = deleteNode.getPrev();
		Node<E> successor = deleteNode.getNext();
		
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		
		return deleteNode.getElement();
	}
	
	// print list
	public void printList() {
		Node<E> currentNode = header.getNext();
		while (currentNode != trailer) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNext();
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<String> listNode = new DoublyLinkedList<>();
		listNode.addLast("Dong");
		listNode.addLast("Tay");
		listNode.addLast("Nam");
		listNode.addMiddle(2, "55");
		listNode.removeMiddle("ay");
		listNode.printList();
	}

}











