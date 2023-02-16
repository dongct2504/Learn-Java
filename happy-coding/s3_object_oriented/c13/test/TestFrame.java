package c13.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

	public TestFrame() {
		// code that setup
		this.setTitle("Test Frame");
		this.setSize(700, 500);
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		this.add(panel);

		// code that creates the button and adds the listener

		JButton button = new JButton("Button");
		// use inner class
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);

		// JButton button = new JButton("Button");
		// // user anonymous class
		// button.addActionListener(new ActionListener() {
		//
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		System.out.println("Hello, The button was clicked!");
		// 	}
		// });

		// code that displays the frame
		panel.add(button);
		this.setVisible(true);
	}

	// the inner class that implements the listener
	class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("The button was clicked!");
		}
	}

	public static void main(String[] args) {
		new TestFrame();
	}
}
