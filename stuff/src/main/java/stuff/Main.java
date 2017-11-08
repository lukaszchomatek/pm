package stuff;

import static spark.Spark.get;
import static spark.Spark.post;

import com.fasterxml.jackson.databind.ObjectMapper;

import stuff.entities.Product;
import stuff.services.ProductService;
public class Main {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello world from ProductService");
		get("/products", (req, res) -> {
			res.type("application/json");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(ProductService.getAllProducts());
			System.out.println(json);
			return json;
		});
		post("/products", (req, rest) -> {
			System.out.println("POST: /products");
			String name = req.queryParams("name");
			String desc = req.queryParams("desc");
			double price = Double.parseDouble(req.queryParams("price"));
			ProductService.addProduct(new Product(name, desc, price));
			return "Product added!";
		});
		
		get("/products/:name", (req, res) ->{
			String name = req.params("name");
			System.out.println("Getting price for " + name);
			double price = ProductService.getPriceForProduct(name);
			return ""+price;
		});
	}
	
}
