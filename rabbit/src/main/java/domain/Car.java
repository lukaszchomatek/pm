package domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class Car {
	String model;
	int productionYear;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	
	//@JsonCreator
	public Car(String model, int productionYear) {
		setProductionYear(productionYear);
		setModel(model);
	}
	
	// Renember about the default contructor...
	public Car() {
		
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", productionYear=" + productionYear + "]";
	}
	
	
}
