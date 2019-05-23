package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameEnvironment;
import main.Item;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * Screen showing the user the contents of their inventory
 */
public class InventoryScreen {

	/** Window holding GUI components */
	private JFrame window;
	
	/** Label holding all items in the players inventory */
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
	
	/** Closes the Inventory Screen */
	public void closeWindow() {
		window.dispose();
	}
	
	/** Closes the Inventory Screen */
	public void finishedWindow() {
		gameEnvironment.closeInventoryScreen(this);
	}
	
	/** Updates the inventory label to show the items the player now has*/
	private void updateInventoryLabel() {
		String itemsString = "<html>";
		ArrayList<Item> crewsItems = gameEnvironment.getCrew().getItems();
		LinkedHashSet<Item> crewsItemsSet = new LinkedHashSet(crewsItems);
		ArrayList<String> itemsNameArray = new ArrayList<String>();
		
		for(Item item: crewsItems) {
			itemsNameArray.add(item.getName());
		}
		
		for(Item item: crewsItemsSet) {
			String originalString =  "<b>"  + item.getName() + "(" + Collections.frequency(itemsNameArray,  item.getName()) + ")" + "</b> (" + item.getType() + "): "  + item.getDescription() + "<br><br>" ;
			String withoutOpening = originalString.replaceAll("<html>", "");
			itemsString += withoutOpening.replaceAll("</html>", "");
			
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
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(28, 10, 183, 42);
		window.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back To Main");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchMainScreen();
			}
		});
		btnBack.setBounds(28, 537, 152, 51);
		window.getContentPane().add(btnBack);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVisitOutpost.setBackground(new Color(255, 255, 255));
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchOutpostScreen();
			}
		});
		btnVisitOutpost.setBounds(790, 537, 160, 51);
		window.getContentPane().add(btnVisitOutpost);
		
		inventoryContents = new JLabel("New label");
		inventoryContents.setHorizontalAlignment(SwingConstants.LEFT);
		inventoryContents.setForeground(Color.WHITE);
		inventoryContents.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inventoryContents.setVerticalAlignment(SwingConstants.TOP);
		inventoryContents.setBounds(28, 62, 948, 465);
		window.getContentPane().add(inventoryContents);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(InventoryScreen.class.getResource("/img/milky_way2.jpg")));
		lblBackground.setBounds(0, 0, 986, 613);
		window.getContentPane().add(lblBackground);
		
		updateInventoryLabel();
	}
}
