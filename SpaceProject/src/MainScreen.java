import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Create the application.
	 */
	public MainScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnVisitOutpost.setBounds(624, 47, 314, 53);
		window.getContentPane().add(btnVisitOutpost);
		
		JButton btnPilotShipTo = new JButton("Pilot Ship To New Planet");
		btnPilotShipTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPilotShipTo.setBounds(624, 110, 314, 53);
		window.getContentPane().add(btnPilotShipTo);
		
		JButton btnSearchPlanetFor = new JButton("Search Planet");
		btnSearchPlanetFor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchPlanetFor.setBounds(624, 173, 314, 53);
		window.getContentPane().add(btnSearchPlanetFor);
		
		JButton btnRepairShields = new JButton("Repair Shields");
		btnRepairShields.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRepairShields.setBounds(624, 236, 314, 53);
		window.getContentPane().add(btnRepairShields);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(26, 407, 267, 178);
		window.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMember1NameType = new JLabel("Name - Type");
		lblMember1NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember1NameType.setBounds(10, 10, 204, 25);
		panel.add(lblMember1NameType);
		
		JLabel lblMember1Health = new JLabel("Health");
		lblMember1Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Health.setBounds(10, 76, 138, 13);
		panel.add(lblMember1Health);
		
		JLabel lblMember1Tiredness = new JLabel("Tiredness\r\n");
		lblMember1Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Tiredness.setBounds(10, 120, 138, 13);
		panel.add(lblMember1Tiredness);
		
		JLabel lblMember1Hunger = new JLabel("Hunger");
		lblMember1Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Hunger.setBounds(10, 99, 138, 13);
		panel.add(lblMember1Hunger);
		
		JLabel lblMember1ActionsRemaining = new JLabel("Actions Remaining");
		lblMember1ActionsRemaining.setBounds(10, 41, 171, 13);
		panel.add(lblMember1ActionsRemaining);
		lblMember1ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		//PUT THIS IN A METHOD:
		CrewMember crewMember1 = gameEnvironment.getCrew().getCrewMembers().get(0);
		lblMember1NameType.setText(crewMember1.getName() + " - " + crewMember1.getType());
		lblMember1Health.setText("Health: " + String.valueOf(crewMember1.getHealth()));
		lblMember1Tiredness.setText("Tiredness: " + String.valueOf(crewMember1.getTiredness()));
		lblMember1Hunger.setText("Hunger: " + String.valueOf(crewMember1.getHunger()));
		lblMember1ActionsRemaining.setText("Actions remaining: " + String.valueOf(crewMember1.getAvailableActions()));
		
	}
}
