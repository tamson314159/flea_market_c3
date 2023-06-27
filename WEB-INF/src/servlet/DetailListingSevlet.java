package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;
import java.util.*;

public class DetailListingSevlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {

			// 画面から送信される商品IDを受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 商品IDのパラメタ取得
			String product_id = request.getParameter("product_id");

			// UserDAOをインスタンス化
			SaleDAO objDao = new SaleDAO();

			// 取得した情報を格納するArrayList作成
			ArrayList<Sale> saleList = new ArrayList<Sale>();

			// selectAllAdminメソッドの呼び出し
			saleList = objDao.selectAllAdmin(product_id);

			// 検索結果をリクエストスコープに登録
			request.setAttribute("Sale", saleList);

		} catch (IllegalStateException e) {

			error = "DB接続エラーのため、出品商品の詳細情報は表示できません。";
			cmd = "";
		} finally {

			if (error.equals("")) {
				request.getRequestDispatcher("/view/detailListing.jsp").forward(request, response);
			} else {

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// error.jspにフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}

}
