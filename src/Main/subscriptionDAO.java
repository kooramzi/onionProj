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


	@SuppressWarnings("null")
	public String[][] selectSub(subscriptionVo subVo) {
		Connection con = null;
		PreparedStatement pstmt = null; // ���������������
		ResultSet rs = null; // ����Ʈ���� ����� Resultset���� ��
		String sql=null;
		List<subscriptionVo> result = new ArrayList<>();
		String[][] sContents = null;

		try {
			con = util.getConnection();
			System.out.println("���Ӽ���!");

			sql = "SELECT * FROM subscription where CATEGORY='���ⱸ��'";
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

//	public void connDB() {
//		try {
//			Class.forName(driver);
//			System.out.println("jdbc driver loading success.");
//			con = DriverManager.getConnection(url, user, password);
//			System.out.println("oracle connection success.\n");
//			pstmt =  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//					ResultSet.CONCUR_UPDATABLE);
//			System.out.println("statement create success.\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
