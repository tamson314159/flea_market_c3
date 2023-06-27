<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css" />
		<title>売上状況</title>
	</head>
	<body>
	<!-- ブラウザ全体 -->
		<div id="wrap">
		<!-- ヘッダー部分 -->
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
						<h2>売上状況</h2>
					</div>
				</div>
			</div>

		<table class="list table">
			<tr>
				<th>ユーザー</th>
				<th>商品番号</th>
				<th>取引金額</th>
				<th>システム利用料</th>
			</tr>

			<tr>
				<td><a href = "<%=request.getContextPath()%>/detailUser">kanda</a></td>
				<td><a href = "<%=request.getContextPath()%>/detailProduct">123</a></td>
				<td>1000</td>
				<td>100</td>
			</tr>
			<tr>
				<td><a href = "<%=request.getContextPath()%>/detailUser">akihabara</a></td>
				<td><a href = "<%=request.getContextPath()%>/detailProduct">456</a></td>
				<td>500</td>
				<td>50</td>
			</tr>
		</table>

		<table>
			<tr>
				<th>システム利用料合計</th>
				<td>150</td>
			</tr>
		</table>
		<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>
		</div>

	</body>
	</html>