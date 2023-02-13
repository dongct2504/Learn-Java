package c17.fileNIO2;

import java.io.IOException;
import java.nio.file.*;

public class WorkWithFile {

	public static void main(String[] args) throws IOException {
		String dirString = "s4_other_essential_skills/c17/fileNIO2/files";

		// Code that creates a directory if it doesn’t already exist
		Path dirPath = Paths.get(dirString);
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
		} else {
			System.out.println("Already exist directory!!");
		}
		
		// Code that creates a file if it doesn’t already exist
		String fileString = "products.txt";
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		} else {
			System.out.println("Already exist file!!");
		}
		
		// Code that displays information about a file
		System.out.println("File name:      " + filePath.getFileName());
		System.out.println("Absolute path:  " + filePath.toAbsolutePath());
		System.out.println("Is writable:    " + Files.isWritable(filePath));
		System.out.println();
		
		// Code that displays the files in a directory
		if (Files.isDirectory(dirPath)) {
			System.out.println("Directory: " + dirPath.toAbsolutePath());
			System.out.println("Files: ");
			DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
			for (Path path : dirStream) {
				if (Files.isRegularFile(filePath)) {
					System.out.println("      " + path.getFileName());
				}
			}
		}

	}
}


















