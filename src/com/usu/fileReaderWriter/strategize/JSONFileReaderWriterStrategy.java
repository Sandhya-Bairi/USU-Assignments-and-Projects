package com.usu.fileReaderWriter.strategize;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usu.person.Person;

public class JSONFileReaderWriterStrategy extends FileReaderWriterStrategy {
	ObjectMapper personObjectMapper = new ObjectMapper();
	
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

	@Override
	public List<Person> outputFileWriter() {
		return null;
	}

}
