package calendar;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;


public class buttonCal extends JFrame {

	private JFrame f;
	private Panel p;
	private Panel yearmenu = null;
	private Panel daymenu = null;
	private Choice choice = null;
	private Choice choice1 = null;
	private Label label = null;
	private Label label1 = null;
	private Button[] bt2 = new Button[42];
	private int year=0;
	private int month=0;
	/**
	 * This method initializes panel	
	 * 	
	 * @return java.awt.Panel	
	 */
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
			choice.add("2023");
			choice.add("2022");

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


	public static void main(String[] args) {
		 new buttonCal();
		
	}


	public buttonCal() {
		super();
		initialize();
	}


	private void initialize() {
		
		f = new JFrame();
		p = new Panel();
		
		p.setSize(339, 450);
		f.setBounds(12,185,339,450);
	
		p.add(getYear(), BorderLayout.NORTH);
		p.add(getDay(), BorderLayout.CENTER);
		
	}

}  
