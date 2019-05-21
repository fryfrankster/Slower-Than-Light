package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.Event;

import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameSetupScreenOriginal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblChooseYourCrew;
	private JLabel label;
	private JLabel lblChooseHowMany;
	private JLabel lblSlowerThanLight;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetupScreenOriginal window = new GameSetupScreenOriginal();
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
	public GameSetupScreenOriginal() {
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(437, 301, 332, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(437, 444, 332, 47);
		frame.getContentPane().add(textField_1);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setToolTipText("");
		slider.setValue(3);
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 16));
		slider.setBounds(414, 602, 378, 60);
		frame.getContentPane().add(slider);
		
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNext.setBounds(538, 695, 127, 47);
		frame.getContentPane().add(btnNext);
		
		JLabel lblChooseYourShip = new JLabel("Choose your ship name");
		lblChooseYourShip.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourShip.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourShip.setBounds(475, 261, 256, 30);
		frame.getContentPane().add(lblChooseYourShip);
		
		lblChooseYourCrew = new JLabel("Choose your crew name");
		lblChooseYourCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourCrew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseYourCrew.setBounds(475, 400, 256, 30);
		frame.getContentPane().add(lblChooseYourCrew);
		
		label = new JLabel("");
		label.setBounds(139, 512, 46, 13);
		frame.getContentPane().add(label);
		
		lblChooseHowMany = new JLabel("Choose how many days you want to play for\r\n");
		lblChooseHowMany.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseHowMany.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseHowMany.setBounds(372, 562, 463, 30);
		frame.getContentPane().add(lblChooseHowMany);
		
		lblSlowerThanLight = new JLabel("Slower Than Light");
		lblSlowerThanLight.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlowerThanLight.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblSlowerThanLight.setBounds(176, 77, 835, 132);
		frame.getContentPane().add(lblSlowerThanLight);
	}
}
