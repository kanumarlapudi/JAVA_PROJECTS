package in.ineuron.comp;

import java.util.Arrays;
import java.util.Random;

//Target Object
public class FlipKart {

	// Dependent Object
	private Courier courier;
	private Float discount;

	static {
		System.out.println("FlipKart.class is loading");
	}

	public FlipKart() {
		System.out.println("FlipKart:: Zero param constructor");
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart.setCourier()");
		System.out.println(this);
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
		System.out.println("Flipkart.setDiscount()");
	}

	// Business Logic
	public String doShopping(String[] items, Float[] prices) {

		System.out.println("FlipKart.doShopping");
		System.out.println("Implementation class is :: " + courier.getClass().getName());
		System.out.println("Discount amount is :: " + discount);

		int oid = 0;
		float billAmt = 0.0f;
		Random random = null;

		for (float price : prices) {
			billAmt += price;
		}
		float x = discount/100.0f;
		float y = x*billAmt;
		billAmt = billAmt - y;
		random = new Random();
		oid = random.nextInt(1000);
		System.out.println("order id is : " + oid);
		String msg = courier.deliver(oid);

		return Arrays.toString(items) + " are purchased having prices " + Arrays.toString(prices)
				+ " with billAmount of " + billAmt + " -----> " + msg;

	}

	@Override
	public String toString() {
		return "FlipKart [courier=" + courier + ", discount=" + discount + "]";
	}

}
