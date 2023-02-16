package dong.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import dong.business.Product;
import dong.db.ProductDB;
import dong.db.DBException;
import dong.db.DBUtil;

@SuppressWarnings("serial") // prevents Eclipse from displaying a warning that this class doesn’t have a serial ID
public class ProductTableModel extends AbstractTableModel {

	private List<Product> products;
	private final String[] COLUMN_NAMES = { "Code", "Description", "Price" };

	public ProductTableModel() {
		try {
			products = ProductDB.getAll();
		} catch (DBException e) {
			System.out.println(e);
		}
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return products.get(rowIndex).getCode();
		case 1:
			return products.get(rowIndex).getDescription();
		case 2:
			return products.get(rowIndex).getPriceFormatted();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}

	public Product getProduct(int rowIndex) {
		return products.get(rowIndex);
	}

	public void databaseUpdated() {
		try {
			products = ProductDB.getAll();
			fireTableDataChanged();
		} catch (DBException e) {
			System.out.println(e);
		}
	}

}
