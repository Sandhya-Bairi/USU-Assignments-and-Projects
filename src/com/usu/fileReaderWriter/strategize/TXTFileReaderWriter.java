package com.usu.fileReaderWriter.strategize;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.usu.person.Person;

public class TXTFileReaderWriter extends FileReaderWriterStrategy{

	@Override
	public List<Person> inputFileReader(String personInputFileName) {
		return null;
	}

	@Override
	public List<Person> outputFileWriter() {
		Path personOutputFilePath = Paths.get("outputFiles\\the-file-name.txt");
		try {
			Files.write(personOutputFilePath, Arrays.asList(""), Charset.forName("UTF-8"));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return null;
	}

}
