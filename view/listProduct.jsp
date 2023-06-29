<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.*"%>

<%
	ArrayList<Product> product_list = (ArrayList<Product>) request.getAttribute("product_list");

%>


<html>
<head>
<title>商品一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common.css">
</head>
<body>
	<%-- ブラウザ全体 --%>
	<div id="wrap">

		<%-- ヘッダー部分  --%>
		<%@ include file="/common/header.jsp"%>

		<%-- メニュー部分 --%>
		<div id="menu">
			<div class="container">
				<%-- ナビゲーション  --%>
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menuUser.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>商品一覧</h2>
				</div>
			</div>
		</div>

		<%-- コンテンツ部分 --%>
		<div id="main" class="container">
			<%-- 検索フォーム --%>
			<form action="<%=request.getContextPath() %>/searchProduct">
			<div class="search">
				<ul>
					<li>商品名<input type="text" name="product_name"></li>
					<li>価格<input type="text" name="price"></li>
					<li><button>検索</button></li>
				</ul>
			</div>
			</form>

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
							<th>購入</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (product_list != null) {
							for (int i = 0; i < product_list.size(); i++) {
					%>
					<tr>
						<td><a
							href="<%=request.getContextPath()%>/detailProduct?product_id=<%=product_list.get(i).getProduct_id()%>&cmd=detailProduct"><%=product_list.get(i).getProduct_id()%></a></td>
						<td><%=product_list.get(i).getProduct_name()%></td>
						<td><%=product_list.get(i).getKinds()%></td>
						<td><%=product_list.get(i).getPrice()%></td>
						<td><%=product_list.get(i).getQuantity()%></td>
						<td><a href="<%=request.getContextPath() %>/purchase?product_id=<%=product_list.get(i).getProduct_id() %>">購入</a></td>

					</tr>
					<%
						}
						}
					%>
					</tbody>
				</table>
			</div>
			</div>




			<!-- フッター部分 -->
			<%@include file="/common/footer.jsp"%>

	</div>

</body>
</html>