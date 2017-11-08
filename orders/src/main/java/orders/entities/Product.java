package orders.entities;

public class Product {
	String name;
	double price;
	int quantity;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object other) {
		if (null == other) {
			return false;
		}
		if (other instanceof Product) {
			return false;
		}
		Product otherProduct = (Product)other;
		return this.name == otherProduct.name;
	}
	
}
