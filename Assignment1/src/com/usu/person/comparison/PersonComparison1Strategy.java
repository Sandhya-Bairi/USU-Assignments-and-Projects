package com.usu.person.comparison;

import java.util.ArrayList;
import java.util.List;

import com.usu.person.Children;
import com.usu.person.Person;

/**
 * @author anujk
 * This is a strategy implementor class for person comparison
 *
 */
public class PersonComparison1Strategy extends PersonComparisonStrategy {
	
	/* (non-Javadoc)
	 * @see com.usu.person.comparison.PersonComparisonStrategy#comparePersons(java.util.List)
	 * This method provides the implementation for person comparison on first condition
	 */
	public List<Integer> comparePersons(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if ((isFieldNotNullAndEmpty(persons.get(i).getStateFileNumber()) && isFieldNotNullAndEmpty(persons.get(j).getStateFileNumber())) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j)))) {
					if(persons.get(i).getStateFileNumber().equals(persons.get(j).getStateFileNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(j).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
					}
				} else if((isFieldNotNullAndEmpty(persons.get(i).getSocialSecurityNumber()) && isFieldNotNullAndEmpty(persons.get(j).getSocialSecurityNumber())) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j)))) {
					if(persons.get(i).getSocialSecurityNumber().equals(persons.get(j).getSocialSecurityNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
					}
				} else if(persons.get(i) instanceof Children && persons.get(j) instanceof Children) { 
					if((isFieldNotNullAndEmpty(((Children)persons.get(i)).getNewbornScreeningNumber()) && isFieldNotNullAndEmpty(((Children)persons.get(j)).getNewbornScreeningNumber()) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j))))) {
						if(persons.get(i).getSocialSecurityNumber().equals(persons.get(j).getSocialSecurityNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
						}
					}
				}else {
					System.out.println("The pair does not match");
				}
			}
		}
		return personsMatchedObjectIds;
	}
}
