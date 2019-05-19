import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InventoryScreen {

	private JFrame window;
	private JLabel inventoryContents;
	private GameEnvironment gameEnvironment;

	/**
	 * Create the application.
	 */
	public InventoryScreen(GameEnvironment incomingGameEnvironment) {
		gameEnvironment = incomingGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeInventoryScreen(this);
	}
	
	private void updateInventoryLabel() {
		String itemsString = "<html>";
		ArrayList<Item> crewsItems = gameEnvironment.getCrew().getItems();
		for(Item item: crewsItems) {
			itemsString +=  "<b>" + item.getName()+ "</b> (" + item.getType() + "): "  + item.getDescription() + "<br><br>" ;
		}
		itemsString += "</html>";
		inventoryContents.setText(itemsString);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1000, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(28, 10, 183, 42);
		window.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back To Main");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchMainScreen();
			}
		});
		btnBack.setBounds(28, 537, 134, 51);
		window.getContentPane().add(btnBack);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchOutpostScreen();
			}
		});
		btnVisitOutpost.setBounds(328, 537, 191, 51);
		window.getContentPane().add(btnVisitOutpost);
		
		inventoryContents = new JLabel("New label");
		inventoryContents.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inventoryContents.setVerticalAlignment(SwingConstants.TOP);
		inventoryContents.setBounds(28, 62, 948, 465);
		window.getContentPane().add(inventoryContents);
		
		updateInventoryLabel();
	}
}
