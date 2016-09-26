/**
 * 
 */
package com.xml.parsing.pojo;

import com.xml.parsing.util.CommonXPathAnnotation;

/**
 * @author vinod
 *
 */
@CommonXPathAnnotation(xPath="/sku/properties")
public class SkuProperties {

	private String skudescription;
	private String analysiscode;
	private boolean blocked;
	private String leadtime;
	private String variant;
	private String season;
	private String seasoncode;
	private String range;
	private String rangecode;
	private String division;
	private String divisioncode;
	private String department;
	private String departmentcode;
	private String category;
	private String categorycode;
	private String brand;
	private String brandcode;
	private String style;
	private String stylecode;
	private String colour;
	private String colourcode;
	private String size;
	private String sizecode;
	private String gender;
	private String gendercode;
	
	public String getSkudescription() {
		return skudescription;
	}
	public void setSkudescription(String skudescription) {
		this.skudescription = skudescription;
	}
	public String getAnalysiscode() {
		return analysiscode;
	}
	public void setAnalysiscode(String analysiscode) {
		this.analysiscode = analysiscode;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public String getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(String leadtime) {
		this.leadtime = leadtime;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSeasoncode() {
		return seasoncode;
	}
	public void setSeasoncode(String seasoncode) {
		this.seasoncode = seasoncode;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getRangecode() {
		return rangecode;
	}
	public void setRangecode(String rangecode) {
		this.rangecode = rangecode;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDivisioncode() {
		return divisioncode;
	}
	public void setDivisioncode(String divisioncode) {
		this.divisioncode = divisioncode;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrandcode() {
		return brandcode;
	}
	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStylecode() {
		return stylecode;
	}
	public void setStylecode(String stylecode) {
		this.stylecode = stylecode;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getColourcode() {
		return colourcode;
	}
	public void setColourcode(String colourcode) {
		this.colourcode = colourcode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSizecode() {
		return sizecode;
	}
	public void setSizecode(String sizecode) {
		this.sizecode = sizecode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGendercode() {
		return gendercode;
	}
	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}
	
	@Override
	public String toString() {
		return "SkuProperties [skudescription=" + skudescription + ", analysiscode=" + analysiscode + ", blocked="
				+ blocked + ", leadtime=" + leadtime + ", variant=" + variant + ", season=" + season + ", seasoncode="
				+ seasoncode + ", range=" + range + ", rangecode=" + rangecode + ", division=" + division
				+ ", divisioncode=" + divisioncode + ", department=" + department + ", departmentcode=" + departmentcode
				+ ", category=" + category + ", categorycode=" + categorycode + ", brand=" + brand + ", brandcode="
				+ brandcode + ", style=" + style + ", stylecode=" + stylecode + ", colour=" + colour + ", colourcode="
				+ colourcode + ", size=" + size + ", sizecode=" + sizecode + ", gender=" + gender + ", gendercode="
				+ gendercode + "]";
	}
	
	
}
