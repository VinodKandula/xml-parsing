/**
 * 
 */
package com.xml.parsing.pojo;

import java.util.List;

import com.xml.parsing.util.CommonXPathAnnotation;

/**
 * @author vinod
 *
 */
@CommonXPathAnnotation(xPath="/pickinstruction/pickheader")
public class Pickheader {
	
	private String customerdocumenttype;
	private String orderdate;
	private String requestedetd;
	private String notes;
	private Parties parties;
	private References references;
	private Delivery delivery;
	private List<Customdata> customdata;
	private Version version;
	private Directives directives;
	
	public String getCustomerdocumenttype() {
		return customerdocumenttype;
	}

	public void setCustomerdocumenttype(String customerdocumenttype) {
		this.customerdocumenttype = customerdocumenttype;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getRequestedetd() {
		return requestedetd;
	}

	public void setRequestedetd(String requestedetd) {
		this.requestedetd = requestedetd;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Parties getParties() {
		return parties;
	}

	public void setParties(Parties parties) {
		this.parties = parties;
	}

	public References getReferences() {
		return references;
	}

	public void setReferences(References references) {
		this.references = references;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<Customdata> getCustomdata() {
		return customdata;
	}

	public void setCustomdata(List<Customdata> customdata) {
		this.customdata = customdata;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Directives getDirectives() {
		return directives;
	}

	public void setDirectives(Directives directives) {
		this.directives = directives;
	}

	@Override
	public String toString() {
		return "Pickheader [customerdocumenttype=" + customerdocumenttype + ", orderdate=" + orderdate
				+ ", requestedetd=" + requestedetd + ", notes=" + notes + ", parties=" + parties + ", references="
				+ references + ", delivery=" + delivery + ", customdata=" + customdata + ", version=" + version
				+ ", directives=" + directives + "]";
	}



	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/directives")
	public class Directives {
		private String action;
		private String wmsPush;
		private String wmsInstance;
		private String wmsTransactionReference;
		
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public String getWmsPush() {
			return wmsPush;
		}
		public void setWmsPush(String wmsPush) {
			this.wmsPush = wmsPush;
		}
		public String getWmsInstance() {
			return wmsInstance;
		}
		public void setWmsInstance(String wmsInstance) {
			this.wmsInstance = wmsInstance;
		}
		public String getWmsTransactionReference() {
			return wmsTransactionReference;
		}
		public void setWmsTransactionReference(String wmsTransactionReference) {
			this.wmsTransactionReference = wmsTransactionReference;
		}
		@Override
		public String toString() {
			return "Directives [action=" + action + ", wmsPush=" + wmsPush + ", wmsInstance=" + wmsInstance
					+ ", wmsTransactionReference=" + wmsTransactionReference + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/version")
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
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/customdata")
	public class Customdata {
		private String attribute;
		@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/customdata/value/text")
		private String text;
		@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/customdata/value/other")
		private String other;
		
		public String getAttribute() {
			return attribute;
		}
		public void setAttribute(String attribute) {
			this.attribute = attribute;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getOther() {
			return other;
		}
		public void setOther(String other) {
			this.other = other;
		}
		@Override
		public String toString() {
			return "Customdata [attribute=" + attribute + ", text=" + text + ", other=" + other + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/delivery")
	public class Delivery {
		private String deliveryservice;
		private String deliverymode;
		private String tradeterms;
		private Address address;
		
		public String getDeliveryservice() {
			return deliveryservice;
		}
		public void setDeliveryservice(String deliveryservice) {
			this.deliveryservice = deliveryservice;
		}
		public String getDeliverymode() {
			return deliverymode;
		}
		public void setDeliverymode(String deliverymode) {
			this.deliverymode = deliverymode;
		}
		public String getTradeterms() {
			return tradeterms;
		}
		public void setTradeterms(String tradeterms) {
			this.tradeterms = tradeterms;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Delivery [deliveryservice=" + deliveryservice + ", deliverymode=" + deliverymode + ", tradeterms="
					+ tradeterms + ", address=" + address + "]";
		}

		@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/delivery/address")
		public class Address {
			private String deliveryparty;
			private String contactname;
			private String contactphonenumber;
			private String deliveryaddress1;
			private String deliveryaddress2;
			private String deliveryaddress3;
			private String deliveryaddress4;
			private String deliverycity;
			private String deliverycounty;
			private String deliverypostcode;
			private String deliverycountry;
			
			public String getDeliveryparty() {
				return deliveryparty;
			}
			public void setDeliveryparty(String deliveryparty) {
				this.deliveryparty = deliveryparty;
			}
			public String getContactname() {
				return contactname;
			}
			public void setContactname(String contactname) {
				this.contactname = contactname;
			}
			public String getContactphonenumber() {
				return contactphonenumber;
			}
			public void setContactphonenumber(String contactphonenumber) {
				this.contactphonenumber = contactphonenumber;
			}
			public String getDeliveryaddress1() {
				return deliveryaddress1;
			}
			public void setDeliveryaddress1(String deliveryaddress1) {
				this.deliveryaddress1 = deliveryaddress1;
			}
			public String getDeliveryaddress2() {
				return deliveryaddress2;
			}
			public void setDeliveryaddress2(String deliveryaddress2) {
				this.deliveryaddress2 = deliveryaddress2;
			}
			public String getDeliveryaddress3() {
				return deliveryaddress3;
			}
			public void setDeliveryaddress3(String deliveryaddress3) {
				this.deliveryaddress3 = deliveryaddress3;
			}
			public String getDeliveryaddress4() {
				return deliveryaddress4;
			}
			public void setDeliveryaddress4(String deliveryaddress4) {
				this.deliveryaddress4 = deliveryaddress4;
			}
			public String getDeliverycity() {
				return deliverycity;
			}
			public void setDeliverycity(String deliverycity) {
				this.deliverycity = deliverycity;
			}
			public String getDeliverycounty() {
				return deliverycounty;
			}
			public void setDeliverycounty(String deliverycounty) {
				this.deliverycounty = deliverycounty;
			}
			public String getDeliverypostcode() {
				return deliverypostcode;
			}
			public void setDeliverypostcode(String deliverypostcode) {
				this.deliverypostcode = deliverypostcode;
			}
			public String getDeliverycountry() {
				return deliverycountry;
			}
			public void setDeliverycountry(String deliverycountry) {
				this.deliverycountry = deliverycountry;
			}
			@Override
			public String toString() {
				return "Address [deliveryparty=" + deliveryparty + ", contactname=" + contactname
						+ ", contactphonenumber=" + contactphonenumber + ", deliveryaddress1=" + deliveryaddress1
						+ ", deliveryaddress2=" + deliveryaddress2 + ", deliveryaddress3=" + deliveryaddress3
						+ ", deliveryaddress4=" + deliveryaddress4 + ", deliverycity=" + deliverycity
						+ ", deliverycounty=" + deliverycounty + ", deliverypostcode=" + deliverypostcode
						+ ", deliverycountry=" + deliverycountry + "]";
			}
			
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/references")
	public class References {
		private String externalreference;
		private String customerporeference;
		private String uniservereference;
		
		public String getExternalreference() {
			return externalreference;
		}
		public void setExternalreference(String externalreference) {
			this.externalreference = externalreference;
		}
		public String getCustomerporeference() {
			return customerporeference;
		}
		public void setCustomerporeference(String customerporeference) {
			this.customerporeference = customerporeference;
		}
		public String getUniservereference() {
			return uniservereference;
		}
		public void setUniservereference(String uniservereference) {
			this.uniservereference = uniservereference;
		}
		
		@Override
		public String toString() {
			return "References [externalreference=" + externalreference + ", customerporeference=" + customerporeference
					+ ", uniservereference=" + uniservereference + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickheader/parties")
	public class Parties {
		private String organisation;
		private String channel;
		
		public String getOrganisation() {
			return organisation;
		}
		public void setOrganisation(String organisation) {
			this.organisation = organisation;
		}
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		
		@Override
		public String toString() {
			return "Parties [organisation=" + organisation + ", channel=" + channel + "]";
		}
		
	}
	
}
