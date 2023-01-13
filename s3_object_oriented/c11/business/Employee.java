package c11.business;

public class Employee implements Printable, DepartmentConstants {

	private int department;
	private String firstName;
	private String lastName;
	
	public Employee(int department, String firstName, String lastName) {
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public void print() {
		String dept = "unknown";
		if (department == ADMIN) {
			dept = "Administration";
		} else if (department == EDITORIAL) {
			dept = "Editorial";
		} else if (department == MARKETING) {
			dept = "Marketing";
		}
		
		System.out.println(firstName + " " + lastName + " (" + dept + ")");
	}
}
