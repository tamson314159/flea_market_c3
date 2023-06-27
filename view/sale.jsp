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

			<table class="list table">
				<tr>
					<th style="width: 150px">商品番号</th>
					<th style="width: 150px">商品名</th>
					<th style="width: 150px">価格</th>
					<th style="width: 150px">数量</th>
					<th style="width: 150px">地域</th>
					<th style="width: 150px">購入日</th>
				</tr>

				<%
					ArrayList<Sale> list = (ArrayList<Sale>) request.getAttribute("sale_list");
					ArrayList<String> total = new ArrayList<String>();
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Sale sales = (Sale) list.get(i);
							commision += sales.getPrice() / 10;
				%>

				<tr>
					<td><a href="<%=request.getContextPath()%>/detailProduct"><%=sales.getProduct_number()%></a></td>
					<td><a href="<%=request.getContextPath()%>/detailProduct"><%=sales.getProduct_name()%></a></td>
					<td><%=sales.getPrice()%></td>
					<td><%=sales.getQuantity()%></td>
					<td><%=sales.getRegion()%></td>
					<td><%=sales.getPurchase_date()%></td>
				</tr>
				<%
					}
					}
				%>

			</table>

			<hr style="position: relative; border-bottom: 2px solid black;">

			<table style="margin-right: 300px">
				<tr>
					<th>システム利用料合計</th>
					<td></td>
				</tr>
			</table>
		</div>
		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
		</div>
</body>
</html>