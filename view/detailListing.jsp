<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Sale"%>

<%
	Sale sale = (Sale) request.getAttribute("Sale");
%>
<html>
	<head>
		<title>出品詳細</title>
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
							<li><a href ="<%=request.getContextPath() %>/list">[出品一覧]</a></li>
						</ul>
					</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>出品詳細画面</h2>
					</div>
				</div>
			</div>

			<!-- 出品コンテンツ部分 -->
			<div id="main" class="container">
				<table class="detail">
					<tr>
						<th>商品番号</th>
						<td><%=sale.getProduct_number() %></td>
					</tr>
					<tr>
						<th>商品名</th>
						<td><%=sale.getProduct_name() %></td>
					</tr>
					<tr>
						<th>種類</th>
						<td><%=sale.getKinds() %></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><%=sale.getPrice() %></td>
					</tr>
					<tr>
						<th>個数</th>
						<td><%=sale.getQuantity() %></td>
					</tr>
					<tr>
						<th>備考</th>
						<td><%=sale.getRemarks() %></td>
					</tr>
					<tr>
						<th>地域</th>
						<td><%=sale.getRegion() %></td>
					</tr>
					<tr>
						<th>出品日</th>
						<td><%=sale.getExhibition_date() %></td>
					</tr>
					<tr>
						<th>更新日</th>
						<td><%=sale.getUpdate_date() %></td>
					</tr>
					<tr>
						<th>取引情報</th>
						<td><%=sale.getTransaction() %></td>
					</tr>
					<tr>
						<th>出品ユーザー</th>
						<td><%=sale.getExhibition_userid() %></td>
					</tr>
				</table>

			</div>

			<!-- フッター部分 -->
			<%@include file="/common/footer.jsp" %>

		</div>
	</body>
</html>