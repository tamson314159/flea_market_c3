<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>テンプレート</title>
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
					<%-- ナビゲーション  --%>
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/template.jsp" >[リンク]</a></li>
						</ul>
					</div>

					<%-- ページタイトル  --%>
					<div id="page_title">
						<h2>テンプレート</h2>
					</div>
				</div>
			</div>

			<%-- コンテンツ部分 --%>
			<div id="main" class="container">
				<%-- 検索フォームのテンプレート --%>
				<div class="search">
					<ul>
						<li>検索値1<input></li>
						<li>検索値2<input></li>
						<li><button>検索</button></li>
					</ul>
				</div>

				<%-- 一覧のテンプレート --%>
				<div class="list">
					<table>
						<thead>
							<tr>
								<th>見出し</th>
								<th>見出し</th>
								<th>見出し</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>要素</td>
								<td>要素</td>
								<td>要素</td>
							</tr>
							<tr>
								<td>要素</td>
								<td>要素</td>
								<td>要素</td>
							</tr>
							<tr>
								<td>要素</td>
								<td>要素</td>
								<td>要素</td>
							</tr>
						</tbody>
					</table>
				</div>

				<%-- 詳細のテンプレート --%>
				<div class="detail">
					<dl>
						<dt>見出し</dt>
						<dd>要素</dd>
						<dt>見出し</dt>
						<dd>要素</dd>
						<dt>見出し</dt>
						<dd>要素</dd>
						<dt>商品説明など長い文章のサンプル</dt>
						<dd>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
						</dd>
					</dl>
				</div>
			</div>

			<%-- フッター部分 --%>
			<%@ include file="/common/footer.jsp" %>
		</div>
	</body>
</html>