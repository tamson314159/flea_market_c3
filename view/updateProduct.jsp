<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product"%>
<%
Product product = (Product) request.getAttribute("product");
%>
<html>
<head>
<title>更新</title>
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
						<li><a href="<%=request.getContextPath()%>/view/menuUser.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<%-- ページタイトル  --%>
				<div id="page_title">
					<h2>商品更新</h2>
				</div>
			</div>
		</div>


				<%-- 登録、変更のテンプレート(登録の画面の際は1列削除してください。) --%>
				<div class="change">
					<form action="<%=request.getContextPath()%>/updateProduct" method="get">
						<table>
							<thead>
								<tr>
									<td>&nbsp;</td>
									<td>&lt;&lt;変更前情報&gt;&gt;</td>
									<td>&lt;&lt;変更後情報&gt;&gt;</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>商品番号</th>
									<td><%= product.getProduct_id() %></td>
									<td><input type="hidden" name="product_id" value="<%=product.getProduct_id()%>"></td>
								</tr>
								<tr>
									<th>種類</th>
									<td><%= product.getKinds() %>></td>
									<td><input type="text" size="40" name="kinds"></td>
								</tr>
								<tr>
									<th>商品名</th>
									<td><%= product.getProduct_name() %></td>
									<td><input type="text" size="40" name="product_name"></td>
								</tr>
								<tr>
									<th>価格</th>
									<td><%= product.getPrice() %></td>
									<td><input type="text" size="40" name="price"></td>
								</tr>
								<tr>
									<th>個数</th>
									<td><%= product.getQuantity() %></td>
									<td><input type="text" size="40" name="quantity"></td>
								</tr>
								<tr>
									<th>備考</th>
									<td><%= product.getRemarks() %></td>
									<td><input type="text" size="40" name="remarks"></td>
								</tr>
								<tr>
									<th>地域</th>
									<td><%= product.getRegion() %></td>
									<td><input type="text" size="40" name="region"></td>
								</tr>
								<tr>
									<th>更新日</th>
									<td><%= product.getUpdate_date() %></td>
									<td><input type="text" size="40" name="update_date"></td>
								</tr>
								<tr>
									<th>取引情報</th>
									<td><%= product.getTransaction() %></td>
									<td><input type="text" size="40" name="transaction"></td>
								</tr>
							</tbody>
						</table>
						<p><input type="submit" value="変更"></p>
					</form>
				</div>


			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>