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
@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail")
public class Pickdetail {

	private String linenumber;
	private String itemsku;
	private String skudescription;
	private String unitsrequested;
	private String bondstatus;
	private String stockcondition;
	private String variant;
	private PickUOM pickuom;
	private Interfaces interfaces;
	private List<Customdata> customdata;
	private Directives directives;
	
	public String getLinenumber() {
		return linenumber;
	}
	public void setLinenumber(String linenumber) {
		this.linenumber = linenumber;
	}
	public String getItemsku() {
		return itemsku;
	}
	public void setItemsku(String itemsku) {
		this.itemsku = itemsku;
	}
	public String getSkudescription() {
		return skudescription;
	}
	public void setSkudescription(String skudescription) {
		this.skudescription = skudescription;
	}
	public String getUnitsrequested() {
		return unitsrequested;
	}
	public void setUnitsrequested(String unitsrequested) {
		this.unitsrequested = unitsrequested;
	}
	public String getBondstatus() {
		return bondstatus;
	}
	public void setBondstatus(String bondstatus) {
		this.bondstatus = bondstatus;
	}
	public String getStockcondition() {
		return stockcondition;
	}
	public void setStockcondition(String stockcondition) {
		this.stockcondition = stockcondition;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public PickUOM getPickuom() {
		return pickuom;
	}
	public void setPickuom(PickUOM pickuom) {
		this.pickuom = pickuom;
	}
	public Interfaces getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(Interfaces interfaces) {
		this.interfaces = interfaces;
	}
	public List<Customdata> getCustomdata() {
		return customdata;
	}
	public void setCustomdata(List<Customdata> customdata) {
		this.customdata = customdata;
	}
	public Directives getDirectives() {
		return directives;
	}
	public void setDirectives(Directives directives) {
		this.directives = directives;
	}

	@Override
	public String toString() {
		return "Pickdetail [linenumber=" + linenumber + ", itemsku=" + itemsku + ", skudescription=" + skudescription
				+ ", unitsrequested=" + unitsrequested + ", bondstatus=" + bondstatus + ", stockcondition="
				+ stockcondition + ", variant=" + variant + ", pickuom=" + pickuom + ", interfaces=" + interfaces
				+ ", customdata=" + customdata + ", directives=" + directives + "]";
	}

	@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/directives")
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
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/customdata")
	public class Customdata {
		private String attribute;
		@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/customdata/value/text")
		private String text;
		@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/customdata/value/other")
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
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/interfaces")
	public class Interfaces {
		private String po;
		private String drop;
		
		public String getPo() {
			return po;
		}
		public void setPo(String po) {
			this.po = po;
		}
		public String getDrop() {
			return drop;
		}
		public void setDrop(String drop) {
			this.drop = drop;
		}
		
		@Override
		public String toString() {
			return "Interfaces [po=" + po + ", drop=" + drop + "]";
		}

	}
	
	@CommonXPathAnnotation(xPath="/pickinstruction/pickdetail/pickuom")
	public class PickUOM {
		private String uom;
		private String qtyperuom;
		
		public String getUom() {
			return uom;
		}
		public void setUom(String uom) {
			this.uom = uom;
		}
		public String getQtyperuom() {
			return qtyperuom;
		}
		public void setQtyperuom(String qtyperuom) {
			this.qtyperuom = qtyperuom;
		}
		@Override
		public String toString() {
			return "PickUOM [uom=" + uom + ", qtyperuom=" + qtyperuom + "]";
		}
		
	}
	
}
