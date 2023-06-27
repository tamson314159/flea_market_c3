package servlet;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class MypageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エラーメッセージ用変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// セッションから「user」を取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// エラー処理(セッション)
			if (user == null) {
				error = "セッション切れの為、マイページ画面の表示が出来ません。";
				cmd = "logout";
			}

			//Userオブジェクトの生成
			User mypage = new User();

			//UserDAOクラスをインスタンス化
			UserDAO userDao = new UserDAO();

			//マイページ画面に表示する情報を取得するメソッドの呼び出し
			mypage = userDao.selectByUserid(user.getUserid());

			// 取得した売上情報を「mypage」という名前でリクエストスコープに登録
			request.setAttribute("mypage", mypage);

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
