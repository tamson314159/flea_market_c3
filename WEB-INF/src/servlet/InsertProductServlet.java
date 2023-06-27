package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class InsertProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
	throws ServletException ,IOException{

		//変数宣言
		String error = "";
		String cmd = "";
		String product_name = "";
		String kinds = "";
		String strPrice = "";
		String strQuantity = "";
		String region= "";
		String remarks = "";
		String transaction= "";
		int price = 0;
		int quantity= 0;

		try {
			//productDAOクラスのオブジェクトを生成します。
			ProductDAO objDao = new ProductDAO();

			//登録する書籍情報を格納するProductオブジェクトを生成します。
			Product product = new Product();

			//画面からの入力情報を受け取るためのエンコードを設定します。
			request.setCharacterEncoding("UTF-8");

			//画面からの入力情報を受ける。
			product_name = request.getParameter("product_name");
			kinds = request.getParameter("kinds");
			strPrice = request.getParameter("price");
			strQuantity = request.getParameter("quantity");
			region = request.getParameter("region");
			remarks = request.getParameter("remarks");
			transaction = request.getParameter("transaction");

			//登録画面での未入力チェック
			if(product_name.equals("")) {
				error = "商品名が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if(kinds.equals("")) {
				error = "種類が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if(strQuantity.equals("")) {
				error = "個数が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if(region.equals("")) {
				error = "地域名が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if(remarks.equals("")) {
				error = "備考が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			if(strPrice.equals("")) {
				error = "価格が未入力の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			//価格が数値以外
			try {
				price = Integer.parseInt(strPrice);
			}catch(NumberFormatException e){
				error ="価格の値が不正の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			//個数が数値以外
			try {
				quantity = Integer.parseInt(strQuantity);
			}catch(NumberFormatException e){
				error ="個数の値が不正の為、商品登録処理は行えませんでした。";
				cmd = "list";
				return;
			}

			//画面からの入力情報を受け取り、Bookオブジェクトに格納します。
			product.setProduct_name(product_name);
			product.setKinds(kinds);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setRegion(region);
			product.setRemarks(remarks);
			product.setTransaction(transaction);

			//ProductDAOクラスに定義したinsert()メソッドを利用して、Productオブジェクトに格納された商品データをデータベースに登録します。
			objDao.insert(product);

		//登録ボタン押下時、DBに接続できない
		}catch(IllegalStateException e) {
			error ="DB接続エラーの為、商品登録はできませんでした。";
			cmd = "logout";

		}catch(Exception e) {
			error="予期せぬエラーが発生しました。<br>" + e;
			cmd = "logout";

		}finally {
			if(error.equals("")) {
				//「listListing.jsp」へフォワードします。
				request.getRequestDispatcher("/view/listListing.jsp").forward(request, response);
			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}

}
