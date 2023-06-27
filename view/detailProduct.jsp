<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Product"%>

<%
	Product product = (Product) request.getAttribute("Product");
%>
<html>
	<head>
		<title>詳細情報</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/common.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!-- ヘッダー部分 -->
			<header>
				<%@include file="/common/header.jsp"  %>
			</header>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ナビゲーション -->
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath() %>/listProduct">[商品一覧]</a></li>
						</ul>
					</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>商品詳細画面</h2>
					</div>
				</div>
			</div>

			<!-- 商品詳細コンテンツ部分 -->
			<div id="main" class="container">
			<form action="<%=request.getContextPath() %>/purchase">
				<table class="detail">
					<tr>
						<th>商品番号</th>
						<td><%=product.getProduct_id() %></td>
					</tr>
					<tr>
						<th>商品名</th>
						<td><%=product.getProduct_name() %></td>
					</tr>
					<tr>
						<th>種類</th>
						<td><%=product.getKinds() %></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><%=product.getPrice() %></td>
					</tr>
					<tr>
						<th>個数</th>
						<td><%=product.getQuantity() %></td>
					</tr>
					<tr>
						<th>備考</th>
						<td><%=product.getRemarks() %></td>
					</tr>
					<tr>
						<th>地域</th>
						<td><%=product.getRegion() %></td>
					</tr>
					<tr>
						<th>出品日</th>
						<td><%=product.getExhibition_date() %></td>
					</tr>
					<tr>
						<th>更新日</th>
						<td><%=product.getUpdate_date() %></td>
					</tr>
					<tr>
						<th>取引情報</th>
						<td><%=product.getTransaction() %></td>
					</tr>
					<tr>
						<th>出品ユーザー</th>
						<td><%=product.getUser_id() %></td>
					</tr>
				</table>
				<input type="submit" value="購入">
			</form>

			</div>

			<!-- フッター部分 -->
			<%@include file="/common/footer.jsp" %>

		</div>
	</body>
</html>