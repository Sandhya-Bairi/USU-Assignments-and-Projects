package com.usu.person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType(name="Child")
public class Children extends Person{
	
	@JsonProperty("NewbornScreeningNumber")
	String newbornScreeningNumber;
	@JsonProperty("IsPartOfMultipleBirth")
	String isPartOfMultipleBirth;
	@JsonProperty("BirthOrder")
	int birthOrder;
	@JsonProperty("BirthCounty")
	String birthCounty;
	@JsonProperty("MotherFirstName")
	String motherFirstName;
	@JsonProperty("MotherMiddleName")
	String motherMiddleName;
	@JsonProperty("MotherLastName")
	String motherLastName;
	
	/**
	 * @return the newbornScreeningNumber
	 */
	@XmlElement(name="NewbornScreeningNumber")
	public String getNewbornScreeningNumber() {
		return newbornScreeningNumber;
	}
	/**
	 * @param newbornScreeningNumber the newbornScreeningNumber to set
	 */
	public void setNewbornScreeningNumber(String newbornScreeningNumber) {
		this.newbornScreeningNumber = newbornScreeningNumber;
	}
	/**
	 * @return the isPartOfMultipleBirth
	 */
	@XmlElement(name="IsPartOfMultipleBirth")
	public String getIsPartOfMultipleBirth() {
		return isPartOfMultipleBirth;
	}
	/**
	 * @param isPartOfMultipleBirth the isPartOfMultipleBirth to set
	 */
	public void setIsPartOfMultipleBirth(String isPartOfMultipleBirth) {
		this.isPartOfMultipleBirth = isPartOfMultipleBirth;
	}
	/**
	 * @return the birthOrder
	 */
	@XmlElement(name="BirthOrder")
	public int getBirthOrder() {
		return birthOrder;
	}
	/**
	 * @param birthOrder the birthOrder to set
	 */
	public void setBirthOrder(int birthOrder) {
		this.birthOrder = birthOrder;
	}
	/**
	 * @return the birthCounty
	 */
	@XmlElement(name="BirthCounty")
	public String getBirthCounty() {
		return birthCounty;
	}
	/**
	 * @param birthCounty the birthCounty to set
	 */
	public void setBirthCounty(String birthCounty) {
		this.birthCounty = birthCounty;
	}
	/**
	 * @return the motherFirstName
	 */
	@XmlElement(name="MotherFirstName")
	public String getMotherFirstName() {
		return motherFirstName;
	}
	/**
	 * @param motherFirstName the motherFirstName to set
	 */
	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}
	/**
	 * @return the motherMiddleName
	 */
	@XmlElement(name="MotherMiddleName")
	public String getMotherMiddleName() {
		return motherMiddleName;
	}
	/**
	 * @param motherMiddleName the motherMiddleName to set
	 */
	public void setMotherMiddleName(String motherMiddleName) {
		this.motherMiddleName = motherMiddleName;
	}
	/**
	 * @return the motherLastName
	 */
	@XmlElement(name="MotherLastName")
	public String getMotherLastName() {
		return motherLastName;
	}
	/**
	 * @param motherLastName the motherLastName to set
	 */
	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Children))
			return false;
		Children other = (Children) obj;
		if (birthCounty == null) {
			if (other.birthCounty != null)
				return false;
		} else if (!birthCounty.equals(other.birthCounty))
			return false;
		if (birthOrder != other.birthOrder)
			return false;
		if (isPartOfMultipleBirth == null) {
			if (other.isPartOfMultipleBirth != null)
				return false;
		} else if (!isPartOfMultipleBirth.equals(other.isPartOfMultipleBirth))
			return false;
		if (motherFirstName == null) {
			if (other.motherFirstName != null)
				return false;
		} else if (!motherFirstName.equals(other.motherFirstName))
			return false;
		if (motherLastName == null) {
			if (other.motherLastName != null)
				return false;
		} else if (!motherLastName.equals(other.motherLastName))
			return false;
		if (motherMiddleName == null) {
			if (other.motherMiddleName != null)
				return false;
		} else if (!motherMiddleName.equals(other.motherMiddleName))
			return false;
		if (newbornScreeningNumber == null) {
			if (other.newbornScreeningNumber != null)
				return false;
		} else if (!newbornScreeningNumber.equals(other.newbornScreeningNumber))
			return false;
		return true;
	}
}
