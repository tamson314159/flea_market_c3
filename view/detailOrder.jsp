<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Sale,java.util.ArrayList"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css"
	rel="stylesheet" type="text/css" />
<title>注文詳細</title>
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
							href="<%=request.getContextPath()%>/showHistoryOrderedItem">[購入履歴]</a></li>
					</ul>
				</div>

				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>注文詳細情報</h2>
				</div>
			</div>
		</div>
		<%-- コンテンツ部分 --%>
		<div id="main" class="container">

			<table class="list table" id="main">
				<%
					ArrayList<Sale> list = (ArrayList<Sale>) request.getAttribute("sales");

					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Sale sale = (Sale) list.get(i);
				%>
				<tr>
					<th class="list th" style="width: 150px;">商品番号</th>
					<td style="width: 150px;"><%=sale.getProduct_number()%></td>
				</tr>
				<tr>
					<th class="list th">商品名</th>
					<td><%=sale.getProduct_name()%></td>
				</tr>
				<tr>
					<th class="list th">商品の種類</th>
					<td><%=sale.getKinds()%></td>
				</tr>
				<tr>
					<th class="list th">価格</th>
					<td><%=sale.getPrice()%></td>
				</tr>
				<tr>
					<th class="list th">個数</th>
					<td><%=sale.getQuantity()%></td>
				</tr>
				<tr>
					<th class="list th">備考</th>
					<td><%=sale.getRemarks()%></td>
				</tr>
				<tr>
					<th class="list th">地域</th>
					<td><%=sale.getRegion()%></td>
				</tr>
				<tr>
					<th class="list th">取引状況</th>
					<td><%=sale.getTransaction()%></td>
				</tr>
				<tr>
					<th class="list th">出品者ID</th>
					<td><%=sale.getExhibition_userid()%></td>
				</tr>
				<tr>
					<th class="list th">購入日</th>
					<td><%=sale.getPurchase_date()%></td>
				</tr>
				<tr>
					<th class="list th">入金状況</th>
					<td><%=sale.getMoney_received()%></td>
				</tr>
				<tr>
					<th class="list th">配送状況</th>
					<td><%=sale.getDelivery()%></td>
				</tr>

				<tr>
					<th class="list th">備考</th>
					<td><%=sale.getRemarks()%></td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>
		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
		</div>
</body>
</html>