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

	// 管理者権限
	// 出品商品の詳細を取得するメソッド(No,10 DetailListingAdminServlet)
	public ArrayList<Sale> selectAllAdmin(int product_id) {
		Connection con = null;
		Statement smt = null;

		// 商品詳細情報を格納するAllayListオブジェクトを生成
		ArrayList<Sale> saleList = new ArrayList<Sale>();

		// SQL文
		String sql ="SELECT a.product_name,a.kinds,a.price,a.quantity,a.remarks,a.region,"
				+ "a.exhibition_date,a.update_date,a.image,a.transaction,a.user_id,"
				+ "b.purchase_user_id FROM product a,purchase_info b WHERE a.product_id= " +product_id;

		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文をDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setProduct_number(product_id);
				//sale.setProduct_id(rs.getInt("product_id"));
				sale.setProduct_name(rs.getString("product_name"));
				sale.setKinds(rs.getString("kinds"));
				sale.setPrice(rs.getInt("price"));
				sale.setQuantity(rs.getInt("quantity"));
				sale.setRemarks(rs.getString("remarks"));
				sale.setRegion(rs.getString("region"));
				sale.setExhibition_date(rs.getString("exhibition_date"));
				sale.setUpdate_date(rs.getString("update_date"));
				sale.setImage(rs.getString("image"));
				sale.setTransaction(rs.getString("transaction"));
				sale.setExhibition_userid(rs.getInt("user_id"));
				sale.setPurchase_userid(rs.getInt("purchase_user_id"));
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

	// ユーザー側
		// 出品商品の詳細を取得するメソッド(No,23 DetailListingServlet)ここ
		public ArrayList<Sale> selectAllUser(int product_id) {

			Connection con = null;
			Statement smt = null;

			// 商品詳細情報を格納するAllayListオブジェクトを生成
			ArrayList<Sale> saleList = new ArrayList<Sale>();

			// SQL文
			String sql = "SELECT a.product_id,a.product_name,a.kinds,a.price,a.quantity,a.remarks,a.region,"
					+ "a.exhibition_date,a.update_date,a.image,a.transaction,a.user_id,"
					+ "b.purchase_user_id,b.purchase_date,b.money_received,b.delivery "
					+ "FROM product a INNER JOIN purchase_info b ON a.product_id=b.product_number WHERE a.product_id= " +product_id;

			try {

				con = getConnection();
				smt = con.createStatement();

				// SQL文をDBへ発行
				ResultSet rs = smt.executeQuery(sql);

				// 検索結果を配列に格納
				while (rs.next()) {
					Sale sale = new Sale();

					sale.setProduct_number(rs.getInt("product_id"));
					sale.setProduct_name(rs.getString("product_name"));
					sale.setKinds(rs.getString("kinds"));
					sale.setPrice(rs.getInt("price"));
					sale.setQuantity(rs.getInt("quantity"));
					sale.setRemarks(rs.getString("remarks"));
					sale.setRegion(rs.getString("region"));
					sale.setExhibition_date(rs.getString("exhibition_date"));
					sale.setImage(rs.getString("image"));
					sale.setTransaction(rs.getString("transaction"));

					sale.setPurchase_userid(rs.getInt("purchase_user_id"));
					sale.setPurchase_date(rs.getString("purchase_date"));
					sale.setMoney_received(rs.getString("money_received"));
					sale.setDelivery(rs.getString("delivery"));
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

	// 購入ユーザー側
	// 購入した商品の詳細を取得するメソッド(No,28 DetailOrderServlet)
	public ArrayList<Sale> selectAllbought(int product_id) {

		Connection con = null;
		Statement smt = null;

		// 商品詳細情報を格納するAllayListオブジェクトを生成
		ArrayList<Sale> saleList = new ArrayList<Sale>();

		// SQL文
		String sql = "SELECT a.product_name,a.kinds,a.price,a.quantity,a.remarks,a.region,"
				+ "a.exhibition_date,a.update_date,a.image,a.transaction,a.user_id,"
				+ "b.purchase_date,b.money_received,b.delivery FROM product a,purchase_info b WHERE a.product_id=" + product_id;

		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文をDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setProduct_number(product_id);
				sale.setProduct_name(rs.getString("product_name"));
				sale.setKinds(rs.getString("kinds"));
				sale.setPrice(rs.getInt("price"));
				sale.setQuantity(rs.getInt("quantity"));
				sale.setRemarks(rs.getString("remarks"));
				sale.setRegion(rs.getString("region"));
				sale.setImage(rs.getString("image"));
				sale.setTransaction(rs.getString("transaction"));
				sale.setExhibition_userid(rs.getInt("user_id"));
				sale.setPurchase_date(rs.getString("purchase_date"));
				sale.setMoney_received(rs.getString("money_received"));
				sale.setDelivery(rs.getString("delivery"));
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

	// 購入ユーザー側
		// 購入記録を追加するメソッド(No. 18)
		public void insert(Sale sale) {
			// DB 接続用オブジェクト
			Connection con = null;
			Statement smt = null;

			// SQL 文
			String sql = "INSERT INTO purchase_info(product_number, purchase_user_id, purchase_date, money_received, delivery) VALUES("
					+ sale.getProduct_number() + ", "
					+ sale.getPurchase_userid() + ", "
					+ "CURDATE(), "
					+ "'" + sale.getMoney_received() + "', "
					+ "'" + sale.getDelivery() + "')";

			try {
				// DB 接続用オブジェクトのインスタンス化
				con = getConnection();
				smt = con.createStatement();

				// DB へ購入情報の挿入
				smt.executeUpdate(sql);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			} finally {
				// リソースの開放
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
		}

		// purchase_infoテーブルから指定ユーザーの条件に合致する購入履歴情報を取得するメソッド(No,26
		// ShowHistoryOrderedItemServlet)
		public ArrayList<Sale> selectByUser(int user_id) {
			Connection con = null;
			Statement smt = null;

			// 検索した情報を格納するAllayListオブジェクトを生成
			ArrayList<Sale> saleList = new ArrayList<Sale>();
			// SQL文
			String sql = "SELECT b.product_number, a.product_name, a.price, a.quantity, b.purchase_date, b.money_received"
					+" FROM product a LEFT JOIN purchase_info b ON a.product_id=b.product_number"
					+ " WHERE b.purchase_user_id = " + user_id + "";
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
					sale.setPrice(rs.getInt("price"));
					sale.setQuantity(rs.getInt("quantity"));
					sale.setPurchase_date(rs.getString("purchase_date"));
					sale.setMoney_received(rs.getString("money_received"));
					saleList.add(sale);
				}
			} catch (SQLException e) {
				throw new IllegalStateException(e);
			} finally {
				// リソースの開放
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

	// 出品ユーザー側
		// 出品した商品の情報を更新するメソッド(No,25 UpdateProductServlet)
		public void update(Sale sale) {
			// SQL文設定
			String sql = "UPDATE product AS a INNER JOIN purchase_info AS b ON a.product_id = b.product_number"
					+ " SET a.product_name='" + sale.getProduct_name() + "',a.kinds='" + sale.getKinds() + "',a.quantity='"
					+ sale.getQuantity() + "',a.price='" + sale.getPrice() + "',a.remarks='" + sale.getRemarks()
					+ "',a.region='" + sale.getRegion() + "',a.image='" + sale.getImage() + "',a.transaction ='"
					+ sale.getTransaction() + "', b.money_received='" + sale.getMoney_received() + "',b.delivery='" + sale.getDelivery() + "' WHERE a.product_id='"
					+ sale.getProduct_number() + "'";
			// 変数宣言
			Connection con = null;
			Statement smt = null;

			try {
				// DBに接続
				con = getConnection();
				smt = con.createStatement();
				// SQL文発行
				smt.executeUpdate(sql);
			} catch (SQLException e) {
				throw new IllegalStateException(e);
			} finally {
				// リソースの開放
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
		}

		// 管理者権限
		// 売り上げ状況を取得するメソッド(No,11 SaleServlet)
		public ArrayList<Sale> selectBySales() {
			Connection con = null;
			Statement smt = null;
			// 購入した書籍情報を格納するAllayListオブジェクトを生成
			ArrayList<Sale> saleList = new ArrayList<Sale>();
			try {
				con = getConnection();
				smt = con.createStatement();
				// SQL文
				String sql = "SELECT b.product_id, b.product_name, b.price, b.region,a.purchase_date, sum(quantity) as quantity "
						+ "FROM purchase_info a inner join product b ON a.product_number = b.product_id "
						+ " GROUP BY  b.product_id ORDER BY  b.product_id";
				// SQL文をDBへ発行
				ResultSet rs = smt.executeQuery(sql);
				// 購入情報を配列に格納
				while (rs.next()) {
					Sale sale = new Sale();
					sale.setProduct_number(rs.getInt("product_id"));
					sale.setProduct_name(rs.getString("product_name"));
					sale.setPrice(rs.getInt("price"));
					sale.setQuantity(rs.getInt("quantity"));
					sale.setRegion(rs.getString("region"));
					sale.setPurchase_date(rs.getString("purchase_date"));
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