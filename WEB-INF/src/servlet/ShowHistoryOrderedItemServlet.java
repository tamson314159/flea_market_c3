package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sale;
import dao.SaleDAO;

public class ShowHistoryOrderedItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			//SaleDAOをインスタンス化
			SaleDAO saleDao = new SaleDAO();

			//メソッドの呼び出し
			ArrayList<Sale> list = saleDao.selectAll();

			//リクエストスコープにlistの値を登録
			request.setAttribute("sale_list",list);

		}catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {//エラー処理なし
				// 「ShowOrderedItem.jsp」へフォワード
				request.getRequestDispatcher("/view/ShowHistoryOrderedItem.jsp").forward(request, response);
			} else {//エラー処理あり
				// リクエストスコープへの登録
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// 「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
