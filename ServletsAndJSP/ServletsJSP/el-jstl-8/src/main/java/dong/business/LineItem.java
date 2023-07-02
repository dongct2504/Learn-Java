package dong.business;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SuppressWarnings("serial")
public class LineItem implements Serializable {

	private Product product;
	int quantity;
	LocalDateTime dateTimePurchase;

	public LineItem() {}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return (product.getPrice() * quantity);
	}

	public String getTotalFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		String totalFormatted = df.format(getTotal()) + " VNĐ";

		return totalFormatted;
	}

	public LocalDateTime getDateTimePurchase() {
		return dateTimePurchase;
	}

	public String getDateTimePurchaseFormatted() {
		// kk to format 24h
		// h to format AM, PM or SA, CH depend on locale (new Locale("vi", "VN"))
		String pattern = "kk:mm dd-MM-yyyy";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		String dateTimePurchaseFormatted = dtf.format(dateTimePurchase);

		return dateTimePurchaseFormatted;
	}

	public void setDateTimePurchase(LocalDateTime dateTimePurchase) {
		this.dateTimePurchase = dateTimePurchase;
	}

	public static void main(String[] args) {
		LineItem i = new LineItem();

		i.setDateTimePurchase(LocalDateTime.parse("2019-03-15T13:45"));

		System.out.println(i.getDateTimePurchaseFormatted());
	}

}








