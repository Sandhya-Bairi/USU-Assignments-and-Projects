package com.usu.fileReaderWriter;

import java.util.Scanner;

/**
 * @author anujk
 *This is a main class from which the program execution will start and this class will call the file reader logic
 */
public class PersonObjectReaderWriter {
	/**
	 * @param args
	 * This is the main method from which execution starts. This method will take input and output file names as inputs 
	 * from users and calls file read and write methods.
	 * 
	 * return
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String personInputFileName = null;
		
		System.out.println("Enter file type:");
		String personFileType = new Scanner(System.in).nextLine();//This line will take user input
		System.out.println("Please enter input file name:");
		personInputFileName = new Scanner(System.in).nextLine();//This line will take user input
		/*System.out.println("Please enter output file name:");
		String personOutputFileName = new Scanner(System.in).nextLine();//This line will take user input
*/		new FileReaderWriter(personFileType, personInputFileName).fileReader(personInputFileName);
	}
}