package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class calendarMain extends JFrame implements ItemListener,ActionListener{
	
	Font fnt = new Font("���� ���", Font.BOLD,20);
	Font fnt2 = new Font("���� ���", Font.PLAIN,15);
	
	//���
	JPanel selectPane = new JPanel();
	JButton prevBtn = new JButton("��");
	JButton nextBtn = new JButton("��");
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	JLabel yearLB = new JLabel("��");
	JLabel monthLB = new JLabel("��");
	
	//�߰�
	JPanel centerPane = new JPanel(new BorderLayout());
	JPanel titlePane = new JPanel(new GridLayout(1,7));
	String [] title  = {"��","��","ȭ","��","��","��","��"};
	JPanel dayPane = new JPanel(new GridLayout(0,7));
	
	//�޷� ������
	Calendar date;
	int year;
	int month;
	
	
	public calendarMain() {
		super("�޷�");
		date = Calendar.getInstance();
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		selectPane.setBorder(null);
	
		//���
		selectPane.setBackground(new Color(46, 139, 87));
		prevBtn.setForeground(new Color(255, 255, 255));
		selectPane.add(prevBtn);  prevBtn.setFont(fnt);
		selectPane.add(yearCombo);  yearCombo.setFont(fnt);
		selectPane.add(yearLB);  yearLB.setFont(fnt2);
		selectPane.add(monthCombo);  monthCombo.setFont(fnt);
		selectPane.add(monthLB);  monthLB.setFont(fnt2);
		nextBtn.setForeground(new Color(255, 255, 255));
		selectPane.add(nextBtn);  nextBtn.setFont(fnt);
		
		getContentPane().add(BorderLayout.NORTH, selectPane);
		
		//���� �� �� ����
		setYear();
		setMonth();
		
		//titleȣ��
		setCalendarTitle();
		centerPane.add(BorderLayout.NORTH,titlePane);
		getContentPane().add(centerPane);
		
		//��¥ �����
		centerPane.add(dayPane);
		setDay();
	
		//����̺�Ʈ �߰�
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	
		//jframe ����
		setSize(345,465);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	
	
	private void setDay() {
		Calendar date = Calendar.getInstance(); //���� ��¥+�ð�
		date.set(year, month-1, 1); //day�� 1�� ����
		int week = date.get(Calendar.DAY_OF_WEEK);
		int lastDay = date.getActualMaximum(Calendar.DATE); //�ִ�� ���� �� �̴� �������� ��
		//����
		for(int s = 1; s<week; s++) {
			JLabel lbl = new JLabel(" ");//�鿩����
			dayPane.add(lbl);
		}
		//��¥�߰�
		for(int day = 1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day),JLabel.CENTER);
			lbl.setFont(fnt2);
			date.set(Calendar.DATE, day);
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
	
	}


	private void setCalendarTitle() {
		for(int i =0; i<title.length;i++) {
			JLabel lbl = new JLabel(title[i],JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}

	private void setYear() {
		for(int i =year-50; i<=year+20; i++) {
			yearCombo.addItem(i);
		}
		yearCombo.setSelectedItem(year);		
	}

	private void setMonth() {
		for(int i =1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);	
	}

	//�޺��ڽ� Ŭ���̺�Ʈ
	@Override
	public void itemStateChanged(ItemEvent e) {
		year =(int)yearCombo.getSelectedItem();
		month =(int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false); //�гδݰ�
		dayPane.removeAll(); //���� �ִ� ��¥ �����
		setDay(); //��¥ó�� �Լ� ȣ���ѵ�
		dayPane.setVisible(true); //�ٽ� ���õ��г��� �����ش�.
	}

	//��ư Ŭ���̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==prevBtn) {
			prevMonth();
			setDayReset();
		} else if (obj==nextBtn) {
			nextMonth();
			setDayReset();
			
		}
		
	}

	private void nextMonth() {
		if(month==12) { //12���϶��� �⵵�� �߰���Ű�� ���� 1�� �ٲ�
			year++;
			month = 1;
		}else
			month++;
	}




	private void prevMonth() {
		if(month==1) { //1���϶� ����Ŭ���� 12���� �������鼭 ���⵵�� �ٲ۴�
			year--;
			month = 12;
		}else
			month--;
	}


	//����̺�Ʈ �������
	private void setDayReset() {
		yearCombo.removeItemListener(this); //��� �̺�Ʈ ���� �� 
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year); //year�� �ش��ϴ� �� �����´�
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false); //�гδݰ�
		dayPane.removeAll(); //���� �ִ� ��¥ �����
		setDay(); //��¥ó�� �Լ� ȣ���ѵ�
		dayPane.setVisible(true); //�ٽ� ���õ��г��� �����ش�.
		
		yearCombo.addItemListener(this); //�ٽ� �̺�Ʈ ���
		monthCombo.addItemListener(this); 
	}




	public static void main(String[] args) {
		new calendarMain();
	}


}
