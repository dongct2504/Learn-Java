package dong.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dong.business.Product;

@SuppressWarnings("serial")
public class ProductForm extends JDialog {

	private JTextField codeField;
	private JTextField descriptionField;
	private JTextField priceField;
	private JButton confirmButton;
	private JButton cancelButton;
	
	private Product product = new Product();
	
	public ProductForm(java.awt.Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}
	
	public ProductForm(java.awt.Frame parent, String title, boolean modal, Product product) {
		this(parent, title, modal);
		this.product = product;
		confirmButton.setText("Save");
		codeField.setText(product.getCode());
		descriptionField.setText(product.getDescription());
		priceField.setText(product.getPriceFormatted());
	}
	
	private void initComponents() {
		codeField = new JTextField();
		descriptionField = new JTextField();
		priceField = new JTextField();
		confirmButton = new JButton();
		cancelButton = new JButton();
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		Dimension shortField = new Dimension(100, 20);
		Dimension longField = new Dimension(300, 20);
		codeField.setPreferredSize(shortField);
		codeField.setMinimumSize(shortField);
		descriptionField.setPreferredSize(shortField);
		descriptionField.setMinimumSize(shortField);
		priceField.setPreferredSize(shortField);
		priceField.setMinimumSize(shortField);
		
		cancelButton.setText("Cancel");
		cancelButton.addActionListener((e) -> cancelButtonActionPerformed());
		
		confirmButton.setText("Add");
		confirmButton.addActionListener((e) -> confirmButtonActionPerformed());
		
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridBagLayout());
		productPanel.add(new JLabel("Code:"),
				getConstraints(0, 0, GridBagConstraints.LINE_END));
		productPanel.add(codeField, 
				getConstraints(0, 1, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Description:"),
				getConstraints(1, 0, GridBagConstraints.LINE_END));
		productPanel.add(descriptionField,
				getConstraints(1, 1, GridBagConstraints.LINE_START));
		productPanel.add(new JLabel("Price:"),
				getConstraints(0, 2, GridBagConstraints.LINE_END));
		productPanel.add(priceField,
				getConstraints(1, 2, GridBagConstraints.LINE_START));
	}
	
	private void cancelButtonActionPerformed() {
		
	}
	
	private void confirmButtonActionPerformed() {
		
	}
	
	private GridBagConstraints getConstraints(int x, int y, int anchor) {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 0, 5);

		c.gridx = x;
		c.gridy = y;
		c.anchor = anchor;
		
		return c;
	}
	
}













