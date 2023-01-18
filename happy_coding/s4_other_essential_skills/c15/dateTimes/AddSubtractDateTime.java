package c15.dateTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class AddSubtractDateTime {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		
		usePlus(currentDateTime);
		useMinus(currentDateTime);

		System.out.println();
		useShortcut(currentDateTime);
	}
	
	public static void usePlus(LocalDateTime currentDateTime) {
		LocalDateTime plusDateTime = currentDateTime.plus(3, ChronoUnit.WEEKS);
		System.out.println("Current date time: (" + currentDateTime + ") After plus: (" + plusDateTime + ")");
		
		LocalTime currentTime = LocalTime.of(18, 15);
		LocalTime plusTime = currentTime.plus(4, ChronoUnit.HOURS);
		System.out.println("Current time: (" + currentTime + ") After plus: (" + plusTime + ")");
	}
	
	public static void useMinus(LocalDateTime currentDateTime) {
		LocalDateTime minusDateTime = currentDateTime.minus(5, ChronoUnit.WEEKS);
		System.out.println("Current date time: (" + currentDateTime + ") After minus: (" + minusDateTime + ")");
	}
	
	public static void useShortcut(LocalDateTime currentDateTime) {
		LocalDateTime plusDateTime = currentDateTime.plusWeeks(3);
		System.out.println("Current date time: (" + currentDateTime + ") After plus: (" + plusDateTime + ")");

		LocalTime currentTime = LocalTime.of(18, 15);
		LocalTime plusTime = currentTime.plusHours(4);
		System.out.println("Current time: (" + currentTime + ") After plus: (" + plusTime + ")");
		
		LocalDateTime minusDateTime = currentDateTime.minusWeeks(5);
		System.out.println("Current date time: (" + currentDateTime + ") After minus: (" + minusDateTime + ")");
		
		// use method chaining
		LocalDateTime anotherDateTime = currentDateTime.plusWeeks(9).plusHours(3);
		System.out.println("Another date time: (" + anotherDateTime + ")");
	}
}







