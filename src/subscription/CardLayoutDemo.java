package subscription;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CardLayoutDemo extends JPanel {

	public CardLayoutDemo() {
		
		//카드를 담을 카드덱
		JPanel cards = new JPanel(new CardLayout());
				

		// 패널1
		JPanel card1 = new JPanel();
		JButton nextButton = new JButton("Next");
		TitledBorder border1 = new TitledBorder(new LineBorder(Color.black),"This is Panel 1!", TitledBorder.CENTER,TitledBorder.BELOW_TOP);
		card1.setBorder(border1);
		card1.add(nextButton);

		// 패널2
		JPanel card2 = new JPanel();
		JButton previousButton = new JButton("Previous");
		TitledBorder border2 = new TitledBorder(new LineBorder(Color.black),"This is Panel 2!", TitledBorder.CENTER,TitledBorder.BELOW_TOP);
		card2.setBorder(border2);
		card2.add(previousButton);

		// CardLayout에 패널들 추가
		cards.add(card1, "Panel1");
		cards.add(card2, "Panel2");

		// 전체에 추가
		add(cards);
		// 화면 레이아웃 가져오기
		CardLayout cl = (CardLayout) cards.getLayout();

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.next(cards);
			}
		});

		previousButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.previous(cards);
			}
		});

	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 854, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayoutDemo cardDemo = new CardLayoutDemo();
		cardDemo.setOpaque(true);
		frame.setContentPane(cardDemo);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}