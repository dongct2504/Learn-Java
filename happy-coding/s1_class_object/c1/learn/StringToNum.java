package c1.learn;

import java.util.Scanner;

public class StringToNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your price: ");
		double price = Double.parseDouble(sc.nextLine());
		
		System.out.println("Your price is: " + price);
	}
}
