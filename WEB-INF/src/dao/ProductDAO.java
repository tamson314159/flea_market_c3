package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {

	//データベース接続情報
	private static String RDB_DRIVE ="com.mysql.jdbc.Driver";
	private static String URL ="jdbc:mysql://localhost/flea_market_db";
	private static String USER ="root";
	private static String PASS ="root123";

	//データベース接続情報を利用してデータベースに接続するインスタンスメソッド「getConnection」を定義します。
	private static Connection getConnection(){
		try{
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}


	//引数で渡したuser_idに対応した商品の一覧情報を表示するメソッド
	public ArrayList<Product> selectAll_user(String user_id) {


		Connection con = null;
		Statement smt = null;

		//return用のArrayListを作成
		ArrayList<Product> productList = new ArrayList<Product>();

		//SQL文
		String sql = "SELECT product_id, product_name, kinds, price, quantity FROM product WHERE user_id = '" + user_id + "' ORDER BY product_id";

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL文発行。
			ResultSet rs = smt.executeQuery(sql);

			//結果セットから商品データを取り出し、ArrayListに格納
			while (rs.next()) {
				Product products = new Product();
				products.setProduct_id(rs.getInt("product_id"));
				products.setProduct_name(rs.getString("product_name"));
				products.setKinds(rs.getString("kinds"));
				products.setPrice(rs.getInt("price"));
				products.setQuantity(rs.getInt("quantity"));
				productList.add(products); //Productオブジェクト内のデータをArrayListに格納
			}

		} catch (Exception e){
			throw new IllegalStateException(e);
		} finally {
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return productList;
	}



	//「productDAO.java」ファイルにデータベースから商品データを検索しArrayListオブジェクトに格納するインスタンスメソッド「selectAll」を定義します。
	public ArrayList<Product> selectAll(){
		//変数宣言
		Connection con = null;
		Statement smt = null;

		//検索した商品情報を格納するAllayListオブジェクトを生成します。
		ArrayList<Product> productList = new ArrayList<Product>();

		try{
			//productDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成します
			con = getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt = con.createStatement();

			//SQL文を文字列として定義します。
			String sql = "SELECT product_id,product_name,kinds,price,quantity FROM product ORDER BY product_id";

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得します。
			ResultSet rs = smt.executeQuery(sql);

			//結果セットから商品データを検索件数分全て取り出し、AllayListオブジェクトにProductオブジェクトとして格納します。
			while(rs.next()){
				Product products = new Product();
				products.setProduct_id(rs.getInt("product_id"));
				products.setProduct_name(rs.getString("product_name"));
				products.setKinds(rs.getString("kinds"));
				products.setPrice(rs.getInt("price"));
				products.setQuantity(rs.getInt("quantity"));
				productList.add(products);
			}

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return productList;
	}

	//「productDAO.java」ファイルにデータベースに商品データを登録するインスタンスメソッド「insert」を定義します。
	public void insert(Product product){
		//変数宣言
		Connection con = null;
		Statement smt = null;

		try{
			//ProductDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成します。
			con = getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt = con.createStatement();

			//引数の情報を利用し、登録用のSQL文を文字列として定義します。
			String sql = "INSERT INTO product VALUES("
							+ "NULL,'"+ product.getProduct_id() + "','"
							+ product.getProduct_name() + "','"
							+ product.getKinds() + "','"
							+ product.getPrice() + "','"
							+ product.getQuantity() + "','"
							+ product.getTransaction() + "','"
							+ product.getRegion() + "','"
							+ product.getRemarks() + "',"
							+ ",CURDATE())";

			//Statementオブジェクトの、executeUpdate（）メソッドを利用して、SQL文を発行し商品データを登録します。
			smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
	}

	//「productDAO.java」ファイルにデータベースから指定された商品データを検索しProductオブジェクトに格納するインスタンスメソッド
	public Product selectByProduct_id(String product_id){
		//変数宣言
		Connection con = null;
		Statement smt = null;

		//検索した商品情報を格納するProductオブジェクトを生成します。
		Product product = new Product();

		try{
			//ProductDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成します。
			con = getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt= con.createStatement();

			//引数の情報を利用し、検索用のSQL文を文字列として定義します。
			String sql = "SELECT p.product_id, p.product_name, p.kinds, p.price, p.quantity, p.remarks, p.region, p.exhibition_date,"
					+ "p.transaction, s.user_id FROM product p INNER JOIN sale s ON p.product_id = s.pruduct_number "
					+ "WHERE product_id = '" + product_id + "'";

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得します。
			ResultSet rs =smt.executeQuery(sql);

			//結果セットから書籍データを取り出し、Bookオブジェクトに格納します。
			if(rs.next()) {
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setKinds(rs.getString("kinds"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setRemarks(rs.getString("remarks"));
				product.setRegion(rs.getString("region"));
				product.setExhibition_date(rs.getString("exhibition_date"));
				product.setTransaction(rs.getString("transaction"));
				product.setUser_id(rs.getInt("user_id"));
			}

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return product;
	}

	//「productDAO.java」ファイルにデータベースから指定された商品データを削除するインスタンスメソッド「delete」を定義します。
	public void delete(String product_id){
		//変数宣言
		Connection con = null;
		Statement smt = null;

		try{
			//ProductDAOクラスに定義したgetConnection()メソッドを利用して、Connectionオブジェクトを生成します。
			con = getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用して、Statementオブジェクトを生成します。
			smt = con.createStatement();

			//引数の情報を利用し、削除用のSQL文を文字列として定義します。
			String sql = "DELETE FROM product WHERE product_id = '"+ product_id +"'";

			//StatementオブジェクトのexecuteUpdate（）メソッドを利用して、SQL文を発行し書籍データを削除します。
			smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
	}

	//「productDAO.java」ファイルにデータベースから指定された商品データを更新するインスタンスメソッド「update」を定義します。
		public void update(Product product) {
		//変数宣言
		Connection con = null;
		Statement smt = null;

		try {
			//ProductDAOクラスに定義したgetConnection()メソッドを利用して、Connectionオブジェクトを生成します。
			con =getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用して、Statementオブジェクトを生成します。
			smt = con.createStatement();

			//引数の情報を利用し、更新用のSQL文を文字列として定義します。
			String sql = "UPDATE product SET product_name = '"+ product.getProduct_name() + "',kinds ="+ product.getKinds() + "',"
					+ "price = '"+ product.getPrice() + "',quantity = '"+ product.getQuantity() + "',region= '"+ product.getRegion() + "',"
					+ "remarks = '"+ product.getRemarks() + "',transaction = '" + product.getTransaction() + "'"
					+ "FROM product WHERE product_id ='"+ product.getProduct_id() + "'";

			//StatementオブジェクトのexecuteUpdate（）メソッドを利用して、SQL文を発行し書籍データを変更します。
			smt.executeUpdate(sql);

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
	}

	//「productDAO.java」ファイルにデータベースから指定された商品データを検索するインスタンスメソッド「search」を定義します。
		public ArrayList <Product> search(String product_id,String product_name, String kinds, String price,String quantity){
		//変数宣言
		Connection con = null;
		Statement smt = null;

		//検索した商品情報を格納するArrayListオブジェクトを生成します。
		ArrayList<Product> productList = new ArrayList<Product>();

		try{
			//ProductDAOクラスに定義したgetConnection()メソッドを利用して、Connectionオブジェクトを生成します。
			con = getConnection();

			//ConnectionオブジェクトのcreateStatement（）メソッドを利用して、Statementオブジェクトを生成します。
			smt = con.createStatement();

			//引数の情報を利用し、検索用のSQL文を文字列として定義します。
			String sql = "SELECT product_id,product_name,kinds,price,quantity FROM product " +
					"WHERE product_id LIKE '%" + product_id + "%' AND product_name LIKE '%" + product_name + "%'"
					+ " AND kinds LIKE '%" + kinds + "%' AND  price LIKE '%" + price + "%' AND quantity LIKE '%\" + quantity + \"%'";

			//Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得します。
			ResultSet rs =	smt.executeQuery(sql);

			//結果セットから商品データを検索件数分全て取り出し、AllayListオブジェクトにProductオブジェクトとして格納します。
			while(rs.next()){
				Product products = new Product();
				products.setProduct_id(rs.getInt("product_id"));
				products.setProduct_name(rs.getString("product_name"));
				products.setKinds(rs.getString("kinds"));
				products.setPrice(rs.getInt("price"));
				products.setQuantity(rs.getInt("quantity"));
				productList.add(products);
			}

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			//Statementオブジェクトをクローズします。
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			//Connectionオブジェクトをクローズします。
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return productList;
	}

}
