package designpatterns.facade;

import designpatterns.facade.Order.OrderStatus;

public class Facade {
	public void placeOrder(Product[] order) {
		currentOrder = new Order();
		for(Product product : order) {
			currentOrder.addProduct(product);
		}
		currentOrder.setStatus(OrderStatus.SUBMITTED);
		currentOrder.calculatePrice();
		currentOrder.setStatus(OrderStatus.BILLED);
	}
	
	public void printInvoice() {
		currentOrder.print();
	}
	
	public OrderStatus getOrderStatus() {
		return currentOrder.getStatus();
	}
	
	private Order currentOrder;
}