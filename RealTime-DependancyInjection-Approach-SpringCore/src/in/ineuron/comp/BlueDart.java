package in.ineuron.comp;

public class BlueDart implements Courier {

	static {
		System.out.println("BlueDart.class file is loading");
	}

	public BlueDart() {
		System.out.println("BlueDart:: Zero param constructor..");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return "BlueDart courier will deliver with the order id :: " + oid + "for the ordered products";
	}

}
