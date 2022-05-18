<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserLogin</title>
<link rel="stylesheet" type="text/css" media="all" href="css/Bbq.css">
</head>
<body>
    <c:if test="${hasError}">
        <div id="flush_error">ユーザーIDかパスワードが間違っています。</div>
    </c:if>
    <c:if test="${flush != null}">
        <div id="flush_success">
            <c:out value="${flush}"></c:out>
        </div>
    </c:if>
    <h1>ログイン画面</h1>
    <form method="POST" action="<c:url value='/UserLogin' />">
        <div>
            <label for="mail">mail:</label> <input type="text" id="mail"
                name="mail">
        </div>
        <div>
            <label for="pass">Password:</label> <input type="password" id="pass"
                name="password">
        </div>
        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">ログイン</button>
    </form>
</body>
</html>
