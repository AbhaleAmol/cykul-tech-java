package com.cykul.rides.parsers.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.cykul.rides.parsers.handlers.SAXParserHandler;

public class CYKULRides {

	private static String XML_FILE_PATH = "/home/cykul/JAVA Projects/sample.xml";
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		SAXParserHandler parserHandler = new SAXParserHandler();
		
		saxParser.parse(new File(XML_FILE_PATH), parserHandler);
	}
}
