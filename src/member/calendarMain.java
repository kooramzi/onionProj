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
	
	Font fnt = new Font("맑은 고딕", Font.BOLD,20);
	Font fnt2 = new Font("맑은 고딕", Font.PLAIN,15);
	
	//상단
	JPanel selectPane = new JPanel();
	JButton prevBtn = new JButton("◀");
	JButton nextBtn = new JButton("▶");
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	JLabel yearLB = new JLabel("년");
	JLabel monthLB = new JLabel("월");
	
	//중간
	JPanel centerPane = new JPanel(new BorderLayout());
	JPanel titlePane = new JPanel(new GridLayout(1,7));
	String [] title  = {"일","월","화","수","목","금","토"};
	JPanel dayPane = new JPanel(new GridLayout(0,7));
	
	//달력 데이터
	Calendar date;
	int year;
	int month;
	
	
	public calendarMain() {
		super("달력");
		date = Calendar.getInstance();
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		selectPane.setBorder(null);
	
		//상단
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
		
		//현재 년 월 세팅
		setYear();
		setMonth();
		
		//title호출
		setCalendarTitle();
		centerPane.add(BorderLayout.NORTH,titlePane);
		getContentPane().add(centerPane);
		
		//날짜 만들기
		centerPane.add(dayPane);
		setDay();
	
		//기능이벤트 추가
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	
		//jframe 설정
		setSize(345,465);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	
	
	private void setDay() {
		Calendar date = Calendar.getInstance(); //오늘 날짜+시간
		date.set(year, month-1, 1); //day를 1로 셋팅
		int week = date.get(Calendar.DAY_OF_WEEK);
		int lastDay = date.getActualMaximum(Calendar.DATE); //최대로 가질 수 이는 마지막날 값
		//공백
		for(int s = 1; s<week; s++) {
			JLabel lbl = new JLabel(" ");//들여쓰기
			dayPane.add(lbl);
		}
		//날짜추가
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

	//콤보박스 클릭이벤트
	@Override
	public void itemStateChanged(ItemEvent e) {
		year =(int)yearCombo.getSelectedItem();
		month =(int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false); //패널닫고
		dayPane.removeAll(); //원래 있는 날짜 지우고
		setDay(); //날짜처리 함수 호출한뒤
		dayPane.setVisible(true); //다시 셋팅된패널을 보여준다.
	}

	//버튼 클릭이벤트
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
		if(month==12) { //12월일때는 년도를 추가시키고 월을 1로 바꿈
			year++;
			month = 1;
		}else
			month++;
	}




	private void prevMonth() {
		if(month==1) { //1월일때 전월클릭시 12월로 떨어지면서 전년도로 바꾼다
			year--;
			month = 12;
		}else
			month--;
	}


	//년월이벤트 등록해제
	private void setDayReset() {
		yearCombo.removeItemListener(this); //등록 이벤트 해제 후 
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year); //year에 해당하는 값 가져온다
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false); //패널닫고
		dayPane.removeAll(); //원래 있는 날짜 지우고
		setDay(); //날짜처리 함수 호출한뒤
		dayPane.setVisible(true); //다시 셋팅된패널을 보여준다.
		
		yearCombo.addItemListener(this); //다시 이벤트 등록
		monthCombo.addItemListener(this); 
	}




	public static void main(String[] args) {
		new calendarMain();
	}


}
