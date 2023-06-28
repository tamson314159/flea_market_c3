<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Sale, java.util.ArrayList" %>

<%
ArrayList<Sale> list = (ArrayList<Sale>)request.getAttribute("sale_list");
String money_received = "";
%>

<html>
	<head>
		<title>購入履歴</title>
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
						<h2>購入履歴</h2>
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
								<th>価格</th>
								<th>個数</th>
								<th>購入日</th>
								<th>入金状況</th>
								<th>入金</th>
							</tr>
						</thead>
						<tbody>
							<%
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
									money_received = list.get(i).getMoney_received();

									if (money_received.equals("0")) {
										money_received = "未入金";
									}
									if (money_received.equals("1")) {
										money_received = "入金済み";
									}
							%>
								<tr>
									<td><a href="<%= request.getContextPath() %>/detailOrder?product_number=<%= list.get(i).getProduct_number() %>&cmd=detail"><%= list.get(i).getProduct_number() %></a></td>
									<td><%= list.get(i).getProduct_name() %></td>
									<td><%= list.get(i).getPrice() %></td>
									<td><%= list.get(i).getQuantity() %></td>
									<td><%= list.get(i).getPurchase_date() %></td>
									<td><%= money_received %></td>
									<td>
										<% if (money_received.equals("未入金")) { %>
										<form action="<%= request.getContextPath() %>/payment">
											<input type="hidden" name="product_id" value="<%= list.get(i).getProduct_number() %>">
											<input type="submit" value="入金">
										</form>
										<%
										}
										%>
									</td>
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
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>