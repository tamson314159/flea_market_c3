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
			<table class="detail">
				<%
					ArrayList<Sale> list = (ArrayList<Sale>) request.getAttribute("sale_list");
					ArrayList<String> total = new ArrayList<String>();
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Sale sales = (Sale) list.get(i);
							commision += sales.getPrice() / 10;
				%>
				<tr>
					<th>商品番号</th>
					<td><a href="<%=request.getContextPath()%>/detailProduct"><%=sales.getProduct_number()%></a></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td><a href="<%=request.getContextPath()%>/detailProduct"><%=sales.getProduct_name()%></a></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><%=sales.getPrice()%></td>
				</tr>
				<tr>
					<th>数量</th>
					<td><%=sales.getQuantity()%></td>
				</tr>
				<tr>
					<th>地域</th>
					<td><%=sales.getRegion()%></td>
				</tr>
				<tr>
					<th>購入日</th>
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