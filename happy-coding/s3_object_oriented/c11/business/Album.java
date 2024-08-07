package c11.business;

public class Album extends Product {

	private String artist;

	public Album() {
		super();
		artist = "";
		count++;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + artist + ")";
	}

	// @Override
	// public String getDisplayText() { // implement the abstract method
	// return super.toString() + " (" + artist + ")";
	// }
}
