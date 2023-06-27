<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%
//セッションからユーザー情報を取得
User user = (User) request.getAttribute("user");
%>
<html>
	<head>
		<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css" />
		<title>マイページ</title>
	</head>
	<body>
	<!-- ブラウザ全体 -->
		<div id="wrap">
		<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>

		<%-- メニュー部分 --%>
			<div id="menu">
				<div class="container">
				<%-- ナビゲーション  --%>
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/menuUser.jsp" >[メニュー]</a></li>
						</ul>
					</div>
					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>マイページ</h2>
					</div>
				</div>
			</div>

		<form action="<%=request.getContextPath()%>/updateMypage" method="post">
			<table >

				<tr>
					<th style="background-color:#9de2ff">氏名</th>
					<th style="width:30px">&nbsp;</th>
					<th><%=user.getName() %></th>
				</tr>
				<tr>
					<th style="background-color:#9de2ff">ニックネーム</th>
					<th>&nbsp;</th>
					<th><%=user.getNickname() %></th>
				</tr>
				<tr>
					<th style="background-color:#9de2ff">住所</th>
					<th>&nbsp;</th>
					<th><%=user.getAddress() %></th>
				</tr>
				<tr>
					<th style="background-color:#9de2ff">メールアドレス</th>
					<th>&nbsp;</th>
					<th><%=user.getMail() %></th>
				</tr>
				<tr>
					<th style="background-color:#9de2ff">パスワード</th>
					<th>&nbsp;</th>
					<th><%=user.getPassword() %></th>
				</tr>
			</table>

			<table>
			<tr><td><input type="submit" value="変更"></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><a href="<%=request.getContextPath()%>/page">ログアウト</a></td></tr>
			</table>
		</form>
		<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>
			</div>
	</body>
</html>