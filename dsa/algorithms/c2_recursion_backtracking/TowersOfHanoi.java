package c2_recursion_backtracking;

/**
 * @author keilar
 */
public class TowersOfHanoi {
	
	/**
	 * @param disk
	 * @param source
	 * @param destination
	 * @param auxiliary
	 * 
	 */
	public static void towerOfHanoi(int disk, String source, String destination, String auxiliary) {
		// if only 1 disk, make the move and return
		if (disk == 1) {
			System.out.println("Move disk 1 form " + source + " to " + destination);
			return;
		}
		
		// Move top n - 1 disks from Source to Auxiliary
		towerOfHanoi(disk - 1, source, auxiliary, destination);

		// Move the remain disks from Source to Destination
		System.out.println("Move disk " + disk + " form " + source + " to " + destination);
		
		// Move n - 1 disks from Auxiliary to Destination
		towerOfHanoi(disk - 1, auxiliary, destination, source);
	}

	public static void main(String[] args) {
		towerOfHanoi(3, "Source", "Destination", "Auxiliary");
	}

}








