<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String)request.getAttribute("error");
if (error == null) {
	error = "";
}
%>

<html>
	<head>
		<title>会員登録</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/common.css">
	</head>

	<body>
		<%-- ブラウザ全体 --%>
		<div id="wrap">

			<%-- ヘッダー部分  --%>
			<%@ include file="/common/header.jsp" %>

			<%-- メニュー部分 --%>
			<div id="menu">
				<div class="container">
					<%-- ナビゲーション  --%>
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/login.jsp" >[ログイン画面]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>会員登録</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">

				<%-- 登録、変更のテンプレート(登録の画面の際は1列削除してください。) --%>
				<div class="change">
					<form action="<%= request.getContextPath() %>/signupMember" method="post">
						<table>
							<tbody>
								<tr>
									<th>氏名</th>
									<td><input type="text" name="name"></td>
								</tr>
								<tr>
									<th>ニックネーム</th>
									<td><input type="text" name="nickname"></td>
								</tr>
								<tr>
									<th>住所</th>
									<td><input type="text" name="address"></td>
								</tr>
								<tr>
									<th>電話番号</th>
									<td><input type="text" name="phone_number"></td>
								</tr>
								<tr>
									<th>メールアドレス</th>
									<td><input type="text" name="mail"></td>
								</tr>
								<tr>
									<th>パスワード</th>
									<td><input type="password" name="password"></td>
								</tr>
							</tbody>
						</table>
						<p><input type="submit" value="会員登録"></p>
						<input type="hidden" name="authority" value="1">
					</form>
					<br>
					<p class="error"><%= error %></p>
				</div>

			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>

<style>
.error {
	color:red;
	}
</style>