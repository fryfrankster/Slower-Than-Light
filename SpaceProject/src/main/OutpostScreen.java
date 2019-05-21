package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

/**
 * GUI allowing user to view and buy items in a space outpost
 */
public class OutpostScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	
	private JLabel lblItem1Name;
	private JLabel lblItem1Description;
	private JLabel lblItem1Benefit;
	private JLabel lblItem1Price;
	
	private JLabel lblItem2Name;
	private JLabel lblItem2Description;
	private JLabel lblItem2Benefit;
	private JLabel lblItem2Price;
	
	private JLabel lblItem3Name;
	private JLabel lblItem3Description;
	private JLabel lblItem3Benefit;
	private JLabel lblItem3Price;
	
	private JLabel lblItem4Name;
	private JLabel lblItem4Description;
	private JLabel lblItem4Benefit;
	private JLabel lblItem4Price;
	
	private JLabel lblItem5Name;
	private JLabel lblItem5Description;
	private JLabel lblItem5Benefit;
	private JLabel lblItem5Price;
	
	private JLabel lblItem6Name;
	private JLabel lblItem6Description;
	private JLabel lblItem6Benefit;
	private JLabel lblItem6Price;
	
	private JPanel panelItem1;
	private JPanel panelItem2;
	private JPanel panelItem3;
	private JPanel panelItem4;
	private JPanel panelItem5;
	private JPanel panelItem6;
	
	private JButton btnPurchaseItem1;
	private JButton btnPurchaseItem2;
	private JButton btnPurchaseItem3;
	private JButton btnPurchaseItem4;
	private JButton btnPurchaseItem5;
	private JButton btnPurchaseItem6;
	
	private JLabel lblMoney;
	private JLabel lblDialougeBox;
	
	/**
	 * Called when user clicks the purchase button
	 * @param int index the index of the button clicked relating to the item the player wants to purchase
	 */
	private void purchaseButtonClicked(int index) {
		if(gameEnvironment.getCrew().canPurchaseItem(gameEnvironment.getCrew(), gameEnvironment.getPlanet(), index)) {
			lblDialougeBox.setText("You have purchased " + gameEnvironment.getPlanet().getPlanetsItems().get(index).getName() );
			gameEnvironment.getCrew().purchaseItem(gameEnvironment.getCrew(), gameEnvironment.getPlanet(), index);
			updateAllItemInfoPanels();
			updateMoneyLabel();
			lblDialougeBox.setBackground(Color.GREEN);
		}
		else {
			lblDialougeBox.setBackground(Color.RED);
			lblDialougeBox.setText("YOU ARE TOO POOR TO AFFORD THIS ITEM!");
		}
	}
	
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
	
	private void updateMoneyLabel() {
		lblMoney.setText("Money: $" + gameEnvironment.getCrew().getMoney());
	}
	
	private void updateItemInfoPanel(Item item, JLabel name, JLabel description, JLabel benefit, JLabel price) {
	    name.setText(item.getName() + "(" +  item.getType() + ")");
		description.setText(item.getDescription());
		benefit.setText("Benefit : " + String.valueOf(item.getBenefit()));
		price.setText("$" + String.valueOf(item.getPrice()));
	}
	
	private void updateAllItemInfoPanels() {
		panelItem1.setVisible(false);
		panelItem2.setVisible(false);
		panelItem3.setVisible(false);
		panelItem4.setVisible(false);
		panelItem5.setVisible(false);
		panelItem6.setVisible(false);
		
		int numItems = gameEnvironment.getPlanet().getPlanetsItemsSize();
		
		switch (numItems) {
			case 6:
				panelItem6.setVisible(true);
				Item item6 = gameEnvironment.getPlanet().getPlanetsItems().get(5);
				updateItemInfoPanel(item6, lblItem6Name, lblItem6Description, lblItem6Benefit, lblItem6Price);
			case 5:
				panelItem5.setVisible(true);
				Item item5 = gameEnvironment.getPlanet().getPlanetsItems().get(4);
				updateItemInfoPanel(item5, lblItem5Name, lblItem5Description, lblItem5Benefit, lblItem5Price);
			case 4:
				panelItem4.setVisible(true);
				Item item4 = gameEnvironment.getPlanet().getPlanetsItems().get(3);
				updateItemInfoPanel(item4, lblItem4Name, lblItem4Description, lblItem4Benefit, lblItem4Price);
				
			case 3:
				panelItem3.setVisible(true);
				Item item3 = gameEnvironment.getPlanet().getPlanetsItems().get(2);
				updateItemInfoPanel(item3, lblItem3Name, lblItem3Description, lblItem3Benefit, lblItem3Price);
			
			case 2:
				panelItem2.setVisible(true);
				Item item2 = gameEnvironment.getPlanet().getPlanetsItems().get(1);
				updateItemInfoPanel(item2, lblItem2Name, lblItem2Description, lblItem2Benefit, lblItem2Price);
				
			case 1:
				panelItem1.setVisible(true);
				Item item1 = gameEnvironment.getPlanet().getPlanetsItems().get(0);
				updateItemInfoPanel(item1, lblItem1Name, lblItem1Description, lblItem1Benefit, lblItem1Price);
				break;
			default:
 				lblDialougeBox.setText("You have purchased all available items, pilot the ship to a new planet!");
		}
	
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(25, 26, 353, 55);
		window.getContentPane().add(lblNewLabel);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				gameEnvironment.launchInventoryScreen();
			}
		});
		btnViewInventory.setBounds(738, 523, 221, 55);
		window.getContentPane().add(btnViewInventory);
		
		lblMoney = new JLabel("Money: $");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoney.setBounds(25, 91, 291, 22);
		window.getContentPane().add(lblMoney);
		
		//ITEM 1
		panelItem1 = new JPanel();
		panelItem1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem1.setBounds(25, 138, 270, 171);
		window.getContentPane().add(panelItem1);
		panelItem1.setLayout(null);
		
		lblItem1Name = new JLabel("Item 1 name");
		lblItem1Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem1Name.setBounds(10, 10, 250, 28);
		panelItem1.add(lblItem1Name);
		
		lblItem1Description = new JLabel("Item 1 description");
		lblItem1Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem1Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem1Description.setBounds(10, 48, 250, 57);
		panelItem1.add(lblItem1Description);
		
		lblItem1Benefit = new JLabel("Item 1 benefit");
		lblItem1Benefit.setBounds(10, 115, 83, 13);
		panelItem1.add(lblItem1Benefit);
		
		lblItem1Price = new JLabel("Item 1 price");
		lblItem1Price.setBounds(10, 138, 83, 13);
		panelItem1.add(lblItem1Price);
		
		btnPurchaseItem1 = new JButton("Buy Item");
		btnPurchaseItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(0);
				
			}
		});
		btnPurchaseItem1.setBounds(175, 126, 85, 37);
		panelItem1.add(btnPurchaseItem1);
		
		//ITEM 2
		panelItem2 = new JPanel();
		panelItem2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem2.setLayout(null);
		panelItem2.setBounds(360, 138, 270, 171);
		window.getContentPane().add(panelItem2);
		
		lblItem2Name = new JLabel("Item 2 name");
		lblItem2Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem2Name.setBounds(10, 10, 250, 28);
		panelItem2.add(lblItem2Name);
		
		lblItem2Description = new JLabel("Item 2 description");
		lblItem2Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem2Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem2Description.setBounds(10, 48, 250, 57);
		panelItem2.add(lblItem2Description);
		
		lblItem2Benefit = new JLabel("item 2 benefit");
		lblItem2Benefit.setBounds(10, 115, 83, 13);
		panelItem2.add(lblItem2Benefit);
		
		lblItem2Price = new JLabel("Item 2 price");
		lblItem2Price.setBounds(10, 138, 83, 13);
		panelItem2.add(lblItem2Price);
		
		btnPurchaseItem2 = new JButton("Buy Item");
		btnPurchaseItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(1);
				
			}
		});
		btnPurchaseItem2.setBounds(175, 126, 85, 37);
		panelItem2.add(btnPurchaseItem2);
		
		//ITEM 3
		panelItem3 = new JPanel();
		panelItem3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem3.setLayout(null);
		panelItem3.setBounds(694, 138, 265, 171);
		window.getContentPane().add(panelItem3);
		
		lblItem3Name = new JLabel("Item 3 name");
		lblItem3Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem3Name.setBounds(10, 10, 245, 28);
		panelItem3.add(lblItem3Name);
		
		lblItem3Description = new JLabel("Item 3 description");
		lblItem3Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem3Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem3Description.setBounds(10, 48, 245, 57);
		panelItem3.add(lblItem3Description);
		
		lblItem3Benefit = new JLabel("Item 3 benefit");
		lblItem3Benefit.setBounds(10, 115, 83, 13);
		panelItem3.add(lblItem3Benefit);
		
		lblItem3Price = new JLabel("Item 3 price");
		lblItem3Price.setBounds(10, 138, 83, 13);
		panelItem3.add(lblItem3Price);
		
		btnPurchaseItem3 = new JButton("Buy Item");
		btnPurchaseItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(2);
				
			}
		});
		btnPurchaseItem3.setBounds(170, 126, 85, 37);
		panelItem3.add(btnPurchaseItem3);
		
		//ITEM 4
		panelItem4 = new JPanel();
		panelItem4.setLayout(null);
		panelItem4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem4.setBounds(25, 332, 270, 171);
		window.getContentPane().add(panelItem4);
		
		lblItem4Name = new JLabel("Item 4 name");
		lblItem4Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem4Name.setBounds(10, 10, 250, 28);
		panelItem4.add(lblItem4Name);
		
		lblItem4Description = new JLabel("Item 4 description");
		lblItem4Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem4Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem4Description.setBounds(10, 48, 250, 57);
		panelItem4.add(lblItem4Description);
		
		lblItem4Benefit = new JLabel("Item 4 benefit");
		lblItem4Benefit.setBounds(10, 115, 83, 13);
		panelItem4.add(lblItem4Benefit);
		
		lblItem4Price = new JLabel("Item 4 price");
		lblItem4Price.setBounds(10, 138, 83, 13);
		panelItem4.add(lblItem4Price);
		
		btnPurchaseItem4 = new JButton("Buy Item");
		btnPurchaseItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(3);
				
			}
		});
		btnPurchaseItem4.setBounds(175, 126, 85, 37);
		panelItem4.add(btnPurchaseItem4);
		
		//ITEM 5
		panelItem5 = new JPanel();
		panelItem5.setLayout(null);
		panelItem5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem5.setBounds(360, 332, 270, 171);
		window.getContentPane().add(panelItem5);
		
		lblItem5Name = new JLabel("Item 5 name");
		lblItem5Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem5Name.setBounds(10, 10, 250, 28);
		panelItem5.add(lblItem5Name);
		
		lblItem5Description = new JLabel("Item 5 description");
		lblItem5Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem5Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem5Description.setBounds(10, 48, 250, 57);
		panelItem5.add(lblItem5Description);
		
		lblItem5Benefit = new JLabel("Item 5 benefit");
		lblItem5Benefit.setBounds(10, 115, 83, 13);
		panelItem5.add(lblItem5Benefit);
		
		lblItem5Price = new JLabel("Item 5 price");
		lblItem5Price.setBounds(10, 138, 83, 13);
		panelItem5.add(lblItem5Price);
		
		btnPurchaseItem5 = new JButton("Buy Item");
		btnPurchaseItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(4);
				
			}
		});
		btnPurchaseItem5.setBounds(175, 126, 85, 37);
		panelItem5.add(btnPurchaseItem5);
		
		//ITEM 6
		panelItem6 = new JPanel();
		panelItem6.setLayout(null);
		panelItem6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem6.setBounds(694, 332, 265, 171);
		window.getContentPane().add(panelItem6);
		
		lblItem6Name = new JLabel("Item 6 name");
		lblItem6Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem6Name.setBounds(10, 10, 245, 28);
		panelItem6.add(lblItem6Name);
		
		lblItem6Description = new JLabel("Item 6 description");
		lblItem6Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem6Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem6Description.setBounds(10, 48, 245, 57);
		panelItem6.add(lblItem6Description);
		
		lblItem6Benefit = new JLabel("Item 6 benefit");
		lblItem6Benefit.setBounds(10, 115, 83, 13);
		panelItem6.add(lblItem6Benefit);
		
		lblItem6Price = new JLabel("Item 6 price");
		lblItem6Price.setBounds(10, 138, 83, 13);
		panelItem6.add(lblItem6Price);
		
		btnPurchaseItem6 = new JButton("Buy Item");
		btnPurchaseItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				purchaseButtonClicked(5);
				
			}
		});
		btnPurchaseItem6.setBounds(170, 126, 85, 37);
		panelItem6.add(btnPurchaseItem6);
		
		lblDialougeBox = new JLabel("");
		lblDialougeBox.setForeground(Color.RED);
		lblDialougeBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDialougeBox.setBounds(356, 88, 564, 25);
		window.getContentPane().add(lblDialougeBox);
		
		updateAllItemInfoPanels();
		updateMoneyLabel();
		
		
		
		
		
	}
}
