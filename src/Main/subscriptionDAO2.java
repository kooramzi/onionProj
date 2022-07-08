package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class subscriptionDAO2 {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	Connection con = null;
	Statement pstmt = null; // 쿼리문사용을위한
	ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
	String sql;

	public String[][] selectSub() {
		List<subscriptionVo> result = new ArrayList<>();
		String[][] sContents = null;

		try {
			connDB();
			System.out.println("접속성공!");

			sql = "SELECT * FROM subscription where CATEGORY='" + rs.getString("CATEGORY") + "'";
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				subscriptionVo subVo = new subscriptionVo(rs.getString("sid"), rs.getString("category"),
						rs.getString("title"));
				result.add(subVo);
			}

			sContents = new String[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					sContents[i][j] = result.get(i).getSid();
					sContents[i][++j] = result.get(i).getCategory();
					sContents[i][++j] = result.get(i).getTitle();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sContents;

	}

//	public void show_subscription() {
//		ArrayList<subscriptionVo> list = subList();
//		DefaultTableModel model = (DefaultTableModel) subTable.getModel();
//		Object[] row = new Object[3];
//		for (int i = 0; i < list.size(); i++) {
//			row[0] = list.get(i).getSid();
//			row[1] = list.get(i).getCategory();
//			row[2] = list.get(i).getTitle();
//			model.addRow(row);
//
//		}
//	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			pstmt =  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
