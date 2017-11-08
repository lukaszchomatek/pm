package orders.aggregates;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import orders.entities.Client;
import orders.entities.Product;

public class Order {
	private UUID id;
	
	private Client client;
	
	private List<Product> products = new ArrayList<>();
	
	private String status = "NOT CONFIRMED";
	
	public UUID getId() {
		return id;
	}
	public Client getClient() {
		return client;
	}
	public List<Product> getProducts() {
		return products;
	}
	
	public String getStatus() {
		return status;
	}
	
	private Order(Client client) {
		this.client = client;
		this.id = UUID.randomUUID();
	}
	public static Order createOrder(Client client) {
		return new Order(client);
	}
	
	public void confirm() {
		this.status = "CONFIRMED";
	}
	
	public void addProduct(Product product) {
		if (products.contains(product)) {
			Product alreadyAdded = products.get(products.indexOf(product));
			alreadyAdded.setQuantity(product.getQuantity());
		} else {
			products.add(product);
		}
	}
	
	/**
	 * Removes all products with the specified name
	 * @param product
	 */
	public void removeProduct(Product product) {
		if (products.contains(product)) {
			products.remove(product);
		}
	}
}
