package dong.ui;

public class UpdateProducts {

	public static void main(String[] args) {
		// Display welcome message
		System.out.println("Welcome to the Product Manager\n");
		
		displayMenu();
		getCommand();
	}
	
	public static void displayMenu() {
		String message = 
				"COMMAND MENU\n" +
				"list     - List all products\n" +
				"add      - Add a product\n" +
				"del      - Delete a product\n" +
				"help     - Show this menu\n" +
				"exit     - Exit this application\n";
		
		System.out.println(message);
	}
	
	public static void getCommand() {
		String action = "";
		while (!action.equals("exit")) {
			action = Console.getString("Enter your command: ");
			System.out.println();
			
			if (action.equalsIgnoreCase("list")) {
				
			} else if (action.equalsIgnoreCase("add")) {
				
			} else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
				
			} else if (action.equalsIgnoreCase("help")) {
				
			} else if (action.equalsIgnoreCase("exit")) {
				
			}

		}
		
	}
	
	public static void displayAllProducts() {
		System.out.println("Display");
	}
}













