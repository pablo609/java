package com.motorolasolutions.cst.insightfeeder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JUnitXml {
	private Document xmlDocument;
	
	public JUnitXml(String filePath) throws Exception {
		generateDOMFromFile(filePath);
	}
	
	private void generateDOMFromFile(String filePath) throws Exception {
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		xmlDocument = dBuilder.parse(xmlFile);
		xmlDocument.getDocumentElement().normalize();
	}
	
	public List<String> getFailedTests() {
		ArrayList<String> testList = new ArrayList<String>();	
		NodeList testcaseNodeList = xmlDocument.getElementsByTagName("testcase");
		
		for(int i = 0; i < testcaseNodeList.getLength(); ++i) {
			Node testcaseNode = testcaseNodeList.item(i);
			
			if(testcaseNode.hasChildNodes()) {
				Node failureNode = getNodeFromList(testcaseNode.getChildNodes(), "failure");	
				
				if(failureNode != null) {		
					testList.add(getNodeAttributeValue(testcaseNode, "name"));
				}
			}
		}
		
		return testList;
	}
	
	public List<String> getPassedTests() {
		ArrayList<String> testList = new ArrayList<String>();
		NodeList testcaseNodeList = xmlDocument.getElementsByTagName("testcase");
		
		for(int i = 0; i < testcaseNodeList.getLength(); ++i) {
			Node testcaseNode = testcaseNodeList.item(i);
			
			if(!testcaseNode.hasChildNodes()) {
				testList.add(getNodeAttributeValue(testcaseNode, "name"));
			}
		}
		
		return testList;
	}
	
	private Node getNodeFromList(NodeList list, String name) {
		for(int i = 0; i < list.getLength(); ++i) {
			if(list.item(i).getNodeName().equals(name)) {
				return list.item(i);
			}
		}
		
		return null;
	}
	
	private String getNodeAttributeValue(Node node, String name) {
		NamedNodeMap nodeMap = node.getAttributes();
		Node attributeNode = nodeMap.getNamedItem(name);
		return attributeNode.getNodeValue();
	}
}
