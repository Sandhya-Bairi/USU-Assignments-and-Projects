package com.usu.fileReaderWriter.strategize.utilities;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.usu.person.Adult;
import com.usu.person.Children;
import com.usu.person.Person;

/**
 * @author anujk
 * This class is implements the logic of deserializing xml
 *
 */
public class XMLDeserializer {
	/**
	 * @param personDocument
	 * @return
	 * @throws Exception
	 * 
	 * This method is used for transforming xml parsed object into Java object
	 */
	public List<Person> xmlToPersonObject(Document personDocument) throws Exception {
		List<Person> persons = new ArrayList<Person>();
		if (!personDocument.getDocumentElement().getNodeName().toString().equalsIgnoreCase("persons")) {
			throw new Exception("Invalid input XML format!");
		}

		NodeList persopersonNodeList = personDocument.getElementsByTagName("Person");

		for (int i = 0; i < persopersonNodeList.getLength(); i++) {
			Node personNode = persopersonNodeList.item(i);
			if (personNode.getNodeType() == Node.ELEMENT_NODE) {
				Element personElement = (Element) personNode;
				String personType = personElement.getAttribute("type");
				if(personType.equals("Adult")) {
					Adult tempAdultObject = new Adult();
					tempAdultObject.setObjectId(Integer.parseInt((personElement.getElementsByTagName("ObjectId").item(0) != null ? personElement.getElementsByTagName("ObjectId").item(0).getTextContent() : "")));
					tempAdultObject.setStateFileNumber((personElement.getElementsByTagName("StateFileNumber").item(0) != null ? personElement.getElementsByTagName("StateFileNumber").item(0).getTextContent() : ""));
					tempAdultObject.setSocialSecurityNumber((personElement.getElementsByTagName("SocialSecurityNumber").item(0) != null ? personElement.getElementsByTagName("SocialSecurityNumber").item(0).getTextContent() : ""));
					tempAdultObject.setFirstName((personElement.getElementsByTagName("FirstName").item(0) != null ? personElement.getElementsByTagName("FirstName").item(0).getTextContent() : ""));
					tempAdultObject.setMiddleName((personElement.getElementsByTagName("MiddleName").item(0) != null ? personElement.getElementsByTagName("MiddleName").item(0).getTextContent() : ""));
					tempAdultObject.setLastName((personElement.getElementsByTagName("LastName").item(0) != null ? personElement.getElementsByTagName("LastName").item(0).getTextContent() : ""));
					tempAdultObject.setBirthYear(Integer.parseInt((personElement.getElementsByTagName("BirthYear").item(0) != null ? personElement.getElementsByTagName("BirthYear").item(0).getTextContent() : "")));
					tempAdultObject.setBirthMonth(Integer.parseInt((personElement.getElementsByTagName("BirthMonth").item(0) != null ? personElement.getElementsByTagName("BirthMonth").item(0).getTextContent() : "")));
					tempAdultObject.setBirthDay(Integer.parseInt((personElement.getElementsByTagName("BirthDay").item(0) != null ? personElement.getElementsByTagName("BirthMonth").item(0).getTextContent() : "")));
					tempAdultObject.setGender((personElement.getElementsByTagName("Gender").item(0) != null ? personElement.getElementsByTagName("Gender").item(0).getTextContent() : ""));
					tempAdultObject.setPhone1((personElement.getElementsByTagName("Phone1").item(0) != null ? personElement.getElementsByTagName("Phone1").item(0).getTextContent() : ""));
					tempAdultObject.setPhone2((personElement.getElementsByTagName("Phone2").item(0) != null ? personElement.getElementsByTagName("Phone2").item(0).getTextContent() : ""));
					persons.add(i, tempAdultObject);
				} else if(personType.equals("Child")) {
					Children tempChildrenObject = new Children();
					tempChildrenObject.setObjectId(Integer.parseInt((personElement.getElementsByTagName("ObjectId").item(0) != null ? personElement.getElementsByTagName("ObjectId").item(0).getTextContent() : "")));
					tempChildrenObject.setStateFileNumber((personElement.getElementsByTagName("StateFileNumber").item(0) != null ? personElement.getElementsByTagName("StateFileNumber").item(0).getTextContent() : ""));
					tempChildrenObject.setSocialSecurityNumber((personElement.getElementsByTagName("SocialSecurityNumber").item(0) != null ? personElement.getElementsByTagName("SocialSecurityNumber").item(0).getTextContent() : ""));
					tempChildrenObject.setFirstName((personElement.getElementsByTagName("FirstName").item(0) != null ? personElement.getElementsByTagName("FirstName").item(0).getTextContent() : ""));
					tempChildrenObject.setMiddleName((personElement.getElementsByTagName("MiddleName").item(0) != null ? personElement.getElementsByTagName("MiddleName").item(0).getTextContent() : ""));
					tempChildrenObject.setLastName((personElement.getElementsByTagName("LastName").item(0) != null ? personElement.getElementsByTagName("LastName").item(0).getTextContent() : ""));
					tempChildrenObject.setBirthYear(Integer.parseInt((personElement.getElementsByTagName("BirthYear").item(0) != null ? personElement.getElementsByTagName("BirthYear").item(0).getTextContent() : "")));
					tempChildrenObject.setBirthMonth(Integer.parseInt((personElement.getElementsByTagName("BirthMonth").item(0) != null ? personElement.getElementsByTagName("BirthMonth").item(0).getTextContent() : "")));
					tempChildrenObject.setBirthDay(Integer.parseInt((personElement.getElementsByTagName("BirthDay").item(0) != null ? personElement.getElementsByTagName("BirthDay").item(0).getTextContent() : "")));
					tempChildrenObject.setGender((personElement.getElementsByTagName("Gender").item(0) != null ? personElement.getElementsByTagName("Gender").item(0).getTextContent() : ""));
					tempChildrenObject.setNewbornScreeningNumber((personElement.getElementsByTagName("NewbornScreeningNumber").item(0) != null ? personElement.getElementsByTagName("NewbornScreeningNumber").item(0).getTextContent() : ""));
					tempChildrenObject.setIsPartOfMultipleBirth((personElement.getElementsByTagName("IsPartOfMultipleBirth").item(0) != null ? personElement.getElementsByTagName("IsPartOfMultipleBirth").item(0).getTextContent() : ""));
					tempChildrenObject.setBirthOrder(Integer.parseInt((personElement.getElementsByTagName("BirthOrder").item(0) != null ? personElement.getElementsByTagName("BirthOrder").item(0).getTextContent() : "")));
					tempChildrenObject.setBirthCounty((personElement.getElementsByTagName("BirthCounty").item(0) != null ? personElement.getElementsByTagName("BirthCounty").item(0).getTextContent() : ""));
					tempChildrenObject.setMotherFirstName((personElement.getElementsByTagName("MotherFirstName").item(0) != null ? personElement.getElementsByTagName("MotherFirstName").item(0).getTextContent() : ""));
					tempChildrenObject.setMotherMiddleName((personElement.getElementsByTagName("MotherMiddleName").item(0) != null ? personElement.getElementsByTagName("MotherMiddleName").item(0).getTextContent() : ""));
					tempChildrenObject.setMotherLastName((personElement.getElementsByTagName("MotherLastName").item(0) != null ? personElement.getElementsByTagName("MotherLastName").item(0).getTextContent() : ""));
					persons.add(i, tempChildrenObject);
				}
			}
		}
		return persons;
	}
}