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
		//エラーメッセージ用変数
		String error = "";
		String cmd = "";

		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// 売上情報を格納するAllayListオブジェクトを生成
			ArrayList<Sale> list = new ArrayList<Sale>();

			// SaleDAOクラスのオブジェクトを生成
			SaleDAO objDao = new SaleDAO();

			// メソッドの呼び出し
//			list = objDao.selectAllbought();
			int productNumber = Integer.parseInt(request.getParameter("product_number"));
			list = objDao.selectAllbought(productNumber);

			// 取得した売上情報を「sales」という名前でリクエストスコープに登録
			request.setAttribute("sales", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示はできませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {// エラー処理なし
				// 「detailOrder.jsp」へフォワード
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
