<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product"%>

<html>
<head>
<title>一覧</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
</head>

<body>
	<div id="wrap">
		<%@ include file="/common/header.jsp"%>
		<div id="menu">
			<div class="container">
				<%-- ナビゲーション  --%>
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menuAdmin.jsp">[メニュー]</a></li>
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
							<th>種類</th>
							<th>商品名</th>
							<th>価格</th>
							<th>個数</th>
						</tr>
					</thead>
					<tbody>
					<%
				ArrayList<Product> list =(ArrayList<Product>)request.getAttribute("product_list");
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						Product product = (Product)list.get(i);
						%>
						<tr>
							<td><%=product.getProduct_id()%></td>
							<td><%= product.getKinds() %></td>
							<td><%= product.getProduct_name() %></td>
							<td><%= product.getPrice() %></td>
							<td><%= product.getQuantity() %></td>
						</tr>
				<%
					}
				}
				%>
					</tbody>
				</table>
			</div>

		</div>

		<%-- フッター部分 --%>
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>