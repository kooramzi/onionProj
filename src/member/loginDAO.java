package member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginDAO {

	private JdbcConnectionUtil util;
	Connection conn = null; // db연결
	Statement stmt = null; // 쿼리문 수행
	ResultSet rs = null; // 검색결과 레코드 저장

	public loginDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public boolean list(loginVo vo) {

		try {
			String sql = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String query = "SELECT * FROM login WHERE id='" + vo.getId() + "' AND password='" + vo.getPassword() + "'";

//			System.out.println("sql: "+query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected....");
			} else
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}