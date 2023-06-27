package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
//import dao.UserDAO;

public class MypageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			User user = new User();

			user.setName("kanda");
			user.setNickname("kanda");
			user.setAddress("kanda");
			user.setMail("kanda");
			user.setPassword("kanda");


			request.setAttribute("user",user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {// エラー処理なし
				// 「list.jsp」へフォワード
				request.getRequestDispatcher("/view/mypage.jsp").forward(request, response);
			} else {// エラー処理なし
				// リクエストスコープへの登録
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// 「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}

}
