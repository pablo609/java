package designpatterns.decorator;

public class RearBumper extends Decorator {
	public RearBumper(Car inner) {
		super(inner);
	}
	
	@Override
	public void draw() {
		super.draw();
		System.out.println(" RB");
	}
}
