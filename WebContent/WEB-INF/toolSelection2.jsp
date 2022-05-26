<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/Bbq.css">
<c:import url="layout/app.jsp">
    <c:param name="content">

        <h2>道具選択</h2>
        <p>現在、持っているBBQ道具を選択してください。</p>
        <form action="<%= request.getContextPath() %>/FoodBudget" method="get">
            <c:forEach varStatus="loop" var="tools" items="${tool}">
                <input type="checkbox" name="tool" value="${loop.index + 1}">${tools.tool_name}
            <%-- <c:out value="${tools.tool_id}"/> --%>
                <%-- <c:out value="${tools.tool_name}"/> --%>
                <br>
            </c:forEach>
            <br> <input type="submit" />
            </form>
    </c:param>
</c:import>