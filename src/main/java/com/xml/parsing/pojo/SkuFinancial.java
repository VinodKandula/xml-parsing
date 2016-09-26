/**
 * 
 */
package com.xml.parsing.pojo;

import com.xml.parsing.util.CommonXPathAnnotation;

/**
 * @author vinod
 *
 */
@CommonXPathAnnotation(xPath="/sku/financial")
public class SkuFinancial {

	private String costprice;
	private String salesprice;
	private Duty duty;
	private Excise excise;
	
	public String getCostprice() {
		return costprice;
	}

	public void setCostprice(String costprice) {
		this.costprice = costprice;
	}

	public String getSalesprice() {
		return salesprice;
	}

	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public Excise getExcise() {
		return excise;
	}

	public void setExcise(Excise excise) {
		this.excise = excise;
	}
	
	@Override
	public String toString() {
		return "SkuFinancial [costprice=" + costprice + ", salesprice=" + salesprice + ", duty=" + duty + ", excise="
				+ excise + "]";
	}


	@CommonXPathAnnotation(xPath="/sku/financial/excise")
	public class Excise {
		private String abv;
		private String taxcodetype;
		
		public String getAbv() {
			return abv;
		}
		public void setAbv(String abv) {
			this.abv = abv;
		}
		public String getTaxcodetype() {
			return taxcodetype;
		}
		public void setTaxcodetype(String taxcodetype) {
			this.taxcodetype = taxcodetype;
		}
		@Override
		public String toString() {
			return "Excise [abv=" + abv + ", taxcodetype=" + taxcodetype + "]";
		}
	
	}
	
	@CommonXPathAnnotation(xPath="/sku/financial/duty")
	public class Duty {
		private String tariffcode;
		private String dutyrate;
		
		public String getTariffcode() {
			return tariffcode;
		}
		public void setTariffcode(String tariffcode) {
			this.tariffcode = tariffcode;
		}
		public String getDutyrate() {
			return dutyrate;
		}
		public void setDutyrate(String dutyrate) {
			this.dutyrate = dutyrate;
		}
		@Override
		public String toString() {
			return "Duty [tariffcode=" + tariffcode + ", dutyrate=" + dutyrate + "]";
		}
		
	}
}
