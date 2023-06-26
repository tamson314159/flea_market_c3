package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

public class ListProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String error = "";
		String cmd = "";

		ProductDAO proDao = new ProductDAO();

		ArrayList<Product> list = new ArrayList<Product>();

		try {

			request.setCharacterEncoding("UTF-8");

			//全てのデータを取得し、listに格納
			list = proDao.selectAll();

			//リクエストスコープに設定
			request.setAttribute("product_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "logout";

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;


		} finally {
			//正常ルートと異常ルートの判別
			if (error.equals("")) {
				request.getRequestDispatcher("/view/listListingAdmin.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
