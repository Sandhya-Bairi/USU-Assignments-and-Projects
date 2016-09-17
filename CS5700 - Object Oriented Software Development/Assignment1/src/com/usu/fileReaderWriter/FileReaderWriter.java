package com.usu.fileReaderWriter;

import java.util.ArrayList;
import java.util.List;

import com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy;
import com.usu.fileReaderWriter.strategize.JSONFileReaderWriterStrategy;
import com.usu.fileReaderWriter.strategize.TXTFileReaderWriter;
import com.usu.fileReaderWriter.strategize.XMLFileReaderWriterStrategy;
import com.usu.person.Person;
import com.usu.person.comparison.PersonComparison1Strategy;
import com.usu.person.comparison.PersonComparison2Strategy;
import com.usu.person.comparison.PersonComparison3Strategy;
import com.usu.person.comparison.PersonComparison4Strategy;
import com.usu.person.comparison.PersonComparison5Strategy;
import com.usu.person.comparison.PersonComparisonStrategy;

/**
 * @author anujk
 * This is a file reader writer class for which the strategy pattern is implemented
 *
 */
public class FileReaderWriter {
	FileReaderWriterStrategy fileReaderWriterStrategy;
	PersonComparisonStrategy personComparisonStrategy;
	
	/**
	 * @throws Exception
	 * This method calls the strategy interface method; 
	 */
	public List<Integer> fileReader(String personInputFileName) throws Exception {
		List<Person> persons = new ArrayList<Person>();
		if(!personInputFileName.isEmpty()) {
			persons = fileReaderWriterStrategy.inputFileReader(personInputFileName);
		} else {
			throw new Exception("Invalid file name or location");
		}
		return comparePerson(persons);
	}
	
	/**
	 * @param personFileName
	 * @throws Exception 
	 * This is a parameterized constructor responsible for taking runtime decisions of strategy
	 */
	public FileReaderWriter(String personInputFileType, int personCompareCriteria) throws Exception {
		if(personInputFileType.equals("json")) {
			fileReaderWriterStrategy = new JSONFileReaderWriterStrategy();
		} else if(personInputFileType.equals("xml")) {
			fileReaderWriterStrategy = new XMLFileReaderWriterStrategy();
		} else {
			throw new Exception("Invalid input file format");
		}
		
		if(personCompareCriteria == 1) {
			personComparisonStrategy = new PersonComparison1Strategy();
		} else if(personCompareCriteria == 2) {
			personComparisonStrategy = new PersonComparison2Strategy();
		} else if(personCompareCriteria == 3) {
			personComparisonStrategy = new PersonComparison3Strategy();
		} else if(personCompareCriteria ==4) {
			personComparisonStrategy = new PersonComparison4Strategy();
		} else if(personCompareCriteria == 5) {
			personComparisonStrategy = new PersonComparison5Strategy();
		} else {
			throw new Exception("Invalid comparison input");
		}
	}
	
	/**
	 * @param personOutputFileType
	 * @throws Exception
	 * Another parameterized constructor
	 */
	public FileReaderWriter(String personOutputFileType) throws Exception {
		if(personOutputFileType.equals("txt")) {
			fileReaderWriterStrategy = new TXTFileReaderWriter();
		} else {
			throw new Exception("Invalid output file format");
		}
	}
	
	/**
	 * @param persons
	 * This method calls person comparing method 
	 */
	List<Integer> comparePerson(List<Person> persons) {
		return personComparisonStrategy.comparePersons(persons);
	}
	
	/**
	 * @param personOutputFileName
	 * @param comparedPersonObjectId
	 * @throws Exception	 * 
	 * This message is used for writing the objectId into the file
	 */
	public void fileWriter(String personOutputFileName, List<Integer> comparedPersonObjectId) throws Exception{
		if(!personOutputFileName.isEmpty()) {
			fileReaderWriterStrategy.outputFileWriter(personOutputFileName, comparedPersonObjectId);
		} else {
			throw new Exception("Invalid file name or location");
		}
	}
}