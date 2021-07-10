package animalGame2;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;

/*
Zakir Muhammad
June 14, 2021
Asks all of the questions and makes a guess
 */

public class Ask {
	public static String[] replies;
	public static int predictionIndex, correct;

	public Ask() throws Exception {
		replies = new String [Read.questions.length];
		JOptionPane.showMessageDialog(null, "Press OK once you have chosen your animal.");
		predictionIndex = qs();

		//image to display on the dialog box for guessing an animal
		ImageIcon emoji = new ImageIcon("HappyEmoji.png");
		Image emojiResize = emoji.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH );
		emoji = new ImageIcon(emojiResize);

		//asking if guess is correct and acting accordingly
		correct = JOptionPane.showOptionDialog(null, "Is the animal " + Read.animals[predictionIndex] + "?", "Guess", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, emoji, null, null);

		if(correct == 0)
			JOptionPane.showMessageDialog(null, "Thank you for playing!");

		else {
			Learn three = new Learn();
		}
	}

	//Asks the questions, stores replies, and returns a guess
	//Post: maxIndex is the index of the animal the has the most matches with the answers that the user gave
	public static int qs() {
		String prediction = null;
		int[] similar = new int [Read.animals.length];

		//asking questions
		for(int i = 0; i < Read.questions.length; i++){
			int replyInt = JOptionPane.showOptionDialog(null, Read.questions[i], "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(replyInt == 0) replies[i] = "y";
			else replies[i] = "n";
		}

		//checks which animal's answers the replies match best
		for(int col = 0; col < Read.animals.length; col++){
			for(int row = 0; row < Read.questions.length; row++){

				if(replies[row].contains(Read.answers[row][col]))
					similar[col]++;
			}
		}

		//finds which animal the answers best match to
		int max = similar[0];
		int maxIndex = 0; 

		for(int i = 1; i < similar.length; i++){
			if(similar[i] > max){
				max = similar[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}