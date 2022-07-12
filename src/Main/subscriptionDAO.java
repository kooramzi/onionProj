package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.JdbcConnectionUtil;

public class subscriptionDAO {
	private JdbcConnectionUtil util;

	public subscriptionDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public String[][] selectSub(subscriptionVo subVo) {
		Connection con = null;
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		String sql=null;
		List<subscriptionVo> result = new ArrayList<>();
		String[][] sContents = null;

		try {
			con = util.getConnection();
			System.out.println("접속성공!");

			sql = "SELECT * FROM subscription where CATEGORY='정기구독'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("sid"), rs.getString("category"),
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
	
	
	public String[][] selectLiv(subscriptionVo subVo) {
		Connection con = null;
		PreparedStatement pstmt = null; // 쿼리문사용을위한
		ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
		String sql=null;
		List<subscriptionVo> result = new ArrayList<>();
		String[][] lContents = null;

		try {
			con = util.getConnection();
			System.out.println("접속성공!");

			sql = "SELECT * FROM subscription where CATEGORY='생활지출'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("sid"), rs.getString("category"),
														rs.getString("title"));
				result.add(subVo);
			}

			lContents = new String[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					lContents[i][j] = result.get(i).getSid();
					lContents[i][++j] = result.get(i).getCategory();
					lContents[i][++j] = result.get(i).getTitle();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lContents;

	}
}
