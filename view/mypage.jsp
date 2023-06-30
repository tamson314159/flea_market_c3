<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%
	//リクエストスコープからユーザー情報を取得
	User mypage = (User) request.getAttribute("mypage");
%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css"
	rel="stylesheet" type="text/css" />
<title>マイページ</title>
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">
		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

		<%-- メニュー部分 --%>
		<div id="menu">
			<div class="container">
				<%-- ナビゲーション  --%>
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menuUser.jsp">[メニュー]</a></li>
					</ul>
				</div>
				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>マイページ</h2>
				</div>
			</div>
		</div>

		<%-- コンテンツ部分 --%>
		<div id="main" class="container">

			<!-- post送信で遷移 -->
			<div class="change">
				<form action="<%=request.getContextPath()%>/updateMypage" method="post">
					<table>
						<tbody>
							<tr>
								<th style="background-color: #9de2ff">パスワード</th>
								<td><%=mypage.getPassword()%></td>
							</tr>
							<tr>
								<th style="background-color: #9de2ff">氏名</th>
								<td><%=mypage.getName()%></td>
							</tr>

							<tr>
								<th style="background-color: #9de2ff">ニックネーム</th>
								<td><%=mypage.getNickname()%></td>
							</tr>
							<tr>
								<th style="background-color: #9de2ff">住所</th>
								<td><%=mypage.getAddress()%></td>
							</tr>
							<tr>
								<th style="background-color: #9de2ff">電話番号</th>
								<td><%=mypage.getPhone_number()%></td>
							</tr>
							<tr>
								<th style="background-color: #9de2ff">メールアドレス</th>
								<td><%=mypage.getMail()%></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>