package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.event.*;

import main.GameEnvironment;

import java.awt.Color;
import java.awt.Event;

import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * GUI allowing the user to choose the crews name, ships name and number of days to play for
 */
public class SetupScreen {

	private JFrame window;
	
	
	
    /** Text field for the user to choose the name of their ship */
	private JTextField shipNameEntryField;
	
	 /** Text field for the user to choose the name of their crew */
	private JTextField crewNameEntryField;
	
	 /** Button user clicks when they have finished choosing their crew */
	private JButton btnNext;
	
	 /** Displays text prompting user to choose their crew members */
	private JLabel lblChooseYourCrew;
	
	/**Prompts the user to choose how many days to play for */
	private JLabel lblChooseHowMany;
	
	/**Label displaying the games name */
	private JLabel lblSlowerThanLight;
	
	/**Label storing error message that shows if user doesn't fill in fields */
	private JLabel lblErrorFillIn;
	
	/**An instance of the game used so buttons can effect the game */
	private GameEnvironment gameEnvironment;
	
	/**Label holding the background image of the screen*/
	private JLabel lblNewLabel;
	
	/** Label holding the introduction to the game */
	private JLabel lblGameIntro;

	/**
	 * Creates the Setup Screen
	 */
	public SetupScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	/**Closes the setup screen */
	public void closeWindow() {
		window.dispose();
	}
	
	/**Closes the setup screen */
	public void finishedWindow() {
		gameEnvironment.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		shipNameEntryField = new JTextField();
		shipNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shipNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		shipNameEntryField.setBounds(283, 258, 408, 47);
		window.getContentPane().add(shipNameEntryField);
		shipNameEntryField.setColumns(10);
		
		crewNameEntryField = new JTextField();
		crewNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crewNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		crewNameEntryField.setColumns(10);
		crewNameEntryField.setBounds(283, 359, 408, 47);
		window.getContentPane().add(crewNameEntryField);
		
		JSlider daysSlider = new JSlider();
		daysSlider.setSnapToTicks(true);
		daysSlider.setPaintTicks(true);
		daysSlider.setPaintLabels(true);
		daysSlider.setMajorTickSpacing(1);
		daysSlider.setMinorTickSpacing(1);
		daysSlider.setToolTipText("");
		daysSlider.setValue(3);
		daysSlider.setMinimum(3);
		daysSlider.setMaximum(10);
		daysSlider.setFont(new Font("Tahoma", Font.BOLD, 18));
		daysSlider.setForeground(Color.WHITE);
		daysSlider.setBounds(283, 451, 408, 60);
		daysSlider.setOpaque(false);
		window.getContentPane().add(daysSlider);
		
		
		
		btnNext = new JButton("Next");
		btnNext.setBackground(Color.WHITE);
		btnNext.setForeground(Color.BLACK);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shipName = shipNameEntryField.getText();
				String crewName = crewNameEntryField.getText();
				if(shipName.isBlank() || crewName.isBlank()) {
					lblErrorFillIn.setVisible(true);
				}
				else {
					int numDays = daysSlider.getValue();
					gameEnvironment.setupGame(shipName, crewName, numDays);
					closeWindow();
					gameEnvironment.launchCrewSelectionScreen();
				}
				
			}
		});
		
		
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(418, 521, 127, 47);
		window.getContentPane().add(btnNext);
		
		JLabel lblChooseYourShip = new JLabel("Choose your ship name");
		lblChooseYourShip.setForeground(Color.WHITE);
		lblChooseYourShip.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChooseYourShip.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourShip.setBounds(347, 218, 256, 30);
		window.getContentPane().add(lblChooseYourShip);
		
		lblChooseYourCrew = new JLabel("Choose your crew name");
		lblChooseYourCrew.setForeground(Color.WHITE);
		lblChooseYourCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourCrew.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChooseYourCrew.setBounds(347, 315, 256, 30);
		window.getContentPane().add(lblChooseYourCrew);
		
		lblChooseHowMany = new JLabel("Choose how many days you want to play for\r\n");
		lblChooseHowMany.setForeground(Color.WHITE);
		lblChooseHowMany.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseHowMany.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChooseHowMany.setBounds(253, 411, 463, 30);
		window.getContentPane().add(lblChooseHowMany);
		
		lblSlowerThanLight = new JLabel("Slower Than Light");
		lblSlowerThanLight.setForeground(Color.WHITE);
		lblSlowerThanLight.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlowerThanLight.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblSlowerThanLight.setBounds(155, -11, 683, 120);
		window.getContentPane().add(lblSlowerThanLight);
		
		lblErrorFillIn = new JLabel("Error, fill in both fields!");
		lblErrorFillIn.setVisible(false);
		lblErrorFillIn.setForeground(Color.RED);
		lblErrorFillIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorFillIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErrorFillIn.setBounds(477, 532, 397, 25);
		window.getContentPane().add(lblErrorFillIn);
		
		lblGameIntro = new JLabel("<html><center>SpaceX has your crew to space to collect samples for their research. On your journey your space ship crashed into an asteroid field. Pieces of the ship broke off and were scattered around the surrounding planets. Your ship is now unable to make long distance space travel. Your mission is to find these pieces so you can take your samples back to Earth</center></html>");
		lblGameIntro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGameIntro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameIntro.setForeground(Color.WHITE);
		lblGameIntro.setBounds(97, 103, 801, 105);
		window.getContentPane().add(lblGameIntro);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SetupScreen.class.getResource("/img/milky_way2.jpg")));
		lblNewLabel.setBounds(0, 0, 986, 613);
		window.getContentPane().add(lblNewLabel);
	}
}
