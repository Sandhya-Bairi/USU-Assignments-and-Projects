package com.usu.person;

import java.util.List;

/*@XmlRootElement(name="Persons")
@XmlAccessorType(XmlAccessType.FIELD)*/
/**
 * @author anujk
 * This POJO was created for ArrayOfPerson tag in xml but now this class is of no use
 *
 */
public class Persons {

//	@XmlElementWrapper
	public List<Person> persons;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}