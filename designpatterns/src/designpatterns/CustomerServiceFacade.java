package designpatterns;

import org.testng.Assert;
import org.testng.annotations.Test;

import designpatterns.facade.*;
import designpatterns.facade.Order.OrderStatus;

public class CustomerServiceFacade {
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
	
	@Test
	public void CustomerServiceFacadeTest() {
		CustomerServiceFacade consultant1 = new CustomerServiceFacade();
		consultant1.placeOrder(new Product[]{ new Product("pc", 10),
												new Product("iphone", 20),
												new Product("samdung", 30)});
		consultant1.printInvoice();
		Assert.assertTrue(consultant1.getOrderStatus() == OrderStatus.BILLED);
	}
}
