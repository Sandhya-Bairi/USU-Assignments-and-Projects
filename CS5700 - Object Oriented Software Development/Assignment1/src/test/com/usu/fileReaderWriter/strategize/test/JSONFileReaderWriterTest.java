package test.com.usu.fileReaderWriter.strategize.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.usu.fileReaderWriter.strategize.JSONFileReaderWriterStrategy;
import com.usu.person.Person;

public class JSONFileReaderWriterTest {

	@Test
	public void testInputFileReader_Empty() {
		JSONFileReaderWriterStrategy jsonFileReaderWriterStrategy = new JSONFileReaderWriterStrategy();
		List<Person> testPersons = jsonFileReaderWriterStrategy.inputFileReader("inputFiles\\json\\PersonTestSet_06.json");
		assertTrue(testPersons.isEmpty());
	}
	
	@Test
	public void testInputFileReader_Correct() {
		JSONFileReaderWriterStrategy jsonFileReaderWriterStrategy = new JSONFileReaderWriterStrategy();
		List<Person> testPersons = jsonFileReaderWriterStrategy.inputFileReader("inputFiles\\json\\PersonTestSet_03.json");
		assertTrue(testPersons.size() > 1);
	}
}