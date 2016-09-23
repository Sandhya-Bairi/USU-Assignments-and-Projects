package com.usu.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author anujk
 * This is a POJO class for Person object
 *
 */
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "__type")
@JsonSubTypes({@Type(value = Children.class, name = "Child"), @Type(value = Adult.class, name = "Adult")})
//@XmlRootElement(name="Person")
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Children.class,Adult.class})*/
public abstract class Person {

	@JsonProperty("ObjectId")
//	@XmlElement(name="ObjectId")
	int objectId;
	@JsonProperty("StateFileNumber")
//	@XmlElement(name="StateFileNumber")
	String stateFileNumber;
	@JsonProperty("SocialSecurityNumber")
//	@XmlElement(name="SocialSecurityNumber")
	String socialSecurityNumber;
	@JsonProperty("FirstName")
//	@XmlElement(name="FirstName")
	String firstName;
	@JsonProperty("MiddleName")
//	@XmlElement(name="MiddleName")
	String middleName;
	@JsonProperty("LastName")
//	@XmlElement(name="LastName")
	String lastName;
	@JsonProperty("BirthYear")
//	@XmlElement(name="BirthYear")
	int birthYear;
	@JsonProperty("BirthMonth")
//	@XmlElement(name="BirthMonth")
	int birthMonth;
	@JsonProperty("BirthDay")
//	@XmlElement(name="BirthDay")
	int birthDay;
	@JsonProperty("Gender")
//	@XmlElement(name="Gender")
	String gender;

	/**
	 * @return the objectId
	 */

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
