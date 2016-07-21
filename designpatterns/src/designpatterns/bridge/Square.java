package designpatterns.bridge;

public class Square extends Shape {
	
	public Square(Color color) {
		super(color);
	}
	
	public void applyColor() {
		System.out.println("|-----|");
		System.out.print("|");
		super.applyColor();
		System.out.println("|");
		System.out.println("|     |");
		System.out.println("|     |");
		System.out.println("|-----|");
	}
}
