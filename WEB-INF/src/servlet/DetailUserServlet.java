package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class DetailUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {

			// 画面から送信されるユーザーIDを受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// ユーザーIDのパラメタ取得
			String userid = request.getParameter("userid");

			// UserDAOをインスタンス化
			UserDAO objDao = new UserDAO();

			// listUserメソッドの呼び出し
			User objUser = objDao.listUser(userid);

			// 検索結果をリクエストスコープに登録
			request.setAttribute("user", objUser);

		} catch (IllegalStateException e) {

			error = "DB接続エラーのため、ユーザーの詳細情報は表示できません。";
			cmd = "";
		} finally {

			//エラーの有無でフォワード先を指定
			if (error.equals("")) {
				// detailUser.jspにフォワード
				request.getRequestDispatcher("/view/detailUser.jsp").forward(request, response);
			} else {

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// error.jspにフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
