<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作り方</title>
<link rel=stylesheet href="css/Bbq.css">
</head>
<h1>作り方</h1>
<p>選択した料理の作り方</p>
<c:forEach var="cookMake" items="${cook_make}">
    <c:out value="${cookMake.getCook_make()}" />
</c:forEach>
<form action="${pageContext.request.contextPath}/RegisterSelection" method="get">
     <input type="hidden" name="_token" value="${_token}" />              
       <input type="submit" value="戻る">         
</form>
<body>

</body>
</html>