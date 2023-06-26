package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import bean.User;

public class UserDAO {

	//DB情報をフィールド変数に定義
	private static String RDB_DRIVE="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost/flea_market_db";
	private static String USER="root";
	private static String PASSWD="root123";

	//DBへ接続するメソッド
	public static Connection getConnection() {
		try {

			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);

			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	//ユーザー一覧画面に表示する情報を返すメソッド
	public ArrayList<User> listUser() {

		Connection con = null;
		Statement smt = null;

		//return用のArrayList変数
		ArrayList<User> user_list = new ArrayList<User>();

		//SQL文
		String sql = "SELECT user_id,name,address,mail FROM user_info ORDER BY user_id";

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//rsから各値を取り出してUserオブジェクトにセット、さらにそれをArrayList変数に追加する
			while(rs.next()) {
				User user = new User(); //新しいUserオブジェクトを生成
				user.setUserid(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMail(rs.getString("mail"));
				user_list.add(user);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソースの開放
			if (smt != null) {
				try {smt.close();} catch (SQLException ignore) {}
			}
			if (con != null) {
				try {con.close();} catch (SQLException ignore) {}
			}
		}
		return user_list;
	}

	//入力されたユーザーIDとパスワードに合致するユーザー情報を取得するメソッド
	public User login(String userid, String password) {

		Connection con = null;
		Statement smt = null;

		//return用のUserオブジェクトの生成
		User user = new User();

		//SQL文
		String sql = "SELECT * FROM user_info WHERE user_id = '" + userid + "'AND password = '" + password + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//結果セットからデータを取り出し、Userオブジェクトに格納
			while (rs.next()) {
				user.setUserid(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setMail(rs.getString("mail"));
				user.setAuthority(rs.getString("authority"));
				user.setNickname(rs.getString("nickname"));
				user.setPhone_number(rs.getString("phone_number"));

				Date today1 = rs.getDate("signup_date");
				String signup_date = today1.toString(); //Date型をString型へキャスト
				user.setSignup_date(signup_date);

				Date today2 = rs.getDate("update_date");
				String update_date = today2.toString(); //Date型をString型へキャスト
				user.setUpdatemypage_date(update_date);
			}

		} catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			if( smt != null ){
				try{smt.close();}catch(SQLException ignore){}
			}
			if( con != null ){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return user;
	}

	//指定されたユーザーIDに合致するユーザー情報を取得するメソッド
		public User listUser(String userid) {

			Connection con = null;
			Statement smt = null;

			//return用のUserオブジェクトの生成
			User user = new User();

			//SQL文
			String sql = "SELECT * FROM user_info WHERE user_id = '" + userid + "'";

			try {

				con = getConnection();
				smt = con.createStatement();

				//SQL文発行
				ResultSet rs = smt.executeQuery(sql);


				//結果セットからデータを取り出し、Userオブジェクトに格納
				while (rs.next()) {
					user.setUserid(rs.getInt("user_id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setAddress(rs.getString("address"));
					user.setMail(rs.getString("mail"));
					user.setAuthority(rs.getString("authority"));
					user.setNickname(rs.getString("nickname"));
					user.setPhone_number(rs.getString("phone_number"));

					Date today1 = rs.getDate("signup_date");
					String signup_date = today1.toString(); //Date型をString型へキャスト
					user.setSignup_date(signup_date);

					Date today2 = rs.getDate("update_date");
					String update_date = today2.toString(); //Date型をString型へキャスト
					user.setUpdatemypage_date(update_date);
				}

			} catch(Exception e){
				throw new IllegalStateException(e);
			}finally{
				if( smt != null ){
					try{smt.close();}catch(SQLException ignore){}
				}
				if( con != null ){
					try{con.close();}catch(SQLException ignore){}
				}
			}
			return user;
		}

		//会員登録処理を行うメソッド
		public void signupMember(String password, String mail, String authority, String name, String nickname, String address, String phone_number, Date signup_date, Date update_date) {

			Connection con = null;
			Statement smt = null;

			//SQL文
			String sql = "INSERT INTO user_info (user_id, password, mail, authority, name, nickname, address, phone_number, signup_date, update_date)"
					+ "VALUES('','" + password + "','" + mail + "','" + authority + "','" + name + "','" + nickname + "','" + address + "','" + phone_number + "','" + signup_date + "','" + update_date + "')";

			try {
				con = getConnection();
				smt = con.createStatement();

				//SQL文発行。会員登録実行。
				smt.executeUpdate(sql);

			} catch(Exception e){
				throw new IllegalStateException(e);
			}finally{
				if( smt != null ){
					try{smt.close();}catch(SQLException ignore){}
				}
				if( con != null ){
					try{con.close();}catch(SQLException ignore){}
				}
			}
		}


}
