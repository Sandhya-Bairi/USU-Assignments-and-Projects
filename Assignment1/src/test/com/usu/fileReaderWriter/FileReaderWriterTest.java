package test.com.usu.fileReaderWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.usu.fileReaderWriter.FileReaderWriter;

public class FileReaderWriterTest {

	@Test
	public void testFileReader_InvalidFileFormat() {
		try {
			new FileReaderWriter("txt", 1);
		} catch (Exception e) {
			assertEquals("Invalid file format", e.getMessage());
		}
	}

	@Test
	public void testFileReaderWriter_InvalidFileName() {
		try {
			new FileReaderWriter("json", 2).fileReader("");
		} catch (Exception e) {
			assertEquals("Invalid file name or location", e.getMessage());
		}
	}
	
	@Test
	public void testFileReaderWriter_Correct() {
		try {
			assertNotNull(new FileReaderWriter("json", 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testComparePerson_Correct() {
		List<Integer> matchedPerson = null;
		try {
			matchedPerson = new FileReaderWriter("json", 5).fileReader("inputFiles\\json\\PersonTestSet_02.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(matchedPerson, is(Arrays.asList(2,2)));
	}
}
