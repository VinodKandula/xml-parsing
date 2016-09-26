package com.xml.parsing.util;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ClassUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 
 * @author vkandula
 *
 */

public class XPathUtil {
	private static XPath xPath = XPathFactory.newInstance().newXPath();
	private Document doc;
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DD_MMMM_YYYY = "dd MMMM yyyy";

	public XPathUtil() throws Exception {
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		this.doc = dBuilder.newDocument();
	}

	public XPathUtil(String inputXML) throws Exception {
		this.doc = this.documentBuilder(inputXML);
	}

	public XPathUtil(File inputFile) throws Exception {
		DocumentBuilder builder = factory.newDocumentBuilder();
		this.doc = builder.parse(inputFile);
	}

	public XPathUtil(InputStream inputStream) throws Exception {
		DocumentBuilder builder = factory.newDocumentBuilder();
		this.doc = builder.parse(inputStream);
	}

	private Document documentBuilder(String inputXML) throws Exception {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(inputXML)));
		return doc;
	}

	public <T> T evaluateXPathAndPopulateData(Class<T> clazz) throws Exception {
		return evaluateXPathAndPopulateData(clazz, 0);
	}

	public <T> T evaluateXPathAndPopulateData(Class<T> clazz, int index) throws Exception {
		T obj = clazz.newInstance();
		evaluateClazzXPathAndPopulateData(clazz, obj, index);
		//System.out.println("Clazz to Object : "+obj.toString());
		return obj;
	}

	private void evaluateClazzXPathAndPopulateData(Class<?> clazz, Object obj, int index) throws Exception {
		CommonXPathAnnotation clzzAnnotation = (CommonXPathAnnotation) clazz.getAnnotation(CommonXPathAnnotation.class);
		Field[] allFields = clazz.getDeclaredFields();
		List<String> attributes = null;
		if (clzzAnnotation != null && clzzAnnotation.attributes() != null && clzzAnnotation.attributes().length > 0) {
			attributes = Arrays.asList(clzzAnnotation.attributes());
		}
		String clazzXPath = clzzAnnotation.xPath();
		if (index > 0) {
			clazzXPath = clazzXPath.replace("#", ""+index);
		}
		if (clzzAnnotation != null && clazzXPath != null) {
			if (obj instanceof Collection<?>) {
				NodeList nodeList = (NodeList) xPath.compile(clazzXPath).evaluate(doc,XPathConstants.NODESET);

				for (int i = 0; i < nodeList.getLength(); i++) {
					Object newObj = createInstance(clazz);
					Node nNode = nodeList.item(i);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						for (String attibute : clzzAnnotation.attributes()) {
							try {
								String attributeVal = eElement.getAttribute(attibute);
								if (attributeVal != null) {
									BeanUtils.setProperty(newObj, attibute, attributeVal);
								}
							} catch (Exception e) {
								System.err.println("Error parsing xPath for attribute : " + attibute);
								e.printStackTrace();
							}
						}

						for (Field field : allFields) {
							try {
								CommonXPathAnnotation fieldAnnotation = field.getAnnotation(CommonXPathAnnotation.class);
								field.setAccessible(true);
								if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType().getSimpleName().toLowerCase().endsWith("string")) {
									if (fieldAnnotation == null || StringUtils.isEmpty(fieldAnnotation.xPath()) ) {
										if (attributes != null && attributes.contains(field.getName())) {
											continue;
										}
										// XML tag names are case sensitive
										NodeList tagNodeList = null;
										if (fieldAnnotation == null || StringUtils.isEmpty(fieldAnnotation.tagName()) ) {
											tagNodeList = eElement.getElementsByTagName(field.getName());
										} else {
											tagNodeList = eElement.getElementsByTagName(fieldAnnotation.tagName());
										}
										
										if ( tagNodeList == null || tagNodeList.getLength() == 0) {
											continue;
										}
										String val = tagNodeList.item(0).getTextContent();
										if (val != null) {
											//field.set(newObj, val);
											BeanUtils.setProperty(newObj, field.getName(), val);
										}
									} else if (fieldAnnotation != null) { 
										// can also be defined for direct attribute xPath notation
										evaluateFieldXPathAndPopulateData(field, fieldAnnotation.xPath(), newObj, null);
									}
								} else {
									if (field.getName().contains("this$"))
										continue;
									Class<?> rawClazz = field.getType();
									Object rawObj = null;
									if (rawClazz.toString().startsWith("interface")) {
										rawObj = new ArrayList();
										String genericTypeName = field.getGenericType().toString();
										rawClazz = Class.forName(genericTypeName.substring(genericTypeName.indexOf('<') + 1, genericTypeName.indexOf('>')));
									} else {
										rawObj = createInstance(rawClazz);
									}
									evaluateClazzXPathAndPopulateData(rawClazz, rawObj, i+1);
									//field.set(newObj, rawObj);
									BeanUtils.setProperty(newObj, field.getName(), rawObj);
								}
							} catch (Exception e) {
								System.err.println("Error parsing xPath for field : " + field.getName());
								e.printStackTrace();
							}
						}
					}
					
					Collection list = (Collection) obj;
					list.add(newObj);
					
				}

			} else {
				Node node = (Node) xPath.compile(clazzXPath).evaluate(doc, XPathConstants.NODE);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					for (String attibute : clzzAnnotation.attributes()) {
						try {
							String attributeVal = eElement.getAttribute(attibute);
							if (attributeVal != null)
								BeanUtils.setProperty(obj, attibute, attributeVal);
						} catch (Exception e) {
							System.err.println("Error parsing xPath for attribute : " + attibute);
							e.printStackTrace();
						}
					}

					for (Field field : allFields) {
						try {
							field.setAccessible(true);
							CommonXPathAnnotation fieldAnnotation = field.getAnnotation(CommonXPathAnnotation.class);
							if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType().getSimpleName().toLowerCase().endsWith("string")) {
								if (fieldAnnotation == null || StringUtils.isEmpty(fieldAnnotation.xPath()) ) {
									if (attributes != null && attributes.contains(field.getName())) {
										continue;
									}
									// XML tag names are case sensitive
									NodeList tagNodeList = null;
									if (fieldAnnotation == null || StringUtils.isEmpty(fieldAnnotation.tagName()) ) {
										tagNodeList = eElement.getElementsByTagName(field.getName());
									} else {
										tagNodeList = eElement.getElementsByTagName(fieldAnnotation.tagName());
									}
									
									if ( tagNodeList == null || tagNodeList.getLength() == 0) {
										continue;
									}
									String val = tagNodeList.item(0).getTextContent();
									if (val != null) {
										//field.set(obj, val);
										BeanUtils.setProperty(obj, field.getName(), val);
									}
								} else if (fieldAnnotation != null) {
									evaluateFieldXPathAndPopulateData(field, fieldAnnotation.xPath(), obj, null);
								}
							} else {
								if (field.getName().contains("this$"))
									continue;
								Class<?> rawClazz = field.getType();
								Object rawObj = null;
								if (rawClazz.toString().startsWith("interface")) {
									rawObj = new ArrayList();
									String genericTypeName = field.getGenericType().toString();
									rawClazz = Class.forName(genericTypeName.substring(genericTypeName.indexOf('<') + 1, genericTypeName.indexOf('>')));
								} else {
									rawObj = createInstance(rawClazz);
								}
								evaluateClazzXPathAndPopulateData(rawClazz, rawObj, 0);
								//field.set(obj, rawObj);
								BeanUtils.setProperty(obj, field.getName(), rawObj);
							}

						} catch (Exception e) {
							System.err.println("Error parsing xPath for field : " + field.getName());
							e.printStackTrace();
						}
					}
				}
			}

		}
	}
	
	private Object createInstance(Class<?> rawClazz) throws Exception {
		Object rawObj = null;
		if (rawClazz.getName().contains("$")) {
			String[] clazzNames = rawClazz.getName().split("\\$");
			
			Class<?> enclosingClass = Class.forName(clazzNames[0]);
			Object enclosingInstance = enclosingClass.newInstance();
			String enclosingClassName = clazzNames[0];
			for (int i = 1; i < clazzNames.length; i++) {
				String childClazzName = enclosingClassName+"$"+clazzNames[i];
				Class<?> childClazz = Class.forName(childClazzName);
				Constructor<?> ctor = childClazz.getDeclaredConstructor(enclosingClass);
				ctor.setAccessible(true);
				rawObj = ctor.newInstance(enclosingInstance);
				enclosingClassName = childClazzName;
				enclosingClass = childClazz;
				enclosingInstance = rawObj;
			}
		} else {
			rawObj = rawClazz.newInstance();
		}
		return rawObj;
	}

	private <T> void evaluateFieldXPathAndPopulateData(Field field, String fieldXpath, T obj, String binding)
			throws Exception {
		if (!StringUtils.isEmpty(fieldXpath)) {
			Object value = null;
			xPath.setNamespaceContext(new XPathNamespaceContext());
			xPath.setXPathFunctionResolver(new CustomXPathFunctionResolver());
			if (field.getType().getSimpleName().toLowerCase().endsWith("string")) {
				value = (String) xPath.evaluate(fieldXpath, this.doc.getDocumentElement(), XPathConstants.STRING);
				if (binding != null && StringUtils.isBlank((String) value)) {
					value = binding;
				}
			} else if (field.getType().getSimpleName().toLowerCase().endsWith("double")) {
				value = (Double) xPath.evaluate(fieldXpath, this.doc.getDocumentElement(), XPathConstants.NUMBER);
			} else if (field.getType().getSimpleName().toLowerCase().endsWith("date")) {
				String dateStr = (String) xPath.evaluate(fieldXpath, this.doc.getDocumentElement(),
						XPathConstants.STRING);
				if (StringUtils.isNotEmpty(dateStr)) {
					if (dateStr.length() > 10)
						value = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateStr);
					else
						value = new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
				}

			}
			if (value != null) {
				//field.setAccessible(true);
				//field.set(obj, value);
				BeanUtils.setProperty(obj, field.getName(), value);
			}
		}
	}

	@Deprecated
	public <T> T evaluateXPathAndPopulateData(Class<T> clazz, int index, String binding) throws Exception {
		T obj = clazz.newInstance();

		Field[] allFields = clazz.getDeclaredFields();
		for (Field field : allFields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				// evaluate xpath and set the value to bean
				try {
					CommonXPathAnnotation annotation = field.getAnnotation(CommonXPathAnnotation.class);
					if (annotation != null) {
						String fieldXpath = annotation.xPath();

						fieldXpath = fieldXpath.replaceAll("#", "" + index);

						evaluateFieldXPathAndPopulateData(field, fieldXpath, obj, binding);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error parsing xPath for field : " + field.getName());
				}
			}
		}

		return obj;
	}

	@Deprecated
	public int getNodeCount(String xpath) {
		double nodeCount = 0;
		try {
			nodeCount = (Double) xPath.evaluate(xpath, doc.getDocumentElement(), XPathConstants.NUMBER);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return (int) nodeCount;
	}

	// retrieve XML data from object
	public String createXMLContent(Object obj) throws Exception {
		Class<?> clazz = obj.getClass();
		CommonXPathAnnotation clzzzAnnotation = (CommonXPathAnnotation) clazz.getAnnotation(CommonXPathAnnotation.class);
		Field[] allFields = clazz.getDeclaredFields();
		List<String> attributes = null;
		if (clzzzAnnotation.attributes() != null && clzzzAnnotation.attributes().length > 0) {
			attributes = Arrays.asList(clzzzAnnotation.attributes());
		}
		if (clzzzAnnotation != null && clzzzAnnotation.xPath() != null) {
			String clazzXPath = clzzzAnnotation.xPath().replace("[#]", "");
			String[] tokens = clazzXPath.split("/");
			Element rootElement = null;
			Element parentElement = null;
			Element childElement = null;
			boolean isFirst = true;
			for (String token : tokens) {
				if(token.length() == 0) {
					continue;
				}
				if (isFirst) {
					rootElement = doc.createElement(token);
					doc.appendChild(rootElement);
					isFirst = false;
					parentElement = rootElement;
					childElement = parentElement;
					continue;
				}
				childElement = doc.createElement(token);
				parentElement.appendChild(childElement);
				parentElement = childElement;
			}

			for (Field field : allFields) {
				field.setAccessible(true);
				Object fieldObj = field.get(obj);
				if (fieldObj == null) continue;
				try {
					CommonXPathAnnotation fieldAnnotation = field.getAnnotation(CommonXPathAnnotation.class);
					if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType().getSimpleName().toLowerCase().endsWith("string")) {
						if (fieldAnnotation == null) {
							if (attributes != null && attributes.contains(field.getName())) {
								Attr attrType = doc.createAttribute(field.getName());
								attrType.setValue(field.get(obj).toString());
								childElement.setAttributeNode(attrType);
								continue;
							}
							// XML tag names are case sensitive
							Element newElement = doc.createElement(field.getName());
							newElement.appendChild(doc.createTextNode(field.get(obj).toString()));
							childElement.appendChild(newElement);
						} else if (fieldAnnotation != null) { 
							// can also be defined for direct attribute xPath notation
							String fieldXpath = fieldAnnotation.xPath().replace("[#]", "");
							String fieldAttribute = null;
							if (fieldXpath.contains("@")) {
								fieldAttribute = fieldXpath.substring(fieldXpath.indexOf("@"));
								fieldXpath = fieldXpath.substring(0, fieldXpath.indexOf("@"));
							}
							Element newElement = parseXPathAndCreateElement(fieldXpath.substring(clzzzAnnotation.xPath().length()), childElement);
							newElement.appendChild(doc.createTextNode(field.get(obj).toString()));
							if (fieldAttribute != null) {
								Attr attrType = doc.createAttribute(fieldAttribute);
								attrType.setValue(field.get(obj).toString());
								newElement.setAttributeNode(attrType);
								continue;
							} 
							List<String> fieldAnnotationAttributes = Arrays.asList(fieldAnnotation.attributes());
							for (String fieldAnnotationAttribute : fieldAnnotationAttributes) {
								Attr attrType = doc.createAttribute(fieldAnnotationAttribute);
								String attributeVal = BeanUtils.getProperty(obj, fieldAnnotationAttribute);
								attrType.setValue(attributeVal);
								newElement.setAttributeNode(attrType);
							}
						}
					} else {
						if (field.getName().contains("this$"))
							continue;
						Class rawClazz = field.getType();
						if (rawClazz.toString().startsWith("interface")) {
							String genericTypeName = field.getGenericType().toString();
							rawClazz = Class.forName(genericTypeName.substring(genericTypeName.indexOf('<') + 1, genericTypeName.indexOf('>')));
							List<?> list = (List) field.get(obj);
							for (Object object : list) {
								createXML(object, childElement, clazzXPath);
							}
						} else {
							createXML(field.get(obj), childElement, clazzXPath);
						}
					}

				} catch (Exception e) {
					System.err.println("Error parsing xPath for field : " + field.getName());
					e.printStackTrace();
				}
			}
		}
		DOMSource domSource = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(domSource, result);
		String xmlOut = writer.toString();
		System.out.println("Objec to XML : \n" + xmlOut);
		return xmlOut;
	}

	private Element parseXPathAndCreateElement(String xPath, Element appendElement) {
		String[] tokens = xPath.split("/");
		Element parentElement = appendElement;
		Element childElement = null;
		for (String token : tokens) {
			if(token.length() == 0) {
				continue;
			}
			childElement = doc.createElement(token);
			parentElement.appendChild(childElement);
			parentElement = childElement;
		}
		return childElement;
	}

	private void createXML(Object obj, Element appendElement, String parentXPath) {
		if (obj == null)
			return;
		Class<?> clazz = obj.getClass();
		CommonXPathAnnotation clzzzAnnotation = (CommonXPathAnnotation) clazz
				.getAnnotation(CommonXPathAnnotation.class);
		Field[] allFields = clazz.getDeclaredFields();
		List<String> attributes = null;
		if (clzzzAnnotation.attributes() != null && clzzzAnnotation.attributes().length > 0) {
			attributes = Arrays.asList(clzzzAnnotation.attributes());
		}
		String clazzXPath = clzzzAnnotation.xPath().replace("[#]", "");
		if (clzzzAnnotation != null && clzzzAnnotation.xPath() != null) {
			Element childElement = parseXPathAndCreateElement(clazzXPath.substring(parentXPath.length()), appendElement);
			for (Field field : allFields) {
				try {
					field.setAccessible(true);
					Object fieldObj = field.get(obj);
					if (fieldObj == null)
						continue;
					CommonXPathAnnotation fieldAnnotation = field.getAnnotation(CommonXPathAnnotation.class);
					if (ClassUtils.isPrimitiveOrWrapper(field.getType()) || field.getType().getSimpleName().toLowerCase().endsWith("string")) {
						if (fieldAnnotation == null) {
							if (attributes != null && attributes.contains(field.getName())) {
								Attr attrType = doc.createAttribute(field.getName());
								attrType.setValue(field.get(obj).toString());
								childElement.setAttributeNode(attrType);
								continue;
							}
							// XML tag names are case sensitive
							Element newElement = doc.createElement(field.getName());
							newElement.appendChild(doc.createTextNode(field.get(obj).toString()));
							childElement.appendChild(newElement);
						} else if (fieldAnnotation != null) {
							// can also be defined for direct attribute xPath
							// notation
							String fieldXpath = fieldAnnotation.xPath().replace("[#]", "");
							String fieldAttribute = null;
							if (fieldXpath.contains("@")) {
								fieldAttribute = fieldXpath.substring(fieldXpath.indexOf("@"));
								fieldXpath = fieldXpath.substring(0, fieldXpath.indexOf("@"));
							}
							Element newElement = parseXPathAndCreateElement(fieldXpath.substring(clazzXPath.length()),
									childElement);
							newElement.appendChild(doc.createTextNode(field.get(obj).toString()));
							if (fieldAttribute != null) {
								Attr attrType = doc.createAttribute(fieldAttribute);
								attrType.setValue(field.get(obj).toString());
								newElement.setAttributeNode(attrType);
								continue;
							}
							List<String> fieldAnnotationAttributes = Arrays.asList(fieldAnnotation.attributes());
							for (String fieldAnnotationAttribute : fieldAnnotationAttributes) {
								Attr attrType = doc.createAttribute(fieldAnnotationAttribute);
								String attributeVal = BeanUtils.getProperty(obj, fieldAnnotationAttribute);
								attrType.setValue(attributeVal);
								newElement.setAttributeNode(attrType);
							}
						}
					} else {
						if (field.getName().contains("this$"))
							continue;
						Class rawClazz = field.getType();
						if (rawClazz.toString().startsWith("interface")) {
							String genericTypeName = field.getGenericType().toString();
							rawClazz = Class.forName(genericTypeName.substring(genericTypeName.indexOf('<') + 1,genericTypeName.indexOf('>')));
							List<?> list = (List) field.get(obj);
							for (Object object : list) {
								createXML(object, childElement, clazzXPath);
							}
						} else {
							createXML(field.get(obj), childElement, clazzXPath);
						}
					}

				} catch (Exception e) {
					System.err.println("Error parsing xPath for field : " + field.getName());
					e.printStackTrace();
				}
			}
		}
	}

}
