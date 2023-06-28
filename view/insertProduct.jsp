<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product"%>
<html>
	<head>
		<title>商品登録</title>
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
					<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath() %>/view/menuUser.jsp" >[メニュー]</a></li>
							<li><a href ="<%=request.getContextPath() %>/listListing">[出品一覧]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>商品登録</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<!-- 書籍登録コンテンツ部分 -->
			<div id="main" class="container">
				<!-- 入力フォーム -->
				<form action="<%=request.getContextPath()%>/insertProduct">
					<input type="hidden" name="transaction" value="1">
					<table class="input-table" align="center">
						<tr>
							<td>商品名</td>
							<td><input type="text" name="product_name"></td>
						</tr>
						<tr>
							<td>種類</td>
							<td><input type="text" name="kinds"></td>
						</tr>
						<tr>
							<td>価格</td>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<td>個数</td>
							<td><input type="text" name="quantity"></td>
						</tr>
						<tr>
							<td>地域</td>
							<td><input type="text" name="region"></td>
						</tr>
						<tr>
							<td>備考</td>
							<td><textarea name="remarks" row="5" cols="45"></textarea></td>
						</tr>
					</table>
					<input type="submit" value="登録">
				</form>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>