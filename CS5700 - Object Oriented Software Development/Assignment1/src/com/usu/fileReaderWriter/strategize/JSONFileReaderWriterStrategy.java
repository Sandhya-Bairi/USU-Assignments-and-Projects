package com.usu.fileReaderWriter.strategize;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usu.person.Person;

/**
 * @author anujk
 * This is a strategy implementor class for json file format
 *
 */
public class JSONFileReaderWriterStrategy extends FileReaderWriterStrategy {
	ObjectMapper personObjectMapper = new ObjectMapper();
	
	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#inputFileReader(java.lang.String)
	 * This method provides the implementation for json input files parsing using jackson jars
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Person> inputFileReader(String personInputFileName) {
		personObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		personObjectMapper.setVisibilityChecker(personObjectMapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));
		try {
			persons = personObjectMapper.readValue(new FileReader(personInputFileName), new TypeReference<List<Person>>(){});
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return persons;
	}

	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#outputFileWriter(java.lang.String, java.util.List)
	 * No implementation is provided as we do not want to save in JSON format
	 */
	@Override
	public void outputFileWriter(String personOutputFileName, List<Integer> comparedPersonObjectId) {
		// TODO Auto-generated method stub
		
	}

}
