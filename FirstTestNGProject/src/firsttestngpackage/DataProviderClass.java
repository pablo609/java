package firsttestngpackage;

import org.testng.annotations.*;

public class DataProviderClass {
	@DataProvider(name="SearchProvider2")
	public static Object[][] getDataFromDataprovider() {
		return new Object[][] {
            { "Guru992", "India" },
            { "Krishna2", "UK" },
            { "Bhupesh2", "USA" } };
	}
}
