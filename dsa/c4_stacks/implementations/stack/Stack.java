package implementations.stack;

/**
 * @author blackd000
 * @param <E>
 */
public interface Stack<E> {

	/**
	 * Return the number of elements in the stack
	 * 
	 * @return number of elements
	 */
	int getSize();

	/**
	 * Tests whether the stack is empty
	 * 
	 * @return true if empty, false otherwise
	 */
	boolean empty();

	/**
	 * Inserts element at the top of the stack
	 * 
	 * @param e element to be inserted
	 */
	void push(E e);

	/**
	 * Returns but not remove the element at the top of the stack
	 * 
	 * @return top element in the stack (or null if empty)
	 */
	E top();

	/**
	 * Removes and returns the top element from the stack
	 * 
	 * @return the removed element (or null if empty)
	 */
	E pop();
}
