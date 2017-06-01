package com.cykul.rides.parsers.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	private static String XML_FILE_PATH = "/home/cykul/JAVA Projects/sample.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
		Document dom = domBuilder.parse(new File(XML_FILE_PATH));
		
//		getDocumentParser(dom.getDocumentElement());
		
		displayXMLDocument(dom.getDocumentElement());
		
	}
	
	public static void getDocumentParser(Node targetNode) {
		System.out.println("<" + targetNode.getNodeName() + ">");
		
		NodeList nodeListSet = targetNode.getChildNodes();
		
		for(int k = 0; k < nodeListSet.getLength(); k++) {
			System.out.println("\t<" + nodeListSet.item(k).getNodeName() + ">" + "</" + nodeListSet.item(k).getNodeName() + ">");
		}
		
		System.out.println("</" + targetNode.getNodeName() + ">");
	}
	
	public static void displayXMLDocument(Node rootNode) {
		System.out.println("<" + rootNode.getNodeName() + ">");
		
		NodeList currentLevelList = rootNode.getChildNodes();
		for(int k = 0; k < currentLevelList.getLength(); k++) {
			if(currentLevelList.item(k).getChildNodes().getLength() > 1) {
				displayXMLDocument(currentLevelList.item(k));
			}
			
			else {
				System.out.println("<" + currentLevelList.item(k).getNodeName() + ">" + currentLevelList.item(k).getTextContent() + "</" + currentLevelList.item(k).getNodeName() + ">");
			}
		}
		
		System.out.println("</" + rootNode.getNodeName() + ">");
	}
}
