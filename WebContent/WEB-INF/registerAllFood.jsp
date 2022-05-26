<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/Bbq.css">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h1>登録食材一覧</h1>
        <table id="food_List">
            <tbody>
                <tr>
                    <th>食材ID</th>
                    <th>食材名前</th>
                    <th></th>
                </tr>
                <c:forEach var="allFood" items="${allFood}" varStatus="status">
                    <tr class="row${status.count % 2}">
                   <td> <a href="${pageContext.request.contextPath}/FoodEdit?food_id=${allFood.food_id}">
                        <c:out value="${allFood.food_id}" />
                        </a></td>
                        <td><c:out value="${allFood.food_name}" /></td>
                        <td><img src="/BbqCook2/upload/${allFood.food_image}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div id="pagination">
            （全 ${food_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((food_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/RegisterAllFood?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
       <p><a href="<c:url value='/FoodRegister' />">新規食材登録</a></p>
