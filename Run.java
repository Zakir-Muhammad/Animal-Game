package animalGame2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;

/*
Zakir Muhammad
June 14, 2021
Main class which creates GUI and starts off the program
 */

public class Run extends JFrame implements ActionListener {
	public static void main (String[] args) throws Exception {
		Run gui = new Run();
	}

	JPanel panel = new JPanel();
	JLabel title = new JLabel("Animal Game 2.0");

	//icon image for the JFrame
	ImageIcon icon = new ImageIcon("AnimalPawprint.png");
	//image displayed on the menu screen
	ImageIcon animalsImg = new ImageIcon("Animals.png");
	JLabel animalsLbl = new JLabel(animalsImg);

	JButton start = new JButton("Start");
	JButton instructions = new JButton ("Instructions");

	public Run() throws Exception {
		//JFrame setup
		super("Animal Game 2.0");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		panel.setBackground(new Color(130, 190, 255));
		panel.setLayout(new MigLayout("al center"));
		setIconImage(icon.getImage());

		//setting up the title and background colour
		title.setFont(new Font("Jokerman", Font.PLAIN, 70));
		start.setBackground(new Color(252, 186, 3));
		instructions.setBackground(new Color(252, 186, 3));

		//adding the components with MiG layout commands
		add(panel);
		panel.add(title, "wrap");
		panel.add(animalsLbl, "align center, wrap");
		panel.add(start, "align center, h 60, w 120, wrap");
		panel.add(instructions, "align center, h 60, w 120");

		//adding ActionListener to the two buttons
		start.addActionListener(this);
		instructions.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed (ActionEvent event) {
		//if the Instructions button is clicked
		if(event.getSource() == instructions) {
			JOptionPane.showMessageDialog(null, "WELCOME TO ANIMAL GAME\r\n"
					+ "\r\n"
					+ "1. In this game you will pick an animal.\r\n"
					+ "2. The computer will try to guess the animal you have picked.\r\n"
					+ "3. The computer will ask you yes or no questions.\r\n"
					+ "4. You will reply with yes or no.\r\n"
					+ "5. At the end, the computer will make its guess!");
		}

		//if the Start button is clicked
		if(event.getSource() == start) {
			try {
				Read one = new Read();
				Ask two = new Ask();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}