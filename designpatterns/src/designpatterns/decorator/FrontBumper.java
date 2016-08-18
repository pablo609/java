package designpatterns.decorator;

public class FrontBumper extends Decorator {
	public FrontBumper(Car inner) {
		super(inner);
	}
	
	@Override
	public void draw() {
		System.out.print("FB ");
		super.draw();
	}
}
