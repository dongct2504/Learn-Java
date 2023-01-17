package c15.learn;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CalculateAge {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LocalDate currentDate = LocalDate.now();

		System.out.print("Please enter your date of birth (YYYY-MM-DD): ");
		LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
		
		int age = calculateAge(currentDate, dateOfBirth);
		
		display(currentDate, dateOfBirth, age);
	}
	
	public static int calculateAge(LocalDate currentDate, LocalDate dateOfBirth) {
		int age = currentDate.getYear() - dateOfBirth.getYear();
		
		LocalDate birthDay = dateOfBirth.withYear(currentDate.getYear());
		if (birthDay.isAfter(currentDate)) {
			return (age - 1);
		} else {
			return age;
		}
	}
	
	public static void display(LocalDate currentDate, LocalDate dateOfBirth, int age) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		
		System.out.println("Your date of birth is: " + dtf.format(dateOfBirth));
		System.out.println("The current date is: " + dtf.format(currentDate));
		System.out.println("Your birth day is: " + dtf.format(dateOfBirth.withYear(currentDate.getYear())));
		System.out.println("Your age is: " + age);
	}
}













