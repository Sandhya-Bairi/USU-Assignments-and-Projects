package com.usu.fileReaderWriter.strategize;

import java.util.ArrayList;
import java.util.List;

import com.usu.person.Person;

/**
 * @author anujk
 * This is an abstract class for file read write whose behavior is decided in the child classes.
 *
 */
public abstract class FileReaderWriterStrategy {
	List<Person> persons = new ArrayList<Person>();
	
	public abstract List<Person> inputFileReader(String personInputFileName);

    public abstract void outputFileWriter(String personOutputFileName, List<Integer> comparedPersonObjectId);
}
