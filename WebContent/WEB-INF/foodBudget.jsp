<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材予算</title>
<link rel=stylesheet href="css/Bbq.css">
</head>
<body>
    <h1>食材予算</h1>
    <c:if test="${requestScope.errors != null}">
        <ul>
            <c:forEach var="error" items="${requestScope.errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>
        </c:if>
        <form action="/BbqCook2/CookList" method=get>
            <input id="person" type="number" name="person" placeholder="20まで"
                min="1" max="20" style="width: 8em;"> <label for="person">人前</label><br>
            <input id="money" type="number" name="money"> <label
                for="money">円</label>
            <button type="submit">検索</button>
        </form>
</body>
</html>