<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User" %>


<%
String userid=""; //ユーザーを管理する変数
String password=""; //パスワードを管理する変数

Cookie[] CookieList = request.getCookies();//クッキーの取得
String message = (String)request.getAttribute("message");//エラーメッセージの取得

//クッキーがあるかの判定
if(CookieList != null){
	for(int i = 0; i < CookieList.length; i++){
		//クッキーからユーザー情報の取得
		if(CookieList[i].getName().equals("userid")){
			userid = CookieList[i].getValue();
		}
		//クッキーからパスワード情報の取得
		if(CookieList[i].getName().equals("password")){
			password = CookieList[i].getValue();
		}
	}
}
//エラーメッセージがない場合
if(message == null){
	message = "";
}

%>




<html>
	<head>
		<title>ログイン画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
	</head>
	<body>
	<%-- ブラウザ全体 --%>
		<div id="wrap">

			<%-- ヘッダー部分  --%>
			<%@ include file="/common/header.jsp" %>

			<%-- メニュー部分 --%>
			<div id="menu">
				<div class="container">

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>ログイン画面</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">
				<%-- 検索フォームのテンプレート --%>
				<form action ="<%=request.getContextPath() %>/login" method="POST">
				<div class="search">
					<p>ユーザー名:<input type="text" name=""></p>
						<p>パスワード:<input type="password" name=""><p>
						<br><br>
						<p><input type="submit" value="ログイン"></p>

				</div>
				</form>



			<p class="center"><%=message %></p>
			</div>
		<!-- フッター部分 -->
		<%@include file="/common/footer.jsp"%>
		</div>
	</body>
</html>