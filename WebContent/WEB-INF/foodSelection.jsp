<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/Bbq.css">
<c:import url="layout/app.jsp">
    <c:param name="content">

    <h1>食材選択</h1>
    <p>現在、持っているBBQ食材を選択してください。</p>
        <form action="/BbqCook2/FoodBudget" method ="get">
        <c:forEach varStatus="loop" var="food" items="${foods}">
            <input type="checkbox" name="foo" value="${loop.index + 1}">${food.food_name}
            <img src=${food.food_image}>
            <br>
        </c:forEach>
        <br>

        <input type="submit" value="送信">
        </form>
</c:param>
</c:import> %