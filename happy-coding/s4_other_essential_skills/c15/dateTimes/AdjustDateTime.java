package c15.dateTimes;

import java.time.*;

public class AdjustDateTime {

	public static void main(String[] args) {
		changeDateOfMonth();
		// changeThatThrowsException();
		quietlyChangeDayOfMonth();
	}

	public static void changeDateOfMonth() {
		LocalDate date = LocalDate.of(2023, 10, 20);
		LocalDate newDate = date.withDayOfMonth(31);
		System.out.println(newDate);
	}

	public static void changeThatThrowsException() {
		LocalDateTime dateTime1 = LocalDateTime.parse("2023-02-28T15:30");
		// throws DateTimeException because 2023 is not a leap year. So in 2023,
		// February is only have 28 days
		LocalDateTime newDateTime1 = dateTime1.withDayOfMonth(29);
		System.out.println(newDateTime1);
	}

	public static void quietlyChangeDayOfMonth() {
		LocalDateTime dateTime2 = LocalDateTime.parse("2023-10-31T15:30");
		LocalDateTime newDateTime2 = dateTime2.withMonth(2); // quietly changes the day of month to 28
		System.out.println(newDateTime2);
	}
}
