package util;

import java.util.Properties;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import bean.Product;
import bean.Sale;
import bean.User;
import dao.UserDAO;

import javax.mail.internet.InternetAddress;

public class SendMail {

	static String message = "";

	static int sum = 0;

	static String name = "";

	static String mail ="";


	public void sendMail(User user, Product product) {

		name = user.getNickname();

		mail = user.getMail();


			message  += product.getProduct_id() + "\t" + product.getProduct_name() + "\t" + product.getPrice() + "\n" ;

			sum += product.getPrice();

		SendMail test = new SendMail();

		test.send(mail);
	}

	public void send(String mail) {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team08@kanda-it-school-system.com", "W7ceL1Ul2fDX6T9");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team08@kanda-it-school-system.com", "K-vita", "iso-2022-jp"));

			// 送信先メールアドレスを指定（テスト時は自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, mail);

			// メールのタイトルを指定
			mimeMessage.setSubject("注文内容の詳細", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText( name + "様\r\n"+"\r\n"+
			"商品のご購入ありがとうございます。\r\n"+
			"以下内容でご注文を受け付けましたので、ご連絡致します。"
			+ message + "合計" + "\t" +sum + "円" + "\r\n"+ "\r\n"+ "またのご利用よろしくお願い致します。","iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

	public void sendMailToSeller(Sale sale) {
		try {
			// 出品者のユーザー情報
			UserDAO userDAO = new UserDAO();
			User seller = userDAO.selectByUserid(sale.getExhibition_userid());

			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team08@kanda-it-school-system.com", "W7ceL1Ul2fDX6T9");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team08@kanda-it-school-system.com", "K-vita", "iso-2022-jp"));

			// 送信先メールアドレスを指定（テスト時は自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, seller.getMail());

			// メールのタイトルを指定
			mimeMessage.setSubject("出品商品が購入されました", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(
					seller.getNickname() + "様\r\n"+"\r\n"
					+ "お客様の出品された商品が購入されました。\r\n"
					+ "以下の商品の発送をお願いいたします。"
					+ "商品名：" + sale.getProduct_name()
					+ "\r\n"+ "\r\n","iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

	public void sendMailToBuyer(Sale sale) {
		try {
			// 購入者のユーザー情報
			UserDAO userDAO = new UserDAO();
			User buyer = userDAO.selectByUserid(sale.getPurchase_userid());

			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team08@kanda-it-school-system.com", "W7ceL1Ul2fDX6T9");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team08@kanda-it-school-system.com", "K-vita", "iso-2022-jp"));

			// 送信先メールアドレスを指定（テスト時は自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, buyer.getMail());

			// メールのタイトルを指定
			mimeMessage.setSubject("購入商品が発送されました", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(
					buyer.getNickname() + "様\r\n"+"\r\n"
					+ "お客様の購入された商品が発送されました。\r\n"
					+ "商品名：" + sale.getProduct_name()
					+ "\r\n"+ "\r\n","iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}
