package designpatterns.prototype;

public class Rectangle extends Shape {

	public Rectangle() {
	}
	
	public Rectangle(Rectangle modle) {
		this.id = modle.id;
	}
	
	@Override
	public Object clone() {
		return new Rectangle(this);
	}

	@Override
	public void display() {
		System.out.println("Figure id: " + id);
		System.out.println("-----");
		System.out.println("|   |");
		System.out.println("-----");

	}

}
