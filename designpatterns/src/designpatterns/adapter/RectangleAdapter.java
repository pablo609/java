package designpatterns.adapter;

public class RectangleAdapter implements Shape {
	private LegacyRectangle legacyRectangle = new LegacyRectangle();
	
	public void display() {
		legacyRectangle.Draw();
	}

	public void setSize(int lenght, int hight) {
		legacyRectangle.setPosition(1, 1, lenght, hight);
	}

}
