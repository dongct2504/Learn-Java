package dong.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dong.business.Product;
import dong.db.DBException;
import dong.db.ProductDB;

@SuppressWarnings("serial")
public class ProductManagerFrame extends JFrame {

	private final Font FONT = new Font("Arial", Font.PLAIN, 14);

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
		setSize(700, 600);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(buildButtonPanel(), BorderLayout.SOUTH);
		productTable = buildProductTable();
		add(new JScrollPane(productTable), BorderLayout.CENTER);
		setVisible(true);
	}

	private JPanel buildButtonPanel() {
		JPanel panel = new JPanel();

		JButton addButton = new JButton("Add");
		addButton.addActionListener((event) -> doAddButton());
		addButton.setFont(FONT);
		panel.add(addButton);

		JButton editButton = new JButton("Edit");
		editButton.addActionListener((event) -> doEditButton());
		editButton.setFont(FONT);
		panel.add(editButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener((event) -> doDeleteButton());
		deleteButton.setFont(FONT);
		panel.add(deleteButton);

		return panel;
	}

	private void doAddButton() {
		ProductForm productForm = new ProductForm(this, "Add Product", true);
		productForm.setLocationRelativeTo(this);
		productForm.setVisible(true);
	}

	private void doEditButton() {

	}

	private void doDeleteButton() {
		int selectedRow = productTable.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this,
					"Vui lòng lựa chọn sản phẩm!!",
					"Chưa chọn",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Product product = productTableModel.getProduct(selectedRow);
			int ask = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc muốn xóa sản phẩm '" + 
							product.getDescription() + "' ra khỏi database không?\n" + 
							"Điều này sẽ không thể khôi phục!!",
					"Chắc chưa",
					JOptionPane.YES_NO_OPTION);
			if (ask == JOptionPane.YES_OPTION) {
				try {
					ProductDB.delete(product);
					productTableModel.databaseUpdated();
				} catch (DBException e) {
					System.out.println(e);
				}
			}
		}
	}

	private JTable buildProductTable() {
		productTableModel = new ProductTableModel();
		JTable table = new JTable(productTableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(null);
		table.setRowHeight(20);
		table.setFont(FONT);
		return table;
	}

	public static void main(String[] args) {
		new ProductManagerFrame();
	}

}
