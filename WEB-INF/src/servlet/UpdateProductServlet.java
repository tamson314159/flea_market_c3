package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class UpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String product_id = "";
		String kinds = "";
		String product_name = "";
		String price = "";
		String quantity = "";
		String remarks = "";
		String region = "";
		String exhibition_date = "";
		String update_date = "";
		String image = "";
		String transaction = "";
		String user_id = "";
		String error = "";
		String cmd = "";


		Product product = new Product();

		ProductDAO proDao = new ProductDAO();

		try {

			request.setCharacterEncoding("UTF-8");

			// 画面からの情報を受け取る
			product_id = request.getParameter("product_id");
			kinds = request.getParameter("kinds");
			product_name = request.getParameter("product_name");
			price = request.getParameter("price");
			quantity = request.getParameter("quantity");
			remarks = request.getParameter("remarks");
			region = request.getParameter("region");
			exhibition_date = request.getParameter("exhibition_date");
			update_date = request.getParameter("update_date");
			image = request.getParameter("image");
			transaction = request.getParameter("transaction");
			user_id = request.getParameter("user_id");

			// データを検索
			//product = proDao.selectByProduct_id(product_id);


			/*if (product.getProduct_id() == null) {
				error = "更新対象の商品が存在しない為、更新処理は行えませんでした。 ";
				cmd = "list";
				return;
			}

			// エラー処理
			*if (product_id.equals("") || kinds.equals("") || product_name.equals("") || price.equals("")
			 * || quantity.equals("") || exhibition_date.equals("") || update_date.equals("")
			 *  || image.equals("") || transaction.equals("") || user_id.equals("")) {
				error = "未入力の部分がある為、更新処理は行えませんでした。";
				cmd = "list";
				return;
			}

			*/

			//要素を設定
			product.setProduct_id((Integer.parseInt(product_id)));
			product.setKinds(kinds);
			product.setProduct_name(product_name);
			product.setPrice((Integer.parseInt(price)));
			product.setQuantity((Integer.parseInt(quantity)));
			product.setRemarks(remarks);
			product.setRegion(region);
			product.setExhibition_date(exhibition_date);
			product.setUpdate_date(update_date);
			product.setImage(image);
			product.setTransaction(transaction);
			product.setUser_id((Integer.parseInt(user_id)));

			//更新
			proDao.update(product);

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
				request.getRequestDispatcher("/view/listListing.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
