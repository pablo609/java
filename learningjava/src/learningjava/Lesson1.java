package learningjava;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.*;

public class Lesson1 {
	@Test
	public void test() throws InterruptedException {
		SimpleDateFormat dateformat = new SimpleDateFormat();
		Date date1 = new Date();
		
		Thread.sleep(3000);
		
		Date date2 = new Date();
		Date date3 = (Date) date2.clone();
		
		dateformat.applyPattern("yyyy.MM.dd HH:mm:ss");
		System.out.println("Date1: " + date1.toString() + " - " + dateformat.format(date1));
		System.out.println("Date2: " + date2.toString() + " - " + dateformat.format(date2));
		System.out.println("Date3: " + date3.toString() + " - " + dateformat.format(date3));
		
		Assert.assertTrue(date2.after(date1));
		Assert.assertTrue(date3.equals(date2));
	}
}
