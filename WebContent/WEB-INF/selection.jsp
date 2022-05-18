<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/Bbq.css">
<c:import url="layout/app.jsp">
<c:param name="content">
    <h1>選択画面</h1>
        <form action="<%= request.getContextPath() %>/ToolSelection" method="GET">
             <p><input type="submit" name="tool"
                value="道具選択へ" class= "button"></p>
        </form>
    <form method="GET" action="<%= request.getContextPath() %>/FoodSelection">
       <p><input type="submit" value="食材選択へ" class= "button"></p>
    </form>
</c:param>
</c:import>
<!--  ${pageContext.request.contextPath}/-->