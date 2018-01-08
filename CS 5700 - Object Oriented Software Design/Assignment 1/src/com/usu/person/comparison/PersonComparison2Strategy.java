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
public class PersonComparison2Strategy extends PersonComparisonStrategy {
	
	/* (non-Javadoc)
	 * @see com.usu.person.comparison.PersonComparisonStrategy#comparePersons(java.util.List)
	 * This method provides the implementation for person comparison on second condition
	 */
	public List<Integer> comparePersons(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if ((isFieldNotNullAndEmpty(persons.get(i).getStateFileNumber()) && isFieldNotNullAndEmpty(persons.get(j).getStateFileNumber())) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j))))) {
					List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
					for (String nameField : nameFields) {
						if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(j).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
						}
					}							
				} else if((isFieldNotNullAndEmpty(persons.get(i).getSocialSecurityNumber()) && isFieldNotNullAndEmpty(persons.get(j).getSocialSecurityNumber())) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j))))) {
					List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
					for (String nameField : nameFields) {
						if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(j).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
						}
					}
				} else  if(persons.get(i) instanceof Children && persons.get(j) instanceof Children) { 
					if((isFieldNotNullAndEmpty(((Children)persons.get(i)).getNewbornScreeningNumber()) && isFieldNotNullAndEmpty(((Children)persons.get(j)).getNewbornScreeningNumber()) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j)))))) {
						List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
						for (String nameField : nameFields) {
							if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
								personsMatchedObjectIds.add(persons.get(i).getObjectId());
								personsMatchedObjectIds.add(persons.get(j).getObjectId());
								System.out.println("Person with object id: " + persons.get(i).getObjectId() + " matches with person of object id: " + persons.get(j).getObjectId());
							}
						}
					} 
				} else {
					System.out.println("The pair does not match");
				}
			}
		}
		return personsMatchedObjectIds;
	}
}
