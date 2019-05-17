import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CrewSelectionScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

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
		
		JLabel lblCrewMember1 = new JLabel("Crew Member 1");
		lblCrewMember1.setBounds(43, 500, 88, 28);
		window.getContentPane().add(lblCrewMember1);
		
		JLabel lblCrewSelection = new JLabel("Crew Selection");
		lblCrewSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewSelection.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblCrewSelection.setBounds(374, 20, 259, 70);
		window.getContentPane().add(lblCrewSelection);
		
		JButton btnNewButton = new JButton("Engineer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Engineer("Engineer"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnNewButton.setBounds(43, 161, 180, 55);
		window.getContentPane().add(btnNewButton);
		
		JButton btnScavenger = new JButton("Scavenger");
		btnScavenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Scavenger("Scavenger"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnScavenger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScavenger.setBounds(265, 161, 180, 55);
		window.getContentPane().add(btnScavenger);
		
		JButton btnRobot = new JButton("Robot");
		btnRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Robot("Robot"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRobot.setBounds(485, 161, 180, 55);
		window.getContentPane().add(btnRobot);
		
		JButton btnWorker = new JButton("Worker");
		btnWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Worker("Worker"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWorker.setBounds(43, 300, 180, 55);
		window.getContentPane().add(btnWorker);
		
		JButton btnSoldier = new JButton("Soldier");
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Soldier("Soldier"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnSoldier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSoldier.setBounds(265, 300, 180, 55);
		window.getContentPane().add(btnSoldier);
		
		JButton btnChungus = new JButton("Chungus");
		btnChungus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.getCrew().addCrewMember(new Chungus("Chungus"));
				ArrayList<CrewMember> crewMembersList = gameEnvironment.getCrew().getCrewMembers();
				lblCrewMember1.setText(gameEnvironment.getCrew().getCrewMembers().get(crewMembersList.size() - 1).getName());
			}
		});
		btnChungus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChungus.setBounds(485, 300, 180, 55);
		window.getContentPane().add(btnChungus);
		
		JLabel lblSkilledAtSearching = new JLabel("<html>Skilled at searching<br>planets</html>");
		lblSkilledAtSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkilledAtSearching.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkilledAtSearching.setBounds(265, 226, 176, 46);
		window.getContentPane().add(lblSkilledAtSearching);
		
		JLabel lblDoesntGetHungry = new JLabel("<html>Doesn't get hungry<br>and is plague immune</html>");
		lblDoesntGetHungry.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry.setBounds(485, 226, 193, 46);
		window.getContentPane().add(lblDoesntGetHungry);
		
		JLabel lblCanPerformAn = new JLabel("<html>Can perform an extra<br>action per day</html>");
		lblCanPerformAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanPerformAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCanPerformAn.setBounds(43, 365, 180, 46);
		window.getContentPane().add(lblCanPerformAn);
		
		JLabel lblDoesntGetHungry_1 = new JLabel("<html>Doesn't get hungry<br>or tired as easily</html>");
		lblDoesntGetHungry_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry_1.setBounds(265, 365, 176, 46);
		window.getContentPane().add(lblDoesntGetHungry_1);
		
		JLabel lblHasIncreasedHealth = new JLabel("<html>Has increased health</html>");
		lblHasIncreasedHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasIncreasedHealth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHasIncreasedHealth.setBounds(485, 365, 180, 46);
		window.getContentPane().add(lblHasIncreasedHealth);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchMainScreen();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(821, 530, 104, 46);
		window.getContentPane().add(btnNext);
		
		JLabel lblCurrentCrewMembers = new JLabel("Current Crew Members");
		lblCurrentCrewMembers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentCrewMembers.setBounds(43, 435, 305, 55);
		window.getContentPane().add(lblCurrentCrewMembers);
		
		JLabel lblShipName = new JLabel("shipName");
		lblShipName.setText(gameEnvironment.getShip().getName());
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShipName.setBounds(758, 141, 150, 40);
		window.getContentPane().add(lblShipName);
		
		JLabel lblCrewName = new JLabel("crewName");
		lblCrewName.setText(gameEnvironment.getCrew().getName());
		lblCrewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrewName.setBounds(758, 191, 150, 40);
		window.getContentPane().add(lblCrewName);
		
		JLabel lblNumOfDays = new JLabel("numOfDays");
		lblNumOfDays.setText(String.valueOf(gameEnvironment.getGameLength()));
		lblNumOfDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumOfDays.setBounds(768, 226, 121, 46);
		window.getContentPane().add(lblNumOfDays);
		
	}
}
