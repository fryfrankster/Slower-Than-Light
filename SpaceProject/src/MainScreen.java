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
		
		JPanel member1Panel = new JPanel();
		member1Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member1Panel.setBounds(10, 424, 229, 178);
		window.getContentPane().add(member1Panel);
		member1Panel.setLayout(null);
		
		JLabel lblMember1NameType = new JLabel("Name - Type");
		lblMember1NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember1NameType.setBounds(10, 10, 209, 25);
		member1Panel.add(lblMember1NameType);
		
		JLabel lblMember1Health = new JLabel("Health");
		lblMember1Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Health.setBounds(10, 76, 138, 13);
		member1Panel.add(lblMember1Health);
		
		JLabel lblMember1Tiredness = new JLabel("Tiredness\r\n");
		lblMember1Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Tiredness.setBounds(10, 120, 138, 13);
		member1Panel.add(lblMember1Tiredness);
		
		JLabel lblMember1Hunger = new JLabel("Hunger");
		lblMember1Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Hunger.setBounds(10, 99, 138, 13);
		member1Panel.add(lblMember1Hunger);
		
		JLabel lblMember1ActionsRemaining = new JLabel("Actions Remaining");
		lblMember1ActionsRemaining.setBounds(10, 41, 171, 13);
		member1Panel.add(lblMember1ActionsRemaining);
		lblMember1ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		
		JPanel member2Panel = new JPanel();
		member2Panel.setLayout(null);
		member2Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member2Panel.setBounds(256, 424, 229, 178);
		window.getContentPane().add(member2Panel);
		
		JLabel lblMember2NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember2NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember2NameType.setBounds(10, 10, 209, 25);
		member2Panel.add(lblMember2NameType);
		
		JLabel lblMember2Health = new JLabel("Health: 0");
		lblMember2Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Health.setBounds(10, 76, 138, 13);
		member2Panel.add(lblMember2Health);
		
		JLabel lblMember2Tiredness = new JLabel("Tiredness: 0");
		lblMember2Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Tiredness.setBounds(10, 120, 138, 13);
		member2Panel.add(lblMember2Tiredness);
		
		JLabel lblMember2Hunger = new JLabel("Hunger: 0");
		lblMember2Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Hunger.setBounds(10, 99, 138, 13);
		member2Panel.add(lblMember2Hunger);
		
		JLabel lblMember2ActionsRemaining = new JLabel("Actions remaining: 0");
		lblMember2ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblMember2ActionsRemaining.setBounds(10, 41, 171, 13);
		member2Panel.add(lblMember2ActionsRemaining);
		
		//PUT THIS IN A METHOD:
		CrewMember crewMember1 = gameEnvironment.getCrew().getCrewMembers().get(0);
		lblMember1NameType.setText(crewMember1.getName() + " - " + crewMember1.getType());
		lblMember1Health.setText("Health: " + String.valueOf(crewMember1.getHealth()) + "/" + crewMember1.getMaxHealth());
		lblMember1Tiredness.setText("Tiredness: " + String.valueOf(crewMember1.getTiredness()) + "/" + crewMember1.getMaxTiredness());
		lblMember1Hunger.setText("Hunger: " + String.valueOf(crewMember1.getHunger()) + "/" + crewMember1.getMaxHunger());
		lblMember1ActionsRemaining.setText("Actions remaining: " + String.valueOf(crewMember1.getAvailableActions()));
		
		
		CrewMember crewMember2 = gameEnvironment.getCrew().getCrewMembers().get(1);
		lblMember2NameType.setText(crewMember2.getName() + " - " + crewMember2.getType());
		lblMember2Health.setText("Health: " + String.valueOf(crewMember2.getHealth()) + "/" + crewMember2.getMaxHealth());
		lblMember2Tiredness.setText("Tiredness: " + String.valueOf(crewMember2.getTiredness()) + "/" + crewMember2.getMaxTiredness());
		lblMember2Hunger.setText("Hunger: " + String.valueOf(crewMember2.getHunger()) + "/" + crewMember2.getMaxHunger());
		lblMember2ActionsRemaining.setText("Actions remaining: " + String.valueOf(crewMember2.getAvailableActions()));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(508, 424, 229, 178);
		window.getContentPane().add(panel_2);
		
		JLabel label_5 = new JLabel("<dynamic> - <dynamic>");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(10, 10, 209, 25);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Health: 0");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(10, 76, 138, 13);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Tiredness: 0");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(10, 120, 138, 13);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Hunger: 0");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(10, 99, 138, 13);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Actions remaining: 0");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 13));
		label_9.setBounds(10, 41, 171, 13);
		panel_2.add(label_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_3.setBounds(747, 424, 229, 178);
		window.getContentPane().add(panel_3);
		
		JLabel label_10 = new JLabel("<dynamic> - <dynamic>");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_10.setBounds(10, 10, 209, 25);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Health: 0");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_11.setBounds(10, 76, 138, 13);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Tiredness: 0");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_12.setBounds(10, 120, 138, 13);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("Hunger: 0");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_13.setBounds(10, 99, 138, 13);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Actions remaining: 0");
		label_14.setFont(new Font("Tahoma", Font.ITALIC, 13));
		label_14.setBounds(10, 41, 171, 13);
		panel_3.add(label_14);
		
		JLabel lblCrewMembers = new JLabel("Crew Members");
		lblCrewMembers.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrewMembers.setBounds(10, 385, 229, 28);
		window.getContentPane().add(lblCrewMembers);
		
	}
}
