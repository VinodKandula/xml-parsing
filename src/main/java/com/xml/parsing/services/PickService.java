/**
 * 
 */
package com.xml.parsing.services;

import java.io.InputStream;

import com.xml.parsing.pojo.PickInstruction;
import com.xml.parsing.util.XPathUtil;

/**
 * @author vinod
 *
 */
public class PickService {

public String generateXMLContent() throws Exception {
		
		PickInstruction pickInstruction = createPOJO();
		
		XPathUtil xPathUtil = new XPathUtil();
		String xmlData = xPathUtil.createXMLContent(pickInstruction);
		
		return xmlData;
	}
	
	public PickInstruction createPOJO() throws Exception {
		
		return parseXMLToPOJO();
	}
	
	public PickInstruction parseXMLToPOJO() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream("pick.xml");
        if (inputStream == null) {
        	inputStream = this.getClass().getClassLoader().getResourceAsStream("pick.xml");
        }
        XPathUtil xPathUtil = new XPathUtil(inputStream);
        return xPathUtil.evaluateXPathAndPopulateData(PickInstruction.class);
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PickService pickService = new PickService();
		
		System.out.println(pickService.generateXMLContent().toString());
		
	}
	
}
