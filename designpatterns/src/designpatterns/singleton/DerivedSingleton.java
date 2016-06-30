package designpatterns.singleton;

public class DerivedSingleton extends Singleton {
	public static Singleton getInstance() {
		if(theObject == null)
		{
			theObject = new DerivedSingleton();
		}
		
		return theObject;
	}
	
	public void setId(int id) {
		this.id = id*2;
	}
	
	protected DerivedSingleton() {
		super();
	}
}
