package c20.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class SimpleGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Product Manager");
		frame.setSize(500, 300);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException e) {
			System.err.println("Unsupported look and feel");
		}

		//		flowLayoutManager(frame);
		borderLayoutManager(frame);

		frame.setVisible(true);
	}

	public static void flowLayoutManager(JFrame frame) {
		frame.setLayout(new FlowLayout());
		frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
	}

	public static void borderLayoutManager(JFrame frame) {
		frame.add(new JButton("North"), BorderLayout.NORTH);
		frame.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(new JButton("East"), BorderLayout.EAST);
		frame.add(new JButton("West"), BorderLayout.WEST);
		frame.add(new JButton("Center"), BorderLayout.CENTER);
	}

}
