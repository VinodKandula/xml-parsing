/**
 * 
 */
package com.xml.parsing.util;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionResolver;

import org.apache.xml.dtm.ref.DTMNodeList;
import org.w3c.dom.Node;

/**
 * @author vkandula
 * 
 *         The CustomXPathFunctionResolver implementation is used to evaluate the
 *         extension function "ext:customSum(2, 3)".
 *
 */
public class CustomXPathFunctionResolver implements XPathFunctionResolver {
	/**
	 * This method returns a customized XPathFunction implementation for the
	 * extension function "ext:customSum(2, 3)".
	 */
	public XPathFunction resolveFunction(QName fname, int arity) {
		if (fname == null)
			throw new NullPointerException("The function name cannot be null.");

		// We only recognize one function, i.e. ext:customSum().
		if (fname.equals(new QName("http://ext.com", "customSum", "ext")))
			/**
			 * Return a customized implementation of XPathFunction. We need to
			 * implement the evaluate(List) method.
			 */
			return new XPathFunction() {
				/**
				 * The actual implementation of the extension function. Just
				 * cast arguments to Double and add them together.
				 */
				public Object evaluate(java.util.List args) {
					double result = 0.0d;
					try {
						for (Object obj : args) {
							if (obj != null) {
								DTMNodeList dtmNodeList = (DTMNodeList) obj;
								Node node = (Node)dtmNodeList.item(0);
								if (node.getFirstChild().getNodeValue() != null)
									result += Double.valueOf(node.getFirstChild().getNodeValue()).doubleValue();
							}
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
					return result;
				}
			};
		else
			return null;
	}

}
