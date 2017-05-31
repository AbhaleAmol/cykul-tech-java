package com.cykul.rides.parsers.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOMParser {

	private static String XML_FILE_PATH = "/home/cykul/JAVA Projects/sample.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
		Document dom = domBuilder.parse(new File(XML_FILE_PATH));
		
		String rootElement = dom.getFirstChild().getNodeName();
		System.out.println("Root Element ==> " + rootElement);
		
		
		
	}
}
