package com.motorolasolutions.cst.insightfeeder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsightFeeder {
	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			System.out.println("Usage: " + InsightFeeder.class.getSimpleName() + " <junit_test_report.xml>");
			return;
		}
		
		JUnitXml junitXml = new JUnitXml(args[0]);
		
		System.out.println("FAILED:");
		for(String testName : junitXml.getFailedTests()) {
			System.out.println(getInsightIdFromTestName(testName));
		}
		
		System.out.println("PASSED:");
		for(String testName : junitXml.getPassedTests()) {
			System.out.println(getInsightIdFromTestName(testName));
		}
	}
	
	private static String getInsightIdFromTestName(String testName) {
		String pattern = "_([_\\d\\w]+)(\\[(\\d+)\\])?";
		Matcher matcher = Pattern.compile(pattern).matcher(testName);
		
		if(matcher.find()) {
			String testInstanceNumber = ":01";

			if(matcher.group(3) != null) {
				testInstanceNumber = String.format(":%02d", Integer.parseInt(matcher.group(3))+1);
			}
			
			return matcher.group(1).replaceAll("_", ".") + testInstanceNumber;
		}
		
		return null;
	}
}
