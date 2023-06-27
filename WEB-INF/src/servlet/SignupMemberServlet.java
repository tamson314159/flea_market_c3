package servlet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

public class SignupMemberServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";

		try {

			//入力パラメータの文字コード指定
			request.setCharacterEncoding("UTF-8");

			//Userオブジェクトの生成
			User user = new User();

			//当日の日付データを取得し、適切な記述に変更後、Date型に再変換
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strdate = sdf.format(date);

			//会員登録画面からデータを取得
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String address = request.getParameter("address");
			String phone_number = request.getParameter("phone_number");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			String signup_date = strdate;
			String update_date = strdate;
			String authority = request.getParameter("authority");

			//空白チェック
			if (name == "" || nickname == "" || address == "" || phone_number == "" || mail == "" || password == "") {
				error = "空欄を埋めてください。";
				return;
			}

			//daoオブジェクトの生成
			UserDAO UserDaoObj = new UserDAO();

			//signupMemberメソッドの呼び出し
			UserDaoObj.signupMember(password, mail, authority, name, nickname, address, phone_number, signup_date, update_date);

			//ログイン画面へ遷移
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員登録できませんでした。";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>"+e;

		} finally {
			//エラーがある場合はエラー文を伴って会員登録画面に遷移
			if (error != "") {
				request.setAttribute("error", error);
				request.getRequestDispatcher("view/signupMember.jsp").forward(request, response);
			}
		}

	}

}
