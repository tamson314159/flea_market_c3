package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class ListUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// エラーメッセージ用変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの設定
			req.setCharacterEncoding("UTF-8");

			// セッションの取得
			HttpSession session = req.getSession();

			// セッションが有効かチェック
			User user = (User) session.getAttribute("user");
			if (user == null) {
				// セッション切れの場合
				error = "セッション切れのため、ユーザー一覧を表示できません。";
				cmd = "logout";
				return;
			}

			// ユーザーの権限チェック
			if (!user.getAuthority().equals("2")) {
				// 管理者ユーザー以外の場合
				error = "閲覧権限がない為、ユーザー一覧を表示できません。";
				cmd = "menu";
				return;
			}

			// DAO のインスタンス化
			UserDAO userDao = new UserDAO();

			// ユーザー一覧の取得
			ArrayList<User> userList = userDao.listUser();

			// ユーザー一覧のリクエストスコープへの格納
			req.setAttribute("user_list", userList);
		} catch (IllegalStateException e) {
			// データベース接続に失敗した場合
			error = "データベース接続に失敗した為、ユーザー一覧表示はできません。";
			cmd = "logout";
		} finally {
			// エラーメッセージのリクエストスコープへの格納
			req.setAttribute("error", error);
			req.setAttribute("cmd", cmd);

			// フォワード先の振り分け
			if (error.equals("")) {
				// ユーザー一覧表示ページへフォワード
				req.getRequestDispatcher("/view/listUser.jsp").forward(req, resp);
			} else {
				// エラーページへフォワード
				req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
			}
		}
	}

}
