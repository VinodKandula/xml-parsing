/**
 * 
 */
package com.xml.parsing.pojo;

import com.xml.parsing.util.CommonXPathAnnotation;

/**
 * @author vinod
 *
 */
@CommonXPathAnnotation(xPath="/pickinstruction")
public class PickInstruction {

	private Pickheader pickheader;
	private Pickdetail pickdetail;
	
	public Pickheader getPickheader() {
		return pickheader;
	}
	public void setPickheader(Pickheader pickheader) {
		this.pickheader = pickheader;
	}
	public Pickdetail getPickdetail() {
		return pickdetail;
	}
	public void setPickdetail(Pickdetail pickdetail) {
		this.pickdetail = pickdetail;
	}
	@Override
	public String toString() {
		return "PickInstruction [pickheader=" + pickheader + ", pickdetail=" + pickdetail + "]";
	}
	
}
