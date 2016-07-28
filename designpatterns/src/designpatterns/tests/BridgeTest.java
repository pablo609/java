package designpatterns.tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import designpatterns.bridge.*;

public class BridgeTest {
	@Test
	public void verifyBridgeTest() {
		ArrayList<Shape> arrayOfShapes = new ArrayList<Shape>();
		arrayOfShapes.add(new Square(new RedColor()));
		arrayOfShapes.add(new Rectangle(new BlueColor()));
		
		for(Shape tempShape : arrayOfShapes) {
			tempShape.applyColor();
		}
		
		arrayOfShapes.get(0).changeColor(new WhiteColor());
		arrayOfShapes.get(1).changeColor(new BlackColor());
		
		for(Shape tempShape : arrayOfShapes) {
			tempShape.applyColor();
		}
	}
}
