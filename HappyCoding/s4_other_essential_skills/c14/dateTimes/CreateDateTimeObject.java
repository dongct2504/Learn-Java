package c14.dateTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.DayOfWeek;

public class CreateDateTimeObject {

	public static void main(String[] args) {
		// useNow();
		// useOf();
		// useParse();
		getDateTimeParts();
	}

	// === How to create date and time objects === //
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

	// === How to get date and time parts === //
	public static void getDateTimeParts() {
		// Assume a current date/time of October 20, 2023 15:07:30.898000000
		LocalDateTime currentDateTime = LocalDateTime.of(2023, 10, 20, 15, 7, 30, 898000000);

		// The LocalDateTime class supports all of the get methods
		int year = currentDateTime.getYear(); // 2023
		Month month = currentDateTime.getMonth(); // OCTOBER
		int monthValue = currentDateTime.getMonthValue(); // 10
		int day = currentDateTime.getDayOfMonth(); // 20
		System.out.println("Month/Day/Year --> " + monthValue + "/" + day + "/" + year);
		
		int dayOfYear = currentDateTime.getDayOfYear(); // 293
		DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek(); // FRIDAY
		System.out.println(dayOfYear + ", " + dayOfWeek);
		
		int hour = currentDateTime.getHour(); // 15
		int minute = currentDateTime.getMinute(); // 7
		int second = currentDateTime.getSecond(); // 30
		int nano = currentDateTime.getNano(); // 898000000
		System.out.println(hour + ":" + minute + ":" + second + "." + nano);
	}
}









