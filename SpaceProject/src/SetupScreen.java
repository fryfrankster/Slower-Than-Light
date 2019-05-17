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
	private JTextField shipNameEntryField;
	private JTextField crewNameEntryField;
	private JLabel lblChooseYourCrew;
	private JLabel label;
	private JLabel lblChooseHowMany;
	private JLabel lblSlowerThanLight;
	
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
		window.setBounds(100, 100, 1200, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		shipNameEntryField = new JTextField();
		shipNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shipNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		shipNameEntryField.setBounds(437, 301, 332, 47);
		window.getContentPane().add(shipNameEntryField);
		shipNameEntryField.setColumns(10);
		
		crewNameEntryField = new JTextField();
		crewNameEntryField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crewNameEntryField.setHorizontalAlignment(SwingConstants.CENTER);
		crewNameEntryField.setColumns(10);
		crewNameEntryField.setBounds(437, 444, 332, 47);
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
		daysSlider.setBounds(414, 602, 378, 60);
		window.getContentPane().add(daysSlider);
		
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shipName = shipNameEntryField.getText();
				String crewName = crewNameEntryField.getText();
				int numDays = daysSlider.getValue();
				gameEnvironment.setupGame(shipName, crewName, numDays);
				closeWindow();
				gameEnvironment.launchCrewSelectionScreen();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(538, 695, 127, 47);
		window.getContentPane().add(btnNext);
		
		JLabel lblChooseYourShip = new JLabel("Choose your ship name");
		lblChooseYourShip.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourShip.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourShip.setBounds(475, 261, 256, 30);
		window.getContentPane().add(lblChooseYourShip);
		
		lblChooseYourCrew = new JLabel("Choose your crew name");
		lblChooseYourCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourCrew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourCrew.setBounds(475, 400, 256, 30);
		window.getContentPane().add(lblChooseYourCrew);
		
		label = new JLabel("");
		label.setBounds(139, 512, 46, 13);
		window.getContentPane().add(label);
		
		lblChooseHowMany = new JLabel("Choose how many days you want to play for\r\n");
		lblChooseHowMany.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseHowMany.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseHowMany.setBounds(372, 562, 463, 30);
		window.getContentPane().add(lblChooseHowMany);
		
		lblSlowerThanLight = new JLabel("Slower Than Light");
		lblSlowerThanLight.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlowerThanLight.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblSlowerThanLight.setBounds(176, 77, 835, 132);
		window.getContentPane().add(lblSlowerThanLight);
	}
}
