package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class detailDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	String title;
	String paydate;
	int fee;
	String term;
	String card_name;
	String bank_name;

	public void detail(String day) {

		String sql = "select s.title, p.paydate, s.fee, p.term, p.card_name, p.bank_name from PAYMENT p, SUBSCRIPTION s where p.sid = s.sid AND PAYDATE = "+"'"+day+"'";
		try {
			connDB();
			System.out.println("접속성공!");

			
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				title = rs.getString("title");
				paydate = rs.getString("paydate");
				fee = rs.getInt(3);// 컬럼 순번
				term = rs.getString("term");
				card_name = rs.getString("card_name");
				bank_name = rs.getString("bank_name");
				System.out.println(title+"kkk");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(title+"kk12k");
		}
		return;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
//			pstmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs = null;
			}
			if (pstmt != null) {
				pstmt = null;
			}
			if (con != null) {
				con = null;
			}
		}
	}
}
