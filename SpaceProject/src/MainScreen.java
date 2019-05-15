import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

public class MainScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainScreen window = new MainScreen();
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
		window.setBounds(100, 100, 1200, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnVisitOutpost.setBounds(64, 183, 314, 53);
		window.getContentPane().add(btnVisitOutpost);
		
		JButton btnPilotShipTo = new JButton("Pilot Ship To New Planet");
		btnPilotShipTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPilotShipTo.setBounds(64, 246, 314, 53);
		window.getContentPane().add(btnPilotShipTo);
		
		JButton btnSearchPlanetFor = new JButton("Search Planet");
		btnSearchPlanetFor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchPlanetFor.setBounds(64, 309, 314, 53);
		window.getContentPane().add(btnSearchPlanetFor);
		
		JButton btnRepairShields = new JButton("Repair Shields");
		btnRepairShields.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRepairShields.setBounds(64, 372, 314, 53);
		window.getContentPane().add(btnRepairShields);
	}

}
