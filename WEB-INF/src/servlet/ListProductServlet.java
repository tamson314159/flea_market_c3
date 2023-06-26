package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.*;

public class ListProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error="";
		String cmd ="";


		try {

			//DAOオブジェクト宣言
			ProductDAO objDao = new ProductDAO();

			//全検索メソッドを呼び出し
			ArrayList<Product> productList = objDao.selectAll();

			// 取得した書籍情報をproduct_listという名前でリクエストスコープに登録
			request.setAttribute("product_list", productList);

		}catch(IllegalStateException e){

			error="DB接続エラーのため、一覧表示できません。";
			cmd ="menu";

		}finally {
			//エラーの有無でフォワード先を指定

			if(error.equals("")) {// エラーがない場合

				// listProduct.jspへフォワード
				request.getRequestDispatcher("/view/listProduct.jsp").forward(request, response);

			}else {// エラーがある場合

				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				// error,jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request,response);
			}

		}
	}


}