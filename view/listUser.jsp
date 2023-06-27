<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList, bean.User"%>
<%
	// ユーザー一覧の取得
	ArrayList<User> userList = (ArrayList<User>) request.getAttribute("user_list");

	// ユーザー一覧が取得できなかった場合の初期化
	if (userList == null) {
		userList = new ArrayList<User>();
	}
%>

<html>
	<head>
		<title>ユーザー一覧</title>
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
							<li><a href ="<%=request.getContextPath()%>/view/menuAdmin.jsp" >[メニュー]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>ユーザー一覧</h2>
					</div>
				</div>
			</div>

			<%-- ユーザー一覧表示機能 --%>
			<div id="main" class="container">

				<%-- ユーザー一覧 --%>
				<div class="list">
					<table>
						<thead>
							<tr>
								<th>ID</th>
								<th>名前</th>
								<th>住所</th>
								<th>メールアドレス</th>
							</tr>
						</thead>
						<tbody>
							<% for (User user : userList) { %>
								<tr>
									<td><a href="<%= request.getContextPath() %>/detailUser?userid=<%= user.getUserid() %>"><%= user.getUserid() %></a></td>
									<td><%= user.getName() %></td>
									<td><%= user.getAddress() %></td>
									<td><%= user.getMail() %></td>
								</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>