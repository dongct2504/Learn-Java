package c15.learn;

import java.time.*;

public class CompareTime {

	public static void main(String[] args) {
		useIsBefore();
		useIsAfter();
		useCompareTo();
	}

	public static void useIsBefore() {
		LocalDate currentDate = LocalDate.now(); // 2023/1/15
		LocalDate halloween = LocalDate.of(2023, Month.OCTOBER, 31);

		if (currentDate.isBefore(halloween)) {
			System.out.println("Current date (" + currentDate + ") is before Halloween (" + halloween + ")");
		}
	}

	public static void useIsAfter() {
		LocalTime currentTime = LocalTime.now();
		LocalTime startTime = LocalTime.of(8, 30);

		if (currentTime.isAfter(startTime)) {
			System.out.println("Current time (" + currentTime + ") is after start time (" + startTime + ")");
		}
	}

	public static void useCompareTo() {
		// LocalDate currentDate = LocalDate.now();
		LocalDate currentDate = LocalDate.of(2023, Month.OCTOBER, 31);
		LocalDate halloween = LocalDate.of(2023, Month.OCTOBER, 31);

		if (currentDate.compareTo(halloween) < 0) {
			System.out.println("Current date (" + currentDate + ") is before Halloween (" + halloween + ")");
		} else if (currentDate.compareTo(halloween) > 0) {
			System.out.println("Current date (" + currentDate + ") is after Halloween (" + halloween + ")");
		} else if (currentDate.compareTo(halloween) == 0) {
			System.out.println("Current date (" + currentDate + ") is Halloween");
		}
	}
}






