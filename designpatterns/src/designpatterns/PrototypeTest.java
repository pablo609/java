package designpatterns;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import designpatterns.prototype.*;

public class PrototypeTest {
  @Test
  public void verifyPrototypeTest() {
	  PrototypesModule.registerPrototype(new Rectangle());
	  PrototypesModule.registerPrototype(new Square());
	  PrototypesModule.registerPrototype(new Triangle());
	  
	  ArrayList<Shape> testArray = new ArrayList<Shape>();
	  
	  testArray.add((Shape)PrototypesModule.clone("rectangle"));
	  testArray.add((Shape)PrototypesModule.clone("square"));
	  testArray.add((Shape)PrototypesModule.clone("triangle"));
	  testArray.add((Shape)PrototypesModule.clone("Rectangle"));
	  testArray.add((Shape)PrototypesModule.clone("Square"));
	  testArray.add((Shape)PrototypesModule.clone("Triangle"));
	  
	  for(Shape tmp : testArray) {
		  tmp.display();
	  }
	  
	  Assert.assertEquals(testArray.get(0).getId(), testArray.get(3).getId());
	  Assert.assertEquals(testArray.get(1).getId(), testArray.get(4).getId());
	  Assert.assertEquals(testArray.get(2).getId(), testArray.get(5).getId());
  }
}
