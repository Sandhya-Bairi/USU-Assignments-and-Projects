package com.usu.fileReaderWriter;

import java.util.List;
import java.util.Scanner;

/**
 * @author anujk
 *This is a main class from which the program execution will start and this class will call the file reader logic
 */
public class PersonObjectReaderWriter {
	/**
	 * @param args
	 * This is the main method from which execution starts. This method will take input and output file names as inputs 
	 * from users and calls file read and write methods. User is also asked to enter file formats and select the 
	 * comparison of his choice
	 * 
	 * return
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String personInputFileName = null;
		
		System.out.println("Enter input file type:");
		String personInputFileType = new Scanner(System.in).nextLine();//This line will take user input

		System.out.println("Please enter input file name:");
		personInputFileName = new Scanner(System.in).nextLine();//This line will take user input
		
		System.out.println("Enter output file type:");
		String personOutputFileType = new Scanner(System.in).nextLine();//This line will take user input
		
		System.out.println("Please enter output file name:");
		String personOutputFileName = new Scanner(System.in).nextLine();//This line will take user input
		
		System.out.println("1. Compare person on the basis of either State File Number/Social Security Number/New born Screen Number with Birth Details");
		System.out.println("2. Compare person on the basis of either State File Number/Social Security Number/New born Screen Number with two or more name fields\n3. Compare person on the basis of Name, Gender and Birth Details");
		System.out.println("4. Compare person on the basis of Social Security Number and name fields\n5. Compare person on the basis of Name and Birth Details");
		System.out.println("Please enter any one comparison to compare persons from above options:");
		int personCompareCriteria = new Scanner(System.in).nextInt();
		
		try {
			List<Integer> comparedPersonObjectId =  new FileReaderWriter(personInputFileType, personCompareCriteria).fileReader(personInputFileName);
			new FileReaderWriter(personOutputFileType).fileWriter(personOutputFileName, comparedPersonObjectId);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}