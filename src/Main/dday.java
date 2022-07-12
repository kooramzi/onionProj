package Main;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class dday extends JFrame {
	static Font f1=new Font("���ʷҹ���", Font.PLAIN, 20);;
	static Calendar now = Calendar.getInstance();
	static Calendar d_day = Calendar.getInstance();



	public static int getDday(int year, int month, int day) {

		try {
			// ��¥ ����
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
		String t1 = "���ó�¥ : " + now.get(Calendar.YEAR) + " �� " + (now.get(Calendar.MONTH) + 1) + " �� "
				+ now.get(Calendar.DAY_OF_MONTH) + " ��";
		lb1.setText(t1);

		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100, 150, 300, 40);
		tf1.setFont(f1);
		String t2 = " �������� " +  getDday(2022, Calendar.AUGUST, 13) + "�� ���Ҿ��.";
		tf1.setText(t2);

		add(lb1);
		add(tf1);
		setTitle("������ D-DAY");
		setSize(500, 400);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new dday();

	}
}