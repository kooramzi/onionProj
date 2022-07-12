package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import calendar.buttonCal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;

public class OnionMain {

	private JFrame frame;
	private JTable subTable;
	private JTable livTable;
	private subscriptionDAO dao;
	private JTable table;
	private JPanel calPanel;
	private JPanel calPanel_1;
	private JTextField totalTextField;
	private Panel yearmenu = null;
	private Panel daymenu = null;
	private Choice choice = null;
	private Choice choice1 = null;
	private Label label = null;
	private Label label1 = null;
	private Button[] bt2 = new Button[42];
	private int year=0;
	private int month=0;

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

	public OnionMain() {
		initialize();
		new buttonCal();
	
	}

	private void initialize() {
		
		dao = new subscriptionDAO(); 
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		calPanel_1 = new JPanel();
		calPanel_1.setBounds(12, 10, 363, 641);
		frame.getContentPane().add(calPanel_1);
		calPanel_1.setLayout(null);
		
		totalTextField = new JTextField();
		totalTextField.setBounds(28, 72, 254, 56);
		calPanel_1.add(totalTextField);
		totalTextField.setColumns(10);
		totalTextField.setEditable(false);	
		
		JButton show_tb = new JButton("SHOW");
		show_tb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
//		JToggleButton hide_tb = new JToggleButton("HIDE");

//		show_tb.setVisible(true);
//		hide_tb.setVisible(false);

		show_tb.setFont(new Font("굴림", Font.PLAIN, 5));
		show_tb.setBounds(304, 140, 47, 23);
		show_tb.setToolTipText("금액 보이기");
		show_tb.setBorderPainted(false);
//		hide_tb.setFont(new Font("굴림", Font.PLAIN, 5));
//		hide_tb.setBounds(319, 140, 32, 23);
//		hide_tb.setToolTipText("금액 숨기기");


		calPanel_1.add(show_tb);
//		calPanel_1.add(hide_tb);
	
		
		JLabel callb = new JLabel("\uC774\uBC88\uB2EC \uC9C0\uCD9C\uCD1D\uC561");
		callb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		callb.setBounds(12, 10, 187, 40);
		calPanel_1.add(callb);
		
		JButton calMoreBtn = new JButton(">");
		calMoreBtn.setBorderPainted(false);
		calMoreBtn.setFont(new Font("굴림", Font.BOLD, 15));
		calMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		calMoreBtn.setBounds(304, 24, 47, 23);
		calPanel_1.add(calMoreBtn);
		frame.getContentPane().add(calPanel_1);
		
		JPanel calpane = new JPanel();
		calPanel_1.add(calpane);
		calpane.setLayout(new BorderLayout(0, 0));
		calpane.setBounds(12, 185, 339, 450);
		calpane.add(getYear(), BorderLayout.NORTH);
		calpane.add(getDay(), BorderLayout.CENTER);
		
		
		JPanel subPanel = new JPanel();
		subPanel.setBounds(387, 10, 485, 315);
		frame.getContentPane().add(subPanel);
		subPanel.setLayout(null);
		
		JLabel sublb = new JLabel("\uB0B4 \uC815\uAE30\uAD6C\uB3C5 \uBAA8\uC544\uBCF4\uAE30");
		sublb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		sublb.setBounds(12, 10, 267, 47);
		subPanel.add(sublb);
		
		JButton subMoreBtn = new JButton(">");
		subMoreBtn.setBorderPainted(false);
		subMoreBtn.setFont(new Font("굴림", Font.BOLD, 15));
		subMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		subMoreBtn.setBounds(415, 27, 47, 23);
		subPanel.add(subMoreBtn);
		
		JScrollPane subScrollPane = new JScrollPane();
		subScrollPane.setBounds(12, 67, 461, 238);
		subPanel.add(subScrollPane);
		
		
		String[] sHeader = new String[] {"번호","구분","항목"};
		String[][] sContents = dao.selectSub(new subscriptionVo());
		subTable = new JTable(sContents,sHeader);
		subScrollPane.setViewportView(subTable);
		
	
		JPanel livPanel = new JPanel();
		livPanel.setBounds(387, 335, 485, 315);
		frame.getContentPane().add(livPanel);
		livPanel.setLayout(null);
		
		
		JLabel livlb = new JLabel("\uB0B4 \uC0DD\uD65C\uC9C0\uCD9C \uBAA8\uC544\uBCF4\uAE30");
		livlb.setBounds(12, 10, 267, 47);
		livPanel.add(livlb);
		livlb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		
		JButton livMoreBtn = new JButton(">");
		livMoreBtn.setBorderPainted(false);
		livMoreBtn.setFont(new Font("굴림", Font.BOLD, 15));
		livMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		livMoreBtn.setBounds(416, 27, 57, 23);
		livPanel.add(livMoreBtn);
		
		JScrollPane livScrollPane = new JScrollPane();
		livScrollPane.setBounds(12, 67, 461, 238);
		livPanel.add(livScrollPane);
		
		String[] lHeader = new String[] {"번호","구분","항목"};
		String[][] lContents = dao.selectLiv(new subscriptionVo());
		livTable = new JTable(lContents,lHeader);
		livScrollPane.setViewportView(livTable);
		
		frame.setVisible(true);
		
	}
	private Panel getYear() {
		if (yearmenu == null) {
			label1 = new Label();
			label1.setText("년");
			label = new Label();
			label.setText("월");
			yearmenu = new Panel();
			yearmenu.setLayout(new FlowLayout());
			yearmenu.add(getChoice(), null);
			yearmenu.add(label1, null);
			yearmenu.add(getChoice1(), null);
			yearmenu.add(label, null);
		}
		return yearmenu;
	}

	/**
	 * This method initializes panel1	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getDay() {
		if (daymenu == null) {
			daymenu= new Panel();
			daymenu.setLayout(new GridLayout(7,7));	
			Button[] bt1 = new Button[7];
			String[] day = {"일","월","화","수","목","금","토"};
			for(int i=0 ; i<7 ; i++){
				bt1[i] = new Button(day[i]);
				daymenu.add(bt1[i]);
			}
			
			bt2 = new Button[42];
			
			for(int i=0 ; i<42 ; i++){
				bt2[i] = new Button("");
				daymenu.add(bt2[i]);
			}

			year = Integer.parseInt(choice.getSelectedItem());
			month = Integer.parseInt(choice1.getSelectedItem());
			
			int startDay = 0;
			int endDay = 0;
			
			java.util.Calendar sDay=java.util.Calendar.getInstance();
			java.util.Calendar eDay=java.util.Calendar.getInstance();
			
			sDay.set(year,month-1,1);
			eDay.set(year, month,1);
			eDay.add(java.util.Calendar.DATE, -1);
			
			startDay=sDay.get(java.util.Calendar.DAY_OF_WEEK);
			endDay=eDay.get(java.util.Calendar.DATE);
			
            for(int i=1; i<=endDay ; i++){
            	bt2[i+startDay-2].setLabel(i+"");
            }
		}
		return daymenu;
	}
	/**
	 * This method initializes choice	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.add("2024");
			choice.add("2022");
			choice.add("2023");

			choice.select(1);
		}
		return choice;
	}

	/**
	 * This method initializes choice1	
	 * 	
	 * @return java.awt.Choice	
	 */
	@SuppressWarnings("deprecation")
	private Choice getChoice1() {
		if (choice1 == null) {
			choice1 = new Choice();

			choice1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
	
					for(int i=0 ; i<42 ; i++){
						bt2[i].setLabel("");
					}
					
					year = Integer.parseInt(choice.getSelectedItem());
					month = Integer.parseInt(choice1.getSelectedItem());
					
					int startDay = 0;
					int endDay = 0;
					
					java.util.Calendar sDay=java.util.Calendar.getInstance();
					java.util.Calendar eDay=java.util.Calendar.getInstance();
					
					sDay.set(year,month-1,1);
					eDay.set(year, month,1);
					eDay.add(java.util.Calendar.DATE, -1);
					
					startDay=sDay.get(java.util.Calendar.DAY_OF_WEEK);
					endDay=eDay.get(java.util.Calendar.DATE);

		            for(int i=1; i<=endDay ; i++){
		            	bt2[i+startDay-2].setLabel(i+"");
		            }
				}
			});
			choice1.add("1");
			choice1.add("2");
			choice1.add("3");
			choice1.add("4");
			choice1.add("5");
			choice1.add("6");
			choice1.add("7");
			choice1.add("8");
			choice1.add("9");
			choice1.add("10");
			choice1.add("11");
			choice1.add("12");

			choice1.select(4);
			
		}
		return choice1;
	}


}
