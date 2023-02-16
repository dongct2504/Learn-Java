package c17.fileNIO2;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FileIOExample {

	public static void main(String[] args) {
		// Get a Path object for the file
		String productsString = "s4_other_essential_skills/c17/fileNIO2/files/products.txt";
		Path productsPath = Paths.get(productsString);

		File productsFile = productsPath.toFile();

		// Write data to the file (set the second parameter to true in FileWriter method to turn on append to existing file)
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile, true)))) {
			//			// use default date time format in USA;
			//			DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

			// use date time format in Vietnam
			String pattern = "kk:mm dd-MM-yyyy";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

			LocalDateTime currentDateTime = LocalDateTime.now();
			out.println("dexter\tDarkly Dreaming Dexter\t300,000 VNĐ\t" + dtf.format(currentDateTime));
		} catch (IOException e) { // catch the IOException (1)
			e.printStackTrace();
		}

		//		// Read data from the file
		//		try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
		//			String line = in.readLine();
		//			System.out.println(line);
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}

		// Read data from the file and handle checked exceptions that must be handled
		// when you’re working with file I/O.
		if (Files.exists(productsPath)) { // prevent the FileNotFoundException (1)
			//			File productsFile = productsPath.toFile();

			// Read data from the file
			try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
				String line;
				while ((line = in.readLine()) != null) { // prevent the EOFException (2)
					System.out.println(line);
				}
			} catch (IOException e) { // catch the IOException (3)
				e.printStackTrace();
			}
		} else {
			System.out.println(productsPath.toAbsolutePath() + " doesn't exist");
		}

	}
}
