package member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class join {

	private JFrame frame;
	private JTextField tfid;
	private JTextField tfpw;
	private JTextField tfname;
	private JTextField tfpn;
	private JTextField tfpwch;
	private MemberDAO memberdao;

	String year = "", month = "", day = "";
	String id = "", pw = "", pwch = "", name = "", gen = "", phone = "";

	public join() {
		initialize();
	}

	private void initialize() {
		memberdao = new MemberDAO();
		frame = new JFrame();
		frame.setBounds(100, 100, 410, 514);
		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
	            frame.setVisible(false);
	         }
			
		});
		frame.getContentPane().setLayout(null);
		
		JLabel joinlb = new JLabel("JOIN MEMBER");
		joinlb.setFont(new Font("Arial Black", Font.PLAIN, 36));
		joinlb.setBounds(59, 23, 292, 52);
		frame.getContentPane().add(joinlb);
		
		JLabel pwlb = new JLabel("PW");
		pwlb.setBounds(71, 140, 110, 29);
		frame.getContentPane().add(pwlb);
		
		JLabel namelb = new JLabel("NAME");
		namelb.setBounds(71, 218, 110, 29);
		frame.getContentPane().add(namelb);
		
		JLabel pnlb = new JLabel("PHONE NUMBER");
		pnlb.setBounds(71, 338, 110, 29);
		frame.getContentPane().add(pnlb);
		
		JLabel idlb = new JLabel("ID");
		idlb.setBounds(71, 102, 110, 29);
		frame.getContentPane().add(idlb);
		
		tfid = new JTextField();
		tfid.setBounds(205, 102, 132, 21);
		frame.getContentPane().add(tfid);
		tfid.setColumns(10);
		
		tfpw = new JPasswordField();
		tfpw.setBounds(205, 140, 132, 21);
		frame.getContentPane().add(tfpw);
		tfpw.setColumns(10);
		
		tfname = new JTextField();
		tfname.setBounds(205, 218, 132, 21);
		frame.getContentPane().add(tfname);
		tfname.setColumns(10);
		
		tfpn = new JTextField();
		tfpn.setBounds(205, 338, 132, 21);
		frame.getContentPane().add(tfpn);
		tfpn.setColumns(10);
		
		tfpwch = new JPasswordField();
		tfpwch.setColumns(10);
		tfpwch.setBounds(205, 179, 132, 21);
		frame.getContentPane().add(tfpwch);
		frame.setVisible(true);
		
		
		JButton joinBtn = new JButton("JOIN");
		joinBtn.setForeground(Color.WHITE);
		joinBtn.setBackground(Color.BLACK);
		joinBtn.setBounds(154, 399, 97, 23);
		frame.getContentPane().add(joinBtn);
		
//		JComboBox monthcombo = new JComboBox();
//		monthcombo.setBounds(205, 299, 67, 23);
//		frame.getContentPane().add(monthcombo);
//		
//		JComboBox daycombo = new JComboBox();
//		daycombo.setBounds(284, 299, 53, 23);
//		frame.getContentPane().add(daycombo);
//		
//		JRadioButton rbtn_f = new JRadioButton("Female");
//		rbtn_f.setBounds(205, 258, 67, 23);
//		frame.getContentPane().add(rbtn_f);
//		
//		JRadioButton rbtn_m = new JRadioButton("Male");
//		rbtn_m.setBounds(284, 258, 61, 23);
//		frame.getContentPane().add(rbtn_m);
		
		JLabel pwlb_check = new JLabel("PW(CHECK)");
		pwlb_check.setBounds(71, 179, 110, 29);
		frame.getContentPane().add(pwlb_check);
		
		
		
//		monthcombo = new JComboBox<String>(
//				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" });
//		daycombo = new JComboBox<String>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
//				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
//				"28", "29", "30", "31" });
//		
//		
//		monthcombo.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == monthcombo) {
//					JComboBox monthBox = (JComboBox) e.getSource();
//					month = (String) monthBox.getSelectedItem();
//					System.out.println(month);
//				}
//
//			}
//		});
//		daycombo.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == daycombo) {
//					JComboBox dayBox = (JComboBox) e.getSource();
//					day = (String) dayBox.getSelectedItem();
//					System.out.println(day);
//				}
//			}
//		});
//
//		rbtn_m.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				gen = e.getActionCommand();
//			}
//		});
//
//		rbtn_f.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				gen = e.getActionCommand();
//			}
//		});
		
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = tfpw.getText().equals(tfpwch.getText());
				if( b== true) {
				MemberVo vo =  new MemberVo(tfid.getText(), tfpw.getText(), tfname.getText(), tfpn.getText());
				memberdao.insertMember(vo);
				new successAlert();
				frame.setVisible(false);
				} else {
					new failAlert();
					
				}
					
			}
			
		});
	}
}

