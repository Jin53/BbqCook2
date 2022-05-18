<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>料理リスト</title>
<link rel="stylesheet" href="css/Bbq.css">
</head>
<body>
<form action="/BbqCook2/HowToCook" method=get>
<h1>料理リスト</h1>
<c:if test="${!empty Cookname}"/>
<c:forEach varStatus="loop" var="Cookname" items="${cook}">
<input type="checkbox" name="cookname" value="${Cookname.getCook_id()}">${Cookname.getCook_name()}
</c:forEach>
<c:if test="${!empty CooknameTool}"/>
<c:forEach varStatus="loop" var="CooknameTool" items="${cookTool}">
<input type="checkbox" name="cookname" value="${CooknameTool.getCook_id()}">${CooknameTool.getCook_name()}
</c:forEach>
<!--<c:forEach var="CooknameT" items="${cookTool}">
<c:out value="${CooknameT.getCook_name()}"/>
</c:forEach>-->
<br>
<button type="submit">選択して作り方表示</button>
</form>
</body>
</html>