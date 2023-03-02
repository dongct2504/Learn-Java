package problems;

import implementations.SinglyLinkedList;

/**
 * 2/130) Find nth node from the end of a Linked List.
 * 
 * @author blackd000
 */
public class FindNthNodeFromEnd {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addLast(5);
		list.addLast(9);
		list.addLast(18);
		list.addLast(2);
		
		System.out.println(list.findNthNodeFromEnd(3)); // 9
	}

}









