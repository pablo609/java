package designpatterns.singleton;

public class Singleton {
	protected static Singleton theObject = null;
	protected int id;
	
	public static Singleton getInstance() {
		if(theObject == null)
		{
			theObject = new Singleton();
		}
		
		return theObject;
	}
	
	public static void destroy() {
		theObject = null;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	protected Singleton() {
		id = 0;
	}
}
