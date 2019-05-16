import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewSelectionScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CrewSelectionScreen window = new CrewSelectionScreen();
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
	public CrewSelectionScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeCrewSelectionScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1200, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblExperiencedWithReparing = new JLabel("Experienced with reparing shields");
		lblExperiencedWithReparing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExperiencedWithReparing.setHorizontalAlignment(SwingConstants.CENTER);
		lblExperiencedWithReparing.setBounds(102, 287, 305, 46);
		window.getContentPane().add(lblExperiencedWithReparing);
		
		JLabel lblCrewSelection = new JLabel("Crew Selection");
		lblCrewSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewSelection.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblCrewSelection.setBounds(458, 34, 259, 70);
		window.getContentPane().add(lblCrewSelection);
		
		JButton btnNewButton = new JButton("Engineer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(102, 174, 247, 103);
		window.getContentPane().add(btnNewButton);
		
		JButton btnScavenger = new JButton("Scavenger");
		btnScavenger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScavenger.setBounds(465, 174, 247, 103);
		window.getContentPane().add(btnScavenger);
		
		JButton btnRobot = new JButton("Robot");
		btnRobot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRobot.setBounds(839, 174, 247, 103);
		window.getContentPane().add(btnRobot);
		
		JButton btnWorker = new JButton("Worker");
		btnWorker.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWorker.setBounds(105, 343, 247, 104);
		window.getContentPane().add(btnWorker);
		
		JButton btnSoldier = new JButton("Soldier");
		btnSoldier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSoldier.setBounds(468, 343, 247, 104);
		window.getContentPane().add(btnSoldier);
		
		JButton btnChungus = new JButton("Chungus");
		btnChungus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChungus.setBounds(842, 343, 247, 104);
		window.getContentPane().add(btnChungus);
		
		JLabel lblSkilledAtSearching = new JLabel("Skilled at searching planets");
		lblSkilledAtSearching.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkilledAtSearching.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkilledAtSearching.setBounds(434, 287, 305, 46);
		window.getContentPane().add(lblSkilledAtSearching);
		
		JLabel lblDoesntGetHungry = new JLabel("Doesn't get hungry and is plague immune");
		lblDoesntGetHungry.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry.setBounds(805, 287, 350, 46);
		window.getContentPane().add(lblDoesntGetHungry);
		
		JLabel lblCanPerformAn = new JLabel("Can perform an extra action per day");
		lblCanPerformAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanPerformAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCanPerformAn.setBounds(79, 476, 305, 46);
		window.getContentPane().add(lblCanPerformAn);
		
		JLabel lblDoesntGetHungry_1 = new JLabel("Doesn't get hungry or tired as easily");
		lblDoesntGetHungry_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesntGetHungry_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoesntGetHungry_1.setBounds(437, 476, 305, 46);
		window.getContentPane().add(lblDoesntGetHungry_1);
		
		JLabel lblHasIncreasedHealth = new JLabel("Has increased health\r\n");
		lblHasIncreasedHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasIncreasedHealth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHasIncreasedHealth.setBounds(808, 476, 305, 46);
		window.getContentPane().add(lblHasIncreasedHealth);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchMainScreen();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(978, 663, 104, 70);
		window.getContentPane().add(btnNext);
		
		JLabel lblCurrentCrewMembers = new JLabel("Current crew members");
		lblCurrentCrewMembers.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentCrewMembers.setBounds(89, 532, 305, 55);
		window.getContentPane().add(lblCurrentCrewMembers);
		
		JLabel lblShipName = new JLabel("SHIP NAME");
		lblShipName.setText(gameEnvironment.getShip().getName());
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShipName.setBounds(102, 105, 258, 46);
		window.getContentPane().add(lblShipName);
		
		JLabel lblCrewName = new JLabel("crew name");
		lblCrewName.setText(gameEnvironment.getCrew().getName());
		lblCrewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrewName.setBounds(458, 105, 258, 46);
		window.getContentPane().add(lblCrewName);
		
		JLabel lblNumOfDays = new JLabel("num of days");
		lblNumOfDays.setText(String.valueOf(gameEnvironment.getGameLength()));

		lblNumOfDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumOfDays.setBounds(839, 105, 258, 46);
		window.getContentPane().add(lblNumOfDays);
	}
}
