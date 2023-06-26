package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{


		// userid,passwordのパラメタ取得(ユーザーIDはメールアドレス)
		String userid = request.getParameter("userid");
		String password =request.getParameter("password");

		//UserDAOをインスタンス化し、メソッドを呼び出す
		UserDAO objDao = new UserDAO();
		User user = objDao.login(userid,password);

		//User情報取得の有無でフォワード先を判定

		//User情報がない場合
		if(user.getMail() == null) {

			//リクエストにエラーメッセージを設定
			request.setAttribute("message", "入力データが間違っています！");
			//login.jspにフォワード
			request.getRequestDispatcher("/view/login.jsp").forward(request,response);

		}
		//User情報がある場合

		//取得したUserオブジェクトをセッションスコープに"user"で登録
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		//クッキーに入力情報のuseridとpasswordを登録
		//ユーザー用クッキーの生成
		Cookie userCookie = new Cookie("userid",user.getMail());
		userCookie.setMaxAge(60*60*24*5);
		response.addCookie(userCookie);
		//パスワード用クッキーの生成
		Cookie passCookie = new Cookie("password",user.getPassword());
		passCookie.setMaxAge(60*60*24*5);
		response.addCookie(passCookie);

		//権限でフォワード先を指定
		if(user.getAuthority().equals("1")) {
			//menuAdmin.jspにフォワード
			request.getRequestDispatcher("/view/menuAdmin.jsp").forward(request, response);
		}else {
		//menuUser.jspにフォワード
		request.getRequestDispatcher("/view/menuUser.jsp").forward(request, response);
		}
	}

}


