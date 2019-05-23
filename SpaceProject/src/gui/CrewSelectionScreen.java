package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import main.CrewMember;
import main.GameEnvironment;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import main.Chungus;
import main.Scavenger;
import main.Soldier;
import main.Worker;
import main.Engineer;
import main.Robot;
import javax.swing.ImageIcon;

/**
 *Screen allowing the user to choose their crew
 */
public class CrewSelectionScreen {

	/** The window holding contents displayed to the user */
	private JFrame window;
	
	/**Used to access all game logic so buttons can effect game*/
	private GameEnvironment gameEnvironment;
	
	/** Shows the name and type of crew member 1*/
	private JLabel lblCrewMember1;
	
	/** Shows the name and type of crew member 2*/
	private JLabel lblCrewMember2;
	
	/** Shows the name and type of crew member 3*/
	private JLabel lblCrewMember3;
	
	/** Shows the name and type of crew member 4*/
	private JLabel lblCrewMember4;
	
	/** Label storing an error message that shows if user inputs something invalid*/
	private JLabel lblErrorText;
	
	/**Adds a crew member of type robot to the players crew */
	private JButton btnRobot;
	
	/**Adds a crew member of type scavenger to the players crew */
	private JButton btnScavenger;
	
	/**Adds a crew member of type worker to the players crew */
	private JButton btnWorker;
	
	/**Adds a crew member of type chungus to the players crew */
	private JButton btnChungus;
	
	/**Adds a crew member of type engineer to the players crew */
	private JButton btnEngineer;
	
	/**Adds a crew member of type Soldier to the players crew */
	private JButton btnSoldier;
	
	/** Holds the background image of the screen */
	private JLabel lblBackground;

	/**
	 * Creates the Crew Selection screen screen
	 * @param incomingGameEnvironment the game environment the screen is getting information from
	 */
	public CrewSelectionScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	/**
	 * Closes the Crew Selection screen
	 */
	public void closeWindow() {
		window.dispose();
	}
	
	/**
	 * Closes the Crew Selection screen
	 */
	public void finishedWindow() {
		gameEnvironment.closeCrewSelectionScreen(this);
	}
	
	/**
	 * Adds the given crew member to the crew if they are given a name that isn't empty 
	 * Displays that crew member in a list at the bottom
	 * @param crewMember the CrewMember to be added to the crew
	 */
	public void addMemberToCrew(CrewMember crewMember) {
		int numMembers = gameEnvironment.getCrew().getCrewSize();
		
		if(crewMember.getName() != null && !crewMember.getName().isBlank()) {
		
			switch (numMembers) {
			
			
			case 0:
				lblCrewMember1.setText("<html>" + crewMember.getName() + " : " + crewMember.getType() + "</html>");
				lblCrewMember1.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 1:
				lblCrewMember2.setText("<html>" + crewMember.getName() + " : " + crewMember.getType() + "</html>");
				lblCrewMember2.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 2:
				lblCrewMember3.setText("<html>" + crewMember.getName() + " : " + crewMember.getType() + "</html>");
				lblCrewMember3.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 3:
				lblCrewMember4.setText("<html>" + crewMember.getName() + " : " + crewMember.getType() + "</html>");
				lblCrewMember4.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				btnChungus.setEnabled(false);
				btnEngineer.setEnabled(false);
				btnWorker.setEnabled(false);
				btnScavenger.setEnabled(false);
				btnSoldier.setEnabled(false);
				btnRobot.setEnabled(false);
				lblErrorText.setText("<html><center>Your crew is full<br>Press next to continue</center></html>");
				break;
				
			}
		}
		
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		lblCrewMember1 = new JLabel("Crew Member 1");
		lblCrewMember1.setForeground(Color.WHITE);
		lblCrewMember1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCrewMember1.setVisible(false);
		lblCrewMember1.setBounds(43, 463, 253, 60);
		window.getContentPane().add(lblCrewMember1);
		
		lblCrewMember2 = new JLabel("Crew Member 2");
		lblCrewMember2.setForeground(Color.WHITE);
		lblCrewMember2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCrewMember2.setVisible(false);
		lblCrewMember2.setBounds(43, 534, 253, 56);
		window.getContentPane().add(lblCrewMember2);
		
		lblCrewMember3 = new JLabel("Crew Member 3");
		lblCrewMember3.setForeground(Color.WHITE);
		lblCrewMember3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCrewMember3.setVisible(false);
		lblCrewMember3.setBounds(318, 471, 257, 52);
		window.getContentPane().add(lblCrewMember3);
		
		lblCrewMember4 = new JLabel("Crew Member 4");
		lblCrewMember4.setForeground(Color.WHITE);
		lblCrewMember4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCrewMember4.setVisible(false);
		lblCrewMember4.setBounds(318, 534, 257, 56);
		window.getContentPane().add(lblCrewMember4);
		
		JLabel lblCrewSelection = new JLabel("Crew Selection");
		lblCrewSelection.setForeground(Color.WHITE);
		lblCrewSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewSelection.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblCrewSelection.setBounds(43, 10, 903, 70);
		window.getContentPane().add(lblCrewSelection);
		
		btnEngineer = new JButton("Engineer");
		btnEngineer.setBackground(Color.WHITE);
		btnEngineer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEngineer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Engineer(name));
			}
		});
		btnEngineer.setBounds(43, 161, 253, 55);
		window.getContentPane().add(btnEngineer);
		
		btnScavenger = new JButton("Scavenger");
		btnScavenger.setBackground(Color.WHITE);
		btnScavenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Scavenger(name));
				
			}
		});
		btnScavenger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScavenger.setBounds(353, 161, 264, 55);
		window.getContentPane().add(btnScavenger);
		
		btnRobot = new JButton("Robot");
		btnRobot.setBackground(Color.WHITE);
		btnRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Robot(name));
			}
		});
		btnRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRobot.setBounds(670, 161, 276, 55);
		window.getContentPane().add(btnRobot);
		
		btnWorker = new JButton("Worker");
		btnWorker.setBackground(Color.WHITE);
		btnWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Worker(name));
			}
		});
		btnWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWorker.setBounds(43, 300, 253, 55);
		window.getContentPane().add(btnWorker);
		
		btnSoldier = new JButton("Soldier");
		btnSoldier.setBackground(Color.WHITE);
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Soldier(name));

			}
		});
		btnSoldier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSoldier.setBounds(353, 300, 264, 55);
		window.getContentPane().add(btnSoldier);
		
	
		
		btnChungus = new JButton("Chungus");
		btnChungus.setBackground(Color.WHITE);
		btnChungus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Chungus(name));
			}
		});
		btnChungus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChungus.setBounds(670, 300, 276, 55);
		window.getContentPane().add(btnChungus);
		
		JLabel lblExperiencedWithReparing = new JLabel("<html><center>Experienced with<br>reparing shields</center></html>");
		lblExperiencedWithReparing.setForeground(Color.WHITE);
		lblExperiencedWithReparing.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExperiencedWithReparing.setHorizontalAlignment(SwingConstants.CENTER);
		lblExperiencedWithReparing.setBounds(43, 226, 253, 46);
		window.getContentPane().add(lblExperiencedWithReparing);
		
		JLabel lblSkilledAtSearching = new JLabel("<html><center>Skilled at searching<br>planets</center></html>");
		lblSkilledAtSearching.setForeground(Color.WHITE);
		lblSkilledAtSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkilledAtSearching.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSkilledAtSearching.setBounds(353, 226, 264, 46);
		window.getContentPane().add(lblSkilledAtSearching);
		
		JLabel lblDoesntGetHungry = new JLabel("<html><center>Doesn't get hungry<br>and is plague immune</center></html>");
		lblDoesntGetHungry.setForeground(Color.WHITE);
		lblDoesntGetHungry.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoesntGetHungry.setBounds(670, 226, 276, 46);
		window.getContentPane().add(lblDoesntGetHungry);
		
		JLabel lblCanPerformAn = new JLabel("<html><center>Can perform an extra<br>action per day</center></html>");
		lblCanPerformAn.setForeground(Color.WHITE);
		lblCanPerformAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanPerformAn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCanPerformAn.setBounds(43, 365, 253, 46);
		window.getContentPane().add(lblCanPerformAn);
		
		JLabel lblDoesntGetHungry_1 = new JLabel("<html><center>Doesn't get hungry<br>or tired as easily</center></html>");
		lblDoesntGetHungry_1.setForeground(Color.WHITE);
		lblDoesntGetHungry_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoesntGetHungry_1.setBounds(353, 365, 264, 46);
		window.getContentPane().add(lblDoesntGetHungry_1);
		
		JLabel lblHasIncreasedHealth = new JLabel("<html><center>Has increased health</center></html>");
		lblHasIncreasedHealth.setForeground(Color.WHITE);
		lblHasIncreasedHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasIncreasedHealth.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHasIncreasedHealth.setBounds(670, 365, 276, 46);
		window.getContentPane().add(lblHasIncreasedHealth);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setBackground(Color.LIGHT_GRAY);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameEnvironment.getCrew().getCrewSize() < 2) {
					lblErrorText.setText("<html><center>You must select at least 2<br>crew members before continuing!</center></html>");
				}
				else {
					closeWindow();
					gameEnvironment.launchMainScreen();
				}
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(808, 530, 104, 46);
		window.getContentPane().add(btnNext);
		
		JLabel lblCurrentCrewMembers = new JLabel("Current Crew Members");
		lblCurrentCrewMembers.setForeground(Color.WHITE);
		lblCurrentCrewMembers.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCurrentCrewMembers.setBounds(42, 422, 305, 55);
		window.getContentPane().add(lblCurrentCrewMembers);
		
		lblErrorText = new JLabel(" ");
		lblErrorText.setVerticalAlignment(SwingConstants.BOTTOM);
		lblErrorText.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorText.setForeground(Color.RED);
		lblErrorText.setBounds(531, 463, 267, 113);
		window.getContentPane().add(lblErrorText);
		
		JLabel lblNewLabel = new JLabel("<html><center>Select the crew members you would like to take on your adventure.<br>Choose between 2 to 4 members by clicking on the buttons below.</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(43, 74, 892, 70);
		window.getContentPane().add(lblNewLabel);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/img/milky_way2.jpg")));
		lblBackground.setBounds(-19, 0, 1028, 613);
		window.getContentPane().add(lblBackground);
		
		
	}
}
