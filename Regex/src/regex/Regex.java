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
}
