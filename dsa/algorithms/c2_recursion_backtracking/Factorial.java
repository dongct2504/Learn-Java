package c2_recursion_backtracking;

import java.util.Scanner;

public class Factorial {

	// recursive definition of method factorial
	public static long factorial(long number) throws IllegalArgumentException {
		if (number < 0) { // argument must be nonnegative
			throw new IllegalArgumentException(); 
		} else if (number <= 1) { // test for base case
			return 1;
		} else { // test for recursive case
			return number * factorial(number - 1);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println(factorial(Long.parseLong(stdIn.nextLine())));
		
		stdIn.close();
	}

}






