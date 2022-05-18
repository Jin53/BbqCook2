<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/Bbq.css">
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>登録選択</title>
</head>
<body>
    <c:if test="${flush != null}">
        <div id="flush_success">
            <c:out value="${flush}"></c:out>
        </div>
    </c:if>
    <h1>登録選択</h1>
    <form action="<%=request.getContextPath()%>/ToolRegister"
        method="GET">
        <p>
            <input type="submit" name="tool" value="道具登録へ" class="button">
        </p>
        <input type="hidden" name="_token" value="${_token}" />
    </form>
    <form method="GET"
        action="<%=request.getContextPath()%>/FoodRegister">
        <p>
            <input type="submit" value="食材登録へ" class="button">
        </p>
        <input type="hidden" name="_token" value="${_token}" />
    </form>
    <form method="GET"
        action="<%=request.getContextPath()%>/CookRegister">
        <p>
            <input type="submit" value="料理登録へ" class="button">
        </p>
        <input type="hidden" name="_token" value="${_token}" />
    </form>
</body>
</html>