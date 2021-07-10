package animalGame2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Zakir Muhammad
June 14, 2021
Imports all of the required data from text files
 */

public class Read {
	private static Scanner a, b, c;
	public static String animalsList, questionsList;
	public static String[] animals, questions;
	public static String[][] answers;

	public Read() throws IOException{
		a = new Scanner (new File("animals.txt"));
		b = new Scanner (new File("questions.txt"));
		c = new Scanner (new File("answers.txt"));

		//placing the data into their respective arrays
		animalsList = a.nextLine();
		animals = animalsList.split("\\*");
		questionsList = b.nextLine();
		questions = questionsList.split("\\*");
		answers = new String [questions.length][animals.length];

		//initialising the 2D array to store answers to each question for each animal
		for(int col = 0; col < animals.length; col++){ 
			String line = c.nextLine();

			for(int row = 0; row < questions.length; row++)
				answers[row][col] = line.split(" ")[row];
		}
	}
}