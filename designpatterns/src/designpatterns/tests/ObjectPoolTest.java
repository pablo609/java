package designpatterns.tests;

import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import designpatterns.objectpool.ReusableObject;
import designpatterns.objectpool.ReusablePool;

public class ObjectPoolTest {
	@Test
	public void verifyObjectPoolTest() {
		ReusablePool pool = ReusablePool.getInstance();
		LinkedList<ReusableObject> accuiredObjects = new LinkedList<ReusableObject>();
		int maxPoolSize = 10;
		
		for(int i = 0; i < maxPoolSize + 5; ++i) {
			ReusableObject tmp = pool.accuire();
			if(tmp != null) {
				System.out.println(tmp.getId());
				accuiredObjects.add(tmp);
			}
			else
				System.out.println("Cannot accuire more!");
		}
		
		Assert.assertEquals(pool.getSize(), maxPoolSize);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 0);
		
		for(int i = 0; i < maxPoolSize; i++) {
			ReusableObject tmp = accuiredObjects.getFirst();
			accuiredObjects.removeFirst();
			pool.release(tmp);
		}
		
		Assert.assertEquals(pool.getSize(), 0);
		Assert.assertEquals(pool.getNumOfFreeObjects(), maxPoolSize);
		
		for(int i = 0; i < maxPoolSize - 4; ++i) {
			ReusableObject tmp = pool.accuire();
			if(tmp != null) {
				System.out.println(tmp.getId());
				accuiredObjects.add(tmp);
			}
			else
				System.out.println("Cannot accuire more!");
		}
		
		Assert.assertEquals(pool.getSize(), 6);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 4);
		
		for(int i = 0; i < 2; i++) {
			ReusableObject tmp = accuiredObjects.getFirst();
			accuiredObjects.removeFirst();
			pool.release(tmp);
		}
		
		Assert.assertEquals(pool.getSize(), 4);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 6);
		
		pool.setMaxNumOfObjects(4);
		
		Assert.assertEquals(pool.getSize(), 4);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 0);
		
		pool.setMaxNumOfObjects(3);
		
		Assert.assertEquals(pool.getSize(), 4);
		Assert.assertEquals(pool.getNumOfFreeObjects(), -1);
		
		accuiredObjects.getFirst();
		
		Assert.assertEquals(pool.getSize(), 4);
		Assert.assertEquals(pool.getNumOfFreeObjects(), -1);
		
		ReusableObject tmp = accuiredObjects.getFirst();
		accuiredObjects.removeFirst();
		pool.release(tmp);
		
		Assert.assertEquals(pool.getSize(), 3);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 0);
		
		tmp = accuiredObjects.getFirst();
		accuiredObjects.removeFirst();
		pool.release(tmp);
		
		Assert.assertEquals(pool.getSize(), 2);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 1);
		
		pool.setMaxNumOfObjects(2);
		
		Assert.assertEquals(pool.getSize(), 2);
		Assert.assertEquals(pool.getNumOfFreeObjects(), 0);
	}
}
