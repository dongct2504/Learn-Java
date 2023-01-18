package c14.business;

public class Software extends Product {

	private String version;

	public Software() {
		super();
		version = "";
		count++;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return super.toString() + " " + version;
	}

	// @Override
	// public String getDisplayText() { // implement the abstract method
	// return super.toString() + " " + version;
	// }
}
