package com.usu.person;

import com.fasterxml.jackson.annotation.JsonProperty;

//@XmlType(name="Adult")
/**
 * @author anujk
 * This is a POJO class for Adult object in hierarchical inheritance
 *
 */
public class Adult extends Person{
	
	@JsonProperty("Phone1")
//	@XmlElement(name="Phone1")
	String phone1;
	@JsonProperty("Phone2")
//	@XmlElement(name="Phone2")
	String phone2;
	
	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * @param phone1 the phone1 to set
	 */
	
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}
	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
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
		if (!(obj instanceof Adult))
			return false;
		Adult other = (Adult) obj;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		return true;
	}
}
