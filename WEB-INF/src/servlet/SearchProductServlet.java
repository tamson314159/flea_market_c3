package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class SearchProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{


		String error ="";
		String cmd ="";

		try {

			// ProductDAOクラスのオブジェクトを生成
			ProductDAO objDao = new ProductDAO();

			// 画面から送信される検索条件を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 画面から送信される検索条件をパラメタで取得
			String product_name = request.getParameter("product_name");

			String price = request.getParameter("price");


			// ProductDAOクラスに定義したsearchメソッドを利用して書籍情報を取得
			ArrayList<Product> productList = objDao.search(product_name, Integer.parseInt(price));

			// 取得した書籍情報を「book_list」という名前でリクエストスコープに登録
			request.setAttribute("product_list", productList);

		}catch(IllegalStateException e) {

			error="DB接続エラーのため検索結果を表示できません。";
			cmd ="menu";

		}finally {
			//エラーの有無でフォワード先を指定

			if(error.equals("")) {// エラーがない場合

				// listProduct.jspへフォワード
				request.getRequestDispatcher("/view/listProduct.jsp").forward(request, response);

			}else {// エラーがある場合

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				// error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);

			}

		}
	}

}
