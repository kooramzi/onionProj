package Main;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class cal_jtogglebtn {

	private JToggleButton show_tb = new JToggleButton("SHOW");
	private JToggleButton hide_tb = new JToggleButton("HIDE");
	
	private ButtonGroup bg = new ButtonGroup();
	private GridLayout gl = new GridLayout(1,2,5,5);
	
	public cal_jtogglebtn() {
		
		this.init();
		this.start();
		this.setResizable(false);
		this.setVisible(true);
		
		show_tb.setFont(new Font("±¼¸²", Font.PLAIN, 8));
		show_tb.setBounds(274, 140, 32, 23);
		calPanel.add(show_tb);
		
		
		hide_tb.setFont(new Font("±¼¸²", Font.PLAIN, 8));
		hide_tb.setBounds(319, 140, 32, 23);
		calPanel.add(hide_tb);
	}
	
	private void init() {
		
		
		show_tb.setToolTipText("±Ý¾× º¸ÀÌ±â");
		bg.add(show_tb);
		
		hide_tb.setToolTipText("±Ý¾× ¼û±â±â");
		bg.add(hide_tb);
		
		hide_tb.setSelectedIcon(show_tb);
		
	}
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
