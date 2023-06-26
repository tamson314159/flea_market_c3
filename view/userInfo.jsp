<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%
//セッションからユーザー情報を取得
User user = (User)session.getAttribute("user");

//権限分け
String authority = user.getAuthority();
if(authority.equals("1")){
	authority = "一般ユーザー";
}else{
	authority = "管理者";
}

%>

<html>
	<body>
	<div style="text-align: right;">
		<table style="margin: 10px; width: 200px; text-align:left; display: inline-block" >
			<tr style="">
				<td>名前：<%=user.getUserid() %></td>
			</tr>
			<tr style="">
				<td>権限：<%=authority %></td>
			</tr>
		</table>
		<hr style="height:3; background-color:#0000ff">
	</div>
	</body>
</html>