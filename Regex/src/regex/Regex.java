package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	private static String ignoreWhitespaces(String input) {
		String pattern = "\\s";
		
		Matcher matcher = Pattern.compile(pattern).matcher(input);
		
		return matcher.replaceAll("");
	}
	
	public static boolean cellPhoneNumber(String number) {
		String pattern = "((\\+|0{1,2})\\d{1,3})?\\d{3}-?\\d{3}-?\\d{3}";
		
		Matcher matcher = Pattern.compile(pattern).matcher(ignoreWhitespaces(number));
		
		return matcher.matches();
	}
	
	public static boolean presenceContactJSON(String json) {
		
		String service = "\\s*\"service\":\\s*\\[.*\\]\\s*";
		String person = "\\s*\"person\":\\s*\\{.*\\}\\s*";
		String device = "\\s*\"device\":\\s*\\[.*\\]\\s*";
		String presence = "\\s*\"presence\":\\s*\\{"
				+ device + ","
				+ person + ","
				+ service
				+ "\\}\\s*";
		String presentityUserId = "\\s*\"presentityUserId\":\\s*\"pres:.*\"\\s*";
		String resourceURL = "\\s*\"resourceURL\":\\s*\"http://.*\"\\s*";
		String presenceContact = "\\{\\s*\"presenceContact\":\\s*\\{"
				+ resourceURL + "," 
				+ presentityUserId + ","
				+ presence
				+ "\\}\\}";
		
		String pattern = presenceContact;
		
		Matcher matcher = Pattern.compile(pattern).matcher(json);
		
		return matcher.matches();
	}
}
