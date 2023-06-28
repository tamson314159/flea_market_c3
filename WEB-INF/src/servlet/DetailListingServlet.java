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

public class DetailListingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// エラーメッセージ用変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの設定
			req.setCharacterEncoding("UTF-8");

			// 詳細表示する出品の商品番号の取得
			int productId = Integer.parseInt(req.getParameter("product_id"));

			// DAO のインスタンス化
			ProductDAO productDAO = new ProductDAO();
			SaleDAO saleDAO = new SaleDAO();

			// 商品情報の取得
			Product product = productDAO.selectByProduct_id(productId);

			// 商品情報のリクエストスコープへの格納
			req.setAttribute("product", product);

			// 商品が取引中または購入済みの場合注文情報を取得する
			if (product.getTransaction().equals("2") || product.getTransaction().equals("3")) {
				// 注文情報の取得
				Sale sale = saleDAO.selectAllUser(productId).get(0);

				// 注文情報のリクエストスコープへの格納
				req.setAttribute("sale", sale);
			}
		} catch (IllegalStateException e) {
			// DB 接続に失敗した場合
			error = "データベース接続に失敗した為、商品詳細は表示できません。";
			cmd = "logout";
		} finally {
			// エラーメッセージのリクエストスコープへの格納
			req.setAttribute("error", error);
			req.setAttribute("cmd", cmd);

			// フォワード先の振り分け
			if (error.equals("")) {
				// 商品詳細ページへフォワード
				req.getRequestDispatcher("/view/detailListing.jsp").forward(req, resp);
			} else {
				// エラーページへフォワード
				req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
			}
		}
	}

}
