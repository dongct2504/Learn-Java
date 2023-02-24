package c4_stacks;

/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle (LIFO). Although similar in purpose, this interface differs from
 * java.util.Stack
 * 
 * @author blackd000
 * @param <E>
 */
public interface Stack<E> {

	/**
	 * Return the number of elements in the stack
	 * @return number of elements
	 */
	int getSize();
	
	/**
	 * Tests whether the stack is empty
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Inserts element at the top of the stack
	 * @param e  the element to be inserted
	 */
	void push(E e);
	
	/**
	 * Returns but not remove the element at the top of the stack
	 * @return top element in the stack (or null if empty)
	 */
	E top();
	
	/**
	 * Removes and returns the top element from the stack
	 * @return the removed element (or null if empty)
	 */
	E pop();
}
