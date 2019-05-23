package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameEnvironment;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * Screen displayed at the end of the game. Shows users score, ship and crew name and parts found.
 */
public class EndScreen {

	/** Window used to hold contents of the GUI*/
	private JFrame window;
	
	/** Instance of game environment used to access game logic and state */
	private GameEnvironment gameEnvironment;
	
	/**Label displays the reason for the game ending */
	private JLabel lblGameOver;

	/**
	 * Constructor for end screen
	 * @param incomingGameEnvironment the current state of the game
	 */
	public EndScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	/**
	 * Closes the window
	 */
	public void closeWindow() {
		window.dispose();
	}
	
	/**
	 * Closes the window
	 */
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
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblScore.setBounds(335, 347, 382, 49);
		window.getContentPane().add(lblScore);
		
		JLabel lblPartsFound = new JLabel("Parts Found: " + gameEnvironment.getCrew().getCurrentPieces() + "/" + gameEnvironment.getCrew().getPiecesToFind() );
		lblPartsFound.setForeground(Color.WHITE);
		lblPartsFound.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPartsFound.setBounds(335, 401, 382, 57);
		window.getContentPane().add(lblPartsFound);
		
		JLabel lblCrewName = new JLabel("Crew: " + gameEnvironment.getCrew().getName());
		lblCrewName.setForeground(Color.WHITE);
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCrewName.setBounds(335, 288, 382, 49);
		window.getContentPane().add(lblCrewName);
		
		JLabel lblShipName = new JLabel("Ship: " + gameEnvironment.getShip().getName());
		lblShipName.setForeground(Color.WHITE);
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblShipName.setBounds(335, 229, 382, 49);
		window.getContentPane().add(lblShipName);
		
		lblGameOver = new JLabel("Game Over");
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblGameOver.setBounds(34, 53, 929, 150);
		window.getContentPane().add(lblGameOver);
		
		JLabel lblThanksForPlaying = new JLabel("Thanks For Playing");
		lblThanksForPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForPlaying.setForeground(Color.WHITE);
		lblThanksForPlaying.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThanksForPlaying.setBounds(328, 503, 333, 49);
		window.getContentPane().add(lblThanksForPlaying);
		
		lblGameOver.setText(gameEnvironment.getReasonForEnding());
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(EndScreen.class.getResource("/img/milky_way2.jpg")));
		lblBackground.setBounds(0, 0, 986, 613);
		window.getContentPane().add(lblBackground);
	}

}
