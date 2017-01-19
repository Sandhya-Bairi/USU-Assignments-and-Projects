package com.usu.fileReaderWriter.strategize;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.usu.fileReaderWriter.strategize.utilities.XMLDeserializer;
import com.usu.person.Person;

/**
 * @author anujk
 * This is a strategy implementor class for xml file format
 *
 */
public class XMLFileReaderWriterStrategy extends FileReaderWriterStrategy {
		
	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#inputFileReader(java.lang.String)
	 * This method provides the implementation for xml input files parsing using DOM parser
	 * 
	 */
	@Override
	public List<Person> inputFileReader(String personInputFileName) {
		List<Person> persons = new ArrayList<Person>();
		try {
			DocumentBuilderFactory personDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			personDocumentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder personDocumentBuilder = personDocumentBuilderFactory.newDocumentBuilder();
			Document personDocument = personDocumentBuilder.parse(personInputFileName);
			persons = new XMLDeserializer().xmlToPersonObject(personDocument);
		} catch (Exception e) {
			e.printStackTrace(); //Catches ParserConfigurationException, SAXException, IOException
		} 
		/*Tried to use JAXB parser but it was not brining the required output
		 * try {
			JAXBContext personXMLMapper = JAXBContext.newInstance(ArrayOfPerson.class);
			Unmarshaller personUnmarshaller = personXMLMapper.createUnmarshaller();
			person = (ArrayOfPerson)personUnmarshaller.unmarshal(new FileInputStream(personInputFileName));
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}*/
		return persons;
	}

	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#outputFileWriter(java.lang.String, java.util.List)
	 * No implementation is provided as we do not want to save in XML format
	 */
	@Override
	public void outputFileWriter(String personOutputFileName, List<Integer> comparedPersonObjectId) {
		// TODO Auto-generated method stub
	}
}
