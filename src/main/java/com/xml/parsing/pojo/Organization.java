/**
 * 
 */
package com.xml.parsing.pojo;

import com.xml.parsing.util.CommonXPathAnnotation;

/**
 * @author vinod
 *
 */
@CommonXPathAnnotation(xPath="/organisation")
public class Organization {
	
	private References references;
	private Defaults defaults;
	private Address address;
	private Contacts contacts;
	private Version version;
	@CommonXPathAnnotation(xPath="/organisation/directives/action")
	private String action;
	private UserCredentials usercredentials;
	
	public References getReferences() {
		return references;
	}
	public void setReferences(References references) {
		this.references = references;
	}
	public Defaults getDefaults() {
		return defaults;
	}
	public void setDefaults(Defaults defaults) {
		this.defaults = defaults;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contacts getContacts() {
		return contacts;
	}
	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public UserCredentials getUsercredentials() {
		return usercredentials;
	}
	public void setUsercredentials(UserCredentials usercredentials) {
		this.usercredentials = usercredentials;
	}
	
	@Override
	public String toString() {
		return "Organisation [references=" + references + ", defaults=" + defaults + ", address=" + address
				+ ", contacts=" + contacts + ", version=" + version + ", action=" + action + ", usercredentials="
				+ usercredentials + "]";
	}
	
	
	@CommonXPathAnnotation(xPath="/organisation/references")
	public class References {
		private String organisationtype;
		private String name;
		private String shortname;
		private String suppliercode;
		
		public String getOrganisationtype() {
			return organisationtype;
		}
		public void setOrganisationtype(String organisationtype) {
			this.organisationtype = organisationtype;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getShortname() {
			return shortname;
		}
		public void setShortname(String shortname) {
			this.shortname = shortname;
		}
		public String getSuppliercode() {
			return suppliercode;
		}
		public void setSuppliercode(String suppliercode) {
			this.suppliercode = suppliercode;
		}
		@Override
		public String toString() {
			return "References [organisationtype=" + organisationtype + ", name=" + name + ", shortname=" + shortname
					+ ", suppliercode=" + suppliercode + "]";
		}
		
	}

	@CommonXPathAnnotation(xPath="/organisation/defaults")
	public class Defaults {
		private String locode;
		private String shippingterms;
		private String currency;
		private String toleranceperlot;
		private String toleranceplusunits;
		
		public String getLocode() {
			return locode;
		}
		public void setLocode(String locode) {
			this.locode = locode;
		}
		public String getShippingterms() {
			return shippingterms;
		}
		public void setShippingterms(String shippingterms) {
			this.shippingterms = shippingterms;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getToleranceperlot() {
			return toleranceperlot;
		}
		public void setToleranceperlot(String toleranceperlot) {
			this.toleranceperlot = toleranceperlot;
		}
		public String getToleranceplusunits() {
			return toleranceplusunits;
		}
		public void setToleranceplusunits(String toleranceplusunits) {
			this.toleranceplusunits = toleranceplusunits;
		}
		
		@Override
		public String toString() {
			return "Defaults [locode=" + locode + ", shippingterms=" + shippingterms + ", currency=" + currency
					+ ", toleranceperlot=" + toleranceperlot + ", toleranceplusunits=" + toleranceplusunits + "]";
		}
		
	}

	@CommonXPathAnnotation(xPath="/organisation/address")
	public class Address {
		private String address1;
		private String address2;
		private String address3;
		private String address4;
		private String city;
		private String county;
		private String iso3country;
		private String postcode;
		
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getAddress3() {
			return address3;
		}
		public void setAddress3(String address3) {
			this.address3 = address3;
		}
		public String getAddress4() {
			return address4;
		}
		public void setAddress4(String address4) {
			this.address4 = address4;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public String getIso3country() {
			return iso3country;
		}
		public void setIso3country(String iso3country) {
			this.iso3country = iso3country;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		
		@Override
		public String toString() {
			return "Address [address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", address4="
					+ address4 + ", city=" + city + ", county=" + county + ", iso3country=" + iso3country + ", postcode="
					+ postcode + "]";
		}
		
	}

	@CommonXPathAnnotation(xPath="/organisation/contacts")
	public class Contacts {
		private String contactname;
		private String telephone;
		private String fax;
		private String adminemailaddress;
		private String opsemailaddress;
		
		public String getContactname() {
			return contactname;
		}
		public void setContactname(String contactname) {
			this.contactname = contactname;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getAdminemailaddress() {
			return adminemailaddress;
		}
		public void setAdminemailaddress(String adminemailaddress) {
			this.adminemailaddress = adminemailaddress;
		}
		public String getOpsemailaddress() {
			return opsemailaddress;
		}
		public void setOpsemailaddress(String opsemailaddress) {
			this.opsemailaddress = opsemailaddress;
		}
		@Override
		public String toString() {
			return "Contacts [contactname=" + contactname + ", telephone=" + telephone + ", fax=" + fax
					+ ", adminemailaddress=" + adminemailaddress + ", opsemailaddress=" + opsemailaddress + "]";
		}
		
	}

	@CommonXPathAnnotation(xPath="/organisation/version")
	public class Version {
		private String date;
		private String statuscode;
		private String statusname;
		private String comments;
		private String reference;
		private String organisation;
		private String user;
		private String message_id;
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getStatuscode() {
			return statuscode;
		}
		public void setStatuscode(String statuscode) {
			this.statuscode = statuscode;
		}
		public String getStatusname() {
			return statusname;
		}
		public void setStatusname(String statusname) {
			this.statusname = statusname;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getOrganisation() {
			return organisation;
		}
		public void setOrganisation(String organisation) {
			this.organisation = organisation;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getMessage_id() {
			return message_id;
		}
		public void setMessage_id(String message_id) {
			this.message_id = message_id;
		}
		
		@Override
		public String toString() {
			return "Version [date=" + date + ", statuscode=" + statuscode + ", statusname=" + statusname + ", comments="
					+ comments + ", reference=" + reference + ", organisation=" + organisation + ", user=" + user
					+ ", message_id=" + message_id + "]";
		}
		
	}

	@CommonXPathAnnotation(xPath="/organisation/usercredentials")
	public class UserCredentials {
		private String username;
		private String emailaddress;
		private String password;
		private String firstname;
		private String lastname;
		private String departmentname;
		private String accounttype;
		@CommonXPathAnnotation(xPath="/organisation/usercredentials/rolemembership/role")
		private String role;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmailaddress() {
			return emailaddress;
		}
		public void setEmailaddress(String emailaddress) {
			this.emailaddress = emailaddress;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getDepartmentname() {
			return departmentname;
		}
		public void setDepartmentname(String departmentname) {
			this.departmentname = departmentname;
		}
		public String getAccounttype() {
			return accounttype;
		}
		public void setAccounttype(String accounttype) {
			this.accounttype = accounttype;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		@Override
		public String toString() {
			return "UserCredentials [username=" + username + ", emailaddress=" + emailaddress + ", password=" + password
					+ ", firstname=" + firstname + ", lastname=" + lastname + ", departmentname=" + departmentname
					+ ", accounttype=" + accounttype + ", role=" + role + "]";
		}
		
	}
	
}