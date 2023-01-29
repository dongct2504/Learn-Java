package dong.ui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class ProductManagerFrame extends JFrame {

	private ProductTableModel productTableModel;
	private JTable productTable;

	public ProductManagerFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e);
		}
		setTitle("Product Manager");
		setSize(768, 384);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	private JPanel buildButtonPanel() {
		JPanel panel = new JPanel();

		JButton addButton = new JButton("Add");
		addButton.addActionListener((event) -> doAddButton());
		panel.add(addButton);

		JButton editButton = new JButton("Edit");
		editButton.addActionListener((event) -> doEditButton());
		panel.add(editButton);

		JButton deleteButton = new JButton("Edit");
		deleteButton.addActionListener((event) -> doDeleteButton());
		panel.add(deleteButton);

		return panel;
	}

	private void doAddButton() {
		JOptionPane.showMessageDialog(this,
				"This feature hasn't been implemented yet.",
				"Not yet implemented",
				JOptionPane.ERROR_MESSAGE);
	}

	private void doEditButton() {
		doAddButton();
	}

	private void doDeleteButton() {
		int selectedRow = productTable.getSelectedRow();
	}
	

	

	public static void main(String[] args) {
		new ProductManagerFrame();
	}

}
