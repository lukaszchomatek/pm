package orders.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import orders.aggregates.Order;
import orders.entities.Client;
import orders.entities.Product;

public class OrderService {
	static List<Order> orders = new ArrayList<>();
	
	public static List<Order> getMyOrders(Client client) {
		List<Order> result = new ArrayList<>();
		for (Order order : orders) {
			if (order.getClient().equals(client)) {
				result.add(order);
			}
		}
		return result;
	}
	
	public static Order createOrder(Client client) {
		Order newOrder = Order.createOrder(client);
		orders.add(newOrder);
		return newOrder;
	}
	
	public static void addProductToOrder(UUID id, Product product) {
		Order order = null;
		
		for (Order orderOnList : orders) {
			if (orderOnList.getId().toString().equals(id.toString())) {
				order = orderOnList;
			}
		}
		if (order == null)
			return;
		
		order.addProduct(product);
	}
	
	public void confirm(UUID id) {
		Order order = null;
		
		for (Order orderOnList : orders) {
			if (orderOnList.getId().toString().equals(id.toString())) {
				order = orderOnList;
			}
		}
		if (order == null)
			return;
		
		order.confirm();
	}
}
