package designpatterns.prototype;

import java.util.Random;

public abstract class Shape implements Prototype {
	protected int id;
	private static Random randomGenerator = new Random();
	
	public Shape() {
		id = randomGenerator.nextInt();
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public int getId() {
		return id;
	}
	public abstract Object clone();
	
	public abstract void display();
}
