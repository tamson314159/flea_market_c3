package servlet;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.ServletException;

import bean.Product;
import dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = ""; //エラーメッセージ管理
		String cmd = ""; //遷移先の管理

		try {

			//ProductクラスとProductDAOクラスのオブジェクト生成
			Product product = new Product();
			ProductDAO ProductDaoObj = new ProductDAO();

			//一覧画面や詳細画面から送られる商品番号を取得
			String product_id = request.getParameter("product_id");

			/** 存在チェック **/
			product = ProductDaoObj.selectByProduct_id(product_id);
			String intproduct_id = String.valueOf(product.getProduct_id()); //int型からString型へキャスト

			if (intproduct_id == null) {
				error = "削除対象の出品商品が存在しない為、削除処理は行えませんでした。";
				cmd = "error";
				return;
			}

			//ProductDAOのdeleteメソッドの呼び出し
			ProductDaoObj.delete(product_id);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、削除処理は行えませんでした。";
			cmd = "error";
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("view/listListing.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
