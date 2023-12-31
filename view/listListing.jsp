<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList, bean.Product" %>

<%
ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("list");
%>

<html>
	<head>
		<title>出品一覧</title>
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
							<li><a href ="<%=request.getContextPath()%>/view/menuUser.jsp" >[メニュー]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>出品一覧</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">

				<%-- 一覧のテンプレート --%>
				<div class="list">
					<table>
						<thead>
							<tr>
								<th>商品番号</th>
								<th>商品名</th>
								<th>種類</th>
								<th>価格</th>
								<th>個数</th>
							</tr>
						</thead>
						<tbody>
						<%
						if (productList != null) {
							for (int i = 0; i < productList.size(); i++) {
								if(productList.get(i).getQuantity() != 0) {

						%>
							<tr>
								<td><a href="<%= request.getContextPath() %>/detailListing?product_id=<%= productList.get(i).getProduct_id() %>&cmd=detail"><%= productList.get(i).getProduct_id() %></a></td>
								<td><%= productList.get(i).getProduct_name() %></td>
								<td><%= productList.get(i).getKinds() %></td>
								<td><%= productList.get(i).getPrice() %></td>
								<td><%= productList.get(i).getQuantity() %></td>
							</tr>
						<%
								}
							}
						}
						%>

						</tbody>
					</table>
				</div>

			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>