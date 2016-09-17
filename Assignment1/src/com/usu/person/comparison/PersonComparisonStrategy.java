package com.usu.person.comparison;

import java.util.ArrayList;
import java.util.List;

import com.usu.person.Children;
import com.usu.person.Person;

/**
 * @author anujk
 * This is an abstract class for person comparison whose behavior is decided in the child classes.
 *
 */
public abstract class PersonComparisonStrategy {
	/**
	 * @param personStringValue
	 * @return
	 * Checks if string field is not null and empty 
	 */
	boolean isFieldNotNullAndEmpty(String personStringValue) {
		if(personStringValue != null && !personStringValue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param person
	 * @return
	 * Checks if all birth details is not null and empty
	 */
	boolean containsBirthDetails(Person person) {
		if(person.getBirthYear() != 0 || person.getBirthMonth() != 0 || person.getBirthDay() != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param person
	 * @return
	 * Checks if 2 or more field is not null
	 */
	boolean isTwoOrMoreNameFieldsAvailable(Person person) {
		if((person.getFirstName() != null)? ((person.getMiddleName() != null) || (person.getLastName() != null)) : ((person.getMiddleName() != null) && (person.getLastName() != null))) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param person
	 * @return
	 * Checks if all name fields is not null
	 */
	boolean isCompleteNameFieldAvailable(Person person) {
		if(person.getFirstName() != null && person.getMiddleName() != null && person.getLastName() != null)
			return true;
		return false;
	}
	
	/**
	 * @param person
	 * @return
	 * Checks if all name fields is not null and empty
	 */
	List<String> nameFieldsNotNullAndEmpty(Person person) {
		List<String> fieldsNotNull = new ArrayList<String>();
		if(person.getFirstName() != null && !person.getFirstName().isEmpty()) {
			fieldsNotNull.add("First Name");
		} else if(person.getMiddleName() != null && !person.getMiddleName().isEmpty()) {
			fieldsNotNull.add("Middle Name");
		} else if(person.getLastName() != null && !person.getLastName().isEmpty()) {
			fieldsNotNull.add("Last Name");
		}
		return fieldsNotNull;
	}
	
	/**
	 * @param person
	 * @return
	 * Checks if all mother details is not null
	 */
	boolean isMotherInformationAvailable(Person person) {
		if(((Children)person).getMotherFirstName() != null && ((Children)person).getMotherMiddleName() != null && ((Children)person).getMotherLastName() != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param persons
	 * @return
	 */
	public abstract List<Integer> comparePersons(List<Person> persons);
}
