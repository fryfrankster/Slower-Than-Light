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

public class OutpostScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;


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
		btnViewInventory.setBounds(535, 61, 221, 55);
		window.getContentPane().add(btnViewInventory);
		
		JLabel lblMoney = new JLabel("Money: $");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoney.setBounds(199, 91, 102, 22);
		window.getContentPane().add(lblMoney);
		
		//ITEM 1
		JPanel panelItem1 = new JPanel();
		panelItem1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem1.setBounds(25, 138, 221, 171);
		window.getContentPane().add(panelItem1);
		panelItem1.setLayout(null);
		
		JLabel lblItem1Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(0).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(0).getType().toUpperCase());
		lblItem1Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem1Name.setBounds(10, 10, 201, 28);
		panelItem1.add(lblItem1Name);
		
		JLabel lblItem1Description1Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(0).getDescription());
		lblItem1Description1Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem1Description1Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem1Description1Description.setBounds(10, 48, 201, 57);
		panelItem1.add(lblItem1Description1Description);
		
		JLabel lblItem1Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(0).getBenefit()));
		lblItem1Benefit.setBounds(10, 115, 83, 13);
		panelItem1.add(lblItem1Benefit);
		
		JLabel lblItem1Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(0).getPrice()));
		lblItem1Price.setBounds(10, 138, 83, 13);
		panelItem1.add(lblItem1Price);
		
		//ITEM 2
		JPanel panelItem2 = new JPanel();
		panelItem2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem2.setLayout(null);
		panelItem2.setBounds(280, 138, 221, 171);
		window.getContentPane().add(panelItem2);
		
		JLabel lblItem2Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(1).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(1).getType().toUpperCase());
		lblItem2Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem2Name.setBounds(10, 10, 201, 28);
		panelItem2.add(lblItem2Name);
		
		JLabel lblItem2Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(1).getDescription());
		lblItem2Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem2Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem2Description.setBounds(10, 48, 201, 57);
		panelItem2.add(lblItem2Description);
		
		JLabel lblItem2Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(1).getBenefit()));
		lblItem2Benefit.setBounds(10, 115, 83, 13);
		panelItem2.add(lblItem2Benefit);
		
		JLabel lblItem2Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(1).getPrice()));
		lblItem2Price.setBounds(10, 138, 83, 13);
		panelItem2.add(lblItem2Price);
		
		//ITEM 3
		JPanel panelItem3 = new JPanel();
		panelItem3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem3.setLayout(null);
		panelItem3.setBounds(535, 138, 221, 171);
		window.getContentPane().add(panelItem3);
		
		JLabel lblItem3Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(2).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(2).getType().toUpperCase());
		lblItem3Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem3Name.setBounds(10, 10, 201, 28);
		panelItem3.add(lblItem3Name);
		
		JLabel lblItem3Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(2).getDescription());
		lblItem3Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem3Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem3Description.setBounds(10, 48, 201, 57);
		panelItem3.add(lblItem3Description);
		
		JLabel lblItem3Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(2).getBenefit()));
		lblItem3Benefit.setBounds(10, 115, 83, 13);
		panelItem3.add(lblItem3Benefit);
		
		JLabel lblItem3Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(2).getPrice()));
		lblItem3Price.setBounds(10, 138, 83, 13);
		panelItem3.add(lblItem3Price);
		
		//ITEM 4
		JPanel panelItem4 = new JPanel();
		panelItem4.setLayout(null);
		panelItem4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem4.setBounds(25, 332, 221, 171);
		window.getContentPane().add(panelItem4);
		
		JLabel lblItem4Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(3).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(3).getType().toUpperCase());
		lblItem4Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem4Name.setBounds(10, 10, 201, 28);
		panelItem4.add(lblItem4Name);
		
		JLabel lblItem4Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(3).getDescription());
		lblItem4Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem4Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem4Description.setBounds(10, 48, 201, 57);
		panelItem4.add(lblItem4Description);
		
		JLabel lblItem4Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(3).getBenefit()));
		lblItem4Benefit.setBounds(10, 115, 83, 13);
		panelItem4.add(lblItem4Benefit);
		
		JLabel lblItem4Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(3).getPrice()));
		lblItem4Price.setBounds(10, 138, 83, 13);
		panelItem4.add(lblItem4Price);
		
		//ITEM 5
		JPanel panelItem5 = new JPanel();
		panelItem5.setLayout(null);
		panelItem5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem5.setBounds(280, 332, 221, 171);
		window.getContentPane().add(panelItem5);
		
		JLabel lblItem5Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(4).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(4).getType().toUpperCase());
		lblItem5Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem5Name.setBounds(10, 10, 201, 28);
		panelItem5.add(lblItem5Name);
		
		JLabel lblItem5Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(4).getDescription());
		lblItem5Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem5Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem5Description.setBounds(10, 48, 201, 57);
		panelItem5.add(lblItem5Description);
		
		JLabel lblItem5Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(4).getBenefit()));
		lblItem5Benefit.setBounds(10, 115, 83, 13);
		panelItem5.add(lblItem5Benefit);
		
		JLabel lblItem5Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(4).getPrice()));
		lblItem5Price.setBounds(10, 138, 83, 13);
		panelItem5.add(lblItem5Price);
		
		//ITEM 6
		JPanel panelItem6 = new JPanel();
		panelItem6.setLayout(null);
		panelItem6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelItem6.setBounds(535, 332, 221, 171);
		window.getContentPane().add(panelItem6);
		
		JLabel lblItem6Name = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(5).getName() + " - " + gameEnvironment.getPlanet().getPlanetsItems().get(5).getType().toUpperCase());
		lblItem6Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItem6Name.setBounds(10, 10, 201, 28);
		panelItem6.add(lblItem6Name);
		
		JLabel lblItem6Description = new JLabel(gameEnvironment.getPlanet().getPlanetsItems().get(5).getDescription());
		lblItem6Description.setVerticalAlignment(SwingConstants.TOP);
		lblItem6Description.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem6Description.setBounds(10, 48, 201, 57);
		panelItem6.add(lblItem6Description);
		
		JLabel lblItem6Benefit = new JLabel("Benefit: +" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(5).getBenefit()));
		lblItem6Benefit.setBounds(10, 115, 83, 13);
		panelItem6.add(lblItem6Benefit);
		
		JLabel lblItem6Price = new JLabel("Price: $" + String.valueOf(gameEnvironment.getPlanet().getPlanetsItems().get(5).getPrice()));
		lblItem6Price.setBounds(10, 138, 83, 13);
		panelItem6.add(lblItem6Price);
		
		
		
		
		
		
	}
}
