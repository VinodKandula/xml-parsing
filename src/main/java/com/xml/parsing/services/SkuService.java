/**
 * 
 */
package com.xml.parsing.services;

import java.io.InputStream;

import com.xml.parsing.pojo.Sku;
import com.xml.parsing.util.XPathUtil;

/**
 * @author vinod
 *
 */
public class SkuService {
	
	public String generateXMLContent() throws Exception {
		
		Sku sku = createPOJO();
		
		XPathUtil xPathUtil = new XPathUtil();
		String xmlData = xPathUtil.createXMLContent(sku);
		
		return xmlData;
	}
	
	public Sku createPOJO() throws Exception {
		
		return parseXMLToPOJO();
	}
	
	public Sku parseXMLToPOJO() throws Exception {
		InputStream inputStream = this.getClass().getResourceAsStream("sku.xml");
        if (inputStream == null) {
        	inputStream = this.getClass().getClassLoader().getResourceAsStream("sku.xml");
        }
        XPathUtil xPathUtil = new XPathUtil(inputStream);
        return xPathUtil.evaluateXPathAndPopulateData(Sku.class);
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		SkuService skuService = new SkuService();
		
		System.out.println(skuService.generateXMLContent().toString());
	}

}
