import java.util.*;
/**
 * Class for item.
 */
class Item {
	String productName;
	int quantity;
	double unitPrice;
	/**
	 * Constructs the object.
	 *
	 * @param      productName  The product name
	 * @param      quantity     The quantity
	 * @param      unitPrice    The unit price
	 */
	public Item(final String productName, final String quantity, final String unitPrice) {
		this.productName = productName;
		this.quantity = Integer.parseInt(quantity);
		this.unitPrice = Double.parseDouble(unitPrice);
	}
	/**
	 * Constructs the object.
	 *
	 * @param      productName  The product name
	 * @param      quantity     The quantity
	 */
	public Item(final String productName, final String quantity) {
		this.productName = productName;
		this.quantity = Integer.parseInt(quantity);
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.productName + " " + this.quantity+ " " + this.unitPrice;
	}
	/**
	 * { function_description }
	 *
	 * @param      other  The other
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean equals(final Item other) {
		if (!this.productName.equals(other.productName)) {
			return false;
		}
		return true;
	}
}
 /**
  * Class for shopping cartesian.
  */
 class ShoppingCart {
	int size1;
	int size2, k = 1;
	Item[] catalog;
	Item[] cart;
	String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean couponApplied = false;
	/**
	 * Constructs the object.
	 */
	ShoppingCart() {
		catalog = new Item[20];
		cart = new Item[20];
		size1 = 0;
		size2 = 0;
	}
	/**
	 * Adds to catalog.
	 *
	 * @param      item  The item
	 */
	public void addToCatalog(final Item item) {
		catalog[size1++] = item;
	}
	/**
	 * Adds to cartesian.
	 *
	 * @param      item  The item
	 */
	public void addToCart(final Item item) {
		if (!inCart(item)) {
		if (checkCatalog(item)) {
			cart[size2++] = item;
		}
	}
	}
	/**
	 * { function_description }
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	boolean inCart (final Item item) {
		for (Item s : cart) {
			if (s != null) {
				if (s.equals(item)) {
					s.quantity = s.quantity + item.quantity;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * { function_description }
	 *
	 * @param      item  The item
	 *
	 * @return     { description_of_the_return_value }
	 */
	private boolean checkCatalog(final Item item) {
		for (Item i : catalog) {
			if (i != null) {
				if (i.equals(item)) {
					if (item.quantity <= i.quantity) {
						i.quantity = i.quantity - item.quantity;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Removes a from cartesian.
	 *
	 * @param      item  The item
	 */
	public void removeFromCart(final Item item) {
		for (int i = 0; i < size2; i++) {
			if (item.equals(cart[i])) {
				cart[i].quantity = cart[i].quantity - item.quantity;
			}	
		}		
	}

	/**
	 * Shows the cartesian.
	 */
	public void showCart() {
		for(Item i : cart) {
			if (i != null) {
				if (i.quantity != 0) {
					System.out.println(i.productName+ " " + i.quantity);
				}
			}
		}
	}

	/**
	 * Shows the catalog.
	 */
	public void showCatalog() {
		for(Item i : catalog) {
			if (i != null) {
			System.out.println(i);
		}
		}
	}

	/**
	 * Gets the total amount.
	 *
	 * @return     The total amount.
	 */
	double getTotalAmount(){
		double total=0;
		for(int i =0; i< size2; i++){
			total += cart[i].quantity * getPrice(cart[i]);
		}
		return total;
	}

	/**
	 * Gets the price.
	 *
	 * @param      item  The item
	 *
	 * @return     The price.
	 */
	double getPrice(final Item item) {
		for (Item i : catalog) {
			if (i != null) {
				if(i.equals(item)) {
					return i.unitPrice;
				}
			}
		}
		return 0.0;
	}

	/**
	 * Gets the payable amount.
	 *
	 * @return     The payable amount.
	 */
	public double getPayableAmount() {
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * 15/100;
		return newTotal + tax;
	}

	/**
	 * { function_description }
	 *
	 * @param      coupon  The coupon
	 */
	public void applyCoupon(final String coupon) {
		// double discount = 0.0;

		if (couponApplied) {
			// System.out.println("Invalid coupon");
			return;
		}
		boolean valid = false;
		if (k == 1){
			for (String s : validCoupons) {
				if (s.equals(coupon)) {
					int num = Integer.parseInt(coupon.substring(3));
					discount = getTotalAmount() * num/100;
					valid = true;
					couponApplied = true;
					k++;
				}
			}
		}
		if (!valid) {
			System.out.println("Invalid coupon");
			return;
		}
	}
	/**
	 * printInvoice function.
	 */
	void printInVoice() {
		System.out.println("Name   quantity   Price");
		for (Item i : cart) {
			if (i != null) {
				if (i.quantity != 0) {
			System.out.println(i.productName + " " + i.quantity + " " + getPrice(i));
		}
	}
	}
		/**
		 * { var_description }
		 */
		final int h = 100;
		/**
		 * { var_description }
		 */
		final int f = 15;
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * f/h;
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" +discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
/**
 * Class for solution.
 */
class Solution {
	public static void main(final String[] args) {
		ShoppingCart shop = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < lines; i++) {
			String[] input = sc.nextLine().split(" ");
			switch (input[0]) {
				case "Item":
				String[] tokens = input[1].split(",");
	shop.addToCatalog(new Item(tokens[0], tokens[1], tokens[2]));
				break;
				case "catalog":
	shop.showCatalog();
				break;
				case "add":
				String[] tokens1 = input[1].split(",");
	shop.addToCart(new Item(tokens1[0], tokens1[1]));
				break;
				case "show":
				shop.showCart();
				break;
				case "totalAmount":
	System.out.println("totalAmount: " + shop.getTotalAmount());
				break;
				case "payableAmount":
	System.out.println("Payable amount: " + shop.getPayableAmount());
				break;
				case "remove":
				String[] tokens2 = input[1].split(",");
	shop.removeFromCart(new Item(tokens2[0], tokens2[1]));
				break;
				case "coupon":
				shop.applyCoupon(input[1]);
				break;
				case "print":
				shop.printInVoice();
				break;
				default:
				break;
			}
		}
	}
}