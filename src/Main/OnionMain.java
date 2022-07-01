package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OnionMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnionMain window = new OnionMain();
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
	public OnionMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setBounds(12, 10, 363, 641);
		frame.getContentPane().add(calPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(387, 10, 485, 315);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(387, 335, 485, 315);
		frame.getContentPane().add(panel_2);
		frame.setVisible(true);
	}
}
