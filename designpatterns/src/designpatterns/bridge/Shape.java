package designpatterns.bridge;

public abstract class Shape {
	private Color color;
	
	public Shape(Color color) {
		this.color = color;
	}
	
	public void changeColor(Color newColor) {
		this.color = newColor;
	}
	
	public void applyColor() {
		color.applyColor();
	}
}
