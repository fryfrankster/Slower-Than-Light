import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	
	private JLabel lblMember1NameType;
	private JLabel lblMember1Health;
	private JLabel lblMember1Tiredness;
	private JLabel lblMember1Hunger;
	private JLabel lblMember1ActionsRemaining;
	
	private JLabel lblMember2NameType;
	private JLabel lblMember2Health;
	private JLabel lblMember2Tiredness;
	private JLabel lblMember2Hunger;
	private JLabel lblMember2ActionsRemaining;
	
	private JLabel lblMember3NameType;
	private JLabel lblMember3Health;
	private JLabel lblMember3Tiredness;
	private JLabel lblMember3Hunger;
	private JLabel lblMember3ActionsRemaining;
	
	private JLabel lblMember4NameType;
	private JLabel lblMember4Health;
	private JLabel lblMember4Tiredness;
	private JLabel lblMember4Hunger;
	private JLabel lblMember4ActionsRemaining;
	
	private JPanel member1Panel;
	private JPanel member2Panel;
	private JPanel member3Panel;
	private JPanel member4Panel;

	


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
	 * Updates a crews information on the panel
	 */
	private void upDateInfoPanel(CrewMember crewMember, JLabel nameType, JLabel health, JLabel tiredness, JLabel hunger, JLabel actions) {
	    nameType.setText(crewMember.getName() + " - " + crewMember.getType());
		health.setText("Health: " + String.valueOf(crewMember.getHealth()) + "/" + crewMember.getMaxHealth());
		tiredness.setText("Tiredness: " + String.valueOf(crewMember.getTiredness()) + "/" + crewMember.getMaxTiredness());
		hunger.setText("Hunger: " + String.valueOf(crewMember.getHunger()) + "/" + crewMember.getMaxHunger());
		actions.setText("Actions remaining: " + String.valueOf(crewMember.getAvailableActions()));
	}
	
	private void updateAllInfoPanels() {
		member1Panel.setVisible(false);
		member2Panel.setVisible(false);
		member3Panel.setVisible(false);
		member4Panel.setVisible(false);
		
		int crewSize = gameEnvironment.getCrew().getCrewSize();
		switch (crewSize) {
			case 4:
				member4Panel.setVisible(true);
				CrewMember crewMember4 = gameEnvironment.getCrew().getCrewMembers().get(3);
				upDateInfoPanel(crewMember4, lblMember4NameType, lblMember4Health, lblMember4Tiredness, lblMember4Hunger, lblMember4ActionsRemaining);
				
			case 3:
				member3Panel.setVisible(true);
				CrewMember crewMember3 = gameEnvironment.getCrew().getCrewMembers().get(2);
				upDateInfoPanel(crewMember3, lblMember3NameType, lblMember3Health, lblMember3Tiredness, lblMember3Hunger, lblMember3ActionsRemaining);
			
			case 2:
				member2Panel.setVisible(true);
				CrewMember crewMember2 = gameEnvironment.getCrew().getCrewMembers().get(1);
				upDateInfoPanel(crewMember2, lblMember2NameType, lblMember2Health, lblMember2Tiredness, lblMember2Hunger, lblMember2ActionsRemaining);
				
			case 1:
				member1Panel.setVisible(true);
				CrewMember crewMember1 = gameEnvironment.getCrew().getCrewMembers().get(0);
				upDateInfoPanel(crewMember1, lblMember1NameType, lblMember1Health, lblMember1Tiredness, lblMember1Hunger, lblMember1ActionsRemaining);
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
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnVisitOutpost.setBounds(662, 47, 314, 53);
		window.getContentPane().add(btnVisitOutpost);
		
		JButton btnPilotShipTo = new JButton("Pilot Ship To New Planet");
		btnPilotShipTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPilotShipTo.setBounds(662, 110, 314, 53);
		window.getContentPane().add(btnPilotShipTo);
		
		JButton btnSearchPlanetFor = new JButton("Search Planet");
		btnSearchPlanetFor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchPlanetFor.setBounds(662, 173, 314, 53);
		window.getContentPane().add(btnSearchPlanetFor);
		
		JButton btnRepairShields = new JButton("Repair Shields");
		btnRepairShields.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRepairShields.setBounds(662, 236, 314, 53);
		window.getContentPane().add(btnRepairShields);
		
		member1Panel = new JPanel();
		member1Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member1Panel.setBounds(10, 424, 229, 178);
		window.getContentPane().add(member1Panel);
		member1Panel.setLayout(null);
		
		lblMember1NameType = new JLabel("Name - Type");
		lblMember1NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember1NameType.setBounds(10, 10, 209, 25);
		member1Panel.add(lblMember1NameType);
		
		lblMember1Health = new JLabel("Health");
		lblMember1Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Health.setBounds(10, 76, 138, 13);
		member1Panel.add(lblMember1Health);
		
		lblMember1Tiredness = new JLabel("Tiredness\r\n");
		lblMember1Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Tiredness.setBounds(10, 120, 138, 13);
		member1Panel.add(lblMember1Tiredness);
		
		lblMember1Hunger = new JLabel("Hunger");
		lblMember1Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember1Hunger.setBounds(10, 99, 138, 13);
		member1Panel.add(lblMember1Hunger);
		
		lblMember1ActionsRemaining = new JLabel("Actions Remaining");
		lblMember1ActionsRemaining.setBounds(10, 41, 171, 13);
		member1Panel.add(lblMember1ActionsRemaining);
		lblMember1ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		
		member2Panel = new JPanel();
		member2Panel.setLayout(null);
		member2Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member2Panel.setBounds(256, 424, 229, 178);
		window.getContentPane().add(member2Panel);
		
		lblMember2NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember2NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember2NameType.setBounds(10, 10, 209, 25);
		member2Panel.add(lblMember2NameType);
		
		lblMember2Health = new JLabel("Health: 0");
		lblMember2Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Health.setBounds(10, 76, 138, 13);
		member2Panel.add(lblMember2Health);
		
		lblMember2Tiredness = new JLabel("Tiredness: 0");
		lblMember2Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Tiredness.setBounds(10, 120, 138, 13);
		member2Panel.add(lblMember2Tiredness);
		
		lblMember2Hunger = new JLabel("Hunger: 0");
		lblMember2Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Hunger.setBounds(10, 99, 138, 13);
		member2Panel.add(lblMember2Hunger);
		
		lblMember2ActionsRemaining = new JLabel("Actions remaining: 0");
		lblMember2ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblMember2ActionsRemaining.setBounds(10, 41, 171, 13);
		member2Panel.add(lblMember2ActionsRemaining);
		
		member3Panel = new JPanel();
		member3Panel.setLayout(null);
		member3Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member3Panel.setBounds(508, 424, 229, 178);
		window.getContentPane().add(member3Panel);
		
		lblMember3NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember3NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember3NameType.setBounds(10, 10, 209, 25);
		member3Panel.add(lblMember3NameType);
		
		lblMember3Health = new JLabel("Health: 0");
		lblMember3Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember3Health.setBounds(10, 76, 138, 13);
		member3Panel.add(lblMember3Health);
		
		lblMember3Tiredness = new JLabel("Tiredness: 0");
		lblMember3Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember3Tiredness.setBounds(10, 120, 138, 13);
		member3Panel.add(lblMember3Tiredness);
		
		lblMember3Hunger = new JLabel("Hunger: 0");
		lblMember3Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember3Hunger.setBounds(10, 99, 138, 13);
		member3Panel.add(lblMember3Hunger);
		
		lblMember3ActionsRemaining = new JLabel("Actions remaining: 0");
		lblMember3ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblMember3ActionsRemaining.setBounds(10, 41, 171, 13);
		member3Panel.add(lblMember3ActionsRemaining);
		
		member4Panel = new JPanel();
		member4Panel.setLayout(null);
		member4Panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		member4Panel.setBounds(747, 424, 229, 178);
		window.getContentPane().add(member4Panel);
		
		lblMember4NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember4NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember4NameType.setBounds(10, 10, 209, 25);
		member4Panel.add(lblMember4NameType);
		
		lblMember4Health = new JLabel("Health: 0");
		lblMember4Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember4Health.setBounds(10, 76, 138, 13);
		member4Panel.add(lblMember4Health);
		
		lblMember4Tiredness = new JLabel("Tiredness: 0");
		lblMember4Tiredness.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember4Tiredness.setBounds(10, 120, 138, 13);
		member4Panel.add(lblMember4Tiredness);
		
		lblMember4Hunger = new JLabel("Hunger: 0");
		lblMember4Hunger.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember4Hunger.setBounds(10, 99, 138, 13);
		member4Panel.add(lblMember4Hunger);
		
		lblMember4ActionsRemaining = new JLabel("Actions remaining: 0");
		lblMember4ActionsRemaining.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblMember4ActionsRemaining.setBounds(10, 41, 171, 13);
		member4Panel.add(lblMember4ActionsRemaining);
		
		JLabel lblCrewMembers = new JLabel("Crew Members");
		lblCrewMembers.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrewMembers.setBounds(10, 385, 229, 28);
		window.getContentPane().add(lblCrewMembers);
		
		JButton btnUseCrewmember = new JButton("Use Crewmember");
		btnUseCrewmember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUseCrewmember.setBounds(10, 143, 209, 25);
		member1Panel.add(btnUseCrewmember);
		
		
		JButton button = new JButton("Use Crewmember");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(10, 143, 209, 25);
		member2Panel.add(button);
		
		
		
		JButton button_1 = new JButton("Use Crewmember");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(10, 143, 209, 25);
		member3Panel.add(button_1);
		
		
		JButton button_2 = new JButton("Use Crewmember");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBounds(10, 143, 209, 25);
		member4Panel.add(button_2);
		
		JLabel lblMoney = new JLabel("Money: $" + gameEnvironment.getCrew().getMoney());
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setBounds(10, 11, 187, 33);
		window.getContentPane().add(lblMoney);
		
		Ship ship = gameEnvironment.getShip();
		JLabel lblShipShieldLevel = new JLabel("Ship shield level: " + ship.getCurrentShieldLevel() + "/" + ship.getMaxShieldLevel());
		lblShipShieldLevel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShipShieldLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShipShieldLevel.setBounds(635, 11, 341, 25);
		window.getContentPane().add(lblShipShieldLevel);
		
		
		updateAllInfoPanels();
	}
}
