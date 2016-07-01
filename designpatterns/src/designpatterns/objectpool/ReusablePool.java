package designpatterns.objectpool;

import java.util.ArrayList;
import java.util.Iterator;

public class ReusablePool {
	private ArrayList<ReusableObject> pool;
	private int maxNumOfObjects;
	private int objectIndex;
	private static ReusablePool theReusablePool = null;
	
	private ReusablePool() {
		this.maxNumOfObjects = 10;
		objectIndex = 1;
		pool = new ArrayList<ReusableObject>();
	}
	
	private ReusableObject addNewObject() {
		ReusableObject temp = new ReusableObject(objectIndex++);
		pool.add(temp);
		return temp;
	}
	
	public static ReusablePool getInstance() {
		if(theReusablePool == null) {
			theReusablePool = new ReusablePool();
		}
		
		return theReusablePool;
	}
	
	public ReusableObject accuire() {
		Iterator<ReusableObject> iter = pool.iterator();
		ReusableObject temp = null;
		
		while(iter.hasNext())
		{
			temp = iter.next();
			if(!(temp.isInUse()))
				return temp;
		}
		
		if(pool.size() < maxNumOfObjects)
		{
			temp = addNewObject();
			temp.setInUse();
			return temp;
		}
		
		return null;
	}
	
	public int getSize() {
		return pool.size();
	}
	
	public int getNumOfFreeObjects() {
		return maxNumOfObjects - pool.size();
	}
	
	public void release(ReusableObject object) {
		pool.remove(object);
	}
	
	public void setMaxNumOfObjects(int num) {
		if(num > 0) {
			int poolSize = pool.size();
			if(num < poolSize) {
				Iterator<ReusableObject> iter = pool.iterator();
				for(int i = 0; i < poolSize - num; i++) {
					if(iter.hasNext()) {
						if(!(iter.next().isInUse())) {
							iter.remove();
						}
					}
					else {
						break;
					}
				}
				
			}
			
			maxNumOfObjects = num;
		}
	}
}
