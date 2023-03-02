package problems;

import java.util.Stack;

/**
 * 2/185) Discuss infix to postfix conversion algorithm using stack.
 * 
 * @author blackd000
 */
public class InfixToPostfix {

	/**
	 * Algorithm: 
	 *   1) If the scanned character is an operand (toán hạng),
	 * {{c1::output}} it. 
	 *   2) If the scanned character is a left parenthesis ‘(‘, {{c1::push}} it to
	 * the stack. 
	 *   3) If the scanned character is a right parenthesis ‘)’, {{c1::pop}} the stack and
	 * {{c1::output}} it until a {{c1::‘(‘}} is popped (but not output),
	 *   4) Else if the scanned character is an operator (toán tử), then 
	 *     4.1) While the precedence of the scanned operator are {{c1::smaller}} than 
	 *     or {{c1::equal}} to the precedence of the operator in the stack, pop and output it. 
	 *     4.2) When you exit while loop, push that {{c1::scanned operator}} to the stack.
	 *   5) {{c1::Pop}} and {{c1::output}} scanned character until the stack is {{c1::empty}}.
	 * 
	 * @param expression that need to be converted
	 * @return the postfix result
	 */
	public static String infixToPostfix(String expression) throws IllegalArgumentException {
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (Character.isLetterOrDigit(c)) { // encounter an operand
				sb.append(c);
			} else if (c == '(') { // encounter a left parenthesis
				stack.push(c);
			} else if (c == ')') { // encounter a right parenthesis
				// pop and output until '(' is popped (but not output)
				while (!stack.empty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else { // encounter an operator
				// while the precedence of the scanned operator is smaller or equal to the precedence
				// of the operator in the stack, pop and output
				while (!stack.empty() && precedence(c) <= precedence(stack.peek())) {
					sb.append(stack.pop());
				}
				// when you exit while loop, push that scanned operator to the stack
				stack.push(c);
			}
		}
		
		while (!stack.empty()) {
			if (stack.peek() == '(') { // edge case
				throw new IllegalArgumentException("Invalid expression");
			}
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	/**
	 * Helper method to check the character's precedence
	 * 
	 * @param c the character that need to be check precedence
	 * @return the precedence of the input character
	 */
	private static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // abcd^e-fgh*+^*+i-
	}

}







