package com.usu.fileReaderWriter;

import java.util.List;

import com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy;
import com.usu.fileReaderWriter.strategize.JSONFileReaderWriterStrategy;
import com.usu.fileReaderWriter.strategize.XMLFileReaderWriterStrategy;
import com.usu.person.Person;
import com.usu.person.comparison.PersonComparison;

/**
 * @author anujk
 * This is a file reader writer class for which the strategy pattern is implemented
 *
 */
public class FileReaderWriter {
	FileReaderWriterStrategy fileReaderWriterStrategy;
	
	/**
	 * This method calls the strategy interface method;
	 */
	public void fileReader(String personInputFileName) {
		List<Person> persons = fileReaderWriterStrategy.inputFileReader(personInputFileName);
		assignPerson(persons);
	}
	
	/**
	 * @param personFileName
	 * This is a parameterized constructor responsible for taking runtime decisions of strategy
	 */
	FileReaderWriter(String personFileType, String personInputFileName) {
		if(personFileType.equals("json")) {
			fileReaderWriterStrategy = new JSONFileReaderWriterStrategy();
		} else if(personFileType.equals("xml")) {
			fileReaderWriterStrategy = new XMLFileReaderWriterStrategy();
		}
	}
	
	void assignPerson(List<Person> persons) {
		PersonComparison personComparison = new PersonComparison();
		personComparison.comparePersons1(persons);
	}
}