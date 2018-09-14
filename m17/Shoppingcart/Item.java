class Item {
	String productName;
	int quantity;
	double unitPrice;
	public Item(final String productName, final String quantity, final String unitPrice) {
		this.productName = productName;
		this.quantity = Integer.parseInt(quantity);
		this.unitPrice = Double.parseDouble(unitPrice);
	}
	public Item(final String productName, final String quantity) {
		this.productName = productName;
		this.quantity = Integer.parseInt(quantity);
	}
	public String toString() {
		return this.productName + " " + this.quantity+ " " + this.unitPrice;
	}
	public boolean equals(final Item other) {
		if (!this.productName.equals(other.productName)) {
			return false;
		}
		return true;
	}
}