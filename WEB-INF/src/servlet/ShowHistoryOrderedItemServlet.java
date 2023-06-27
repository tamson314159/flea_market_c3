package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Sale;
import bean.User;
import dao.SaleDAO;

public class ShowHistoryOrderedItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			// セッションから「user」を取得
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// エラー処理(セッション)
			if (user == null) {
				error = "セッション切れの為、購入状況の確認は出来ません。";
				cmd = "logout";
			}
			// SaleDAOをインスタンス化
			SaleDAO saleDao = new SaleDAO();

			// 購入した商品の詳細情報を取得するメソッドの呼び出し
			ArrayList<Sale> list = saleDao.selectByUser(user.getUserid());

			// 購入した商品の詳細情報を「sale_list」という名前でリクエストスコープに登録
			request.setAttribute("sale_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {// エラー処理なし
				// 「ShowOrderedItem.jsp」へフォワード
				request.getRequestDispatcher("/view/showHistoryOrderedItem.jsp").forward(request, response);
			} else {// エラー処理あり
				// リクエストスコープへの登録
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// 「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
