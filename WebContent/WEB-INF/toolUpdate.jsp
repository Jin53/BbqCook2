<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/Bbq.css">

<title>登録道具名変更</title>
</head>
<body>
    <h1>登録道具名変更</h1>

    <c:out value="${toolName}に変更しました。" />

    <a  href="${pageContext.request.contextPath}/RegisterAllTool?_token=${_token}">一覧に戻る</a>

</body>
</html>