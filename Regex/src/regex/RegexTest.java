package regex;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegexTest {
	
	@DataProvider(name = "CellPhoneNumberTestData")
	public Object[][] createcellPhoneNumberTestData() {
		return new Object[][] {
			{"456-456-234", true},
			{"456456234", true},
			{"456.456234", false},
			{"56456234", false},
			{"356 456 234", true},
			{"+48 356 456 234", true},
			{"0056 456-456-234", true},
		};
	}
	
	@Test(dataProvider = "CellPhoneNumberTestData")
  	public void cellPhoneNumber(String number, boolean positiveCheck) {
		if(positiveCheck) {
			Assert.assertTrue(Regex.cellPhoneNumber(number));
		}
		else {
			Assert.assertFalse(Regex.cellPhoneNumber(number));
		}
  	}
}
