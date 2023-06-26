<%@page contentType="text/html; charset=UTF-8"%>
<%@page import= %>


<%

String message = (String)request.getAttribute("message");//エラーメッセージの取得

//エラーメッセージがない場合
if(message == null){
	message = "";
}

%>



<html>
	<head>
		<title>ログイン画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
	</head>
	<body>
		<!-- ヘッダー部分 -->
		<%@include file="/common/header.jsp"%>
		<br><br>
		<!-- ログイン画面 -->
		<form action ="<%=request.getContextPath() %>/login" method="POST">
			<table style="margin:auto">
				<tr>
					<td class="table1">ユーザー名(メールアドレス)</td>
					<td><input type="text" name="" ></td>
				</tr>
				<tr>
					<td class="table1">パスワード</td>
					<td><input type="password" name="" ></td>
				</tr>
			</table><br><br>
				<p style="text-align:center">
					<input type="submit" value="ログイン">
				</p>
		</form>
			<p class="center"><%=message %></p>
		<!-- フッター部分 -->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>