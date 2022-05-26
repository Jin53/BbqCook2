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
    <h1>BBQ料理サーチシステム</h1>
    <img class="top"
     src="https://cdn.pixabay.com/photo/2015/05/31/12/23/fool-791504_1280.jpg"
     >
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
