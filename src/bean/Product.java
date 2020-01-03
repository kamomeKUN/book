package bean;

import java.io.Serializable;

public class Product implements Serializable {
	// field
	private int id;
	private String name;
	private int price;

	// getter-setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
