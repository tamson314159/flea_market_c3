<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<html>
<head>
<title>プロフィール変更</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="/common/header.jsp"%>
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
					<h2>プロフィール変更</h2>
				</div>
			</div>
		</div>


		<%-- 登録、変更のテンプレート(登録の画面の際は1列削除してください。) --%>
		<div class="change">
			<form action="<%=request.getContextPath()%>/updateMypage"
				method="post">
				<table>
					<thead>
						<tr>
							<td>&nbsp;</td>
							<td>&lt;&lt;変更前情報&gt;&gt;</td>
							<td>&lt;&lt;変更後情報&gt;&gt;</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>ユーザーID</th>
							<td><%= user.getUserid() %></td>
							<td><input type="hidden" name="user_id"
								value="<%=user.getUserid()%>"></td>

						</tr>
						<tr>
							<th>名前</th>
							<td><%=user.getName() %></td>
							<td><input type="text" size="40" name="name"></td>
						</tr>
						<tr>
							<th>ニックネーム</th>
							<td><%=user.getNickname() %></td>
							<td><input type="text" size="40" name="nickname"></td>
						</tr>
						<tr>
							<th>住所</th>
							<td><%=user.getAddress() %></td>
							<td><input type="text" size="40" name="address"></td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td><%=user.getMail() %></td>
							<td><input type="text" size="40" name="mail"></td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td><%=user.getPhone_number() %></td>
							<td><input type="text" size="40" name="phone_number"></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><%=user.getPassword() %></td>
							<td><input type="text" size="40" name="password"></td>
						</tr>
					</tbody>
				</table>
				<p>
					<input type="submit" value="変更">
				</p>
			</form>
		</div>


	</div>

	<%-- フッター部分 --%>
	<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>
