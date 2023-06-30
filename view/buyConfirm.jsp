<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Product" %>


<%
Product product = (Product)request.getAttribute("Product");
%>
<html>
	<head>
		<title>購入品確認</title>
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
							<li><a href ="<%=request.getContextPath()%>/showHistoryOrderedItem" >[購入履歴]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>購入品確認</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">
			<%-- 登録、変更のテンプレート(登録の画面の際は1列削除してください。) --%>
				<div class="change">
						<table>
							<thead>
								<tr>
									<a>下記の商品を購入しました。</a>
								</tr>
							</thead>
							<tbody>
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
							</tbody>
						</table>
				</div>


			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>