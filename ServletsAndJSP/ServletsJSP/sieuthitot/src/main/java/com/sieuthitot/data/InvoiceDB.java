package com.sieuthitot.data;

import java.sql.*;

import com.sieuthitot.business.Invoice;

public class InvoiceDB {
	
	public static int insert(Invoice invoice) throws SQLException {
		String query = "INSERT INTO invoice "
				+ "  (user_id, invoice_date, total_amount, is_processed) "
				+ "VALUES "
				+ "  (?, NOW(), ?, 'n')"; // don't know how to convert LocalDate to Date

		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setLong(1, invoice.getUser().getUserId());
			ps.setBigDecimal(2, invoice.getInvoiceTotal());

			int affectedRows = ps.executeUpdate();

			String lastInvoiceIdQuery = "SELECT MAX(invoice_id) AS last_invoice_id "
					+ "FROM invoice";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(lastInvoiceIdQuery);
			rs.next();
			invoice.setInvoiceId(rs.getLong("last_invoice_id"));

			return affectedRows;
		} catch (SQLException e) {
			throw e;
		}
	}

}







