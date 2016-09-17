package com.usu.person.comparison;

import java.util.ArrayList;
import java.util.List;

import com.usu.person.Person;

/**
 * @author anujk
 * This is a strategy implementor class for person comparison
 */
public class PersonComparison4Strategy extends PersonComparisonStrategy {
	
	/* (non-Javadoc)
	 * @see com.usu.person.comparison.PersonComparisonStrategy#comparePersons(java.util.List)
	 * This method provides the implementation for person comparison on fourth condition
	 */
	public List<Integer> comparePersons(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if((isFieldNotNullAndEmpty(persons.get(i).getSocialSecurityNumber()) && isFieldNotNullAndEmpty(persons.get(j).getSocialSecurityNumber())) && (isCompleteNameFieldAvailable(persons.get(i)) && isCompleteNameFieldAvailable(persons.get(j)))) {
					if(persons.get(i).getSocialSecurityNumber().equals(persons.get(j).getSocialSecurityNumber()) && persons.get(i).getFirstName().equals(persons.get(j).getFirstName()) && persons.get(i).getMiddleName().equals(persons.get(j).getMiddleName()) && persons.get(i).getLastName().equals(persons.get(j).getLastName())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(j).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
					} else {
						System.out.println("The pair does not match");
					}
				}
			}
		}
		return personsMatchedObjectIds;
	}
}
