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

public class PurchaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int product_id = 0;
			String error = "";
			String cmd = "";

			try {

				HttpSession session = request.getSession();

				// セッションから"user"のUserオブジェクトを取得する
				User user = (User) session.getAttribute("user");

				SendMail mail = new SendMail();

				if(user == null) {
					error = "セッション切れの為、カートに追加出来ません。";
					cmd = "logout";
				}

				// パラメータを取得する
				product_id = Integer.parseInt(request.getParameter("product_id"));

				ProductDAO proDao = new ProductDAO();

				Product product = proDao.selectByProduct_id(product_id);

				request.setAttribute("Product", product);

				// Saleのインスタンスを生成
				Sale sale = new Sale();

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

				sale.setMoney_received("0");
				sale.setDelivery("0");
//				//セッションからList配列を取得する
//				ArrayList<Sale> list = (ArrayList<Sale>) session.getAttribute("sale_list");
//
//				// 取得出来なかった場合と、listがnullの場合
//				if (list == null) {
//					list = new ArrayList<Sale>();
//				}

				// カート機能廃止

				// 購入
				SaleDAO saleDAO = new SaleDAO();
				saleDAO.insert(sale);

				// 商品の取引状況の更新。（本当はproductDAOを使った方がいいかもしれない）
				sale.setTransaction("2");
				saleDAO.update(sale);

				mail.sendMail(user,product);

//				// List配列に追加
//				list.add(sale);
//				// セッションスコープに登録
//				session.setAttribute("sale_list", list);

			} catch (IllegalStateException e) {
				error = "DB接続エラーの為、カートに追加は出来ません。";
				cmd = "logout";

			} catch (Exception e) {
				error = "予期せぬエラーが発生しました。<br>" + e;

			} finally {
				// 正常ルートと異常ルートの判別
				if (error.equals("")) {
					request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
				} else {
					request.setAttribute("error", error);
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}
		}
}

