package animalGame2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
Zakir Muhammad
June 14, 2021
Exports the data back to the text files
 */

public class Write {
	private static PrintWriter a, b, c;

	public Write() throws IOException {
		a = new PrintWriter ("animals.txt");
		b = new PrintWriter ("questions.txt");
		c = new PrintWriter ("answers.txt");

		//output the animals
		a.print(Read.animalsList);
		a.print("*" + Learn.chosenAnimal);

		//output the answers
		for(int col = 0; col < Read.animals.length; col++){
			for(int row = 0; row < Read.questions.length; row++){
				c.print(Read.answers[row][col] + " ");

				if(col != Ask.predictionIndex)
					if(row == Read.questions.length-1)
						c.print("null ");

				if(row == Read.questions.length-1){
					if(col == Ask.predictionIndex)
						c.print(Learn.newAnswerPredict + " ");

					else
						c.print("null ");
				}
			}
			c.println();
		}

		//output the answers for the new animal
		for(int i = 0; i < Ask.replies.length; i++){
			c.print(Ask.replies[i] + " ");
		}
		c.print(Learn.newAnswerChosen);

		//output questions
		b.print(Read.questionsList + "*" + Learn.newQuestion);

		a.close();
		b.close();
		c.close();
	}

	//Only exports the answers back to their text file
	public static void answersOnly() throws IOException {
		c = new PrintWriter ("answers.txt");

		for(int col = 0; col < Read.animals.length; col++){
			for(int row = 0; row < Read.questions.length; row++){
				c.print(Read.answers[row][col] + " ");
			}
			c.println();
		}
		c.close();
	}
}