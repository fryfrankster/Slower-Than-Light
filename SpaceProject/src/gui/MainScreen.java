package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.CrewMember;
import main.GameEnvironment;
import main.Ship;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

/**
 * The main screen of the game the player interacts with. Allows player to perform crew member actions and general actions
 *
 */
public class MainScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	
	/** Label showing the name and type of crew member 1 */
	private JLabel lblMember1NameType;
	
	/** Label showing the health of crew member 1 */
	private JLabel lblMember1Health;
	
	/** Label showing the tiredness of crew member 1 */
	private JLabel lblMember1Tiredness;
	
	/** Label showing the hunger of crew member 1 */
	private JLabel lblMember1Hunger;
	
	/** Label showing the actions remaining of crew member 1 */
	private JLabel lblMember1ActionsRemaining;
	
	/** Label showing the name and type of crew member 2 */
	private JLabel lblMember2NameType;
	
	/** Label showing the health of crew member 2 */
	private JLabel lblMember2Health;
	
	/** Label showing the tiredness of crew member 2 */
	private JLabel lblMember2Tiredness;
	
	/** Label showing the hunger of crew member 2 */
	private JLabel lblMember2Hunger;
	
	/** Label showing the actions remaining of crew member 2 */
	private JLabel lblMember2ActionsRemaining;
	
	/** Label showing the name and type of crew member 3 */
	private JLabel lblMember3NameType;
	
	/** Label showing the health of crew member 3 */
	private JLabel lblMember3Health;
	
	/** Label showing the tiredness of crew member 3 */
	private JLabel lblMember3Tiredness;
	
	/** Label showing the hunger of crew member 3 */
	private JLabel lblMember3Hunger;
	
	/** Label showing the actions remaining of crew member 3 */
	private JLabel lblMember3ActionsRemaining;
	
	/** Label showing the name and type of crew member 4 */
	private JLabel lblMember4NameType;
	
	/** Label showing the health of crew member 4 */
	private JLabel lblMember4Health;
	
	/** Label showing the tiredness of crew member 4 */
	private JLabel lblMember4Tiredness;
	
	/** Label showing the hunger of crew member 4 */
	private JLabel lblMember4Hunger;
	
	/** Label showing the actions remaining of crew member 4 */
	private JLabel lblMember4ActionsRemaining;
	
	/** Panel containing an information about crew member 1*/
	private JPanel member1Panel;
	
	/** Panel containing an information about crew member 2*/
	private JPanel member2Panel;
	
	/** Panel containing an information about crew member 3*/
	private JPanel member3Panel;
	
	/** Panel containing an information about crew member 4*/
	private JPanel member4Panel;
	
	/** Button that moves user to next day when clicked*/
	private JButton btnMoveToNextDay;
	
	/** Button that makes a crew member sleep when clicked*/
	private JButton btnSleep;
	
	/** Button that makes a crew member use an item when clicked*/
	private JButton btnUseItems;
	
	/** Button that sets the current crew member being used to member 1*/
	private JButton btnUseCrewmember1;
	
	/** Button that sets the current crew member being used to member 2*/
	private JButton btnUseCrewmember2;
	
	/** Button that sets the current crew member being used to member 3*/
	private JButton btnUseCrewmember3;
	
	/** Button that sets the current crew member being used to member 4*/
	private JButton btnUseCrewmember4;
	
	/** Stores which crew member is currently performing actions */
	private CrewMember selectedCrewMember = null;
	
	/**Label that displays information about what is happening in the game to the user */
	private JLabel lblGameDialouge;
	
	/** Label Showing the user the amount of parts they have found*/
	private JLabel lblPartsFound;
	
	/** Label Showing the user current day and total days*/
	private JLabel lblDay;
	
	/**Label showing heading for the general actions buttons*/
	private JLabel lblGeneralActions;
	
	/**Label showing heading for the crew member actions buttons*/
	private JLabel lblCrewMemberActions;
	
	/**Shows the player how much money the crew has*/
	private JLabel lblMoney;
	
	/**Label showing the player the ships shield level*/
	private JLabel lblShipShieldLevel;
	
	/**The button related to the selected crew member. Used when pilot ship so user cannot pilot ship with the same crew member*/
	private JButton selectedMemberButton;
	
	/**Boolean showing whether the user is currently choosing a crew member to help pilot the ship with*/
	private boolean pilotMode = false;
	
	/**Label showing heading for the general actions buttons*/
	private CrewMember otherCrewMember = null;
	
	/**Label that shows whether crew member 1 has space plague*/
	private JLabel lblMember1Plague;
	
	/**Label that shows whether crew member 2 has space plague*/
	private JLabel lblMember2Plague;
	
	/**Label that shows whether crew member 3 has space plague*/
	private JLabel lblMember3Plague;
	
	/**Label that shows whether crew member 4 has space plague*/
	private JLabel lblMember4Plague;
	
	/**Label containing the background image of the screen */
	private JLabel lblBackground;

	/**
	 * Creates the Main Screen GUI
	 * @param incomingGameEnvironment instance of the game environment used to control game logic
	 */
	public MainScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	
	/**
	 * Updates the label showing the ships current and maximum shield level
	 */
	private void updateShieldLabel() {
		Ship ship = gameEnvironment.getShip();
		lblShipShieldLevel.setText("Ship shield level: " + ship.getCurrentShieldLevel() + "/" + ship.getMaxShieldLevel());
		if(ship.getCurrentShieldLevel() <=0) {
			gameEnvironment.setReasonForEnding("Game over, The ship lost all shields!");
			closeWindow();
			gameEnvironment.launchEndScreen();
		}
	}
	
	/**
	 * Closes the main screen GUI
	 */
	public void closeWindow() {
		window.dispose();
	}
	
	/**
	 * Gets the other crew member who is piloting the ship, and pilots the ship with both crew members
	 * Updates GUI with information
	 * @param memberIndex the index in the Crew Member array of the other member to pilot the ship with
	 */
	public void getOtherPilot(int memberIndex) {
		otherCrewMember = gameEnvironment.getCrew().getCrewMembers().get(memberIndex);
		
		pilotMode = false;
		lblGameDialouge.setText("<html>" + selectedCrewMember.pilotShip(otherCrewMember, gameEnvironment.getPlanet(), gameEnvironment.getRandomEvent(), gameEnvironment.getShip()) + "</html>");
		selectedMemberButton.setVisible(true);
		updateAllCrewInfoPanels();
		updateShieldLabel();
	}
	
	/**
	 * Closes the main screen GUI
	 */
	public void finishedWindow() {
		gameEnvironment.closeMainScreen(this);
	}
	
	/**
	 * Updates the label showing the crews current money
	 */
	private void updateMoney() {
		lblMoney.setText("Money: $" + gameEnvironment.getCrew().getMoney());
	}
	
	 /**
	  * Checks if the selected user can do an action and Updates game dialogue lbl
	  * @return if the crew member can perform an action
	  */
	private boolean selectedMemberCanDoAction() {

		if (selectedCrewMember == null) {
			lblGameDialouge.setText("You must pick a crew member!");
			return false;
		}
		
		else if(!selectedCrewMember.canPerformAction()) {
			lblGameDialouge.setText("Current crew member is out of actions, pick another!!");
			return false;
		}
		
		else {
			return true;
		}
	}
	
	/**
	 * Updates the label showing the current day and the total days
	 */
	private void updateDay() {
		lblDay.setText("Day " + gameEnvironment.getCurrentDay() + "/" + gameEnvironment.getGameLength());
	}
	
	/**
	 * Updates the label showing the amount of parts the user has found
	 */
	private void updateParts() {
		lblPartsFound.setText("Parts found: " + gameEnvironment.getCrew().getCurrentPieces() + "/" + gameEnvironment.getCrew().getPiecesToFind());
	}
	
	/**
	 * Updates all the information labels associated with a given crewmember
	 * @param crewMember The crewm ember whose information is displayed
	 * @param nameType label showing the members name and type
	 * @param health label showing the members health
	 * @param tiredness label showing the members tiredness
	 * @param hunger label showing the members hunger
	 * @param actions label showing the members actions
	 * @param plague label showing whether the member has space plague
	 */
	private void updateCrewmemberInfoPanel(CrewMember crewMember, JLabel nameType, JLabel health, JLabel tiredness, JLabel hunger, JLabel actions, JLabel plague) {
	    nameType.setText("<html>" + crewMember.getName() + " - " + crewMember.getType() + "</html>");
		health.setText("Health: " + String.valueOf(crewMember.getHealth()) + "/" + crewMember.getMaxHealth());
		tiredness.setText("Tiredness: " + String.valueOf(crewMember.getTiredness()) + "/" + crewMember.getMaxTiredness());
		hunger.setText("Hunger: " + String.valueOf(crewMember.getHunger()) + "/" + crewMember.getMaxHunger());
		actions.setText("Actions remaining: " + String.valueOf(crewMember.getAvailableActions()));
		plague.setVisible(crewMember.hasSpacePlague());
	}
	
	/**
	 * Updates the information panels of all crew members.
	 */
	private void updateAllCrewInfoPanels() {
		member1Panel.setVisible(false);
		member2Panel.setVisible(false);
		member3Panel.setVisible(false);
		member4Panel.setVisible(false);
		
		int crewSize = gameEnvironment.getCrew().getCrewSize();
		switch (crewSize) {
			case 4:
				member4Panel.setVisible(true);
				CrewMember crewMember4 = gameEnvironment.getCrew().getCrewMembers().get(3);
				btnUseCrewmember4.setVisible(crewMember4.getAvailableActions() != 0);
				updateCrewmemberInfoPanel(crewMember4, lblMember4NameType, lblMember4Health, lblMember4Tiredness, lblMember4Hunger, lblMember4ActionsRemaining, lblMember4Plague);
				
			case 3:
				member3Panel.setVisible(true);
				CrewMember crewMember3 = gameEnvironment.getCrew().getCrewMembers().get(2);
				btnUseCrewmember3.setVisible(crewMember3.getAvailableActions() != 0);
				updateCrewmemberInfoPanel(crewMember3, lblMember3NameType, lblMember3Health, lblMember3Tiredness, lblMember3Hunger, lblMember3ActionsRemaining, lblMember3Plague);
			
			case 2:
				member2Panel.setVisible(true);
				CrewMember crewMember2 = gameEnvironment.getCrew().getCrewMembers().get(1);
				btnUseCrewmember2.setVisible(crewMember2.getAvailableActions() != 0);
				updateCrewmemberInfoPanel(crewMember2, lblMember2NameType, lblMember2Health, lblMember2Tiredness, lblMember2Hunger, lblMember2ActionsRemaining, lblMember2Plague);
				
			case 1:
				member1Panel.setVisible(true);
				CrewMember crewMember1 = gameEnvironment.getCrew().getCrewMembers().get(0);
				btnUseCrewmember1.setVisible(crewMember1.getAvailableActions() != 0);
				updateCrewmemberInfoPanel(crewMember1, lblMember1NameType, lblMember1Health, lblMember1Tiredness, lblMember1Hunger, lblMember1ActionsRemaining, lblMember1Plague);
				break;
			default:
				gameEnvironment.setReasonForEnding("Game over, all crew died!");
				closeWindow();
				gameEnvironment.launchEndScreen();
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
		
		
		//BUTTONS FOR GENERAL ACTIONS
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBackground(Color.WHITE);
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchInventoryScreen();
			}
		});
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnViewInventory.setBounds(20, 198, 233, 37);
		window.getContentPane().add(btnViewInventory);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setBackground(Color.WHITE);
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchOutpostScreen();
			}
		});
		btnVisitOutpost.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnVisitOutpost.setBounds(20, 104, 233, 37);
		window.getContentPane().add(btnVisitOutpost);
		
		btnMoveToNextDay = new JButton("Move To Next Day");
		btnMoveToNextDay.setBackground(Color.WHITE);
		btnMoveToNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameEnvironment.getCurrentDay() == gameEnvironment.getGameLength()) {
					gameEnvironment.setReasonForEnding("Game over, you ran out of days!");
					closeWindow();
					gameEnvironment.launchEndScreen();
				}
					
				else {
				lblGameDialouge.setText("<html>" + gameEnvironment.nextDay() + "</html>");
				updateAllCrewInfoPanels();
				updateDay();
				pilotMode = false;
				}
			}
		});
		btnMoveToNextDay.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnMoveToNextDay.setBounds(20, 151, 233, 37);
		window.getContentPane().add(btnMoveToNextDay);
		
		
		//BUTTONS FOR CREW MEMBER ACTIONS
		
		//PILOT SHIP
		JButton btnPilotShipTo = new JButton("Pilot Ship To New Planet");
		btnPilotShipTo.setBackground(Color.WHITE);
		btnPilotShipTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pilotMode = false;
			if(selectedMemberCanDoAction()){
				if(gameEnvironment.getCrew().getAvailableCrewMembers() < 2) {
					lblGameDialouge.setText("You need two crew members to pilot the ship!");
				}
				else {
					selectedMemberButton.setVisible(false);
					pilotMode = true;
					lblGameDialouge.setText("Select another crewmember to help pilot the ship");
					
				}
			}
		}
		});
		btnPilotShipTo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPilotShipTo.setBounds(665, 104, 301, 37);
		window.getContentPane().add(btnPilotShipTo);
		
		//SEARCH PLANET
		JButton btnSearchPlanetFor = new JButton("Search Planet");
		btnSearchPlanetFor.setBackground(Color.WHITE);
		btnSearchPlanetFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilotMode = false;
				if(selectedMemberCanDoAction()) {
					lblGameDialouge.setText(selectedCrewMember.searchForParts(gameEnvironment.getPlanet(), gameEnvironment.getCrew()));
					updateMoney();
					updateAllCrewInfoPanels();
					if(gameEnvironment.getCrew().foundAllParts()) {
						gameEnvironment.setReasonForEnding("You won by finding all parts!");
						closeWindow();
						gameEnvironment.launchEndScreen();
					}
					else {
						updateParts();
						
					}
				}
			}
		});
		btnSearchPlanetFor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSearchPlanetFor.setBounds(665, 151, 301, 37);
		window.getContentPane().add(btnSearchPlanetFor);
		
		//REPAIR SHIELDS
		JButton btnRepairShields = new JButton("Repair Shields");
		btnRepairShields.setBackground(Color.WHITE);
		btnRepairShields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilotMode = false;
				if(selectedMemberCanDoAction()) {
					lblGameDialouge.setText(selectedCrewMember.repairShields(gameEnvironment.getShip()));
					updateAllCrewInfoPanels();
					updateShieldLabel();
				}
			}
		});
		btnRepairShields.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRepairShields.setBounds(665, 198, 301, 37);
		window.getContentPane().add(btnRepairShields);
		
		//SLEEP
		btnSleep = new JButton("Sleep");
		btnSleep.setBackground(Color.WHITE);
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilotMode = false;
				
				if(selectedMemberCanDoAction()) {
					
					lblGameDialouge.setText("<html>" + selectedCrewMember.sleep() + "</html>");
					updateAllCrewInfoPanels();
				
				
				}
				
			}
		});
		btnSleep.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSleep.setBounds(665, 290, 301, 35);
		window.getContentPane().add(btnSleep);
		
		//USE ITEM
		btnUseItems = new JButton("Use Item");
		btnUseItems.setBackground(Color.WHITE);
		btnUseItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilotMode = false;
				if(gameEnvironment.getCrew().getInventorySize() == 0) {
					lblGameDialouge.setText("Your inventory is empty!");
				}
				else {
				
					if(selectedMemberCanDoAction()) {
					
//					ArrayList<String> crewsItemsNames = gameEnvironment.getCrew().getCrewsItemsNames(); 
//					TreeSet<String> crewsItemSet = new TreeSet<String>(crewsItemsNames);
//					String[] choices = new String[gameEnvironment.getCrew().getInventorySize()];
//					
//					int index = 0;
//					for(String name : crewsItemSet) {
//						choices[index] = String.valueOf(index) + ": " + name + " (" + Collections.frequency(crewsItemsNames, name) + ")";
//						index += 1;
//					}
						
						String[] choices = gameEnvironment.getCrew().getItemsAsStringArray();
						
					    String input = (String) JOptionPane.showInputDialog(null, "Choose an item to use",
					        "Item to use", JOptionPane.QUESTION_MESSAGE, null, // Use
					                                                                        // default
					                                                                        // icon
					        choices, // Array of choices
					        choices[0]); // Initial choice
	
					    if(input != null) {
						    int indexOfItem = Integer.parseInt(Character.toString(input.charAt(0)));
						   
						    lblGameDialouge.setText("<html>" + selectedCrewMember.useItem(gameEnvironment.getCrew(), indexOfItem) + "</html>");
						    updateAllCrewInfoPanels();
					    }
					    
					}
				}
			}
		});
		btnUseItems.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseItems.setBounds(665, 245, 301, 35);
		window.getContentPane().add(btnUseItems); 
		
		
		//CREW MEMBER 1 STATUS
		member1Panel = new JPanel();
		member1Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		member1Panel.setBounds(20, 425, 229, 178);
		window.getContentPane().add(member1Panel);
		member1Panel.setLayout(null);
		
		lblMember1NameType = new JLabel("Name - Type");
		lblMember1NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember1NameType.setBounds(10, 0, 209, 39);
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
		
		//CREW MEMBER 2 STATUS
		member2Panel = new JPanel();
		member2Panel.setLayout(null);
		member2Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		member2Panel.setBounds(259, 425, 229, 178);
		window.getContentPane().add(member2Panel);
		
		lblMember2NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember2NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember2NameType.setBounds(10, 0, 209, 39);
		member2Panel.add(lblMember2NameType);
		
		lblMember2Health = new JLabel("Health: 0");
		lblMember2Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember2Health.setBounds(10, 76, 108, 13);
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
		
		//CREW MEMBER 3 STATUS
		member3Panel = new JPanel();
		member3Panel.setLayout(null);
		member3Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		member3Panel.setBounds(498, 425, 229, 178);
		window.getContentPane().add(member3Panel);
		
		lblMember3NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember3NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember3NameType.setBounds(10, 0, 209, 39);
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
		
		//CREW MEMBER 4 STATUS
		member4Panel = new JPanel();
		member4Panel.setLayout(null);
		member4Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		member4Panel.setBounds(737, 425, 229, 178);
		window.getContentPane().add(member4Panel);
		
		lblMember4NameType = new JLabel("<dynamic> - <dynamic>");
		lblMember4NameType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMember4NameType.setBounds(10, 0, 209, 39);
		member4Panel.add(lblMember4NameType);
		
		lblMember4Health = new JLabel("Health: 0");
		lblMember4Health.setForeground(Color.BLACK);
		lblMember4Health.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMember4Health.setBounds(10, 76, 107, 13);
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
		
		JLabel lblCrewMembers = new JLabel("Crew Members:");
		lblCrewMembers.setForeground(Color.WHITE);
		lblCrewMembers.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrewMembers.setBounds(20, 389, 229, 28);
		window.getContentPane().add(lblCrewMembers);
		
		btnUseCrewmember1 = new JButton("Use Crewmember");
		btnUseCrewmember1.setBackground(Color.WHITE);
		btnUseCrewmember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilotMode) {
					getOtherPilot(0);		
				}
				else {
				selectedCrewMember = gameEnvironment.getCrew().getCrewMembers().get(0);
				selectedMemberButton = btnUseCrewmember1;
				}
			}
		});
		btnUseCrewmember1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUseCrewmember1.setBounds(10, 143, 209, 25);
		member1Panel.add(btnUseCrewmember1);
		
		lblMember1Plague = new JLabel("Has space plague!");
		lblMember1Plague.setForeground(Color.RED);
		lblMember1Plague.setBounds(10, 61, 209, 14);
		member1Panel.add(lblMember1Plague);
		
		btnUseCrewmember2 = new JButton("Use Crewmember");
		btnUseCrewmember2.setBackground(Color.WHITE);
		btnUseCrewmember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilotMode) {
					getOtherPilot(1);
				}
				else {
				selectedCrewMember = gameEnvironment.getCrew().getCrewMembers().get(1);
				selectedMemberButton = btnUseCrewmember2;
				}
			}
		});
		btnUseCrewmember2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUseCrewmember2.setBounds(10, 143, 209, 25);
		member2Panel.add(btnUseCrewmember2);
		
		lblMember2Plague = new JLabel("Has space plague!");
		lblMember2Plague.setForeground(Color.RED);
		lblMember2Plague.setBounds(10, 61, 209, 14);
		member2Panel.add(lblMember2Plague);
		
		btnUseCrewmember3 = new JButton("Use Crewmember");
		btnUseCrewmember3.setBackground(Color.WHITE);
		btnUseCrewmember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilotMode) {
					getOtherPilot(2);
				}
				else {
				selectedCrewMember = gameEnvironment.getCrew().getCrewMembers().get(2);
				selectedMemberButton = btnUseCrewmember3;
				}
			}
		});
		btnUseCrewmember3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUseCrewmember3.setBounds(10, 143, 209, 25);
		member3Panel.add(btnUseCrewmember3);
		
		lblMember3Plague = new JLabel("Has space plague!");
		lblMember3Plague.setForeground(Color.RED);
		lblMember3Plague.setBounds(10, 61, 209, 14);
		member3Panel.add(lblMember3Plague);
		
		btnUseCrewmember4 = new JButton("Use Crewmember");
		btnUseCrewmember4.setBackground(Color.WHITE);
		btnUseCrewmember4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pilotMode) {
					getOtherPilot(3);
				}
				else {
				selectedCrewMember = gameEnvironment.getCrew().getCrewMembers().get(3);
				selectedMemberButton = btnUseCrewmember4;
				}
			}
		});
		btnUseCrewmember4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUseCrewmember4.setBounds(10, 143, 209, 25);
		member4Panel.add(btnUseCrewmember4);
		
		lblMember4Plague = new JLabel("Has space plague!");
		lblMember4Plague.setForeground(Color.RED);
		lblMember4Plague.setBounds(10, 61, 209, 14);
		member4Panel.add(lblMember4Plague);
		
		lblMoney = new JLabel("Money: $" + gameEnvironment.getCrew().getMoney());
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setBounds(20, 7, 187, 33);
		window.getContentPane().add(lblMoney);
		
		Ship ship = gameEnvironment.getShip();
		lblShipShieldLevel = new JLabel("Ship Shield Level: " + ship.getCurrentShieldLevel() + "/" + ship.getMaxShieldLevel());
		lblShipShieldLevel.setForeground(Color.WHITE);
		lblShipShieldLevel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblShipShieldLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblShipShieldLevel.setBounds(625, 11, 341, 25);
		window.getContentPane().add(lblShipShieldLevel);
		
		lblGameDialouge = new JLabel("Welcome, Press a button to begin!");
		lblGameDialouge.setForeground(Color.WHITE);
		lblGameDialouge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGameDialouge.setBounds(20, 330, 956, 49);
		window.getContentPane().add(lblGameDialouge);
		
		lblPartsFound = new JLabel("Parts Found: " + gameEnvironment.getCrew().getCurrentPieces() + "/" + gameEnvironment.getCrew().getPiecesToFind());
		lblPartsFound.setForeground(Color.WHITE);
		lblPartsFound.setHorizontalAlignment(SwingConstants.LEFT);
		lblPartsFound.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPartsFound.setBounds(475, 7, 187, 33);
		window.getContentPane().add(lblPartsFound);
		
		lblDay = new JLabel("Day " + gameEnvironment.getCurrentDay() + "/" + gameEnvironment.getGameLength());
		lblDay.setForeground(Color.WHITE);
		lblDay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDay.setBounds(278, 7, 157, 33);
		window.getContentPane().add(lblDay);
		
		lblGeneralActions = new JLabel("General Actions:");
		lblGeneralActions.setForeground(Color.WHITE);
		lblGeneralActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneralActions.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGeneralActions.setBounds(20, 66, 233, 28);
		window.getContentPane().add(lblGeneralActions);
		
		lblCrewMemberActions = new JLabel("Crew Member Actions:");
		lblCrewMemberActions.setForeground(Color.WHITE);
		lblCrewMemberActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewMemberActions.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCrewMemberActions.setBounds(665, 66, 301, 28);
		window.getContentPane().add(lblCrewMemberActions);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(MainScreen.class.getResource("/img/milky_way2.jpg")));
		lblBackground.setBounds(0, 0, 986, 613);
		window.getContentPane().add(lblBackground);
		
		
		updateAllCrewInfoPanels();

	}
}
