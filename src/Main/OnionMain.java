package Main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class OnionMain implements MouseListener, ActionListener {

	JFrame frame;
	private JTable subTable;
	private JTable livTable;
	private subscriptionDAO dao;
	private JTable table;
	private JPanel calPanel;
	private JPanel calPanel_1;
	private JLabel printTotal;
	private Panel yearmenu = null;
	private Panel daymenu = null;
	private Choice choice = null;
	private Choice choice1 = null;
	private Label label = null;
	private Label label1 = null;
	private Button[] bt2 = new Button[42];
	private int year=0;
	private int month=0;
	private int totalfee = 0;
	private ArrayList <subscriptionVo> list;
	private Vector<Object> vector;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private int totalFee;
	static String paydate;

	public static void main(String[] args) {
	 new OnionMain();
		 
	}

	public OnionMain()  {
		dao = new subscriptionDAO(); 
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		calPanel_1 = new JPanel();
		calPanel_1.setBackground(Color.WHITE);
		calPanel_1.setBounds(12, 10, 363, 641);
		frame.getContentPane().add(calPanel_1);
		calPanel_1.setLayout(null);
		
		
		printTotal = new JLabel(Integer.toString(dao.totalFee(new subscriptionVo())));
		printTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		printTotal.setBounds(28, 72, 192, 56);
		printTotal.setVerticalTextPosition(0); //center
		printTotal.setHorizontalTextPosition(SwingConstants.RIGHT); //left
		printTotal.setFont(new Font("arial", Font.ITALIC, 50));
		calPanel_1.add(printTotal);
		
		
		
		JButton show_bt = new JButton("금액숨기기");
		show_bt.setBorderPainted(false);
		show_bt.setContentAreaFilled(false);
		show_bt.setFocusPainted(false);
		
		show_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(show_bt.getText().equals("금액숨기기")) {
					printTotal.setVisible(false);
					show_bt.setText("금액보이기");
				} else if (show_bt.getText().equals("금액보이기")) {
					printTotal.setVisible(true);
					show_bt.setText("금액숨기기");
				}
			} 
		});

		show_bt.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		show_bt.setBounds(253, 143, 98, 32);
		calPanel_1.add(show_bt);

		
		JLabel callb = new JLabel("\uC774\uBC88\uB2EC \uC9C0\uCD9C\uCD1D\uC561");
		callb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		callb.setBounds(12, 10, 187, 40);
		calPanel_1.add(callb);
		
		JButton calMoreBtn = new JButton(":");
		calMoreBtn.setBorderPainted(false);
		calMoreBtn.setContentAreaFilled(false);
		calMoreBtn.setFocusPainted(false);
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
		
		JLabel wonlb = new JLabel("\uC6D0 / ");
		wonlb.setHorizontalAlignment(SwingConstants.CENTER);
		wonlb.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		wonlb.setBounds(225, 96, 47, 23);
		calPanel_1.add(wonlb);
		
		JLabel cntlb = new JLabel("\uAC74");
		cntlb.setHorizontalAlignment(SwingConstants.CENTER);
		cntlb.setFont(new Font("함초롬바탕", Font.BOLD, 16));
		cntlb.setBounds(314, 96, 25, 23);
		calPanel_1.add(cntlb);
		
		JLabel cnt = new JLabel(Integer.toString(dao.cnt(new subscriptionVo())));
		cnt.setVerticalAlignment(SwingConstants.BOTTOM);
		cnt.setHorizontalAlignment(SwingConstants.RIGHT);
		cnt.setFont(new Font("함초롬바탕", Font.PLAIN, 22));
		cnt.setBounds(273, 83, 36, 40);
		calPanel_1.add(cnt);
		
		
		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.WHITE);
		subPanel.setBounds(387, 10, 485, 315);
		frame.getContentPane().add(subPanel);
		subPanel.setLayout(null);
		
		JLabel sublb = new JLabel("\uB0B4 \uC815\uAE30\uAD6C\uB3C5 \uBAA8\uC544\uBCF4\uAE30");
		sublb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		sublb.setBounds(12, 10, 267, 47);
		subPanel.add(sublb);
	
		
		JScrollPane subScrollPane = new JScrollPane();
		subScrollPane.setBounds(12, 67, 461, 238);
		subPanel.add(subScrollPane);
		
		String[] sHeader = new String[] {"구분","항목","요금"};
		Object[][] sContents = dao.selectSub(new subscriptionVo());
		subTable = new JTable(sContents,sHeader);
	
        model = new DefaultTableModel(sContents, sHeader) {
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        }; 
      
        subTable.setModel(model);
        subTable.getRowCount();
        subTable.setSelectionBackground(Color.BLUE);
		subTable.setSelectionForeground(Color.white);
		subTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
                JTable t = (JTable)e.getSource();
                if(e.getClickCount()==2) {
                	new dday();
                	
                 } 
             }
		});
		

		subScrollPane.setViewportView(subTable);
		
	
		JPanel livPanel = new JPanel();
		livPanel.setBackground(Color.WHITE);
		livPanel.setBounds(387, 335, 485, 315);
		frame.getContentPane().add(livPanel);
		livPanel.setLayout(null);
		
		
		JLabel livlb = new JLabel("\uB0B4 \uC0DD\uD65C\uC9C0\uCD9C \uBAA8\uC544\uBCF4\uAE30");
		livlb.setBounds(12, 10, 267, 47);
		livPanel.add(livlb);
		livlb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		
		
		JScrollPane livScrollPane = new JScrollPane();
		livScrollPane.setBounds(12, 67, 461, 238);
		livPanel.add(livScrollPane);
		
		String[] lHeader = new String[] {"구분","항목","요금"};
		Object[][] lContents = dao.selectLiv(new subscriptionVo());
		livTable = new JTable(lContents,lHeader);
	
        model1 = new DefaultTableModel(lContents, lHeader) {
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        }; 
        
        livTable.setModel(model1);
        livTable.getRowCount();
        livTable.setSelectionBackground(Color.BLUE);
        livTable.setSelectionForeground(Color.white);
        livTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
                JTable t = (JTable)e.getSource();
                if(e.getClickCount()==2) {
                	new dday();
                	
                 } 
             }
		});
      
      
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
			yearmenu.setBackground(Color.WHITE);
			yearmenu.setLayout(new FlowLayout());
			yearmenu.add(getChoice(), null);
			yearmenu.add(label1, null);
			yearmenu.add(getChoice1(), null);
			yearmenu.add(label, null);
		}
		return yearmenu;
	}

	
	private Panel getDay() {
		if (daymenu == null) {
			daymenu= new Panel();
			daymenu.setBackground(Color.WHITE);
			daymenu.setLayout(new GridLayout(7,7));	
			JLabel[] bt1 = new JLabel[7];
			String[] day = {"일","월","화","수","목","금","토"};
			for(int i=0 ; i<7 ; i++){
				bt1[i] = new JLabel(day[i]);
				bt1[i].setHorizontalAlignment(SwingConstants.CENTER);
				bt1[i].setFont(new Font("함초롬바탕", Font.PLAIN, 12));
				daymenu.add(bt1[i]);
				
			}
			
			bt2 = new Button[42];
			
			for(int i=0 ; i<42 ; i++){
				bt2[i] = new Button("");
				daymenu.add(bt2[i]);
				bt2[i].addActionListener(this);
				bt2[i].setFont(new Font("함초롬바탕", Font.PLAIN, 12));
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

			choice1.select(6);
			
		}
		return choice1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<bt2.length; i++) {
			paydate = year+"-"+month+"-"+bt2[i].getLabel();
			if(e.getSource()==bt2[i]) {
				System.out.println(paydate);
				
				new detail();
			}
		}
	}
}
