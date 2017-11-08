package stuff.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import stuff.entities.Product;

public class ProductService {
	static List<Product> products = new ArrayList<Product>();
	static {
		products.add(new Product("Milk", "Classic Milk", 2.5));
		products.add(new Product("Bread", "White bread", 2.4));
		products.add(new Product("Newspaper", "Only good news", 2.0));
		products.add(new Product("Lollipop", "Strwaberry taste", 0.5));
	}
	
	public static void addProduct(Product p) {
		products.add(p);
	}
	
	public static List<Product> getAllProducts() {
		return Collections.unmodifiableList(products);
	}

	public static double getPriceForProduct(String name) {
		for (Product product : products) {
			if (product.getName().equals(name))
				return product.getPrice();
		}
		return 0;
	}
}
