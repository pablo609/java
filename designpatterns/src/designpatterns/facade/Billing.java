package designpatterns.facade;

import designpatterns.facade.Order.OrderStatus;

public class Billing {
	public void calculateOrder(Order order) {
		if(order.getStatus() == OrderStatus.SUBMITTED)
		{
			order.calculatePrice();
			order.setStatus(OrderStatus.BILLED);
		}
	}
}
