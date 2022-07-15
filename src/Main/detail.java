package Main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class detail {
	private JFrame frame;
	private detailDAO dao;
	
	public detail() {
		dao= new detailDAO();
		dao.detail(OnionMain.paydate);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 339, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(111, 26, 116, 116);
		frame.getContentPane().add(logoPanel);
		
		JLabel titlelb = new JLabel(dao.title);
		titlelb.setHorizontalAlignment(SwingConstants.CENTER);
		titlelb.setBounds(111, 152, 116, 25);
		frame.getContentPane().add(titlelb);
		
		JLabel paydatelb = new JLabel(dao.paydate);
		paydatelb.setBounds(76, 213, 186, 25);
		frame.getContentPane().add(paydatelb);
		
		JLabel feelb = new JLabel("");
		feelb.setBounds(76, 248, 186, 25);
		frame.getContentPane().add(feelb);
		
		JLabel termlb = new JLabel(dao.term);
		termlb.setBounds(76, 283, 186, 25);
		frame.getContentPane().add(termlb);
		
		JLabel cardlb = new JLabel(dao.card_name);
		cardlb.setBounds(76, 318, 186, 25);
		frame.getContentPane().add(cardlb);
		
		JLabel banklb = new JLabel(dao.bank_name);
		banklb.setBounds(76, 353, 186, 25);
		frame.getContentPane().add(banklb);
		
		frame.setVisible(true);
	}

	
}
