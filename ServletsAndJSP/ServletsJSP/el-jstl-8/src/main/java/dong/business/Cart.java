package dong.business;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cart implements Serializable {

	private List<LineItem> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public List<LineItem> getItems() {
		return items;
	}
	
	public int getCount() {
		return items.size();
	}
	
	public void addItem(LineItem item) {
		String code = item.getProduct().getCode();
		int quantity = item.getQuantity();
		
		// if the item is already in the cart then set quantity and return
		for (LineItem i : items) {
			if (i.getProduct().getCode().equals(code)) {
				i.setQuantity(quantity);
				return;
			}
		}
		
		// if the item is not in the cart then add
		items.add(item);
	}
	
	public boolean removeItem(LineItem item) {
		String code = item.getProduct().getCode();
		
		for (LineItem i : items) {
			if (i.getProduct().getCode().equals(code)) {
				items.remove(i);
				return true;
			}
		}

		return false;
	}
	
	public double getTotal() {
		double total = 0;
		for (LineItem i : items) {
			total += i.getTotal();
		}
		
		return total;
	}
	
	public String getTotalFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		String totalFormatted = df.format(getTotal()) + " VNĐ";
		
		return totalFormatted;
	}
	
}















