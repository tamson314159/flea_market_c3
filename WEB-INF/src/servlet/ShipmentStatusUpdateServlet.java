package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import bean.Sale;
import bean.User;
import dao.ProductDAO;
import dao.SaleDAO;
import util.SendMail;

public class ShipmentStatusUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// エラーメッセージ用の変数
		String error = "";
		String cmd = "";

		try {

			HttpSession session = req.getSession();
			// セッションから"user"のUserオブジェクトを取得する
			User user = (User) session.getAttribute("user");

			SendMail mail = new SendMail();

			if(user == null) {
				error = "セッション切れの為、発送更新処理ができません。";
				cmd = "logout";
			}

			int user_id = user.getUserid();

			// パラメータを取得する
			int product_id = Integer.parseInt(req.getParameter("product_id"));
			ProductDAO proDao = new ProductDAO();

			// Saleのインスタンスを生成
			Sale sale = new Sale();

			//selectByProduct_idメソッドの呼び出し
			Product product = proDao.selectByProduct_id(product_id);

			//値を設定
			sale.setProduct_number(product.getProduct_id());
			sale.setProduct_name(product.getProduct_name());
			sale.setKinds(product.getKinds());
			sale.setPrice(product.getPrice());
			sale.setQuantity(product.getQuantity());
			sale.setRemarks(product.getRemarks());
			sale.setRegion(product.getRegion());
			sale.setImage(product.getImage());
			sale.setExhibition_date(product.getExhibition_date());
			sale.setUpdate_date(product.getUpdate_date());
			sale.setTransaction(product.getTransaction());
			sale.setExhibition_userid(product.getUser_id());
			sale.setPurchase_userid(user.getUserid());

			//入金状況と発送状況を済みに設定
			sale.setMoney_received("1");
			sale.setDelivery("1");

//			//セッションからList配列を取得する
//			ArrayList<Sale> list = (ArrayList<Sale>) session.getAttribute("sale_list");
//
//			// 取得出来なかった場合と、listがnullの場合
//			if (list == null) {
//				list = new ArrayList<Sale>();
//			}
			SaleDAO saleDAO = new SaleDAO();

			// 商品の取引状況の更新。（本当はproductDAOを使った方がいいかもしれない）
			sale.setTransaction("3");
			saleDAO.update(sale);

			mail.sendMailToBuyer(sale);

//			// List配列に追加
//			list.add(sale);
//			// セッションスコープに登録
//			session.setAttribute("sale_list", list);

			/** **/

			// 文字エンコーディングの設定
			req.setCharacterEncoding("UTF-8");

			// 発送状況更新対象の購入番号の取得
			int productId = Integer.parseInt(req.getParameter("product_id"));

			// 購入情報の取得
			sale = saleDAO.selectAllUser(productId).get(0);

			// 取引状況の更新
			sale.setTransaction("3");

			// 発送状況の更新
			sale.setDelivery("1");

			// DB の更新
			saleDAO.update(sale);

			//selectAll_userメソッドの呼び出し。
			ArrayList<Product> product_list = proDao.selectAll_user(user_id);

			//ユーザー側の出品一覧画面に送るデータをリクエストスコープに登録
			req.setAttribute("list", product_list);


		} catch (IllegalStateException e) {
			// DB に接続できなかった場合
			error = "データベース接続に失敗した為、発送状況の更新ができません。";
			cmd = "logout";
		} finally {
			// エラーメッセージのリクエストスコープへの格納
			req.setAttribute("error", error);
			req.setAttribute("cmd", cmd);

			// フォワード先の振り分け
			if (error.equals("")) {
				// 出品一覧ページにフォワード
				req.getRequestDispatcher("/view/listListing.jsp").forward(req, resp);
			} else {
				// エラーページにフォワード
				req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
			}
		}
	}

}
