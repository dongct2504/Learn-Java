package c2_recursion_backtracking;

import java.util.Arrays;

/**
 * @author blackd000
 * 3/67) Generate all the strings of n bits. Assume A[0..n – 1] 
 * is an array of size n.
 */
public class GenerateString {

	private static void binary(int n, int arr[]) {
		if (n < 1) {
			System.out.println(Arrays.toString(arr));
		} else {
			arr[n - 1] = 0;
			binary(n - 1, arr);
			arr[n - 1] = 1;
			binary(n - 1, arr);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[3];
		
		binary(3, arr);
	}
}













