<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String)request.getAttribute("error");
String cmd = (String)request.getAttribute("cmd");
%>

<html>
	<head>
		<title>エラー</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/common.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ページタイトル -->
					<div id="page_title">
						<h2>●●エラー●●</h2>
					</div>
				</div>
			</div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">
				<!-- エラーメッセージ -->
				<p style="text-align:center;"><%=error %></p>

				<!-- リンク先 -->
				<p style="margin-top:100px; text-align: center;">
					<%
					if (cmd.equals("logout")) {
					%>
						<a href="<%=request.getContextPath() %>/logout">[ログイン画面へ]</a>
					<%
					} else if(cmd.equals("list")){
					%>
						<a href="<%=request.getContextPath() %>">[一覧表示に戻る]</a>
					<%
					}else if(cmd.equals("menu")){
					%>
						<a href="<%=request.getContextPath() %>">[メニューに戻る]</a>
					<%
					}
					%>
				</p>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>