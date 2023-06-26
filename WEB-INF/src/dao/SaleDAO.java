package dao;

import java.sql.*;
import java.util.*;
import bean.*;

public class SaleDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";

	private static String URL = "jdbc:mysql://localhost/flea_market_db";

	private static String USER = "root";

	private static String PASSWD = "root123";

	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public ArrayList<Sale> selectAll() {

		Connection con = null;
		Statement smt = null;

		// すべてのユーザー情報を格納するAllayListオブジェクトを生成
		ArrayList<Sale> saleList = new ArrayList<Sale>();

		// SQL文
		String sql = "SELECT A.product_name,A.kinds,A.price,A.quantity,A.remarks,A.region,"
				+ "A.exhibition_date,A.update_date,A.image,A.transaction,A.user_id,A.purchase_date,"
				+ "B.purchase_date,B.money_received,B.delivery FROM product A,purchase B WHERE A.product_id = B.product_number";

		try {

			con = getConnection();
			smt = con.createStatement();

			// SQL文をDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setProduct_number(rs.getInt("product_number"));
				sale.setProduct_name(rs.getString("product_name"));

				saleList.add(sale);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return saleList;
	}

}
