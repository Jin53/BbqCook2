<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top画面</title>
<link rel="stylesheet" type="text/css" media="all" href="css/Bbq.css">
</head>
<body>
    <h1>Top画面</h1>
    <form action="<%=request.getContextPath()%>/UserLogin" method="get">
        <p>
            <input type="submit" value=ユーザーログイン class="button">
        </p>
    </form>
    <form action="<%=request.getContextPath()%>/Administrator"
        method="get">
        <p>
            <input type="submit" value=管理者ログイン class="button">
        </p>
    </form>
</body>
</html>