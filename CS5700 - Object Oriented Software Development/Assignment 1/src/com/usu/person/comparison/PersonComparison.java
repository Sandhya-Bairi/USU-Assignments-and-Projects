package com.usu.person.comparison;

import java.util.ArrayList;
import java.util.List;

import com.usu.person.Children;
import com.usu.person.Person;

public class PersonComparison {
	
	boolean isFieldNotNullAndEmpty(String personStringValue) {
		if(personStringValue != null && !personStringValue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean containsBirthDetails(Person person) {
		if(person.getBirthYear() != 0 || person.getBirthMonth() != 0 || person.getBirthDay() != 0) {
			return true;
		}
		return false;
	}
	
	boolean isTwoOrMoreNameFieldsAvailable(Person person) {
		if((person.getFirstName() != null)? ((person.getMiddleName() != null) || (person.getLastName() != null)) : ((person.getMiddleName() != null) && (person.getLastName() != null))) {
			return true;
		}
		return false;
	}
	
	boolean isCompleteNameFieldAvailable(Person person) {
		if(person.getFirstName() != null && person.getMiddleName() != null && person.getLastName() != null)
			return true;
		return false;
	}
	
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
	
	boolean isMotherInformationAvailable(Person person) {
		if(((Children)person).getMotherFirstName() != null && ((Children)person).getMotherMiddleName() != null && ((Children)person).getMotherLastName() != null) {
			return true;
		}
		return false;
	}
	
	public List<Integer> comparePersons1(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if ((isFieldNotNullAndEmpty(persons.get(i).getStateFileNumber()) && isFieldNotNullAndEmpty(persons.get(j).getStateFileNumber())) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j)))) {
					if(persons.get(i).getStateFileNumber().equals(persons.get(j).getStateFileNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(j).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
					}
				} else if((isFieldNotNullAndEmpty(persons.get(i).getSocialSecurityNumber()) && isFieldNotNullAndEmpty(persons.get(j).getSocialSecurityNumber())) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j)))) {
					if(persons.get(i).getSocialSecurityNumber().equals(persons.get(j).getSocialSecurityNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
					}
				} else if((isFieldNotNullAndEmpty(((Children)persons.get(i)).getNewbornScreeningNumber()) && isFieldNotNullAndEmpty(((Children)persons.get(j)).getNewbornScreeningNumber()) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j))))) {
					if(persons.get(i).getSocialSecurityNumber().equals(persons.get(j).getSocialSecurityNumber()) && (persons.get(i).getBirthYear() == persons.get(j).getBirthYear()) && (persons.get(i).getBirthMonth() == persons.get(j).getBirthMonth()) && (persons.get(i).getBirthDay() == persons.get(j).getBirthDay())) {
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						personsMatchedObjectIds.add(persons.get(i).getObjectId());
						System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
					}
				} else {
					System.out.println("The pair does not match");
				}
			}
		}
		return personsMatchedObjectIds;
	}
	
	public List<Integer> comparePersons2(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if ((isFieldNotNullAndEmpty(persons.get(i).getStateFileNumber()) && isFieldNotNullAndEmpty(persons.get(j).getStateFileNumber())) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j))))) {
					List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
					for (String nameField : nameFields) {
						if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(j).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
						}
					}							
				} else if((isFieldNotNullAndEmpty(persons.get(i).getSocialSecurityNumber()) && isFieldNotNullAndEmpty(persons.get(j).getSocialSecurityNumber())) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j))))) {
					List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
					for (String nameField : nameFields) {
						if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(j).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
						}
					}
				} else if((isFieldNotNullAndEmpty(((Children)persons.get(i)).getNewbornScreeningNumber()) && isFieldNotNullAndEmpty(((Children)persons.get(i)).getNewbornScreeningNumber()) && (isTwoOrMoreNameFieldsAvailable(persons.get(i)) && (isTwoOrMoreNameFieldsAvailable(persons.get(j)))))) {
					List<String> nameFields = nameFieldsNotNullAndEmpty(persons.get(i));
					for (String nameField : nameFields) {
						if((nameField.equals("FirstName") && nameField.equals("MiddleName")) || (nameField.equals("MiddleName") && nameField.equals("LastName")) || (nameField.equals("FirstName") && nameField.equals("LastName"))) {
							personsMatchedObjectIds.add(persons.get(i).getObjectId());
							personsMatchedObjectIds.add(persons.get(j).getObjectId());
							System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
						}
					}
				} else {
					System.out.println("The pair does not match");
				}
			}
		}
		return personsMatchedObjectIds;
	}
	
	public List<Integer> comparePersons3(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		for(int i = 0; i < persons.size(); i++) {
			for(int j = i+1; j < persons.size(); j++) {
				if((isCompleteNameFieldAvailable(persons.get(i)) && isCompleteNameFieldAvailable(persons.get(j))) && ((persons.get(i).getGender() != null) && (persons.get(j).getGender() != null)) && (containsBirthDetails(persons.get(i)) && containsBirthDetails(persons.get(j))) && (isMotherInformationAvailable(persons.get(i)) && isMotherInformationAvailable(persons.get(j)))){
					personsMatchedObjectIds.add(persons.get(i).getObjectId());
					personsMatchedObjectIds.add(persons.get(j).getObjectId());
					System.out.println("Person with object id: " + persons.get(i).getObjectId() + "matches with person of object id: " + persons.get(j).getObjectId());
				}				
			}
		}
		return personsMatchedObjectIds;
	}
	
	public List<Integer> comparePersons4(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		return personsMatchedObjectIds;
	}
	
	public List<Integer> comparePersons5(List<Person> persons) {
		List<Integer> personsMatchedObjectIds = new ArrayList<Integer>();
		return personsMatchedObjectIds;
	}
}
