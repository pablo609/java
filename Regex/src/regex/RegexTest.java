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
	
	@Test
	public void presenceContactJSON() {
		String json = "{  \"presenceContact\": {    \"resourceURL\": \"http://uns.agency.gov:64000/unsapi/presence/1/city.gov/pres%3Ajohn.smith%40city.gov\",    \"presentityUserId\": \"pres:john.smith@city.gov\",    \"presence\": {      \"device\": [        {          \"deviceId\": \"pres:device1@city.gov\",          \"displayName\": \"Device 1\",          \"class\": \"BB-Device\",          \"networkAvailability\": {            \"network\": [              {                \"connectionStatus\": \"Active\",                \"id\": \"3GPP-GPRS\"              }            ]          },          \"timestamp\": \"2010-07-22T20:57:29Z\"        }      ],      \"person\": {        \"class\": \"user\",        \"displayName\": \"John Smith\",        \"activities\": {          \"activityValue\": [            \"Busy\"          ]        },        \"extended\": {          \"attribute\": [            {              \"name\": \"rank\",              \"value\": \"Captain\"            },            {              \"name\": \"traininglevel\",              \"value\": \"M1\"            }          ]        },        \"timestamp\": \"2010-07-22T20:57:29Z\"      },      \"service\": [        {          \"devices\": {            \"deviceId\": [              \"pres:device1@city.gov\"            ]          },          \"serviceAvailability\": \"Open\",          \"serviceId\": \"com.motorolasolutions:UNS\",          \"version\": \"5.0\",          \"timestamp\": \"2010-07-22T20:57:29Z\"        }      ]    }  }}";
		
		Assert.assertTrue(Regex.presenceContactJSON(json));
	}
}
