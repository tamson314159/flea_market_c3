package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.*;
import dao.ProductDAO;

public class ListListingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = ""; //エラーメッセージの管理
		String cmd = ""; //遷移先の管理
		//Product型のArrayList変数を定義
		ArrayList<Product> productList = new ArrayList<Product>();

		try {

			//セッションからユーザーIDを取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			/** セッション切れの場合エラー **/
			if (user == null) {
				error = "セッション切れの為、出品商品一覧を表示できませんでした。";
				cmd = "logout";
				return;
			}

			int user_id = user.getUserid();

			//ProductDAOクラスののオブジェクト生成
			ProductDAO ProductDaoObj = new ProductDAO();

			//selectAll_userメソッドの呼び出し
			productList = ProductDaoObj.selectAll_user(user_id);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、出品商品一覧を表示できませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {
				//エラーが無い場合
				request.setAttribute("list", productList);
				request.getRequestDispatcher("/view/listListing.jsp").forward(request, response);
			} else {
				//エラーがある場合
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
