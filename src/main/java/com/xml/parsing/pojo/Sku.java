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
@CommonXPathAnnotation(xPath="/sku")
public class Sku {

	private String skucode;
	@CommonXPathAnnotation(xPath="/sku/parties/organisation")
	private String organisation;
	private SkuProperties properties;
	private List<Barcodes> barcodes;
	private UOM uom;
	private Dimensions dimensions;
	private Weights weights;
	private SkuFinancial  skuFinancial;
	private List<Customdata> customdata;
	private Version version;
	private Directives directives;
	
	public String getSkucode() {
		return skucode;
	}

	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public SkuProperties getProperties() {
		return properties;
	}

	public void setProperties(SkuProperties properties) {
		this.properties = properties;
	}

	public List<Barcodes> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<Barcodes> barcodes) {
		this.barcodes = barcodes;
	}

	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Weights getWeights() {
		return weights;
	}

	public void setWeights(Weights weights) {
		this.weights = weights;
	}

	public SkuFinancial getSkuFinancial() {
		return skuFinancial;
	}

	public void setSkuFinancial(SkuFinancial skuFinancial) {
		this.skuFinancial = skuFinancial;
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
		return "Sku [skucode=" + skucode + ", organisation=" + organisation + ", properties=" + properties
				+ ", barcodes=" + barcodes + ", uom=" + uom + ", dimensions=" + dimensions + ", weights=" + weights
				+ ", skuFinancial=" + skuFinancial + ", customdata=" + customdata + ", version=" + version
				+ ", directives=" + directives + "]";
	}


	@CommonXPathAnnotation(xPath="/sku/directives")
	public class Directives {
		private String action;
		private String wmsPush;
		private String wmsInstance;
		
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
		
		@Override
		public String toString() {
			return "Directives [action=" + action + ", wmsPush=" + wmsPush + ", wmsInstance=" + wmsInstance + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/sku/version")
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
	
	@CommonXPathAnnotation(xPath="/sku/customdata")
	public class Customdata {
		private String attribute;
		@CommonXPathAnnotation(xPath="/sku/customdata/value/text")
		private String text;
		@CommonXPathAnnotation(xPath="/sku/customdata/value/other")
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
	
	@CommonXPathAnnotation(xPath="/sku/weights")
	public class Weights {
		private String grossweight;
		private String netweight;
		
		public String getGrossweight() {
			return grossweight;
		}
		public void setGrossweight(String grossweight) {
			this.grossweight = grossweight;
		}
		public String getNetweight() {
			return netweight;
		}
		public void setNetweight(String netweight) {
			this.netweight = netweight;
		}
		
		@Override
		public String toString() {
			return "Dimensions [grossweight=" + grossweight + ", netweight=" + netweight + "]";
		}

	}
	
	@CommonXPathAnnotation(xPath="/sku/dimensions")
	public class Dimensions {
		private String height;
		private String width;
		private String depth;
		private String volume;
		private String cube;
		
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		public String getDepth() {
			return depth;
		}
		public void setDepth(String depth) {
			this.depth = depth;
		}
		public String getVolume() {
			return volume;
		}
		public void setVolume(String volume) {
			this.volume = volume;
		}
		public String getCube() {
			return cube;
		}
		public void setCube(String cube) {
			this.cube = cube;
		}
		
		@Override
		public String toString() {
			return "Dimensions [height=" + height + ", width=" + width + ", depth=" + depth + ", volume=" + volume
					+ ", cube=" + cube + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/sku/uom")
	public class UOM {
		private String unitofmeasure;
		private String qtyperuom;
		
		public String getUnitofmeasure() {
			return unitofmeasure;
		}
		public void setUnitofmeasure(String unitofmeasure) {
			this.unitofmeasure = unitofmeasure;
		}
		public String getQtyperuom() {
			return qtyperuom;
		}
		public void setQtyperuom(String qtyperuom) {
			this.qtyperuom = qtyperuom;
		}
		
		@Override
		public String toString() {
			return "Barcodes [unitofmeasure=" + unitofmeasure + ", qtyperuom=" + qtyperuom + "]";
		}
		
	}
	
	@CommonXPathAnnotation(xPath="/sku/barcodes")
	public class Barcodes {
		private String barcodetype;
		private String barcodevalue;
		private String uom;
		private String unitsperuom;
		
		public String getBarcodetype() {
			return barcodetype;
		}
		public void setBarcodetype(String barcodetype) {
			this.barcodetype = barcodetype;
		}
		public String getBarcodevalue() {
			return barcodevalue;
		}
		public void setBarcodevalue(String barcodevalue) {
			this.barcodevalue = barcodevalue;
		}
		public String getUom() {
			return uom;
		}
		public void setUom(String uom) {
			this.uom = uom;
		}
		public String getUnitsperuom() {
			return unitsperuom;
		}
		public void setUnitsperuom(String unitsperuom) {
			this.unitsperuom = unitsperuom;
		}
		@Override
		public String toString() {
			return "Barcodes [barcodetype=" + barcodetype + ", barcodevalue=" + barcodevalue + ", uom=" + uom
					+ ", unitsperuom=" + unitsperuom + "]";
		}	
		
	}
}
