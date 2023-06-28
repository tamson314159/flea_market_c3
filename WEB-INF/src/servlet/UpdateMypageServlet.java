package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UpdateMypageServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_id = "";
		String name = "";
		String nickname = "";
		String address = "";
		String mail = "";
		String password = "";
		String error = "";
		String cmd = "";


		User user = new User();

		UserDAO userDao = new UserDAO();

		try {

			request.setCharacterEncoding("UTF-8");

			// 画面からの情報を受け取る
			user_id = request.getParameter("user_id");
			name = request.getParameter("name");
			nickname = request.getParameter("nickname");
			address = request.getParameter("address");
			mail = request.getParameter("mail");
			password = request.getParameter("password");

			// データを検索
			//product = proDao.selectByProduct_id(product_id);

			// エラー処理
			/*if (name.equals("") || nickname.equals("") || address.equals("") || mail.equals("")
			 * || password.equals("") ) {
				error = "未入力の部分がある為、変更処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if (user.getUser_id() == null) {
				error = "更新対象の商品が存在しない為、変更処理は行えませんでした。 ";
				cmd = "list";
				return;
			}
			*/

			//要素を設定
			user.setUserid(Integer.parseInt("user_id"));
			user.setName("name");
			user.setNickname("nickname");
			user.setAddress("address");
			user.setMail("mail");
			user.setPassword("password");

			//更新
			userDao.update(user);

		} catch (NumberFormatException e) {
			error = "値が不正の為、更新処理は行えませんでした。 ";
			cmd = "list";

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新処理は行えませんでした。";
			cmd = "logout";

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;

		} finally {
			// 正常ルートと異常ルートの判別
			if (error.equals("")) {
				request.getRequestDispatcher("/view/mypage.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}

