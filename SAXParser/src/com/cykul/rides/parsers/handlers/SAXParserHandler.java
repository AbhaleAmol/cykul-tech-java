package com.cykul.rides.parsers.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	private static String currentElement = null;	
	private static int numberOfRiders;	
	private static double riderFee;
	
	
	@Override
	public void startDocument() {
		System.out.println("Document Started for parsing...");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		currentElement = qName;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(currentElement.equalsIgnoreCase("numberofriders"))
			numberOfRiders = Integer.parseInt(new String (ch , start , length));
		if(currentElement.equalsIgnoreCase("riderfee"))
			riderFee = Integer.parseInt(new String (ch , start , length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

	}
	
	@Override
	public void endDocument() throws SAXException {
		double totalCurrentFee = numberOfRiders * riderFee;
		System.out.println("Total amount to be paid (incl. of all taxes) ==> " + (totalCurrentFee + ((totalCurrentFee * 15) / 100)));
		System.out.println("Finishing document parsing...");
	}
	
	
}
