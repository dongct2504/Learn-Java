package c3_linked_lists;

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
	
	
	public static void main(String[] args) {
		
	}

}
