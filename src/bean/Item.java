package bean;

import java.io.Serializable;

public class Item implements Serializable {
	// field
	private Product product;
	private int count;
	// setter-getter
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
