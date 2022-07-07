package subscription;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import subscription.JdbcConnectionUtil;

public class cardlayout extends JPanel {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	private JFrame frame;
	private JTable displaySubTable;
	private JdbcConnectionUtil util;
	private JTable subTable;



	@SuppressWarnings("null")
	public ArrayList<subscriptionVo> subList() {
		ArrayList<subscriptionVo> subList = new ArrayList<>();

		Connection conn; // db연결
		Statement stmt = null; // 쿼리문 수행
		ResultSet rs; // 검색결과 레코드 저장
		String sql;

		try {
			connDB();
			System.out.println("접속성공!");
			sql = "SELECT * FROM subscription";
			rs = stmt.executeQuery(sql);
			subscriptionVo subVo;

			while (rs.next()) {
				subVo = new subscriptionVo(rs.getInt("sid"), rs.getString("category"), rs.getString("title"));
				subList.add(subVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subList;
	}

	public void show_subscription() {
		ArrayList<subscriptionVo> list = subList();
		DefaultTableModel model = (DefaultTableModel) displaySubTable.getModel();
		Object[] row = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getSid();
			row[1] = list.get(i).getCategory();
			row[2] = list.get(i).getTitle();
			model.addRow(row);

		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cardlayout window = new cardlayout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cardlayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1, "name_5785206491100");
		panel1.setLayout(null);

		subTable = new JTable();
		subTable.setBounds(464, 74, 322, 482);
		panel1.add(subTable);

		show_subscription();
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
