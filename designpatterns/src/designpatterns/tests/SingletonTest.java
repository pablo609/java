package designpatterns.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import designpatterns.singleton.Singleton;
import designpatterns.singleton.DerivedSingleton;

public class SingletonTest {
	@AfterMethod
	public void destroySingleton() {
		Singleton.destroy();
	}
	@Test
	public void verifySingletonTest() {
		final int testId1 = 10;
		final int testId2 = 20;
		
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		singleton1.setId(testId1);
		singleton2.setId(testId2);
		
		Assert.assertEquals(singleton1.getId(), singleton2.getId());
		Assert.assertEquals(singleton2.getId(), testId2);
	}
	
	@Test
	public void verifyDerivedSingletonTest() {
		final int testId1 = 10;
		final int testId2 = 20;
		final int testIdDerived = testId2 * 2;
		
		Singleton singleton1 = DerivedSingleton.getInstance();
		Singleton singleton2 = DerivedSingleton.getInstance();
		
		singleton1.setId(testId1);
		singleton2.setId(testId2);
		
		Assert.assertEquals(singleton1.getId(), singleton2.getId());
		Assert.assertEquals(singleton2.getId(), testIdDerived);
	}
}
