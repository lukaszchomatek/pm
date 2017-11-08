package orders;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import orders.aggregates.Order;
import orders.entities.Client;
import orders.entities.Product;
import orders.services.ClientService;
import orders.services.OrderService;

public class Main {

	public static void main(String[] args) {
		port(4568);
		get("/hello", (req, res) -> "Hello world from OrderService");
		// TODO Auto-generated method stub

		post("/orders", (req, res) -> {
			String clientName = req.queryParams("name");
			String clientSurname = req.queryParams("surname");
			Client client = ClientService.getClient(clientName, clientSurname);

			// if (client != null)
			Order newOrder = OrderService.createOrder(client);
			return newOrder.getId().toString();
		});

		get("/orders", (req, res) -> {
			String clientName = req.queryParams("name");
			String clientSurname = req.queryParams("surname");
			Client client = ClientService.getClient(clientName, clientSurname);
			ObjectMapper mapper = new ObjectMapper();
			// if (client != null)
			return mapper.writeValueAsString(OrderService.getMyOrders(client));
		});

		put("/orders/:id", (req, res) -> {
			UUID id = UUID.fromString(req.params("id"));
			String productName = req.queryParams("productName");
			String quantity = req.queryParams("quantity");

			double price = 0.0;

			try {

				URL url = new URL("http://localhost:4567/products/" + productName);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				// conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output = br.readLine();
				System.out.println("Output from Server .... \n" + output + "\n");
				// while ((output = br.readLine()) != null) {
				// System.out.println(output);
				// }

				if (output != null)
					price = Double.parseDouble(output);
				conn.disconnect();

			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

			if (price <= 0)
				return "Bad product name or order ID";
			Product product = new Product(productName, price, Integer.parseInt(quantity));
			OrderService.addProductToOrder(id, product);

			return "Product " + product.getName() + " added to order " + id.toString();
		});
	}

}
