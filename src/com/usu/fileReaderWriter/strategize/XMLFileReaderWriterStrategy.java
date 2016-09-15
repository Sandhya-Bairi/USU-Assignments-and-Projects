package com.usu.fileReaderWriter.strategize;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.usu.person.Adult;
import com.usu.person.ArrayOfPerson;
import com.usu.person.Children;
import com.usu.person.Person;

public class XMLFileReaderWriterStrategy extends FileReaderWriterStrategy {
		
	@Override
	public List<Person> inputFileReader(String personInputFileName) {
		ArrayOfPerson persons = new ArrayOfPerson();
		try {
			JAXBContext personXMLMapper = JAXBContext.newInstance(Children.class, Adult.class);
			Unmarshaller personUnmarshaller = personXMLMapper.createUnmarshaller();
			persons = (ArrayOfPerson)personUnmarshaller.unmarshal(new FileReader(personInputFileName));
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}

		return persons.getPersons();
	}

	@Override
	public List<Person> outputFileWriter() {
		
		return null;
	}

}
