package com.usu.fileReaderWriter.strategize;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.usu.person.Person;

/**
 * @author anujk
 * This is a strategy implementor class for txt file format
 *
 */
public class TXTFileReaderWriter extends FileReaderWriterStrategy{

	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#inputFileReader(java.lang.String)
	 * No implementation is provided as we do not want to parse in Text format
	 */
	@Override
	public List<Person> inputFileReader(String personInputFileName) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.usu.fileReaderWriter.strategize.FileReaderWriterStrategy#outputFileWriter(java.lang.String, java.util.List)
	 * This method provides the implementation for text file writing
	 */
	@Override
	public void outputFileWriter(String personOutputFileName, List<Integer> comparedPersonObjectId) {
		try {
			FileWriter personOutputFileWriter = new FileWriter("outputFiles\\"+personOutputFileName);
		
			for(int i = 0; i < comparedPersonObjectId.size(); i+=2) {
				personOutputFileWriter.write(comparedPersonObjectId.get(i) + "," + comparedPersonObjectId.get(i+1));	
			}
			personOutputFileWriter.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
