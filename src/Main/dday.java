package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class dday extends JFrame {
	static Font f1=new Font("함초롬바탕", Font.PLAIN, 20);;
	static Font f2=new Font("함초롬바탕", Font.PLAIN, 15);;
	static Calendar now = Calendar.getInstance();
	static Calendar d_day = Calendar.getInstance();



	public static int getDday(int year, int month, int day) {

		try {
			// 날짜 셋팅
			d_day.set(year, month, day);

			long l_now = now.getTimeInMillis() / (24 * 60 * 60 * 1000);
			long l_dday = d_day.getTimeInMillis() / (24 * 60 * 60 * 1000);
			long substract = l_now - l_dday;

			return (int) substract;

		} catch (Exception e) {
			return -1;
		}
	}
	
	dday() {
		JLabel lb1 = new JLabel();
		lb1.setBounds(100, 100, 300, 40);
		lb1.setFont(f1);
		String t1 = "오늘은 " + now.get(Calendar.YEAR) + " 년 " + (now.get(Calendar.MONTH) + 1) + " 월 "
				+ now.get(Calendar.DAY_OF_MONTH) + " 일 입니다.";
		lb1.setText(t1);

		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100, 150, 300, 40);
		tf1.setFont(f1);
		String t2 = " 다음 결제일이 " +  getDday(2022, Calendar.AUGUST+1, 13) + "일 남았습니다.";
		tf1.setText(t2);

		JButton bt1 = new JButton("창닫기");
		bt1.setBounds(191, 226, 97, 23);
		bt1.setFont(f2);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bt1.setBorderPainted(false);
		bt1.setContentAreaFilled(false);
		bt1.setFocusPainted(false);
		
		
		add(lb1);
		add(tf1);
		add(bt1);
		setTitle("결제일 D-DAY");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new dday();

	}
}