package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Sale;
import dao.SaleDAO;

public class DetailOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {
			//
			ArrayList<Sale> list = new ArrayList<Sale>();

			//SaleDAOクラスのオブジェクトを生成
			SaleDAO objDao = new SaleDAO();

			//メソッドの呼び出し
			list=objDao.selectAll();

			// 取得した書籍情報を「sales」という名前でリクエストスコープに登録
			request.setAttribute("sales", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {// エラー処理なし
				// 「list.jsp」へフォワード
				request.getRequestDispatcher("/view/detailOrder.jsp").forward(request, response);
			} else {// エラー処理なし
				// リクエストスコープへの登録
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				// 「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}

}
