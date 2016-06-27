package learningjava;


import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.Assert;
import org.testng.annotations.*;

public class Lesson1 {
	@Test
	public void test() throws IOException  {
		InputStreamReader cin = null;
		
		cin = new InputStreamReader(System.in);
		char c;
		do {
			c= (char) cin.read();
			System.out.println(c);
		} while(c != 'q');
		
		cin.close();
	}
}
