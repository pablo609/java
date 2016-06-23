package designpatterns.facade;

import java.util.Vector;

public class Order {
	public enum OrderStatus { EMPTY, SUBMITTED, BILLED, SHIPPED };
	
	public Order() {
		status = OrderStatus.EMPTY;
		price = 0;
		list = new Vector<Product>();
	}
	public void addProduct(Product product) {
		list.add(product);
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public void calculatePrice() {
		for(int i = 0; i < list.size(); ++i) {
			price += list.get(i).getPrice();
		}
	}
	public int getPrice() {
		return price;
	}
	public void print() {
		for(int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).getName() + " - " + list.get(i).getPrice());
		}
	}
	
	private Vector<Product> list;
	private OrderStatus status;
	private int price;
}
