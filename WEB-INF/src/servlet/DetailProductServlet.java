package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class DetailProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
	throws ServletException ,IOException{

		//変数宣言
		String error = "";
		String cmd = "";
		String product_id = "";

		try {
			//ProductDAOクラスのオブジェクトを生成します。
			ProductDAO objDao = new ProductDAO();

			//登録する商品情報を格納するProductオブジェクトを生成します。
			Product Product = new Product();

			//画面から送信されるcmd情報を受け取るためのエンコードを設定します。
			request.setCharacterEncoding("UTF-8");

			//画面から送信されるproduct_idとcmd情報を受け取ります。
			product_id = request.getParameter("product_id");


			//SelectByProduct_idメソッドの呼び出し
			Product = objDao.selectByProduct_id(product_id);

			//取得した商品情報を「Product」という名前でリクエストスコープに登録します。
			request.setAttribute("Product", Product);

			//書籍一覧画面のISBNリンクをクリック時、DBに接続できない
			}catch(IllegalStateException e) {
				error ="DB接続エラーの為、商品詳細は表示できませんでした。";
				cmd = "logout";

			}catch(Exception e) {
				error="予期せぬエラーが発生しました。<br>" + e;
				cmd = "logout";

			}finally {
				if(error.equals("")) {

						request.getRequestDispatcher("/view/detailProduct.jsp").forward(request, response);

				}else {
					request.setAttribute("error",error);
					request.setAttribute("cmd",cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}

			}
		}
}
