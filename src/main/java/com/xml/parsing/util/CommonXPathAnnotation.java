/**
 * 
 */
package com.xml.parsing.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author vkandula
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonXPathAnnotation {
	
	public String xPath() default "";
	public String tagName() default "";
	public String[] attributes() default {};

}
