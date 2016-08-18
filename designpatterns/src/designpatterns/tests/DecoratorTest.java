package designpatterns.tests;

import org.testng.annotations.Test;

import designpatterns.decorator.*;

public class DecoratorTest {
	@Test
	public void verifyDecorator() {
		Car fullCar1 = new FrontBumper(new RearBumper(new Body()));
		Car fullCar2 = new RearBumper(new FrontBumper(new Body()));
		
		fullCar1.draw();
		fullCar2.draw();
	}
}
