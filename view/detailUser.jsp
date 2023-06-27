<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.*"%>

<%
	User user = (User) request.getAttribute("user");
%>


<html>
<head>
<title>ユーザー詳細情報</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>

	<%-- ブラウザ全体 --%>
	<div id="wrap">

		<%-- ヘッダー部分  --%>
		<%@ include file="/common/header.jsp"%>

		<%-- メニュー部分 --%>
		<div id="menu">
			<div class="container">
				<%-- ナビゲーション  --%>
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/listUser">[ユーザー一覧]</a></li>
					</ul>
				</div>

				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>ユーザー詳細</h2>
				</div>
			</div>
		</div>
		<%-- コンテンツ部分 --%>
		<div id="main" class="container">

			<!-- 詳細画面表示 -->
			<div id="main" class="container">
				<div class="detail">
					<dl>
						<dt>ユーザーID</dt>
						<dd><%=user.getUserid()%></dd>
						<dt>氏名</dt>
						<dd><%=user.getName()%></dd>
						<dt>ニックネーム</dt>
						<dd><%=user.getNickname()%></dd>
						<dt>住所</dt>
						<dd><%=user.getAddress()%></dd>
						<dt>メールアドレス</dt>
						<dd><%=user.getMail()%></dd>
						<dt>電話番号</dt>
						<dd><%=user.getPhone_number()%></dd>
						<dt>パスワード</dt>
						<dd><%=user.getPassword()%></dd>
						<dt>会員登録日</dt>
						<dd><%=user.getSignup_date()%></dd>
						<dt>マイページ更新日</dt>
						<dd><%=user.getUpdatemypage_date()%></dd>
						<dt>退会日</dt>
						<dd><%if(user.getSignout_date()!=null){%>
						<%=user.getSignout_date()%><%} %></dd>


					</dl>
				</div>
			</div>
			</div>



			<!-- フッター部分 -->
			<%@include file="/common/footer.jsp"%>
			</div>

</body>
</html>
