package c15.learn;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.*;

public class FormatDateTimeObject {

	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();

		useSameStyle(currentDateTime);
		useSeparateStyle(currentDateTime);
	}
	
	// use the same style to format both the date and time
	public static void useSameStyle(LocalDateTime currentDateTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // format both the date and time
		
		String currentDateTimeFormatted = dtf.format(currentDateTime);
		
		System.out.println("Before: (" + currentDateTime + ") After: (" + currentDateTimeFormatted + ")");
	}
	
	public static void useSeparateStyle(LocalDateTime currentDateTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.MEDIUM); // format date and then time
		
		String currentDateTimeFormatted = dtf.format(currentDateTime);
		
		System.out.println("Before: (" + currentDateTime + ") After: (" + currentDateTimeFormatted + ")");
	}
}










