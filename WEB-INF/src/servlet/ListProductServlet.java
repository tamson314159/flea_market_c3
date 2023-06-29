package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

public class ListProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
	throws ServletException ,IOException{

		String error="";
		String cmd ="";


		try {
			//セッションからユーザー情報を取得
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			//セッション接続エラー処理
			if (user == null) {
				error = "セッション接続エラーの為、一覧表示はできませんでした。";
				cmd = "logout";
				return;
			}

			//DAOオブジェクト宣言
			ProductDAO ProductDaoObj = new ProductDAO();

			//全検索メソッドを呼び出し
			ArrayList<Product> productList = ProductDaoObj.selectAll();

			// 取得した商品情報をproduct_listという名前でリクエストスコープに登録
			request.setAttribute("product_list", productList);

		}catch(IllegalStateException e){

			error="DB接続エラーのため、一覧表示できません。";
			cmd ="menu";

		}finally {
			//エラーの有無でフォワード先を指定
			//エラーが無い場合
			if(error.equals("")) {
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("user");
				String authority = user.getAuthority();

				if (authority.equals("1")) {
					/** ユーザー側の商品一覧画面へ遷移する場合 **/
					request.getRequestDispatcher("/view/listProduct.jsp").forward(request, response);
				}
				if (authority.equals("2")) {
					/** 管理者画面の出品一覧画面へ遷移する場合 **/
					request.getRequestDispatcher("/view/listListingAdmin.jsp").forward(request, response);
				}

			}else {// エラーがある場合

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				// error,jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
			}

		}
	}


}
