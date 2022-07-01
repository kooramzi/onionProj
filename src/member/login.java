package member;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.OnionMain;

public class login implements ActionListener  {

	private userDAO dao;
	private TextField tfmsg;
	private TextField id,pw;

	public login() {
		dao = new userDAO();
		JFrame f = new JFrame("��Ͼ� - �α���");
		f.setSize(900, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImgPanel panel_1 = new ImgPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 884, 661);
		f.getContentPane().add(panel_1);
		
		id = new TextField(10);
		id.setBounds(429, 512, 145, 23);
		panel_1.add(id);
		
		JLabel lid = new JLabel("ID :", Label.RIGHT);
		lid.setBounds(392, 512, 32, 23);
		lid.setOpaque(false); //�� ���� ����
		panel_1.add(lid);
		
		JLabel lpw = new JLabel("Password :", Label.RIGHT);
		lpw.setBounds(348, 541, 76, 23);
		panel_1.add(lpw);
		
		pw = new TextField(10);
		pw.setEchoChar('*');
		pw.setBounds(429, 541, 145, 23);
		panel_1.add(pw);
		
		JButton loginb = new JButton("�α���");
//		loginb.setOpaque(false);
		loginb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(id.getText().equals("")) {
					tfmsg.setText("���̵� ��Ȯ�� �Է��ϼ���.");
				} else if(pw.getText().equals("")) {
					tfmsg.setText("��й�ȣ�� ��Ȯ�� �Է��ϼ���.");
				} else {

					loginVo vo = new loginVo(id.getText(),pw.getText());
					boolean b = dao.list(vo);
					if(b==true) {
						new OnionMain();
						f.setVisible(false);
					}else 
						tfmsg.setText("�α��� ����! ȸ�������� �����ϴ�.");
				}
			}
		});
		
		loginb.setBounds(400, 570, 80, 23);
		panel_1.add(loginb);
		
		
		JButton joinb = new JButton("ȸ������");
		joinb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new join();
			}
			
		});
		joinb.setBounds(500, 570, 85, 23);
		panel_1.add(joinb);
		
		
		tfmsg = new TextField(40);
		tfmsg.setFocusable(false);
		tfmsg.setEditable(false);
		tfmsg.setBounds(308, 606, 304, 23);
		panel_1.add(tfmsg);
		f.setVisible(true);
		
		f.getContentPane().add(panel_1);
		
		
	}
	
	class ImgPanel extends JPanel {
		   private ImageIcon icon = new ImageIcon("E:/work/SubCal/src/memberimg/��Ͼ����.png");
		   private Image img = icon.getImage(); // �̹��� ��ü

		   public void paintComponent(Graphics g) {
		      super.paintComponent(g);
		      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		   }
		} 

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		new login();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
