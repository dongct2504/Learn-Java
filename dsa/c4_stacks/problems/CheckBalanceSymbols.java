package problems;

import java.util.Stack;

/**
 * 1/183) Discuss how stacks can be used for checking balancing of symbols.
 * 
 * @author blackd000
 */
public class CheckBalanceSymbols {

	/**
	 * Algorithm:
	 *   1) Each time we encounter an opening symbol, we push that symbol onto the stack
	 *   2) Each time we encounter a closing symbol, we pop a symbol from the 
	 *   stack (assuming it is not empty) and Check that these two symbols form a valid pair.
	 *   3) If we reach the end of the expression and the stack is empty, then the original 
	 *   expression was properly matched. Otherwise, there must be an opening delimiter on 
	 *   the stack without a matching symbol.
	 *   
	 * @param expression
	 * @return true if reach the end of the expression and the stack is empty, false if doesn't
	 */
	public static boolean isMatched(String expression) {
		final String OPENING = "({[";
		final String CLOSING = ")}]";
		
		Stack<Character> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (OPENING.indexOf(c) != -1) { // encounter opening symbol
				stack.push(c);
			} else if (CLOSING.indexOf(c) != -1) { // encounter closing symbol
				if (stack.empty()) { // stack empty so nothing to match with
					return false;
				}
				if (CLOSING.indexOf(c) != OPENING.indexOf(stack.pop())) {
					return false; // mismatched index of closing with opening
				}
			} 
		}
		return stack.empty();
	}
	
	public static void main(String[] args) {
		String expression = "[(18 * 93) / 27] - 15";
		
		System.out.println(isMatched(expression));
	}
	
}







