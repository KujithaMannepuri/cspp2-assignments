class ShoppingCart {
	int size1;
	int size2, k = 1;
	Item[] catalog;
	Item[] cart;
	String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean couponApplied = false;
	
	ShoppingCart() {
		catalog = new Item[20];
		cart = new Item[20];
		size1 = 0;
		size2 = 0;
	}
	
	public void addToCatalog(final Item item) {
		catalog[size1++] = item;
	}
	
	public void addToCart(final Item item) {
		if (!inCart(item)) {
		if (checkCatalog(item)) {
			cart[size2++] = item;
		}
	}
	}
	
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
	
	public void removeFromCart(final Item item) {
		for (int i = 0; i < size2; i++) {
			if (item.equals(cart[i])) {
				cart[i].quantity = cart[i].quantity - item.quantity;
			}	
		}		
	}
	
	public void showCart() {
		for(Item i : cart) {
			if (i != null) {
				if (i.quantity != 0) {
					System.out.println(i.productName + " " + i.quantity);
				}
			}
		}
	}
	
	public void showCatalog() {
		for(Item i : catalog) {
			if (i != null) {
			System.out.println(i);
		}
		}
	}
	
	double getTotalAmount(){
		double total=0;
		for(int i =0; i< size2; i++){
			total += cart[i].quantity * getPrice(cart[i]);
		}
		return total;
	}
	
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
	
	public double getPayableAmount() {
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * 15 / 100;
		return newTotal + tax;
	}

	
	public void applyCoupon(final String coupon) {
		

		if (couponApplied) {
			// System.out.println("Invalid coupon");
			return;
		}
		boolean valid = false;
		if (k == 1){
			for (String s : validCoupons) {
				if (s.equals(coupon)) {
					int num = Integer.parseInt(coupon.substring(3));
					discount = getTotalAmount() * num / 100;
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
	
	void printInVoice() {
		System.out.println("Name   quantity   Price");
		for (Item i : cart) {
			if (i != null) {
				if (i.quantity != 0) {
			System.out.println(i.productName + " " + i.quantity + " " + getPrice(i));
		}
	}
	}
		
		
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * 15 / 100;
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}