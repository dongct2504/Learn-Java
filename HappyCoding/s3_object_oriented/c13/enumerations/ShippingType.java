package c13.enumerations;

public enum ShippingType {
	UP_NEXT_DAY, 
	UP_SECOND_DAY, 
	UP_GROUND; // the ; lets the compiler know that there are no more constants

	@Override
	public String toString() {
		String s = "";
		if (ordinal() == 0) {
			s = "UPS Next Day (1 business day)";
		} else if (this.ordinal() == 1) {
			s = "UPS Second Day (2 business days)";
		} else if (this.ordinal() == 2) {
			s = "UPS Ground (5 to 7 business days)";
		}
		
		return s;
	}
}
