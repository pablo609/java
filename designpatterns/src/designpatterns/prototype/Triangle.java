package designpatterns.prototype;

public class Triangle extends Shape {

	public Triangle() {
	}
	
	public Triangle(Triangle modle) {
		this.id = modle.id;
	}
	
	@Override
	public Object clone() {
		return new Triangle(this);
	}

	@Override
	public void display() {
		System.out.println("Figure id: " + id);
		System.out.println("/\\ - " + id);
		System.out.println("--");
		
	}
	
}
