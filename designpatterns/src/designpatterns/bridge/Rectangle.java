package designpatterns.bridge;

public class Rectangle extends Shape {
	
	public Rectangle(Color color) {
		super(color);
	}
	
	public void applyColor() {
		System.out.println("|-------|");
		System.out.print("|");
		super.applyColor();
		System.out.println("  |");
		System.out.println("|-------|");
	}
}
