package main;
//Testing
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.Event;

import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SetupScreen {

	private JFrame window;
	/**
	 * For the user to enter the ships name
	 */
	private JTextField shipNameEntryField;
	private JTextField crewNameEntryField;
	private JButton btnNext;
	private JLabel lblChooseYourCrew;
	private JLabel label;
	private JLabel lblChooseHowMany;
	private JLabel lblSlowerThanLight;
	private JLabel lblErrorFillIn;
	
	private GameEnvironment gameEnvironment;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameSetupScreen2 window = new GameSetupScreen2();
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
	public SetupScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame!
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		shipNameEntryField = new JTextField();
		shipNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shipNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		shipNameEntryField.setBounds(311, 193, 332, 47);
		window.getContentPane().add(shipNameEntryField);
		shipNameEntryField.setColumns(10);
		
		crewNameEntryField = new JTextField();
		crewNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crewNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		crewNameEntryField.setColumns(10);
		crewNameEntryField.setBounds(311, 319, 332, 47);
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
		daysSlider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		daysSlider.setBounds(299, 435, 378, 60);
		window.getContentPane().add(daysSlider);
		
		
		
		btnNext = new JButton("NEXT");
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
		btnNext.setBounds(419, 519, 127, 47);
		window.getContentPane().add(btnNext);
		
		JLabel lblChooseYourShip = new JLabel("Choose your ship name");
		lblChooseYourShip.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourShip.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourShip.setBounds(349, 153, 256, 30);
		window.getContentPane().add(lblChooseYourShip);
		
		lblChooseYourCrew = new JLabel("Choose your crew name");
		lblChooseYourCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourCrew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourCrew.setBounds(349, 275, 256, 30);
		window.getContentPane().add(lblChooseYourCrew);
		
		label = new JLabel("");
		label.setBounds(247, 438, 46, 13);
		window.getContentPane().add(label);
		
		lblChooseHowMany = new JLabel("Choose how many days you want to play for\r\n");
		lblChooseHowMany.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseHowMany.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseHowMany.setBounds(257, 395, 463, 30);
		window.getContentPane().add(lblChooseHowMany);
		
		lblSlowerThanLight = new JLabel("Slower Than Light");
		lblSlowerThanLight.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlowerThanLight.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblSlowerThanLight.setBounds(157, 10, 683, 120);
		window.getContentPane().add(lblSlowerThanLight);
		
		lblErrorFillIn = new JLabel("Error, fill in both fields!");
		lblErrorFillIn.setVisible(false);
		lblErrorFillIn.setForeground(Color.RED);
		lblErrorFillIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorFillIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErrorFillIn.setBounds(285, 577, 397, 25);
		window.getContentPane().add(lblErrorFillIn);
	}
}
