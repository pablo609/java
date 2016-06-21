package learningjava;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.*;

public class Lesson1 {
	@Test
	public void test() {
		int[] array = {1,2,3,4,5};
		
		int[] array2;
		
		array2 = new int[]{45,34,33,31};
		
		Arrays.sort(array2);
		
		for(int a : array) {
			System.out.println(a);
		}
		
		for(int a : array2) {
			System.out.println(a);
		}
	}
}
