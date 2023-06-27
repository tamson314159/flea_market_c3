package servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sale;
import dao.SaleDAO;

public class SaleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エラーメッセージ用変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			//売上情報を格納するAllayListオブジェクトを生成
			ArrayList<Sale> list = new ArrayList<Sale>();

			//SaleDAOのインスタンス化
			SaleDAO saleObj = new SaleDAO();

			//売り上げ状況を取得するメソッドの呼び出し
			list = saleObj.selectBySales();

			// 売上情報を「sale_list」という名前でリクエストスコープに登録
			request.setAttribute("sale_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {// エラー処理なし
				// 「sale.jsp」へフォワード
				request.getRequestDispatcher("/view/sale.jsp").forward(request, response);
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
