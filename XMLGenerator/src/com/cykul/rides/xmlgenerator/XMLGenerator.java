package com.cykul.rides.xmlgenerator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLGenerator {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory domBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder domBuilder = domBuilderFactory.newDocumentBuilder();
		Document dom = domBuilder.newDocument();
		
		Element rootElement = dom.createElement("personalInfo");
		
		Element firstName = dom.createElement("firstName");
		firstName.setTextContent("Amol");
		rootElement.appendChild(firstName);
		
		Element lastName = dom.createElement("lastName");
		lastName.setTextContent("Abhale");
		rootElement.appendChild(lastName);
		
		Element emailID = dom.createElement("emailID");
		emailID.setTextContent("amol@cykul.com");
		rootElement.appendChild(emailID);
		
		Element mobileNumber = dom.createElement("mobileNumber");
		mobileNumber.setTextContent("8143495180");
		rootElement.appendChild(mobileNumber);
		
		Element organization = dom.createElement("organization");
		organization.setTextContent("Learnasium");
		rootElement.appendChild(organization);
		
		Element numberOfRiders = dom.createElement("numberOfRiders");
		numberOfRiders.setTextContent("4");
		rootElement.appendChild(numberOfRiders);
		
		Element riderFee = dom.createElement("riderFee");
		riderFee.setTextContent("1500");
		rootElement.appendChild(riderFee);
		
		dom.appendChild(rootElement);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		
		Transformer transformer = transformerFactory.newTransformer();
		
		DOMSource domSource = new DOMSource(dom);
		
		StreamResult streamResult = new StreamResult("/home/cykul/JAVA Projects/sample.xml");
		
		transformer.transform(domSource, streamResult);
		
		
	}
}
