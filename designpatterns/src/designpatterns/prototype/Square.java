package designpatterns.prototype;

public class Square extends Shape {
	
	public Square() {
	}
	
	public Square(Square model) {
		this.id = model.id;
	}
	
	@Override
	public Object clone() {
		return new Square(this);
	}

	@Override
	public void display() {
		System.out.println("Figure id: " + id);
		System.out.println("---");
		System.out.println("| |");
		System.out.println("---");
	}
}
