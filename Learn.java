package animalGame2;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
Zakir Muhammad
June 14, 2021
Updates data and takes steps to guess the chosen animal next time
 */

public class Learn {
	public static String chosenAnimal, newQuestion, newAnswerPredict, newAnswerChosen;

	public Learn() throws IOException {
		chosenAnimal = JOptionPane.showInputDialog("What was the animal?");

		//if the animal was in the animals.txt file but the answers to the new questions for that animal were not stored
		if(Read.animalsList.contains(chosenAnimal)) scenario1();
		//if the animal was not in the animals.txt file
		else scenario2();
	}

	//Updates the chosen animal's answers
	public static void scenario1() throws IOException {

		JOptionPane.showMessageDialog(null, "Sorry, I guessed wrong. I will know " + chosenAnimal + " next time!");

		//Finds the index of the animal the user chose
		int chosenAnimalIndex = 0;
		for(int i = 0; i < Read.animals.length; i++)
			if(Read.animals[i].equalsIgnoreCase(chosenAnimal))
				chosenAnimalIndex = i;

		//Updated the answers to the questions for that animal
		for(int i = 0; i < Read.questions.length; i++)
			Read.answers[i][chosenAnimalIndex] = Ask.replies[i];

		Write.answersOnly();
	}

	//Creates new question to improve program
	public static void scenario2() throws IOException {

		//asks user to create a new question
		do {
			newQuestion = JOptionPane.showInputDialog("Please create a question that can help me differentiate between " 
					+ chosenAnimal + " and " + Read.animals[Ask.predictionIndex] + ".");
		} while(Read.questionsList.contains(newQuestion));

		//stores the answer to the new question for the chosen and guessed animals
		int newAnswerChosenInt = JOptionPane.showOptionDialog(null, "What is the answer to that question for " + chosenAnimal + "?", "Help", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		JOptionPane.showMessageDialog(null, "Thank you for helping!");

		if(newAnswerChosenInt == 0) {
			newAnswerChosen = "y";
			newAnswerPredict = "n";
		}

		else {
			newAnswerChosen = "n";
			newAnswerPredict = "y";
		}

		Write four = new Write();
	}
}