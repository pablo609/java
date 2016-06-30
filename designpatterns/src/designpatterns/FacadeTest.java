package designpatterns;

import org.testng.Assert;
import org.testng.annotations.Test;

import designpatterns.facade.Facade;
import designpatterns.facade.Order.OrderStatus;
import designpatterns.facade.Product;

public class FacadeTest {
	@Test
	public void verifyFacadeTest() {
		Facade consultant1 = new Facade();
		consultant1.placeOrder(new Product[]{ new Product("pc", 10),
												new Product("iphone", 20),
												new Product("samdung", 30)});
		consultant1.printInvoice();
		Assert.assertTrue(consultant1.getOrderStatus() == OrderStatus.BILLED);
	}
}
