package c15.learn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeTest {

	public static void main(String[] args) {
		// useNow();
		// useOf();
		useParse();
	}

	public static void useNow() {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);

		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);
	}

	public static void useOf() {
		LocalDate halloween1 = LocalDate.of(2023, Month.OCTOBER, 31);
		LocalDate halloween2 = LocalDate.of(2023, 10, 31);
		System.out.println(halloween1 + ", " + halloween2);

		LocalTime startTime1 = LocalTime.of(14, 32); // minutes
		LocalTime startTime2 = LocalTime.of(14, 32, 45); // seconds
		LocalTime startTime3 = LocalTime.of(14, 32, 45, 123456789); // nanoseconds
		System.out.println(startTime1 + ", " + startTime2 + ", " + startTime3);

		LocalDateTime startDateTime1 = LocalDateTime.of(halloween1, startTime2);
		LocalDateTime startDateTime2 = LocalDateTime.of(2023, 10, 31, 14, 32);
		System.out.println(startDateTime1 + ", " + startDateTime2);
	}

	public static void useParse() {
		LocalDate halloween3 = LocalDate.parse("2023-10-31");
		System.out.println(halloween3);

		LocalTime startTime4 = LocalTime.parse("02:32:45");
		System.out.println(startTime4);

		LocalDateTime startDateTime3 = LocalDateTime.parse("2023-10-31T02:32:45.123456789");
		System.out.println(startDateTime3);
	}
}
