/**
 * 
 */
package com.xml.parsing.services;

import com.xml.parsing.pojo.Organization;
import com.xml.parsing.pojo.Organization.Address;
import com.xml.parsing.pojo.Organization.Defaults;
import com.xml.parsing.pojo.Organization.References;
import com.xml.parsing.util.XPathUtil;

/**
 * @author vinod
 *
 */
public class OrganizationService {
	
	public String generateXMLContent() {
		
		// read the data from C3 collection and create the organization POJO
		
		Organization organization = this.createPOJO();
		
		try {
			XPathUtil xPathUtil = new XPathUtil();
			String xmlData = xPathUtil.createXMLContent(organization);
			return xmlData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Organization createPOJO() {
		Organization organization = new Organization();
		Organization.References references = organization.new References();
		references.setName("Pantagonia");
		references.setOrganisationtype("6");
		references.setShortname("Pantagonia");
		references.setSuppliercode("PANT");
		
		organization.setReferences(references);
		
		Organization.Defaults defaults = organization.new Defaults();
		defaults.setCurrency("");
		defaults.setLocode("");
		defaults.setShippingterms("");
		defaults.setToleranceperlot("");
		defaults.setToleranceplusunits("");
		
		organization.setDefaults(defaults);
		
		Organization.Address address = organization.new Address();
		address.setAddress1("");
		address.setAddress2("");
		address.setAddress3("");
		address.setAddress4("");
		address.setCity("");
		
		organization.setAddress(address);
		
		return organization;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OrganizationService organizationService = new OrganizationService();
		organizationService.generateXMLContent();

	}

}
