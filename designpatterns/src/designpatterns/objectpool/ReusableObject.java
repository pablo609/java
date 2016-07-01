package designpatterns.objectpool;

public class ReusableObject {
	private int id;
	private boolean inUse;
	
	public ReusableObject(int id) {
		this.id = id;
		inUse = false;
	}
	
	public void setInUse() {
		this.inUse = true;
	}
	
	public void clearInUse() {
		this.inUse = false;
	}
	
	public boolean isInUse() {
		return inUse;
	}
	
	public int getId() {
		return id;
	}
}
