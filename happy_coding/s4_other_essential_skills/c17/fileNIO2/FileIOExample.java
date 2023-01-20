package c17.fileNIO2;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FileIOExample {

	public static void main(String[] args) {
		// Get a Path object for the file
		String productsString = "./s4_other_essential_skills/c17/fileNIO2/files/products.txt";
		Path productsPath = Paths.get(productsString);

		if (Files.exists(productsPath)) { // prevent the FileNotFoundException (1)
			File productsFile = productsPath.toFile();

			// Write data to the file (true in FileWriter method to turn on append to existing file)
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile, true)))) {
				DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
				LocalDateTime currentDateTime = LocalDateTime.now();
				out.println("Java's murach\tMurach's beginning Java\t57.50\t" + dtf.format(currentDateTime));
			} catch (IOException e) { // catch the IOException (2)
				e.printStackTrace();
			}
		} else {
			System.out.println(productsPath.toAbsolutePath() + " doesn't exist");
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
			File productsFile = productsPath.toFile();

			// Read data from the file
			try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
				String line = null;
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







