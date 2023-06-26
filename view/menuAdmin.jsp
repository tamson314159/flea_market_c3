<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>管理者メニュー</title>
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

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>メニュー</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">
				<ul style="margin-top:20px;">
					<li><a href="<%=request.getContextPath() %>/sale" >売上状況</a></li>
					<li><a href="<%=request.getContextPath() %>/listUser">ユーザー一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/listMessageAdmin">メッセージ一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/listProduct">出品一覧</a></li>
					<li>&nbsp;<!--半角スペース1個分--></li>
					<li><a href="<%=request.getContextPath() %>/logout">ログアウト</a></li>
				</ul>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>