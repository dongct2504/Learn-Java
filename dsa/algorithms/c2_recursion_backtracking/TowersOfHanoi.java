package c2_recursion_backtracking;

/**
 * @author blackd000
 */
public class TowersOfHanoi {
	
	/**
	 * Algorithm:
	 * 1) Move the top n – 1 disks from Source to Auxiliary tower,
	 * 2) Move the nth disk from Source to Destination tower,
	 * 3) Move the n – 1 disks from Auxiliary tower to Destination tower.
	 * 4) Transferring the top n – 1 disks from Source to Auxiliary tower can again be thought
	 * of as a fresh problem and can be solved in the same manner. Once we solve Towers
	 * of Hanoi with three disks, we can solve it with any number of disks with the above
	 * algorithm.
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








