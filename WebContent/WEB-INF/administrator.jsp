<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>管理者用</title>
        <link rel=stylesheet href=css/Bbq.css>
    </head>
    <body>
     <c:if test="${hasError}">
        <div id="flush_error">ユーザーIDかパスワードが間違っています。</div>
    </c:if>

    <h1>管理者用</h1>
    <form method="POST" action="<%= request.getContextPath() %>/Administrator">
        <div>
            <label for="username">ID:</label>
            <input type="text" id="username" name="id">
        </div>
        <div>
            <label for="pass">Password:</label>
            <input type="password" id="pass" name="adminPassword">
        </div>
        <button type="submit">ログイン</button>
    </form>
    </body>
</html>