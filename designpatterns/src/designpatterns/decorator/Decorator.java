package designpatterns.decorator;

public class Decorator implements Car {
	Car inner;
	
	public Decorator(Car inner) {
		this.inner = inner;
	}
	
	public void draw() {
		inner.draw();
	}
}
