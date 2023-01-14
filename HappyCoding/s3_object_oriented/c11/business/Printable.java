package c11.business;

public interface Printable {
	// void print(); // this method is automatically public and abstract

	default void print() {
		System.out.println(toString());
	}
}
