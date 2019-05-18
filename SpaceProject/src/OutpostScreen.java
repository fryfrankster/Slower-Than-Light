import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;

public class OutpostScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OutpostScreen window = new OutpostScreen();
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
	public OutpostScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeOutpostScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back To Main");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchMainScreen();
			}
		});
		btnNewButton.setBounds(25, 523, 120, 55);
		window.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome To The Outpost");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(25, 26, 255, 55);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblAvailableItems = new JLabel("Available Items ");
		lblAvailableItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAvailableItems.setBounds(25, 84, 137, 32);
		window.getContentPane().add(lblAvailableItems);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchInventoryScreen();
			}
		});
		btnViewInventory.setBounds(257, 523, 221, 55);
		window.getContentPane().add(btnViewInventory);
		
		JLabel lblMoney = new JLabel("Money: $");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoney.setBounds(199, 91, 102, 22);
		window.getContentPane().add(lblMoney);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 138, 160, 244);
		window.getContentPane().add(panel);
	}
}
