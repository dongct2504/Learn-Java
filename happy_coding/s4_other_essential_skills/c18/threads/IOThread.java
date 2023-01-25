package c18.threads;

public class IOThread extends Thread {

	@Override
	public void run() {
		System.out.println(this.getName() + " started!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}

		System.out.println(this.getName() + " finished!!");
	}
}
