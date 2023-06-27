package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import bean.Sale;
import dao.ProductDAO;
import dao.SaleDAO;

public class ShipmentStatusUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// エラーメッセージ用の変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの設定
			req.setCharacterEncoding("UTF-8");

			// 発送状況更新対象の購入番号の取得
			int productId = Integer.parseInt(req.getParameter("product_id"));

			// DAO のインスタンス化
			SaleDAO saleDAO = new SaleDAO();

			// 購入情報の取得
			Sale sale = saleDAO.selectAllUser(Integer.valueOf(productId).toString()).get(0);

			// 取引状況の更新
			sale.setTransaction("3");

			// 発送状況の更新
			sale.setDelivery("1");

			// DB の更新
			saleDAO.update(sale);
		} catch (IllegalStateException e) {
			// DB に接続できなかった場合
			error = "データベース接続に失敗した為、発送状況の更新ができません。";
			cmd = "logout";
		} finally {
			// エラーメッセージのリクエストスコープへの格納
			req.setAttribute("error", error);
			req.setAttribute("cmd", cmd);

			// フォワード先の振り分け
			if (error.equals("")) {
				// 出品一覧ページにフォワード
				req.getRequestDispatcher("/listListing").forward(req, resp);
			} else {
				// エラーページにフォワード
				req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
			}
		}
	}

}
