import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrewSelectionScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private JLabel lblCrewMember1;
	private JLabel lblCrewMember2;
	private JLabel lblCrewMember3;
	private JLabel lblCrewMember4;
	private JLabel lblErrorText;
	private JButton btnRobot;
	private JButton btnScavenger;
	private JButton btnWorker;
	private JButton btnChungus;
	private JButton btnEngineer;
	private JButton btnSoldier;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CrewSelectionScreen window = new CrewSelectionScreen();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public CrewSelectionScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeCrewSelectionScreen(this);
	}
	
	public void addMemberToCrew(CrewMember crewMember) {
		int numMembers = gameEnvironment.getCrew().getCrewSize();
		
		if(crewMember.getName() != null && !crewMember.getName().isBlank()) {
		
			switch (numMembers) {
			
			
			case 0:
				lblCrewMember1.setText(crewMember.getName() + " : " + crewMember.getType());
				lblCrewMember1.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 1:
				lblCrewMember2.setText(crewMember.getName() + " : " + crewMember.getType());
				lblCrewMember2.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 2:
				lblCrewMember3.setText(crewMember.getName() + " : " + crewMember.getType());
				lblCrewMember3.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				break;
			case 3:
				lblCrewMember4.setText(crewMember.getName() + " : " + crewMember.getType());
				lblCrewMember4.setVisible(true);
				gameEnvironment.getCrew().addCrewMember(crewMember);
				btnChungus.setEnabled(false);
				btnEngineer.setEnabled(false);
				btnWorker.setEnabled(false);
				btnScavenger.setEnabled(false);
				btnSoldier.setEnabled(false);
				btnRobot.setEnabled(false);
				lblErrorText.setText("<html>Your crew is full<br>Press next to continue</html>");
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
		
		JLabel lblExperiencedWithReparing = new JLabel("<html>Experienced with<br>reparing shields</html>");
		lblExperiencedWithReparing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperiencedWithReparing.setHorizontalAlignment(SwingConstants.CENTER);
		lblExperiencedWithReparing.setBounds(43, 226, 180, 46);
		window.getContentPane().add(lblExperiencedWithReparing);
		
		lblCrewMember1 = new JLabel("Crew Member 1");
		lblCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrewMember1.setVisible(false);
		lblCrewMember1.setBounds(43, 488, 253, 40);
		window.getContentPane().add(lblCrewMember1);
		
		lblCrewMember2 = new JLabel("Crew Member 2");
		lblCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrewMember2.setVisible(false);
		lblCrewMember2.setBounds(43, 550, 253, 26);
		window.getContentPane().add(lblCrewMember2);
		
		lblCrewMember3 = new JLabel("Crew Member 3");
		lblCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrewMember3.setVisible(false);
		lblCrewMember3.setBounds(318, 496, 257, 32);
		window.getContentPane().add(lblCrewMember3);
		
		lblCrewMember4 = new JLabel("Crew Member 4");
		lblCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrewMember4.setVisible(false);
		lblCrewMember4.setBounds(318, 550, 257, 26);
		window.getContentPane().add(lblCrewMember4);
		
		JLabel lblCrewSelection = new JLabel("Crew Selection");
		lblCrewSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewSelection.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblCrewSelection.setBounds(374, 20, 259, 70);
		window.getContentPane().add(lblCrewSelection);
		
		btnEngineer = new JButton("Engineer");
		btnEngineer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEngineer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Engineer(name));
			}
		});
		btnEngineer.setBounds(43, 161, 180, 55);
		window.getContentPane().add(btnEngineer);
		
		btnScavenger = new JButton("Scavenger");
		btnScavenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Scavenger(name));
				
			}
		});
		btnScavenger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScavenger.setBounds(395, 161, 180, 55);
		window.getContentPane().add(btnScavenger);
		
		btnRobot = new JButton("Robot");
		btnRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Robot(name));
			}
		});
		btnRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRobot.setBounds(732, 161, 180, 55);
		window.getContentPane().add(btnRobot);
		
		btnWorker = new JButton("Worker");
		btnWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Worker(name));
			}
		});
		btnWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWorker.setBounds(43, 300, 180, 55);
		window.getContentPane().add(btnWorker);
		
		btnSoldier = new JButton("Soldier");
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Soldier(name));

			}
		});
		btnSoldier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSoldier.setBounds(395, 300, 180, 55);
		window.getContentPane().add(btnSoldier);
		
	
		
		btnChungus = new JButton("Chungus");
		btnChungus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a name for the crew member");
				addMemberToCrew(new Chungus(name));
			}
		});
		btnChungus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChungus.setBounds(732, 300, 180, 55);
		window.getContentPane().add(btnChungus);
		
		JLabel lblSkilledAtSearching = new JLabel("<html>Skilled at searching<br>planets</html>");
		lblSkilledAtSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkilledAtSearching.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkilledAtSearching.setBounds(395, 226, 176, 46);
		window.getContentPane().add(lblSkilledAtSearching);
		
		JLabel lblDoesntGetHungry = new JLabel("<html>Doesn't get hungry<br>and is plague immune</html>");
		lblDoesntGetHungry.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry.setBounds(732, 226, 193, 46);
		window.getContentPane().add(lblDoesntGetHungry);
		
		JLabel lblCanPerformAn = new JLabel("<html>Can perform an extra<br>action per day</html>");
		lblCanPerformAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanPerformAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCanPerformAn.setBounds(43, 365, 180, 46);
		window.getContentPane().add(lblCanPerformAn);
		
		JLabel lblDoesntGetHungry_1 = new JLabel("<html>Doesn't get hungry<br>or tired as easily</html>");
		lblDoesntGetHungry_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry_1.setBounds(395, 365, 176, 46);
		window.getContentPane().add(lblDoesntGetHungry_1);
		
		JLabel lblHasIncreasedHealth = new JLabel("<html>Has increased health</html>");
		lblHasIncreasedHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasIncreasedHealth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHasIncreasedHealth.setBounds(732, 365, 180, 46);
		window.getContentPane().add(lblHasIncreasedHealth);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameEnvironment.getCrew().getCrewSize() < 2) {
					lblErrorText.setText("<html>You must select at least 2<br>crewmembers before continuing!</html>");
				}
				else {
					closeWindow();
					gameEnvironment.launchMainScreen();
				}
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(821, 530, 104, 46);
		window.getContentPane().add(btnNext);
		
		JLabel lblCurrentCrewMembers = new JLabel("Current Crew Members");
		lblCurrentCrewMembers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentCrewMembers.setBounds(43, 435, 305, 55);
		window.getContentPane().add(lblCurrentCrewMembers);
		
		lblErrorText = new JLabel(" ");
		lblErrorText.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorText.setForeground(Color.RED);
		lblErrorText.setBounds(572, 490, 127, 86);
		window.getContentPane().add(lblErrorText);
		
		JLabel lblNewLabel = new JLabel("Select the crew members you would like to take on your adventure. Choose between 2 to 4 members by clicking on the buttons below.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(43, 74, 933, 70);
		window.getContentPane().add(lblNewLabel);
		
		
	}
}
