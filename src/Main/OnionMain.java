package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import subscription.subscriptionDAO;
import subscription.subscriptionVo;

import javax.swing.SwingConstants;
import java.awt.Color;

public class OnionMain {

	private JFrame frame;
	private JTable calTable;
	private JTable subTable;
	private JTable livTable;

	
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
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setBounds(12, 10, 363, 641);
		frame.getContentPane().add(calPanel);
		calPanel.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("SHOW/HIDE");
		tglbtnNewToggleButton.setBounds(216, 142, 135, 23);
		calPanel.add(tglbtnNewToggleButton);
		
		JLabel callb = new JLabel("\uC774\uBC88\uB2EC \uC9C0\uCD9C\uCD1D\uC561");
		callb.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		callb.setBounds(12, 10, 187, 40);
		calPanel.add(callb);
		
		JButton calMoreBtn = new JButton(">");
		calMoreBtn.setBorderPainted(false);
		calMoreBtn.setFont(new Font("굴림", Font.BOLD, 20));
		calMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		calMoreBtn.setBounds(304, 24, 47, 23);
		calPanel.add(calMoreBtn);
		
		JScrollPane calScrollPane = new JScrollPane();
		calScrollPane.setBounds(12, 181, 339, 450);
		calPanel.add(calScrollPane);
		
		calTable = new JTable();
		calScrollPane.setViewportView(calTable);
		calScrollPane.add(calTable);
		calTable.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		calTable.setFillsViewportHeight(true);//컨테이너의 전체 높이를 테이블이 전부 사용하도록 설정
//		showCal();
		
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
		subMoreBtn.setFont(new Font("굴림", Font.BOLD, 20));
		subMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		subMoreBtn.setBounds(415, 27, 47, 23);
		subPanel.add(subMoreBtn);
		
		JScrollPane subScrollPane = new JScrollPane();
		subScrollPane.setBounds(12, 67, 461, 238);
		subPanel.add(subScrollPane);
		
		subTable = new JTable();
		subTable.setFillsViewportHeight(true);//컨테이너의 전체 높이를 테이블이 전부 사용하도록 설정
		subTable.setRowHeight(2);
		subTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uBC88\uD638", "\uAD6C\uBD84", "\uD56D\uBAA9"
			}
		));
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
		livMoreBtn.setFont(new Font("굴림", Font.BOLD, 20));
		livMoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		livMoreBtn.setBounds(416, 27, 57, 23);
		livPanel.add(livMoreBtn);
		
		JScrollPane livScrollPane = new JScrollPane();
		livScrollPane.setBounds(12, 67, 461, 238);
		livPanel.add(livScrollPane);
		
		livTable = new JTable();
		livTable.setFillsViewportHeight(true);//컨테이너의 전체 높이를 테이블이 전부 사용하도록 설정
		livTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uBC88\uD638", "\uAD6C\uBD84", "\uD56D\uBAA9"
			}
		));
		livScrollPane.setViewportView(livTable);
		frame.setVisible(true);
	}


	
}


