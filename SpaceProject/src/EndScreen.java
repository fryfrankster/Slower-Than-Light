import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

public class EndScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EndScreen window = new EndScreen();
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
	public EndScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeEndScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("Score: " + gameEnvironment.getScore());
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblScore.setBounds(335, 347, 382, 67);
		window.getContentPane().add(lblScore);
		
		JLabel lblPartsFound = new JLabel("Parts Found: " + gameEnvironment.getCrew().getCurrentPieces() + "/" + gameEnvironment.getCrew().getPiecesToFind() );
		lblPartsFound.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPartsFound.setBounds(335, 424, 382, 67);
		window.getContentPane().add(lblPartsFound);
		
		JLabel lblCrewName = new JLabel("Crew: " + gameEnvironment.getCrew().getName());
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCrewName.setBounds(335, 288, 382, 49);
		window.getContentPane().add(lblCrewName);
		
		JLabel lblShipName = new JLabel("Ship: " + gameEnvironment.getShip().getName());
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblShipName.setBounds(335, 229, 382, 49);
		window.getContentPane().add(lblShipName);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblGameOver.setBounds(222, 53, 632, 150);
		window.getContentPane().add(lblGameOver);
		
		JLabel lblThanksForPlaying = new JLabel("Thanks for playing!!!");
		lblThanksForPlaying.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThanksForPlaying.setBounds(335, 502, 333, 49);
		window.getContentPane().add(lblThanksForPlaying);
	}

}
