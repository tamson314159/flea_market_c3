<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Product, bean.Sale"%>

<%
	// 商品詳細の取得
	Product product = (Product) request.getAttribute("product");

	// 商品詳細が取得できなかった場合の処理
	if (product == null) {
		request.setAttribute("error", "出品商品情報が取得できなかったため、商品情報が表示できません。");
		request.setAttribute("cmd", "menu");
		request.getRequestDispatcher("/view/error.jsp").forward(request, response);
	}

	// 商品が取引中・購入済みの場合注文情報を取得する
	Sale sale = null;
	if (product.getTransaction().equals("2") || product.getTransaction().equals("3")) {
		sale = (Sale) request.getAttribute("sale");
	}

%>

<html>
	<head>
		<title><%= product.getProduct_name() %></title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/common.css">
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/detailListing.css">
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
							<li><a href="<%= request.getContextPath() %>/view/menuUser.jsp">[メニュー]</a></li>
							<li><a href="<%= request.getContextPath() %>/listListng">[出品一覧]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>出品詳細</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">
				<%-- 詳細のテンプレート --%>
				<div class="detail">
					<dl>
						<%--
						<dt>画像</dt>
						<dd><img src="<%= request.getContextPath() + "/" + product.getImage() %>" alt="<%= product.getProduct_name() %>"></dd>
						--%>
						<dt>商品番号</dt>
						<dd><%= product.getProduct_id() %></dd>
						<dt>商品名</dt>
						<dd><%= product.getProduct_name() %></dd>
						<dt>種類</dt>
						<dd><%= product.getKinds() %></dd>
						<dt>価格</dt>
						<dd><%= product.getPrice() %></dd>
						<dt>個数</dt>
						<dd><%= product.getQuantity() %></dd>
						<dt>備考</dt>
						<dd><%= product.getRemarks() %></dd>
						<%--
						<dt>地域</dt>
						<dd><%= product.getRegion() %></dd>
						--%>
						<dt>出品日</dt>
						<dd><%= product.getExhibition_date() %></dd>
						<dt>更新日</dt>
						<dd><%= product.getUpdate_date() %></dd>
						<dt>取引状況</dt>
						<%
							// 出品状況の数字を文字列に変換する
							String transaction = "";
							if (product.getTransaction().equals("1")) {
								transaction = "出品中";
							} else if (product.getTransaction().equals("2")) {
								transaction = "取引中";
							} else if (product.getTransaction().equals("3")) {
								transaction = "購入済み";
							}
						%>
						<dd><%= transaction %></dd>
					</dl>
				</div>
				<%-- 発送状況によりリンクボタンを設定する --%>
				<%-- 出品中の場合 --%>
				<% if (product.getTransaction().equals("1")) { %>
					<div class="search">
						<ul>
							<li>
								<form action="<%= request.getContextPath() %>/updateProduct" method="get">
									<input type="hidden" name="product_id" value="<%= product.getProduct_id() %>">
									<button type="submit">編集</button>
								</form>
							</li>
							<li>
								<form action="<%= request.getContextPath() %>/deleteProduct" method="get">
									<input type="hidden" name="product_id" value="<%= product.getProduct_id() %>">
									<button type="submit">削除</button>
								</form>
							</li>
						</ul>
					</div>
				<%-- 取引中の場合 --%>
				<% } else if (product.getTransaction().equals("2")) { %>
					<div class="search">
						<form action="<%= request.getContextPath() %>/shipmentStatusUpdate" method="get">
							<input type="hidden" name="product_id" value="<%= product.getProduct_id() %>">
							<button type="submit">発送</button>
						</form>
					</div>
				<% } %>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>