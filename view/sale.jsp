<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Sale"%>
<%
	int commision = 0;
%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css"
	rel="stylesheet" type="text/css" />
<title>売上状況</title>
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">
		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

		<%-- メニュー部分 --%>
		<div id="menu">
			<div class="container">
				<%-- ナビゲーション  --%>
				<div id="nav">
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/view/menuAdmin.jsp">[メニュー]</a></li>
					</ul>
				</div>
				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>売上状況</h2>
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
							<th>数量</th>
							<th>購入日</th>
						</tr>
					</thead>
					<tbody>
				<%
					ArrayList<Sale> list = (ArrayList<Sale>) request.getAttribute("sale_list");
					ArrayList<String> total = new ArrayList<String>();
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Sale sales = (Sale) list.get(i);
							commision += sales.getPrice()*sales.getQuantity() / 10;
				%>
				<tr>
						<td><%=list.get(i).getProduct_number()%></a></td>
						<td><%=list.get(i).getProduct_name()%></td>
						<td><%=list.get(i).getPrice()%></td>
						<td><%=list.get(i).getQuantity()%></td>
						<td><%=list.get(i).getPurchase_date()%></td>

					</tr>
					<%
						}
						}
					%>
					</tbody>
				</table>

			<hr style="position: relative; border-bottom: 2px solid black;">

			<table style="margin-right: 300px">
				<tr>
					<td>システム利用料合計:<%=commision %></td>
				</tr>
			</table>
		</div>
		</div>
		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>