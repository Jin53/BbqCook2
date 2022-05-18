<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
<meta charset="UTF-8">
<title>道具登録完了</title>
</head>
<body>
    <link rel="stylesheet" href="css/Bbq.css">
    <h1>食材登録完了</h1>
    <p><c:out value = "${newFood}"/>の道具が正常に登録されました</p>

    <form method="GET" action="<%= request.getContextPath() %>/RegisterSelection">
        <p>
            <input type="submit" value="登録選択画面へ" class="button">
        </p>
         <input type="hidden" name="_token" value="${_token}" />
    </form>

</body>
</html>