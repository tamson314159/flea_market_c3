<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>一般ユーザーメニュー</title>
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
					<li><a href="<%=request.getContextPath() %>/listProduct" >商品一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/listListing">出品一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/showHistoryOrderedItem">購入履歴</a></li>
					<li><a href="<%=request.getContextPath() %>/mypage">マイページ</a></li>
					<li><a href="<%=request.getContextPath() %>/listMessage">メッセージ</a></li>
					<li><a href="<%=request.getContextPath() %>/view/insertProduct.jsp">商品登録</a></li>
					<li>&nbsp;<!--半角スペース1個分--></li>
					<li><a href="<%=request.getContextPath() %>/logout">ログアウト</a></li>
				</ul>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>