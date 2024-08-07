package learn.ui;

import learn.business.Invoice;
import learn.business.LineItem;
import learn.business.Product;
import learn.db.ProductDB;

public class InvoiceApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Invoice application\n");

		Invoice invoice = new Invoice();
		getLineItems(invoice);
		displayInvoice(invoice);
	}

	public static void getLineItems(Invoice invoice) {
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String productCode = Console.getString("Enter product code: ");
			int quantity = Console.getInt("Enter quantity: ");

			Product product = ProductDB.getProduct(productCode);
			invoice.addItem(new LineItem(product, quantity));

			choice = Console.getString("Another line item? (y/n): ");
			System.out.println();
		}
	}

	public static void displayInvoice(Invoice invoice) {
		StringBuilder sb = new StringBuilder();
		sb.append(StringUtil.pad("Invoice date:", 20));
		sb.append(invoice.getInvoiceDateFormatted() + "\n");
		sb.append(StringUtil.pad("Invoice due date:", 20));
		sb.append(invoice.getDueDateFormatted() + "\n\n");
		
		sb.append(StringUtil.pad("Description", 40));
		sb.append(StringUtil.pad("Price", 10));
		sb.append(StringUtil.pad("Qty", 8));
		sb.append(StringUtil.pad("Total", 10));
		sb.append("\n");
		
		for (LineItem lineItem : invoice.getLineItem()) {
			Product product = lineItem.getProduct();
			sb.append(StringUtil.pad(product.getDescription(), 40));
			sb.append(StringUtil.pad(product.getPriceFormatted(), 10));
			sb.append(StringUtil.pad(lineItem.getQuantityFormatted(), 8));
			sb.append(StringUtil.pad(lineItem.getTotalFormatted(), 10));
			sb.append("\n");
		}
		
		sb.append("\nInvoice Total: ");
		sb.append(invoice.getTotalFormatted());
		sb.append("\n");

		System.out.println(sb.toString());
	}
}
