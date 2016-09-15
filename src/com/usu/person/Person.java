package com.usu.person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "__type")
@JsonSubTypes({@Type(value = Children.class, name = "Child"), @Type(value = Adult.class, name = "Adult")})
@XmlRootElement(name="Person")
@XmlSeeAlso({Children.class,Adult.class})
public abstract class Person {

	@JsonProperty("ObjectId")
	int objectId;
	@JsonProperty("StateFileNumber")
	String stateFileNumber;
	@JsonProperty("SocialSecurityNumber")
	String socialSecurityNumber;
	@JsonProperty("FirstName")
	String firstName;
	@JsonProperty("MiddleName")
	String middleName;
	@JsonProperty("LastName")
	String lastName;
	@JsonProperty("BirthYear")
	int birthYear;
	@JsonProperty("BirthMonth")
	int birthMonth;
	@JsonProperty("BirthDay")
	int birthDay;
	@JsonProperty("Gender")
	String gender;

	/**
	 * @return the objectId
	 */
	@XmlElement(name="ObjectId")
	public int getObjectId() {
		return objectId;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	/**
	 * @return the stateFileNumber
	 */
	@XmlElement(name="StateFileNumber")
	public String getStateFileNumber() {
		return stateFileNumber;
	}
	/**
	 * @param stateFileNumber the stateFileNumber to set
	 */
	public void setStateFileNumber(String stateFileNumber) {
		this.stateFileNumber = stateFileNumber;
	}
	/**
	 * @return the socialSecurityNumber
	 */
	@XmlElement(name="SocialSecurityNumber")
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	/**
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	/**
	 * @return the firstName
	 */
	@XmlElement(name="FirstName")
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	@XmlElement(name="MiddleName")
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	@XmlElement(name="LastName")
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the birthYear
	 */
	@XmlElement(name="BirthYear")
	public int getBirthYear() {
		return birthYear;
	}
	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * @return the birthMonth
	 */
	@XmlElement(name="BirthMonth")
	public int getBirthMonth() {
		return birthMonth;
	}
	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	/**
	 * @return the birthDay
	 */
	@XmlElement(name="BirthDay")
	public int getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * @return the gender
	 */
	@XmlElement(name="Gender")
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (birthDay != other.birthDay)
			return false;
		if (birthMonth != other.birthMonth)
			return false;
		if (birthYear != other.birthYear)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (objectId != other.objectId)
			return false;
		if (socialSecurityNumber == null) {
			if (other.socialSecurityNumber != null)
				return false;
		} else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
			return false;
		if (stateFileNumber == null) {
			if (other.stateFileNumber != null)
				return false;
		} else if (!stateFileNumber.equals(other.stateFileNumber))
			return false;
		return true;
	}
}
