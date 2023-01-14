package c13.enumerations;

/**
 * @author keilar
 * @version 1.0.0
 */
public class TestEnum {
	
	public static void main(String[] args) {
		ShippingType upGround = ShippingType.UP_SECOND_DAY;
		
		System.out.println(getShippingAmount(ShippingType.UP_GROUND));
		
		System.out.println(upGround.toString());
	}
	
	/**
	 * @param st
	 * @return
	 */
	public static double getShippingAmount(ShippingType st) {
		double shippingAmount = 2.99;
		if (st == ShippingType.UP_NEXT_DAY) {
			shippingAmount = 10.99;
		} else if (st == ShippingType.UP_SECOND_DAY) {
			shippingAmount = 5.99;
		}
		
		return shippingAmount;
	}
}
