package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sale;
import dao.SaleDAO;

public class PaymentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// エラーメッセージ用の変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの設定
			req.setCharacterEncoding("UTF-8");

			// 入金対象の出品番号を取得
			int productId = Integer.parseInt(req.getParameter("product_id"));

			// DAO のインスタンス化
			SaleDAO saleDAO = new SaleDAO();

			// 入金対象の購入情報を取得
			Sale sale = saleDAO.selectAllUser(productId).get(0);

			// 入金情報の更新
			sale.setMoney_received("1");

			// DB の更新
			saleDAO.update(sale);
		} catch (IllegalStateException e) {
			// データベースに接続できなかった場合
			error = "データベースに接続できなかった為、入金処理が行えませんでした。";
			cmd = "logout";
		} finally {
			// エラーメッセージのリクエストスコープへの格納
			req.setAttribute("error", error);
			req.setAttribute("cmd", cmd);

			// フォワード先の振り分け
			if (error.equals("")) {
				// 購入履歴画面へフォワード
				req.getRequestDispatcher("/showHistoryOrderedItem").forward(req, resp);
			} else {
				// エラー画面へフォワード
				req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
			}
		}
	}

}
