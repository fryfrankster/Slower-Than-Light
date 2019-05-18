import java.awt.EventQueue;

import javax.swing.JFrame;

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
	}

}
