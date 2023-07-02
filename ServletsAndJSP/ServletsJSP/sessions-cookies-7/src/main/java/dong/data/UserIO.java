package dong.data;

import dong.business.User;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserIO {

	private static final String FIELD_SEP = "\t";
	private static List<User> users;

	public static List<User> getAll(String path) {
		if (users != null) {
			return users;
		}

		Path usersPath = Paths.get(path);
		if (Files.exists(usersPath)) {
			users = new ArrayList<>();

			File usersFile = usersPath.toFile();
			try (BufferedReader in = new BufferedReader(new FileReader(usersFile))) {
				String line;
				while ((line = in.readLine()) != null) {
					String[] columns = line.split(FIELD_SEP);
					String name = columns[0];
					String email = columns[1];

					users.add(new User(name, email));
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			System.out.println("Path doesn't exist");
		}

		return users;
	}

	public static User getUser(String email, String path) {
		users = getAll(path);
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
	}

	public static void addUser(User user, String path) {
		if (users == null) {
			users = new ArrayList<>();
		}
		users.add(user);
		System.out.println(path);
		saveAll(path);
	}

	private static boolean saveAll(String path) {
		Path usersPath = Paths.get(path);
		if (Files.exists(usersPath)) {
			File usersFile = usersPath.toFile();
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(usersFile)))) {
				// write all products in the array list to the file
				for (User user : users) {
					out.print(user.getName() + FIELD_SEP);
					out.print(user.getEmail() + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Path doesn't exist");
		}

		return true;
	}

}
