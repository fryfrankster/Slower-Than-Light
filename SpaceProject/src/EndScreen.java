import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class EndScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen window = new EndScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EndScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(456, 401, 73, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPartsFound = new JLabel("Parts Found");
		lblPartsFound.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPartsFound.setBounds(456, 491, 148, 67);
		frame.getContentPane().add(lblPartsFound);
		
		JLabel lblShipName = new JLabel("Crew Name");
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblShipName.setBounds(445, 315, 148, 49);
		frame.getContentPane().add(lblShipName);
		
		JLabel lblShipName_1 = new JLabel("Ship Name\r\n");
		lblShipName_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblShipName_1.setBounds(445, 226, 148, 49);
		frame.getContentPane().add(lblShipName_1);
		
		JLabel lblGa = new JLabel("Game Over");
		lblGa.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblGa.setBounds(332, 50, 632, 150);
		frame.getContentPane().add(lblGa);
		
		JLabel lblThanksForPlaying = new JLabel("Thanks for playing!!!");
		lblThanksForPlaying.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThanksForPlaying.setBounds(481, 604, 333, 49);
		frame.getContentPane().add(lblThanksForPlaying);
	}

}
