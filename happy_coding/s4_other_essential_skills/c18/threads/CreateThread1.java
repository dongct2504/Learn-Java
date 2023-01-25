package c18.threads;

// 1. Create a class that inherits the Thread class.
// 2. Override the run method to perform the desired task.
// 3. Create the thread by instantiating an object from the class.
// 4. Call the start method of the thread object.

public class CreateThread1 {

	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println(t1.getName() + " start!!");

		Thread t2 = new IOThread(); // create IOThread
		t2.start(); // start the IOThread
		System.out.println(t1.getName() + " starts " + t2.getName());

		System.out.println(t1.getName() + " finished!!");
	}

}
