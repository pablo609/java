package designpatterns;

import java.util.ArrayList;

import org.testng.annotations.Test;
import designpatterns.adapter.*;

public class AdapterTest {
	@Test
	public void verifyAdapterTest() {
		ArrayList<Shape> rectangles = new ArrayList<Shape>();
		rectangles.add(new Rectangle());
		rectangles.add(new RectangleAdapter());
		rectangles.add(new Rectangle());
		
		int initialLenght = 3;
		int initialHight = 4;
		for(Shape tmp : rectangles) {
			tmp.setSize(initialLenght++, initialHight++);
			tmp.display();
		}
	}
}
